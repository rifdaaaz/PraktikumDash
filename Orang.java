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

    private static void delay(int n) {
        try {
            Thread.sleep(n);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
    Random r = new Random();
        /* while(isPaused){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            } 
        } */
        // int n = r.nextInt(2) + 7;
        int n = 7;
        delay(n*1000);
        if (!Asisten.getIsPaused() && !Praktikan.getIsPaused()) {
            Asisten.togglePause();
            Praktikan.togglePause();

            sapa();

            Asisten.togglePause();
            Praktikan.togglePause();
        }
    }

    public void sapa(){
        if (this.nama == "Einstein") {
            
            System.out.println();
            System.out.println("                          Einstein Datang");
            System.out.println();
            System.out.println("                                       ,---,_");
            System.out.println("                           _>   `'-.  .--'/");
            System.out.println("                       .--'` ._      `/   <_");
            System.out.println("                       >,-' ._'.. ..__ . ' '-.");
            System.out.println("                   .-'   .'`         `'.     '.");
            System.out.println("                       >   / >`-.     .-'< \\ , '._\\");
            System.out.println("                   /    ; '-._>   <_.-' ;  '._>");
            System.out.println("                   `>  ,/  /___\\ /___\\  \\_  /");
            System.out.println("                   `.-|(|  \\o_/  \\o_/   |)|`");
            System.out.println("                       \\;        \\      ;/");
            System.out.println("                           \\  .-,   )-.  /");
            System.out.println("                           /`  .'-'.  `\\");
            System.out.println("                          ;_.-`.___.'-.;");
            System.out.println();
            System.out.println("                  Bagaimana Praktikumnya? EZ kan?");
            System.out.println();
        }
        else if (this.nama == "Odie") {
            // int chance = r.nextInt(2);
            int chance = 2;
            if (chance == 2) {
                delay(500);
                System.out.println();
                System.out.println("                                   You are lucky! ");
                System.out.println("                                You got to see Odie! ");
                System.out.println("                              The chance only 50% btw ");
                System.out.println();
                System.out.println("                                 _.._   _..---.");
                System.out.println("                             .-\"    ;-\"       \\");
                System.out.println("                             /      /           |");
                System.out.println("                            |      |       _=   |");
                System.out.println("                            ;   _.-'\\__.-')     |");
                System.out.println("                                       `-'      |   |    ;");
                System.out.println("                                      |  /;   /      _,");
                System.out.println("                                 .-.;.-=-./-\"\"-.-` _`");
                System.out.println("                                 /   |     \\     \\-` `,");
                System.out.println("                                 |    |      |     |");
                System.out.println("                                 |____|______|     |");
                System.out.println("                                  \0 / \0   /      /");
                System.out.println("                              .--.-\"\"-.`--'     .'");
                System.out.println("                              (#   )          ,  \\");
                System.out.println("                              ('--'          /\\`  \\");
                System.out.println("                              \\       ,,  .'      \\");
                System.out.println("                                  `-._    _.'\\        \\");
                System.out.println("                                      `\"\"`    \\        \\");
                System.out.println();
                System.out.println("                       Now wait 3 second to continue playing... ");
                delay(3000);
            }
        }
        else {
            System.out.println("People's name not exist");
        }
    }

    public static void togglePause() {
        isPaused = isPaused ? false : true;
    }
}