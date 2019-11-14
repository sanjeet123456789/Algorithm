package java_practice.Binary_Search;

import java.util.ArrayList;
import java.util.List;


public class Binary_Search {
	public static void main(String[] args) {
		System.out.println("linked list");
		int[] arr_list= {1,2,3,4,5,6,7,8,9,10,11,12};
		System.out.println(arr_list.length);
		binarySearchlist(arr_list,74,0,arr_list.length-1);
		
	}

	private static void binarySearchlist(int[] arr_list, int x, int first, int last) {
		int mid=(first+last)/2;
		while(first<=last) {
			
			if(arr_list[mid]<x) {
				first=mid+1;
				
			}else if(arr_list[mid]==x) {
				System.out.println("found at"+mid);
				break;
			}else {
				last=mid-1;
			}
			mid=(first+last)/2;
		}
		if(first>last) {
			System.out.println("not found!");
		}
		// TODO Auto-generated method stub
		
	}


}
