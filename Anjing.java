public class Anjing extends Hewan {
	

	public Anjing(String S) {
		super(S);
		System.out.println("Ini Anjing");
	}

	public void berbunyi() {
		Hewan.numberOfBunyi++;
		System.out.println("Guk!");
	}

	public void berbunyi(int jml) {
		for (int i=0; i<jml; i++) {
			Hewan.numberOfBunyi++;
			System.out.print("Guk");
		}	
		System.out.println("!");
	}

}