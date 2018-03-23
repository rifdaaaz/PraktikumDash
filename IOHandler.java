import java.io.*;
import java.util.Scanner;

public static class IOHandler {
    
    public static ArrayList<Question> addQuestionFromText (FileInputStream fileIn){
        try{
            Scanner inFile = new Scanner (fileIn); //object IO
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        String line1,line2; //read from txt
        ArrayList<Question> arrQuestions = new Question[12];
        int i = 0; //index 
        while(inFile.hasNext()){
            line1 = inFile.nextLine();
            line2 = inFile.nextLine();
            arrQuestions.add(i,new Question(line1,line2));
            i++;
        }
        return arrQuestions;
       
    }
     

} 