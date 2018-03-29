import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Main {
       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Instatiate new scanner obj
        //======================
        // HANDLING Input/Output
        //======================
        ArrayList<Question> qList = IOHandler.addQuestionFromText(IOHandler.stringToFile("Question.txt"));
        //qList to contain Question from file "Question.txt"
        Question[] arrq = new Question[qList.size()];
        //arrq (an array of Question) use to add the question to praktikan
        ArrayList<Praktikan> pList = IOHandler.addPraktikanFromText(IOHandler.stringToFile("praktikan.txt"));
        //pList to contain praktikan from file "praktikan.txt"
        ArrayList<Asisten> aList = IOHandler.addAsistenFromText(IOHandler.stringToFile("asisten.txt"));
        //aList to contain Asisten from file "asisten.txt"

        //=======================================
        // INSTATIATE WORLD USING BUILDER PATTERN
        //=======================================
        WorldBuilder world = new WorldBuilder.Builder().asisten1(aList.get(0))
                                                        .asisten2(aList.get(1))
                                                        .praktikan1(pList.get(0))
                                                        .praktikan2(pList.get(1))
                                                        .praktikan3(pList.get(2))
                                                        .praktikan4(pList.get(3)) 
                                                        .questionList(new ArrayList<Question>()).build();

        Map map = new Map();
        //map to show position of asisten and praktikan
        Asisten a[] = new Asisten[2];
        //Instantiate array of Asisten to contain asisten from the world
        a[0] = world.getAsisten1(); //get Asisten from the world
        a[1] = world.getAsisten2(); //get Asisten from the world

        Praktikan[] p = new Praktikan[4];
        //Instatiate array of Praktikan to contain praktikan from the world
        p[0] = world.getPraktikan4(); //get Praktikan from the world
        p[1] = world.getPraktikan1(); //get Praktikan from the world
        p[2] = world.getPraktikan2(); //get Praktikan from the world
        p[3] = world.getPraktikan3(); //get Praktikan from the world
        arrq = qList.toArray(arrq); //add Question from qList (ArrayList of Question) to arrq
                
        QueuePraktikan qp = QueuePraktikan.getInstance(); //Instatiate Queue Praktikan using Singleton pattern
        
        //======================================
        // ADDING PRAKTIKAN TO QUEUEPRAKTIKAN
        //======================================
        for (int i = 0; i < p.length; i++) { 
            p[i].addQuestion(arrq); // Add question from arrq to list of question
            if(p[i].hasQuestion()) { 
                qp.add(p[i]); //add praktikan to QueuePraktikan
            }
        }

        //========================================
        // STARTING THREAD of ALL ASISTEN on ARRAY
        //=======================================

        for (int i = 0; i< a.length; i++) {
            a[i].start(); // menjalankan thread asisten untuk seluruh asisten pada array of asisten
        }
        
        // SwingUtilities.invokeLater(new Runnable()) {

        //     @Override
        //     public void run() {
        //         View view = new View();
        //         view.setVisible(true);
        //         view.setView(map.get());
        //         view.revalidate();
        //         view.repaint();
        //         System.out.println("HELLO");
        //     }
        // });

        
        // while (!qp.isEmpty()) {
        //     for (int i = 0; i<a.length; i++) {
        //          map.setTitik(a[i].getPos());
        //          map.placeAsisten(a[i]);
        //     }

        //      for (int i = 0; i<p.length; i++) {
        //          map.setTitik(p[i].getPos());
        //          map.placePraktikan(p[i]);
        //      }

        //     map.printMap();
        //     try {
        //         Thread.sleep(1000);
        //     } catch (InterruptedException ex) {
        //         Thread.currentThread().interrupt();
        //     }

        // }
    }


}