import java.util.LinkedList;
import java.util.Queue;
 
public class QueuePraktikan {
 
	static Queue<Praktikan> queue = new LinkedList<Praktikan>();
	private static QueuePraktikan queueInstance = null;
	public static QueuePraktikan getInstance() {
 
		if (queueInstance == null) {
			queueInstance = new QueuePraktikan();
		}
		return queueInstance;
	}
 
	public Queue<Praktikan> get() {
		return queue;
	}
 
	// Inserts the specified element into this queue if it is possible to do so
	// immediately without violating capacity restrictions
	public void add(Praktikan value) {
		synchronized (queue) {
			queue.add(value);
		}
	}
 
	// Removes a single instance of the specified element from this collection
	public void remove(Praktikan value) {
		synchronized (queue) {
			queue.remove(value);
		}
	}
 
	// Retrieves and removes the head of this queue, or returns null if this
	// queue is empty.
	public Praktikan poll() {
		Praktikan data = queue.poll();
		return data;
	}
 
	// Returns true if this collection contains no elements
	public boolean isEmpty() {
		return queue.isEmpty();
	}
 
	// Returns the number of elements in this collection. If this collection
	// contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE
	public int getTotalSize() {
		return queue.size();
	}
}