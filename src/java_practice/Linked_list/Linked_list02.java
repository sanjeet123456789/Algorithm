package java_practice.Linked_list;



public class Linked_list02 {
	Node head;
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
		
	}
	
	//inserting at first position
	
	void push(int new_data) {
		
		Node new_node=new Node(new_data);
		new_node.data=new_data;
		new_node.next=head;
		head=new_node;
	}
	//inserting after given prev value
	public void insertAfter(Node prev_node,int new_data) {
		if(prev_node==null) {
			System.out.println("the given previous value cannot be null");
			return;
		}
		Node new_node=new Node(new_data);
		//making next of new node as next of perevious node
		new_node.next=prev_node.next;
		prev_node.next=new_node;
		
	}
	//inserting at the end of linked list
	public void append(int new_data) {
		Node new_node=new Node(new_data);
		//if linked list is empty
		if(head==null) {
			head=new Node(new_data);
			return;
		}
		//new node going to be last node of next ==null
		new_node.next=null;
		//traverse till the last before inserting
		Node last=head;
		while(last.next!=null)
			last=last.next;
		//change the next of lat node
		last.next=new_node;
		return;
	}
	public void deleteFirst() {
		if(head==null) {
			System.out.println("linked list is empty");
			return;
		}
		Node first=head;
		Node second=head.next;
		first=null;
		head=second;		
//		System.out.println("de"+second.data);
		
	}
	public  void delete_last() {
		if(head==null) {
			System.out.println("linked is empty");
			return ;
		}if(head.next==null) {
			return ;
		}
		Node last=head;
		while(last.next.next!=null) {
			last=last.next;
			
		}
		//if headis null
		
		System.out.println(last.data+"De");
		last.next=null;
		
		
		
	}
	public void deleteMid(Node current) {
		if(head==null) {
			System.out.println("linked is empty");
			return ;
		}
		Node node=head;
		while(node.next!=current) {
			node=node.next;
		}
		System.out.println(node.next.data+"delete in mid");
		node.next=current.next;
//		node.next=null;
	
		
		
	}

	//traverse and print
	public void print_traverse() {
	Node last=head;
		while(last.next!=null) {
			System.out.println(last.data);
			last=last.next;
			
		}
			
	}
	public static void main(String[] args) {
		Linked_list02 list_name=new Linked_list02();
		list_name.append(6);
	
		list_name.append(7);
		list_name.append(8);
		list_name.append(9);
		list_name.push(777);
		list_name.append(10);
		list_name.append(11);
		list_name.insertAfter(list_name.head.next, 8);
		list_name.append(11);
		
		list_name.push(8);
		
		list_name.print_traverse();
		System.out.println("conplete");
//		list_name.deleteFirst();
		list_name.deleteMid(list_name.head.next.next);
//		list_name.delete_last();
		list_name.print_traverse();
	}
}
