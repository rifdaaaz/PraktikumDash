import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class Praktikan extends Mahasiswa {
  private static int count = 0;
  private char logo = '1';
  private Queue<Question> q = new LinkedList<>();
  private static boolean isPaused = false;
  private int index;
  public int getIndex(){return index;}

  public Praktikan(Praktikan p) {
    this.pos = p.pos;
    this.nama = p.nama;
    this.logo = p.logo;
  }

  private Praktikan(Builder builder) {
    this.pos = builder.pos;
    this.nama = builder.nama;
    index = count;
    count++;
    logo += count - 1;
  }

  // Builder Praktikan
  
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


    public Praktikan create() {
      return new Praktikan(this);
    }

  }

  public static boolean getIsPaused() {
    return isPaused;
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

  public void thank(){
    View.setQuotationPraktikan(nama + "\t: Terimakasih Kak! :)",index);
  }

  public void run() {
    Peta p = Peta.getInstance();
    View.setQuotationPraktikan(nama + "\t: KAKK... KAKK..",index);
    while(hasQuestion() && !Main.getGameOver()){
      Random rand = new Random();
      int n = rand.nextInt(4)+3;
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
      p.placePraktikan(this);
      if(hasQuestion()){
        View.setQuotationPraktikan(nama + "\t: KAKK... KAKK..",index);
      }
    }
  }

  public static void togglePause() {
    isPaused = isPaused ? false : true;
  }

}