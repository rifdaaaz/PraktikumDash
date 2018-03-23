public abstract class Mahasiswa extends Thread {
	private final Position pos;
	private final String name;

	private Mahasiswa(final Point _pos, final String _name){
		this.name = _name;
		this.pos = _pos;
	}

	public Position getPos() {
		return pos;
	}
	public String getName() {
		return name;
	}

	public static class Builder() {
		private final Point pos;
		private final String nama;

		public Builder(final Point _pos){
		this.pos = _pos;
		}

		public Builder(final String _name){
		this.name = _name;
		}

		public Mahasiswa create() {
			return new Mahasiswa(pos,name);
		}
	}
}