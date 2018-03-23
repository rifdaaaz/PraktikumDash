//Queue Praktikan Singleton
import java.util.Queue;
import java.util.LinkedList;

public class QueuePraktikan {
	
	static Queue<Praktikan> queue = new LinkedList<Praktikan>();
	private static QueuePraktikan queueInstance = null;

	public static QueuePraktikan getInstance(){
		if (queueInstance==null) {
			queueInstance = new QueuePraktikan();
		}
		return queueInstance;
	}

	public Queue<Praktikan> get() {
		return queue;
	}
	//constructor private agar tdk bisa diinisialisasi
	private QueuePraktikan() {}

	public void add(Praktikan value){
		syncronized (queue) {
			queue.add(value);
		}
	}

	public void remove(Praktikan value){
		syncronized (queue) {
			queue.remove(value);
		}
	}

	//pol ini kayak pop, return null kalo queue empty
	public Praktikan poll() {
		Praktikan data = queue.poll();
		return data;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int getTotalSize() {
		return queue.size();
	}

}