import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface{

	private ArrayList<T> queue;
	private int head;
	private int tail;
	private int size;

	public MyQueue(int s) {

		size = s;
		queue = new ArrayList<T>(size);
		head = 0;
		tail = 0;
	}

	public MyQueue() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//boolean res = false;
		boolean res = false;
		if(queue.isEmpty()) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		//Object val = head.data;
		boolean res=false;

		if(queue.size()==size) {
			res = true;
		} 
		return res;
	}

	@Override
	//delete 
	public Object dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub

		if( isEmpty()) {
			throw new QueueUnderflowException();

		} else {
			T val = queue.get(head);
			queue.remove(queue.indexOf(val));
			tail--;
			return val;
		}


	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int num = queue.size();

		return num;
	}

	@Override
	//add
	public boolean enqueue(Object e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		boolean res = false;

		if(size == tail) {
			throw new QueueOverflowException();
		} else {
			tail++;
			queue.add((T)e);
			res =true;
		}

		return res;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String text = "";
		T val;
		ArrayList<T> copy = queue;
		for(int i = 0; i < copy.size(); i++) {
			val = (T) copy.get(i).toString();
			text += val + delimiter;

		}
		text = text.substring(0,text.length()-1);
		return text;
	}

	public String toString() {
		// TODO Auto-generated method stub
		String text = "";
		T val;
		ArrayList<T> copy = queue;
		for(int i = 0; i < copy.size(); i++) {
			val = (T) copy.get(i).toString();
			text += val;
		}
		return text;


	}

	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		Object val;
		for(int i = 0; i < list.size(); i++) {
			val = (T) list.get(i);
			enqueue(val);
		}
	}

}
