import java.util.ArrayList;
import java.util.Scanner;

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
        Asisten sandro = world.getAsisten1();
        Asisten varrel = world.getAsisten2();
        map.placeAsisten(sandro);
        map.placeAsisten(varrel);

        // Position letakAthur = new Position(6, 6);
        Praktikan[] p = new Praktikan[4];
        p[0] = world.getPraktikan4();
        p[1] = world.getPraktikan1();
        p[2] = world.getPraktikan2();
        p[3] = world.getPraktikan3();
        arrq = qList.toArray(arrq);
        for (int i = 0; i < 4; i++) {
            p[i].addQuestion(arrq);
            map.placePraktikan(p[i]);
        }
        
        QueuePraktikan qp = QueuePraktikan.getInstance();
        for (int i = 0; i < 4; i++) {
            if(p[i].hasQuestion()) {
                qp.add(p[i]);
            }
        }
        sandro.setTarget(qp.poll());
        //System.out.println(athur.getPos());
        while (!qp.isEmpty()) {
            while (!sandro.isSampai()) {
                map.setTitik(sandro.getPos());
                sandro.move();
                map.placeAsisten(sandro);
                map.printMap();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            sandro.jawab();
            sandro.setTarget(qp.poll());
        }
    }


}