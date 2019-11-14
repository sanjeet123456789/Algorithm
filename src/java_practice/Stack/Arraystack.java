package java_practice.Stack;

public class Arraystack {
	private  int index=0;
	private int arr[];
	private int size;
	public  Arraystack(int size) {
		this.size=size;
		arr=new int[size];
		// TODO Auto-generated constructor stub
	}
	public void push(int element) {
		if(isfull()) {
			throw new StackOverflowError("stack is full");
		}
		arr[index]=element;
		index++;
	}
	private boolean isfull() {
		if(index==size) {
			return true;
		}
		return false;
	}
	public int pop() {
		if(isEmpty()) {
			throw new StackOverflowError("stack is empty");
		}
		return arr[--index];
	}
	private boolean isEmpty() {
		if(index==0) {
			return true;
		}
		return false;
	}
	public int size() {
		return index;
	}
	public  void traverse() {
		for(int i=0;i<index;i++) {
			System.out.print(arr[i]);
		}
	}
	public static void main(String[] args) {
		Arraystack arrstack=new Arraystack(5);
		arrstack.push(5);
		arrstack.push(6);
		arrstack.push(7);
		arrstack.push(8);
		arrstack.pop();
		System.out.println(arrstack.size());
		arrstack.traverse();
	}
}
