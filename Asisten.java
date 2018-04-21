// Asisten.java
import java.util.*;

public class Asisten extends Mahasiswa{
	private static volatile boolean isPaused = false;
	private static int count = 0;
	private boolean active = true;
	private Praktikan target;
	private int life = 3;
	private char logo = 'A';
	private static final Scanner s = new Scanner(System.in);

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

	public void move(){
		Position dest = new Position(target.getPos());
		if(!isSampai()){
			if(pos.getX() < dest.getX()){
				pos.move(1, 0);
			}else if(pos.getX() > dest.getX()){
				pos.move(-1, 0);
			}
			else{
				if(pos.getY() < dest.getY()){
					pos.move(0, 1);
				}else if(pos.getY() > dest.getY()){
					pos.move(0, -1);
				}
			}
		}
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
		}
		active = false;
	}

	public boolean isActive(){
		return active;
	}

	public static void togglePause() {
		isPaused = isPaused ? false : true;
	}

}