// Asisten.java
import java.util.*;

public class Asisten extends Mahasiswa{
	private static int count = 0;
	private Praktikan target;
	private int life = 2;
	private char logo = 'A';

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

	public void jawab(){
		this.interrupt();
		Scanner s = new Scanner(System.in);
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
					System.out.println("Asisten " + nama + " pingsan w -_-'");
				}
			}
		}while(!ans.equals(q.getAnswer()) && life > 0);
		if(target.hasQuestion()){
			qp.add(target);
		}
		s.close();
	}

	public void display(){
		if(isSampai()){
			System.out.println("Asisten " + nama + "("+logo+") sampai ke Praktikan " + target.getNama());
			//jawab();
		}else{
			System.out.println("Asisten " + nama + " berjalan ke " + pos);
		}
	}

	// ======================
	// 			RUN
	// ======================

	@Override
	public void run() {
		QueuePraktikan qp = QueuePraktikan.getInstance();
		setTarget(qp.poll());
		System.out.println(target.getPos());
		while(!qp.isEmpty()){
	        while (!isSampai()) {
	        	move();
	            try {
	                Thread.sleep(500);
	            } catch (InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	        }
        	jawab();
	        setTarget(qp.poll());
		}
	}

	// public static void main(String[] args) {
	// 	Question q[] = new Question[3];
	// 	q[0] = new Question("a1","q1");
	// 	q[1] = new Question("a2","q2");
	// 	q[2] = new Question("a3","q3");

	// 	Praktikan p = new Praktikan.Builder().nama("Sandro")
	// 										 .pos(new Position(5,5)).create();
	// 	Asisten a = new Asisten.Builder().nama("SandroAssist")
	// 									 .pos(new Position(0, 0)).build();
	// 	p.addQuestion(q);
	// 	a.setTarget(p);

	// 	Question q1 = p.getQuestion();
	// 	System.out.println(q1.getQuestion());
	// 	System.out.println("masuk");

	// 	while(!a.isSampai()){
	// 		a.move();
	// 		a.display();
	// 	}
	// }

}