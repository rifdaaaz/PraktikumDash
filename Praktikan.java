import java.util.Queue; //Import queue library from java standard library
import java.util.LinkedList; //Import LinkedList library from java standard library
import java.util.Random; //Import Random library from java standard library

public class Praktikan extends Mahasiswa {
  private static int count = 0; //atributte that show the number of Praktikan instatiated
  private char logo = '1'; //attribute that show the logo of praktikan
  private Queue<Question> q = new LinkedList<>(); //attribute to contain question on queue

  //=======================================
  // BUILDER PATTERN OF Praktikan CLASS
  //=======================================
  private Praktikan(Builder builder) {
    this.pos = builder.pos; //setting praktikan position (Mahasiswa attributes) based on position value of builder 
    this.nama = builder.nama; //setting praktikan position (Mahasiswa attributes) based on position value of builder
    count++; //Add the number of praktikan number
    logo += count - 1; //Add the number of logo to differentiate between other (build) praktikan
  }

  // Builder inner class
  public static class Builder {
    //all of attribute of praktikan are copied to builder attributes
    private Position pos; //attribute position 
    private String nama; //attribute nama

    public Builder pos(Position _pos) {
    //method constructor of Builder to set position
      this.pos = _pos;
      return this;
    }

    public Builder nama(String _nama) {
    //method constructor of PraktikanBuilder to set nama
      this.nama = _nama;
      return this;
    }


    public Praktikan create() {
    //method to build 
      return new Praktikan(this);
    }

  }

  public char getLogo(){
		return logo;
	}

  public void addQuestion(Question[] question) {
    Random rand = new Random();
    int n = rand.nextInt(3) + 1;

    for (int i = 0; i < n; i ++ ) {
      int questionIndex = rand.nextInt(question.length);
      q.add(question[questionIndex]);
    }
  }

  public Queue<Question> getQueue() {
    return q;
  }

  public Question getQuestion() {
    Question head = q.poll();
    return head;
  }

  public boolean hasQuestion() {
    return (this.q.size() > 0);
  }

  public void move(Position p) {
    this.pos = p;
  }

}