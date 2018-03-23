import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class Praktikan extends Mahasiswa {
  private Queue<Question> q = new LinkedList<>();

  public Praktikan(String nama, Position pos, Queue<Question> q) {
    super(nama, pos);
    this.q = q;
  }
  public Praktikan(Praktikan p) {
    this(p.nama, p.pos, p.q);
  }

  // Builder Praktikan

  /* public static class Builder {
    private final Position pos;
		private final String nama;
    private final Queue<Question> q;

    public Position Builder(final Position _pos) {
      this.pos = _pos;
      return this;
    }

    public String Builder(final String _nama) {
			this.nama = _nama;
			return this;
		}

    public Queue<Question> Builder(final Queue<Question> _q) {
      this.q = _q;
      return this;
    }

    public Praktikan create() {
      return new Praktikan(pos, nama, q);
    }

  } */



  public void addQuestion(Question[] question) {
    Random rand = new Random();
    int n = rand.nextInt(3) + 1;
    int questionIndex = rand.nextInt(question.length);

    for (int i = 0; i < n; i ++ ) {
      q.add(question[questionIndex]);
      questionIndex = rand.nextInt(question.length);
    }
  }

  public Queue<Question> getQueue() {
    return q;
  }

  public Question getQuestion() {
    Question head = q.peek();
    return head;
  }

  public boolean hasQuestion() {
    return (this.q.size() == 0);
  }

  public void move(Position p) {
    this.pos = p;
  }

}