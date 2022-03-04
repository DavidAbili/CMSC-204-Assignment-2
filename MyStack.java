import java.util.ArrayList;

//import MyStack.Node;

public class MyStack<T> implements StackInterface {

	private ArrayList<T> stack;
	private int size;
	private T top;


	public MyStack(int s) {

		size = s;
		stack = new ArrayList<T>(size);
	}

	public MyStack() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean res = false;
		if(stack.isEmpty()) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		boolean res = false;
		if(size == stack.size()) {
			res = true;
		}
		return res;
	}

	@Override
	public Object pop() throws StackUnderflowException {
		// TODO Auto-generated method stub

		if(isEmpty()) {
			throw new StackUnderflowException();
		} else {
			T val = stack.get(size()-1);
			stack.remove(size()-1);
			return val;
		}

	}

	@Override
	public Object top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackUnderflowException();	
		} else {
			top = stack.get(stack.size()-1);
		}
		return top;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int num = stack.size();

		return num;
	}

	@Override
	public boolean push(Object e) throws StackOverflowException {
		// TODO Auto-generated method stub
		boolean res = false;
		if(isFull()) {
			throw new StackOverflowException();
		} else {
			stack.add((T) e);
			res = true;	
		}
		return res;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String text = "";
		T val;
		ArrayList<T> copy = stack;
		for(int i = 0; i < copy.size(); i++) {
			val = (T) copy.get(i).toString();
			text += val + delimiter;

		}
		text = text.substring(0,text.length()-1);
		return text;


	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String text = "";
		T val;
		ArrayList<T> copy = stack;
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
			push(val);
		}
	}
}
