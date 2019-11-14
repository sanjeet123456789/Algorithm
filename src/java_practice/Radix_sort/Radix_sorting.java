package java_practice.Radix_sort;
import java.util.*;
public class Radix_sorting {
	static int getMax(int arr[],int n) {
		int mx=arr[0];
		for(int i=0;i<n;i++) {
			if(arr[i]>mx) {
				mx=arr[i];
			}
			
		}
		return mx;
	}
	//function to do counting sortof arr[] according to 
	//the digit represented by exp
	static void countSort(int arr[],int n,int exp) {
		int output[]=new int[n];
		int i;
		int count[]=new int[10];
//		Arrays.fill(count,0);
		//store count of occurences in count[]
		for(i=0;i<n;i++) {
			count[(arr[i]/exp)%10]++;
//			System.out.println(count[(arr[i]/exp)%10]);
		}
		//change count[i] so that count[i]now contains
		//actual position of this digital in output[]
		for(i=1;i<10;i++) {
			count[i]+=count[i-1];
//			System.out.println(count[i]);
		}
		//build the output array
		for(i=n-1;i>=0;i--) {
			output[count[(arr[i]/exp)%10]-1]=arr[i];
			count[(arr[i]/exp)%10]--;
		}
		//copy the output array to arr[] so that arr[] now
		//contains sorted numbers according to current digit
		for(i=0;i<n;i++) {
			arr[i]=output[i];
		}
		
			
	}
	//main function to that sorts arr[] of sizen using  radix sort
	static void radixsort(int arr[],int n) {
		//Find the maximum number to know number of digits
		int m=getMax(arr,n);
	
		for(int exp=1;m/exp>0;exp*=10) {
			countSort(arr, n, exp);
		}
	}
	//utility function to print an array
	static void printx(int arr[],int n) {
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]+" ");
		}
	}
	//driver or main function to check above function
	public static void main(String[] args) {
		int arr[]= {170,465,15,92,802,45,2,66};
		int n=arr.length;
		radixsort(arr, n);
		printx(arr, n);
	}
	
	
	
		
}
