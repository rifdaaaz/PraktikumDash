public abstract class Mahasiswa extends Thread {
	protected Position pos;
	protected String nama;

	public Mahasiswa(String _nama, Position _pos){
		this.nama = _nama;
		this.pos = new Position(_pos);
	}

	public Position getPos() {
		return this.pos;
	}
	public String getNama() {
		return this.nama;
	}

	/* public static class Builder {
		private final Position pos;
		private final String nama;

		public Position Builder(final Position _pos){
			this.pos = _pos;
			return this;
		}

		public String Builder(final String _nama){
			this.nama = _nama;
			return this;
		}

		public Mahasiswa create() {
			return new Mahasiswa(pos,nama);
		}
	} */
}