import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Main {
       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Question> qList = IOHandler.addQuestionFromText(IOHandler.stringToFile("Question.txt"));
        Question[] arrq = new Question[qList.size()];
        ArrayList<Praktikan> pList = IOHandler.addPraktikanFromText(IOHandler.stringToFile("praktikan.txt"));
        ArrayList<Asisten> aList = IOHandler.addAsistenFromText(IOHandler.stringToFile("asisten.txt"));
        WorldBuilder world = new WorldBuilder.Builder().asisten1(aList.get(0))
                                                        .asisten2(aList.get(1))
                                                        .praktikan1(pList.get(0))
                                                        .praktikan2(pList.get(1))
                                                        .praktikan3(pList.get(2))
                                                        .praktikan4(pList.get(3)) 
                                                        .questionList(new ArrayList<Question>()).build();
        Map map = new Map();
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
                
        QueuePraktikan qp = QueuePraktikan.getInstance();
        for (int i = 0; i < p.length; i++) {
            p[i].addQuestion(arrq);
            if(p[i].hasQuestion()) {
                qp.add(p[i]);
            }
        }

        for (int i = 0; i< a.length; i++) {
            a[i].start();
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                View view = new View();
                view.setVisible(true);
                view.setView(map.get());
                view.repaint();
            }
        });

        
        while (!qp.isEmpty()) {
            for (int i = 0; i<a.length; i++) {
                 map.setTitik(a[i].getPos());
                 map.placeAsisten(a[i]);
                 a[i].display();
            }

             for (int i = 0; i<p.length; i++) {
                 map.setTitik(p[i].getPos());
                 map.placePraktikan(p[i]);
             }

            //map.printMap();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }


}