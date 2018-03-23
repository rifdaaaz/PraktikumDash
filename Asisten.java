// Asisten.java
import java.util.*;

public class Asisten extends Mahasiswa{
	private static int count = 0;
	private Praktikan target;
	private int life = 2;
	private char logo = 'A';

	public Asisten(String nama, Position pos){
		super(nama, pos);
		target = null;
		life = 2;
		count++;
		logo +=count-1; 
	}

	private void setTarget(Praktikan target){
		this.target = new Praktikan(target);
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
			if(pos.getX() < dest.getY()){
				pos.move(1, 0);
			}else if(pos.getX() > dest.getY()){
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

	public void display(){
		if(isSampai()){
			System.out.println("Asisten " + nama + "("+logo+") sampai ke Praktikan " + target.getNama());
		}else{
			System.out.println("Asisten " + nama + " berjalan ke " + pos);
		}
	}

	public static void main(String[] args) {
		Queue<Question> q = new LinkedList<>();
		q.add(new Question("a1","q1"));
		q.add(new Question("a2","q2"));
		q.add(new Question("a3","q3"));

		Praktikan p = new Praktikan("Sandro", new Position(5,5),q);
		Asisten a = new Asisten("SandroAssist", new Position(0,0));
		a.setTarget(p);

		while(!a.isSampai()){
			a.move();
			a.display();
		}
	}

}