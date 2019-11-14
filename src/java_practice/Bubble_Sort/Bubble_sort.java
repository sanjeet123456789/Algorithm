package java_practice.Bubble_Sort;

public class Bubble_sort {
	public static void main(String[] args) {
		Bubble_sorting bubble=new Bubble_sorting();
		int arr[]= {784,45,12,45,1,5,487,4,5,48,74,5,78,34,45};
		bubble.sorting(arr);
		bubble.display(arr);
	}
}
class Bubble_sorting{
	void sorting(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					//swap
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
					
				}
			}
		}
	}
	void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
