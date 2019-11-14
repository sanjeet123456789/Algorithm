package java_practice.Array_list;

import java.util.ArrayList;
import java.util.Iterator;

public class Array_list {
	public static void main(String[] args) {
		System.out.println("hello");
		ArrayList name_list=new ArrayList();
		name_list.add("sanjeet");
		name_list.add("saurab");
		name_list.add("shivam");
		name_list.add("rahul");
		name_list.add("9tara");
		System.out.println(name_list.get(2));
		name_list.remove(2);
		System.out.println(name_list.size());
		//3 Ways to traverse
		Iterator iterator=name_list.iterator();
		while(iterator.hasNext()) {
			Object name=iterator.next();
			System.out.println(name);
		}
		for(Object name:name_list) {
			System.out.println(name);
		}
		
		for(int i=0;i<name_list.size();i++) {
			System.out.println(name_list.get(i));
		}
	}
	
}
