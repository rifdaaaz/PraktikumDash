import java.util.Random;

public class Orang extends Mahasiswa {

    private static boolean isPaused = false; 


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
        int i = 0;
        while(i<1){
            Random rand = new Random();
            int n = rand.nextInt(10)+10;
            try {
                Thread.sleep(n*1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            while(isPaused){
                try {
                  Thread.sleep(n*1000);
                } catch (InterruptedException ex) {
                  Thread.currentThread().interrupt();
                }
            }
            System.out.println(nama + " : KAKK... KAKK..");
            sapa();
            i++;
        }
    }

    public void sapa(){
        if (this.nama.equals("Pak Duktek")) {
            System.out.println("Hello Guys!");
        }
        if (this.nama == "Einstein") {
            
            System.out.println();
            System.out.println("                          Einstein Datang: \"Bagaimana Praktikumnya? EZ kan?\" ");
            // System.out.println();
            // System.out.println("                                       ,---,_");
            // System.out.println("                           _>   `'-.  .--'/");
            // System.out.println("                       .--'` ._      `/   <_");
            // System.out.println("                       >,-' ._'.. ..__ . ' '-.");
            // System.out.println("                   .-'   .'`         `'.     '.");
            // System.out.println("                       >   / >`-.     .-'< \\ , '._\\");
            // System.out.println("                   /    ; '-._>   <_.-' ;  '._>");
            // System.out.println("                   `>  ,/  /___\\ /___\\  \\_  /");
            // System.out.println("                   `.-|(|  \\o_/  \\o_/   |)|`");
            // System.out.println("                       \\;        \\      ;/");
            // System.out.println("                           \\  .-,   )-.  /");
            // System.out.println("                           /`  .'-'.  `\\");
            // System.out.println("                          ;_.-`.___.'-.;");
            System.out.println();
            // System.out.println("                  \"Bagaimana Praktikumnya? EZ kan?\"");
            // System.out.println();
        }
        else if (this.nama.equals("Mahasiswi")) {
            System.out.println("Hai Athurku :)");
        }
        else {
            System.out.println("People's name not exist");
        }
    }

    public static void togglePause() {
        isPaused = isPaused ? false : true;
    }
}