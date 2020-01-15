package java_practice.Heap_Sort;

public class Heap_Sort {
	public static void main(String[] args) {
		int arr[]= {12,11,13,4,5,8,9};
		int n=arr.length;
		
		Heap_Sort ob=new Heap_Sort();
		ob.sort(arr);
		System.out.println("Sorted array is");
		printArray(arr);
	}
	static void printArray(int arr[]) {
		int n=arr.length;
		for(int i=0;i<n;++i) {
			System.out.println(arr[i]+" ");
			
		}
		System.out.println();
	}
	public void sort(int arr[]) {
		
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--)
			heapify(arr,n,i);
		for(int i=n-1;i>=0;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			
			heapify(arr,i,0);
			
//			printArray(arr);
		}
	}
	void heapify(int arr[],int n,int i) {
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		if(l<n && arr[l]>arr[largest])
			largest=l;
		if(r<n&&arr[r]>arr[largest])
			largest=r;
//		printArray(arr);
		if(largest!=i) {
			int swap=arr[i];
			arr[i]=arr[largest];
			arr[largest]=swap;
//			printArray(arr);
			heapify(arr,n,largest);
		}
	}
}
