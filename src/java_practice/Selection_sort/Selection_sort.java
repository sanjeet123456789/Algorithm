package java_practice.Selection_sort;

public class Selection_sort {
	public static void main(String[] args) {
		Selectionsorting sort=new Selectionsorting();
		int arr[]= {1,2,3,4,58,7414,45,1,545,};
		sort.sorting(arr);
		sort.display(arr);
	}
}

class Selectionsorting{
	
	void sorting(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int min_index=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min_index])
					min_index=j;
			}
			int temp=arr[min_index];
			arr[min_index]=arr[i];
			arr[i]=temp;
		}
	}
	void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(""+arr[i]);
		}
	}
}
