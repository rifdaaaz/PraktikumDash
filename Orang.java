public class Orang extends Mahasiswa {

    private Orang(Builder builder) {
        this.pos = builder.pos;
        this.nama = builder.nama;
    }

    public static class Builder {
    private Position pos;
    private String nama;

    public Builder pos(Position _pos) {
      this.pos = _pos;
      return this;
    }

    public Builder nama(String _nama) {
      this.nama = _nama;
      return this;
    }

    public Orang create() {
      return new Orang(this);
    }

  }

    @Override
    public void run() {
        if (this.nama == "Pak Duktek") {
            System.out.println("Hello Guys!");
        }
        else if (this.nama == "Mahasiswi") {
            System.out.println("Hai Athurku :)");
        }
        else {
            System.out.println("People's name not exist");
        }
    }

}