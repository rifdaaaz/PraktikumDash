import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class IOHandler {
    
    public static File stringToFile (String filename){
        return (new File(filename));
    }
    
    public static ArrayList<Question> addQuestionFromText (File fileIn){
        Scanner inFile = null;
        try{
            inFile = new Scanner (fileIn); //object IO
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        String line1,line2; //read from txt
        ArrayList<Question> arrQuestions = new ArrayList(12);
        int i = 0; //index 
        while(inFile.hasNext()){
            line1 = inFile.nextLine();
            line2 = inFile.nextLine();
            arrQuestions.add(i,new Question(line1,line2));
            i++;
        }
        return arrQuestions;
    }

    public static ArrayList<Praktikan> addPraktikanFromText (File fileIn){
        Scanner inFile = null;
        try{
            inFile = new Scanner (fileIn); //object IO
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        String line1,line2,line3; //read from txt
        ArrayList<Praktikan> arrPraktikan = new ArrayList(4);
        int i = 0; //index 
        while(inFile.hasNext()){
            line1 = inFile.nextLine();
            line2 = inFile.nextLine();
            line3 = inFile.nextLine();
            arrPraktikan.add(i,new Praktikan(line1,new Position (Integer.parseInt(line2),Integer.parseInt(line3))));
            i++;
        }
        return arrPraktikan;
    }

    public static ArrayList<Asisten> addAsistenFromText (File fileIn){
        Scanner inFile = null;
        try{
            inFile = new Scanner (fileIn); //object IO
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        String line1,line2,line3; //read from txt
        ArrayList<Asisten> arrAsisten = new ArrayList(4);
        int i = 0; //index 
        while(inFile.hasNext()){
            line1 = inFile.nextLine();
            line2 = inFile.nextLine();
            line3 = inFile.nextLine();
            arrAsisten.add(i,new Asisten(line1,new Position (Integer.parseInt(line2),Integer.parseInt(line3))));
            i++;
        }
        return arrAsisten;
    }
} 