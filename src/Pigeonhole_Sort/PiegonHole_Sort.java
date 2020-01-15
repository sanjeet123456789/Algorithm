package Pigeonhole_Sort;

import java.util.Arrays;

public class PiegonHole_Sort {
	public static void main(String[] args) {
		PiegonHole_Sort sort=new PiegonHole_Sort();
		int[] arr= {8,3,2,7,4,6,8};
		System.out.println("Sorted order");
		sort.pigenhole(arr,arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void pigenhole(int arr[],int n) {
		int min=arr[0];
		int max=arr[0];
		int range,i,j,index;
		
		for(int a=0;a<n;a++) {
			if(arr[a]>max)
				max=arr[a];
			if(arr[a]<min)
				min=arr[a];
		}
		
		range=max-min+1;
		int[] phole=new int[range];
		Arrays.fill(phole, 0);
		for(i=0;i<n;i++) {
			phole[arr[i]-min]++;
		index=0;
			for(j=0;j<range;j++) {
				while(phole[j]-->0) {
					arr[index++]=j+min;
				}
			}
		}
	}
}
