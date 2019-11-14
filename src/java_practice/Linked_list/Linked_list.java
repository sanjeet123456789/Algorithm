package java_practice.Linked_list;

import java.util.LinkedList;

public class Linked_list {
 public static void main(String[] args) {
	LinkedList name_list=new LinkedList();
	name_list.add(30);
	name_list.add("sanjeet pal");
	name_list.add("sagar");
	name_list.add(null);
	name_list.add("mohan");
	name_list.add("3sha");
	System.out.println(name_list);
	name_list.addFirst("first name");
	name_list.addLast("last name");
	System.out.println(name_list);
	name_list.removeFirst();
	name_list.removeLast();
	System.out.print(name_list);
	
	
	
	
}
}
