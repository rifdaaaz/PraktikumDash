public class Mahasiswa extends Thread {
	protected final Position pos;
	protected final String nama;

	private Mahasiswa(final Position _pos, final String _nama){
		this.nama = _nama;
		this.pos = _pos;
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