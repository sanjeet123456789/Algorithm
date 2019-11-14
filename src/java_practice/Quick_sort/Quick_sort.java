package java_practice.Quick_sort;

public class Quick_sort {
	public static void main(String[] args) {
		int arr[]= {78,79,45,1,5,4,8,15748};
		QuickSorting q=new QuickSorting();
		q.display(arr);
		q.sort(arr,0,arr.length-1);
		q.display(arr);
	}
}
class QuickSorting{
	int partition(int[] arr,int low,int high) {
//		System.out.println(arr[high]);
		int pivoting=arr[high];
		int i=(low-1);
		for(int j=low;j<high;j++) {
			//if current element is smaller then pivot
			if(arr[j]<pivoting) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		// place pivot in position
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
	
	void sort(int[] arr,int low,int high) {
		if(low<high) {
			int pi=partition(arr, low, high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
			
		}
		
	}
	void display(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
