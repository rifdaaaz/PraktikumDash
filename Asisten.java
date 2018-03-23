// Asisten.java
import java.util.*;

public class Asisten extends Mahasiswa{
	private Praktikan target;
	private int life = 2;

	public Asisten(String nama, Position pos){
		super(nama, pos);
		target = null;
		life = 2;
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

	public void jawab(){
		Scanner s = new Scanner(System.in);
		String ans;
		Question q = target.getQuestion();
		do{
			System.out.println(q.getQuestion());
			ans = s.next();
			if(!ans.equals(q.getAnswer())){
				System.out.println("Masih Salah");
				life--;
				if(life<=0){
					System.out.println("Pingsan w -_-'");
				}
			}
		}while(!ans.equals(q.getAnswer()) && life > 0);
	}

	public void display(){
		if(isSampai()){
			System.out.println("Asisten " + nama + " sampai ke Praktikan " + target.getNama());
			jawab();
		}else{
			System.out.println("Asisten " + nama + " berjalan ke " + pos);
		}
	}

	public static void main(String[] args) {
		Queue<Question> q = new LinkedList<>();
		q.add(new Question("q1","a1"));
		q.add(new Question("q2","a2"));
		q.add(new Question("q3","a3"));

		Praktikan p = new Praktikan("Sandro", new Position(5,5),q);
		Asisten a = new Asisten("SandroAssist", new Position(0,0));
		a.setTarget(p);

		while(!a.isSampai()){
			a.move();
			a.display();
		}
	}

}