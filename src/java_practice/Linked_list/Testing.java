package java_practice.Linked_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;



public class Testing {
	public static void main(String[] args) {
		System.out.println("merge sorting");
		binary_sorting b=new binary_sorting();
		int arr[]= {1,2,3,4,5,6,7,89,72,100,123,70};
		b.dispaly(arr);
		b.merging(arr, 0,arr.length-1);
		b.dispaly(arr);
		
	
	
	} 	
}

class binary_sorting{
	void merging(int  arr[],int first,int last) {
		if(first<last) {
			int pi=pivot_selection(arr,first,last);
			merging(arr, first, pi-1);
			merging(arr, pi+1, last);
			
			
		}
		
		
	}
	
		
		
		
		
	private int pivot_selection(int[] arr, int first, int last) {
		int pivot=arr[last];
		 int pointer=first-1;
		for(int i=first;i<last;i++) {
			if(arr[i]<pivot ) {
				pointer++;
				//
				int temp= arr[pointer];
				arr[pointer]=arr[i];
				arr[i]=temp;
			}
		}
		//
		int temp=arr[last];
		arr[last]=arr[pointer+1];
		arr[pointer+1]=temp;
		return pointer+1;
	}







	void dispaly(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}


