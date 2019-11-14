package java_practice.Queue;

public class Arrayqueue {
	private static int front,rear,capacity;
	private static int queue[];
	Arrayqueue(int c){
		front=rear=0;
		capacity=c;
		queue=new int[capacity];
	}
	static void queueEnqueue(int data) {
		if(capacity==rear) {
			System.out.println("\n Queue is full");
			return;
		}
		else {
			queue[rear]=data;
			rear++;
		}
		return;
	}
	static void queueDequeue() {
		if(front==rear) {
			System.out.println("queue is empty");
			return;
		}else {
			for(int i=0;i<rear-1;i++) {
				queue[i]=queue[i+1];
			}
			if(rear<capacity) 
				queue[rear]=0;
			rear--;
		}
		return;
	}
	static void displayqueue() {
		if(front==rear) {
			System.out.println("queue is empty");
			return;
		}else {
			for(int i=front;i<rear;i++) {
				System.out.println(queue[i]);
			}
		}
	}
	public static void main(String[] args) {
		Arrayqueue aqueue=new Arrayqueue(10);
		aqueue.queueEnqueue(16);
		aqueue.queueEnqueue(78);
		aqueue.displayqueue();
	}
	
}
