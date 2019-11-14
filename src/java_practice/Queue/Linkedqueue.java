package java_practice.Queue;

public class Linkedqueue {
	public static void main(String[] args) {
		Liknodeque l=new Liknodeque();
		l.enque(78);
		l.enque(77);
		l.enque(74);
		l.enque(88);
		l.enque(99);
		l.enque(100);
		l.enque(112);
		l.enque(114);
		l.traverse();
		l.dequeue();
		l.dequeue();
		l.traverse();
	}

}
class Liknodeque{
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			this.data=d;
			this.next=null;
		}
		
	}
	
	Node front ,rear;
	public Liknodeque() {
		this.front=this.rear=null;
	}
	//add int node
	void enque(int new_data) {
		Node new_node=new Node(new_data);
		if(this.rear==null) {
			this.front=this.rear=new_node;
			return;
		}
		this.rear.next=new_node;
		this.rear=new_node;
	}
	//method to remove node
	 void dequeue() {
		if(this.front==null) {
			return;
		}
		Node first_node=this.front;
		System.out.println(first_node.data+"de");
		this.front=this.front.next;
//		if(this.front==null) {
//			this.rear=null;
//		}
		
		
	}
	 void traverse() {
		 Node temp=this.front;
		 while(temp!=null) {
			 System.out.println(temp.data);
			 temp=temp.next;
		 }
	 }
	
}