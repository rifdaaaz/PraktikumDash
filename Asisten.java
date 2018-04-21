// Asisten.java
import java.util.*;

public class Asisten extends Mahasiswa{
	private static boolean isPaused = false;
	private static int count = 0;
	private boolean active = true;
	private Praktikan target;
	private int life = 3;
	private char logo = 'A';
	private static final Scanner s = new Scanner(System.in);
	private LinkedList<Position> route = null;
	private BFS router;

/* 	public Asisten(String nama, Position pos){
		super(nama, pos);
		target = null;
		life = 2;
		count++;
		logo +=count-1; 
	} */

	//konstruktor pake builder
	private Asisten(Builder builder){
		this.life = builder.life;
		this.logo = builder.logo;
		this.nama = builder.nama;
		this.pos = builder.pos;
		this.target = null;
		this.active = true;
		this.life = 2;
		count++;
		this.logo += count - 1;
	}


	public static class Builder {
		private Praktikan target;
		private int life = 2;
		private char logo = 'A';
		private String nama;
		private Position pos;

		public Builder(){}
		public Builder nama(String nama){
			this.nama = nama;
			return this;
		}
		public Builder pos(Position pos){
			this.pos = pos;
			return this;
		}		
		public Asisten build(){
			return new Asisten(this);
		}
	}

	public static int getCount(){
		return count;
	}

	public static boolean getIsPaused() {
		return isPaused;
	}

	public void setTarget(Praktikan target){
		this.target = target;
	}

	public int getLife() {
		return this.life;
	}

	public boolean isSampai(){
		if(target != null){
			return pos.equals(target.getPos());
		}
		return false;
	}

	public char getLogo(){
		return logo;
	}

	public synchronized void jawab(){
		// this.interrupt();
		Asisten.togglePause();
		Praktikan.togglePause();
		Orang.togglePause();
		String ans;
		QueuePraktikan qp = QueuePraktikan.getInstance();
		Question q = target.getQuestion();
		do{
			System.out.println("Pertanyaan : " + q.getQuestion());
			System.out.print("Jawabanmu : ");
			ans = s.next();
			if(!ans.equals(q.getAnswer())){
				System.out.println("Jawabanmu masih salah :(");
				life--;
				if(life<=0){
					System.out.println("Asisten " + nama + " pingsan dan walk out dari laboratorium");
				}
			}
		}while(!ans.equals(q.getAnswer()) && life > 0);
		
		if(target.hasQuestion()){
			qp.add(target);
		}
		
		if(life <= 0){
			count--;
		}
		Orang.togglePause();
		Praktikan.togglePause();
		Asisten.togglePause();
	}

	public synchronized void display(){
		if(!isSampai()){
			System.out.println("Asisten " + nama + " berjalan ke " + pos + " menuju " + target.getNama());
		}
	}

	public void displaySampai(){
		if(isSampai()){
			System.out.println("Asisten " + nama + " sampai ke Praktikan " + target.getNama());
			//jawab();
		}
	}

	public boolean isActive(){
		return active;
	}

	public static void togglePause() {
		isPaused = isPaused ? false : true;
	}
	// ======================
	// 			RUN
	// ======================

	@Override
	public void run() {
		QueuePraktikan qp = QueuePraktikan.getInstance();
		while(!qp.isEmpty() && life > 0){
			setTarget(qp.poll());
	        while (!isSampai()) {
	        	while (isPaused) {
					try {
				      Thread.sleep(1000);
				    } catch (InterruptedException ex) {
				      Thread.currentThread().interrupt();
				    }
	        	}
	        	move();
	        	display();
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        while (isPaused) {
	        	try {
		          Thread.sleep(1000);
		        } catch (InterruptedException ex) {
		          Thread.currentThread().interrupt();
		        }
	        }
	        displaySampai();
        	jawab();
			setTarget(null);
			// route = null;
		}
		active = false;
	}

	// ==================================
	// Move
	// ==================================
	public void move(){
		Position dest = new Position(target.getPos());
		if(route == null){
			Peta maze = Peta.getInstance();
			router = new BFS(maze.get(), pos, target.getPos());
			route = router.FindRoute();
		}
		if(!isSampai()){
			try{
				pos = new Position(route.removeFirst());
			}catch(Exception e){
				route = null;
				// System.out.println(nama);
				// System.out.println(pos);
				// System.out.println(route == null?"null":"ada");
				// System.out.println(target.getNama() + " pas error");
			}
			// System.out.println(pos);
		}
	}
	// ==================================
	// BFS resolver
	// ==================================
	public class BFS{
		char[][] maze;
		Position current;
		Position target;

		public BFS(char[][] maze, Position current, Position target){
			this.maze = new char[14][14];
			for (int i = 0; i<14; i++) {
				for (int j = 0; j<14; j++) {
					this.maze[i][j] = maze[i][j];
				}
			}
			this.current = current;
			this.target = target;
		}

		private boolean isInMaze(Position p){
	        return ((p.getX()<14 && p.getX()>=0) && (p.getY()<14 && p.getY()>=0));
	    }

	    private boolean isClear(Position p, char[][] maze){
	        return ((maze[p.getX()][p.getY()]!='#') && (maze[p.getX()][p.getY()]!='*'));
	    }

	    public LinkedList<Position> FindRoute(){

	        Position[][] trace = new Position[14][14]; 

	        LinkedList<Position> list = new LinkedList<Position>();

	        list.add(new Position(current));

	        Position crt;
	        Position next;
	        while (!list.isEmpty()) {

	            //posisi sekarang
	            crt = list.removeFirst();

	            // kalo sudah sama kaya target break

	            //mark yang visited
	            maze[crt.getX()][crt.getY()]='*';

	            //masukin tetangganya
	            next = new Position(crt);
	            next.move(0,1);    //tetangga atas
	            if (isInMaze(next) && isClear(next,maze)) { 
	                list.add(next);//yang selanjutnya dicek 
	                trace[next.getX()][next.getY()] = new Position(crt);//koordinat sebelumnya dimasukin ke koordinat sekarang buat tracing
	                if (crt.equals(target)) {break; }//kalau udah goal break
	            }

	            next = new Position(crt);
	            next.move(1,0);    //tetangga kanan
	            if (isInMaze(next) && isClear(next,maze)) {
	                list.add(next);
	                trace[next.getX()][next.getY()] = new Position(crt);
	                if (crt.equals(target)) {break; }
	            }

	            next = new Position(crt);
	            next.move(-1,0);    //tetangga kiri
	            if (isInMaze(next) && isClear(next,maze)) {
	                list.add(next);
	                trace[next.getX()][next.getY()] = new Position(crt);
	                if (crt.equals(target)) {break; }
	            }
	            
	            next = new Position(crt);
	            next.move(0,-1);   //move atas
	            if (isInMaze(next) && isClear(next,maze)) {
	                list.add(next);
	                trace[next.getX()][next.getY()] = new Position(crt);
	                if (crt.equals(target)) {break; }
	            }

	        }

	        // Tracing path dari belakang
	        LinkedList<Position> trail = new LinkedList<Position>();
	        int i = target.getX();
	        int j = target.getY();
	        trail.addFirst(target);
	        while(trace[i][j] != null){
	            Position temp = new Position(trace[i][j]);
	            trail.addFirst(temp);
	            i = temp.getX();
	            j = temp.getY();
	        }


	        // for (Position pos : trail) {
	        //     System.out.print(pos + " ");
	        // }

	        return trail;
	    }
	}
}