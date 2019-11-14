package java_practice.Insertion_sort;

public class Insertion_sort {
	public static void main(String[] args) {
		int arr[]= {1,45,78,45,12,45,1,54,54,57,45,1,54,45,9999};
		Insertation_sorting s=new Insertation_sorting();
		s.traverse(arr);
		s.sorting(arr);
		s.traverse(arr);
	}
}
class Insertation_sorting{
	void sorting(int[] arr) {
		for(int i=1;i<arr.length-1;i++) {
			int key=arr[i];
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>key) {
					//swap
					int temp=arr[j];
					arr[j]=arr[j+1]; 
					arr[j+1]=temp;
				}
				key=arr[j];
			}
		}
	}
	void traverse(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
