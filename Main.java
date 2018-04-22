import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;

public class Main {
    private static boolean GameOver = false;
    public static void setGameOver(boolean b){
        GameOver = b;
    }
    
    public static boolean getGameOver(){
        return GameOver;
    }

    public static void displayIntro() {
        System.out.println("\t______          _    _   _ _                     ______          _     ");
        System.out.println("\t| ___ \\        | |  | | (_) |                    |  _  \\        | |    ");
        System.out.println("\t| |_/ / __ __ _| | _| |_ _| | ___   _ _ __ ___   | | | |__ _ ___| |__  ");
        System.out.println("\t|  __/ '__/ _` | |/ / __| | |/ / | | | '_ ` _ \\  | | | / _` / __| '_ \\ ");
        System.out.println("\t| |  | | | (_| |   <| |_| |   <| |_| | | | | | | | |/ / (_| \\__ \\ | | |");
        System.out.println("\t\\_|  |_|  \\__,_|_|\\_\\\\__|_|_|\\_\\\\__,_|_| |_| |_| |___/ \\__,_|___/_| |_|\n");
                                                                         
        System.out.print("\t\t\t\tInitializing");
        for (int i = 0; i<4; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println();
    }

    public static void displayPemain(Praktikan[] p,Asisten[] a) {

        System.out.println("Asisten:");
        for (int i = 0; i< a.length; i++) {
            System.out.println(a[i].getNama()+": "+a[i].getPos()); 
        }

        System.out.println();

        System.out.println("Praktikan:");
        for (int i = 0; i< p.length; i++) {
            System.out.println(p[i].getNama()+": "+p[i].getPos()); 
        }
        
        System.out.println("\t\t\tPress enter to start..");                                                             
        try{
            System.in.read();
        }catch(Exception e){

        }
        System.out.println();
        System.out.println("The game is starting\n");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void displayEpilog() {
        System.out.println("  ___   _   __  __ ___    _____   _____ ___ ");
        System.out.println(" / __| /_\\ |  \\/  | __|  / _ \\ \\ / / __| _ \\");
        System.out.println("| (_ |/ _ \\| |\\/| | _|  | (_) \\ V /| _||   /");
        System.out.println(" \\___/_/ \\_\\_|  |_|___|  \\___/ \\_/ |___|_|_\\");
    }

    public static void main(String[] args) {
        // Random r = new Random();
        // int n = r.nextInt(5000) + 1000;

        displayIntro();
        Scanner sc = new Scanner(System.in);
        ArrayList<Question> qList = IOHandler.addQuestionFromText(IOHandler.stringToFile("Question.txt"));
        Question[] arrq = new Question[qList.size()];
        ArrayList<Praktikan> pList = IOHandler.addPraktikanFromText(IOHandler.stringToFile("praktikan.txt"));
        ArrayList<Asisten> aList = IOHandler.addAsistenFromText(IOHandler.stringToFile("asisten.txt"));
        WorldBuilder world = new WorldBuilder.Builder() .asisten1(aList.get(0))
                                                        .asisten2(aList.get(1))
                                                        .praktikan1(pList.get(0))
                                                        .praktikan2(pList.get(1))
                                                        .praktikan3(pList.get(2))
                                                        .praktikan4(pList.get(3)) 
                                                        .questionList(new ArrayList<Question>()).build();
        // Map map = new Map();
        // Position letakSandro = new Position(3, 5);
        Asisten a[] = new Asisten[2];
        a[0] = world.getAsisten1();
        a[1] = world.getAsisten2();

        // Position letakAthur = new Position(6, 6);
        Praktikan[] p = new Praktikan[4];
        p[0] = world.getPraktikan4();
        p[1] = world.getPraktikan1();
        p[2] = world.getPraktikan2();
        p[3] = world.getPraktikan3();
        arrq = qList.toArray(arrq);
        Peta maze = Peta.getInstance();
                
        QueuePraktikan qp = QueuePraktikan.getInstance();
        for (int i = 0; i < p.length; i++) {
            p[i].addQuestion(arrq);
            if(p[i].hasQuestion()) {
                qp.add(p[i]);
            }
        }

        //Bikin orang
        Orang people = new Orang.Builder().pos(new Position())
                                           .nama("Einstein")
                                           .create();

        Orang odie = new Orang.Builder().pos(new Position())
                                           .nama("Odie")
                                           .create();


        char[][] temp = new char[][]{
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','#','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','.','.','#','#','#','.','.','.','.','.','#'},
            {'#','.','#','.','.','.','.','#','.','.','.','.','.','#'},
            {'#','.','#','.','.','.','.','#','#','#','#','#','#','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','#','#','#','#','#','#','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','#','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','#','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','#','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };
        maze.setPeta(temp);
        
        displayPemain(p,a);

  

        for (int i = 0; i< p.length; i++) {
            p[i].start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i< a.length; i++) {
            a[i].start();
        }


        //people.start();
        //odie.start();

        setGameOver((!a[0].isActive() && !a[1].isActive()) || Asisten.getCount() <= 0);
            
        while (!getGameOver()) {
            // if (n<100) {
            //     people.start();
            // }
            while (Asisten.isPaused) {
                try {
                  Thread.sleep(1000);
                } catch (InterruptedException ex) {
                  Thread.currentThread().interrupt();
                }
            }
            SwingUtilities.invokeLater(new Runnable() {
            
                @Override
                public void run() {
                    View view = new View();
                    view.setVisible(true);
                        view.setView(maze.printPeta(p,a));
                        System.out.println("repaint?????");
                       // view.removeAll();
                        view.revalidate();
                        view.repaint();
                        System.out.println("HELLO");
                     
                }
            });     
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            setGameOver((!a[0].isActive() && !a[1].isActive()) || Asisten.getCount() <= 0);

        }
        if (getGameOver()){
            try {
                for (int i = 0; i< p.length; i++) {
                    p[i].join();
                }
            }catch(Exception e) {
                //do nothing
            }
        }

        if (Asisten.getCount() <= 0) {
            System.out.println("Semua asisten pingsan, praktikum kali ini repeating semua");
        } else{
            System.out.println("Praktikum Selesai");
            for (int i = 0; i< p.length; i++) {
                p[i].thank();
            }
            
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
            displayEpilog();

    }


}