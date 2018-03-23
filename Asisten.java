// Asisten.java

public class Asisten extends Mahasiswa{
	private bool isSampai;
	private Praktikan target;

	public void move(){
		dest = new Position(Praktikan.getPos());		
		if(pos.getX() < dest.getY()){
			pos.move(1, 0);
		}else if(pos.getX() > dest.getY()){
			pos.move(-1, 0);
		}
		else{
			if(pos.getY() < dest.getY()){
				pos.move(0, 1);
			}else if(pos.getY() < dest.getY()){
				pos.move(0, -1);
			}
			else{
				isSampai = TRUE;
			}
		}
	}

	public void display(){
		if(isSampai){
			System.out.println("Asisten " + nama + " sampai ke Praktikan "2);
		}else{
			System.out.println("Asisten " + nama + " berjalan ke " + pos);
		}
	}

}