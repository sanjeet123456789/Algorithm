package java_practice.Stack;
import static java.lang.System.exit;
public class Linkedstack {
	public static void main(String[] args) {
		Lenkedclass l=new Lenkedclass();
		l.push(10);
		l.push(88);
		l.push(78);
		l.display();
		l.pop();
		l.display();
	}
}
class Lenkedclass{
	Node top;
	 class Node{
		int data;
		Node next;
		Node(int d){
			this.data=d;
			this.next=null;
		}
	}
	Lenkedclass(){
		this.top=null;
	}
	
	 void push(int new_data) {	
		Node new_node=new Node(new_data);
//		if(new_node==null) {
//			System.out.println("heap overflow");
//			return;
//		}
		new_node.data=new_data;
		new_node.next=top;
		top=new_node;
	}
	 void pop() {
		if(top==null) {
			System.out.println("stack overflow");
			return;
		}
		top=(top).next;
	}
	 void display() {
		if(top==null) {
			System.out.println("Nothing to display");
			exit(1);
		}else {
			Node x=top;
			while(x!=null) {
				System.out.println(x.data);
				x=x.next;
			}
		}
		
		
		
	}
}