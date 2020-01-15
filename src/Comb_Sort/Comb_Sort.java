package Comb_Sort;

public class Comb_Sort {
	int getnextGap(int gap) {
		gap=(gap*10)/13;
		if(gap<1)
			return 1;
		return gap;
	}
	
	void sort(int arr[]) {
		int n=arr.length;
		int gap=n;
		
		
		boolean swapped=true;
		while(gap!=1||swapped==true) {
			gap=getnextGap(gap);
			
			swapped=false;
			for(int i=0;i<n-gap;i++) {
				if(arr[i]>arr[i+gap]) {
					int temp=arr[i];
					arr[i]=arr[i+gap];
					arr[i+gap]=temp;
					swapped=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Comb_Sort ob=new Comb_Sort();
		int arr[]= {8,4,1,56,3-44,23,-6,28,0};
		ob.sort(arr);
		System.out.println("sorted array");
		for(int i=0;i<arr.length;++i)
			System.out.println(arr[i]+" ");
	}
}
