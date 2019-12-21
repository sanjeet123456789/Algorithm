package java_practice.Merge_sort;

public class Merge_sort {
	public static void main(String[] args) {
		int arr[]= {45,784,8,49,7,999,89};
		MergeSort m=new MergeSort();
		m.display(arr);
		m.sort(arr, 0, arr.length-1);
		System.out.println(arr.length+"asd");
		m.display(arr);
		
	}
}
class MergeSort{
	void sort(int arr[],int l,int r) {
		if(l<r) {
			int mid=(l+r)/2;
			sort(arr,l,mid);
//			System.out.println("calling sort");
			sort(arr,mid+1,r);
//			System.out.println("calling sort again");
			merge(arr,l,mid,r);
//			System.out.println("calling merger");
		}
	}
	void merge(int arr[],int l,int mid,int r) {
		System.out.println("mid"+mid);
		//find the size of two sub array
		int n1=mid-l+1;
		int n2=r-mid;
		//create a temp array
		int L[]=new int[n1];
		int R[]=new int[n2];
		//copy data to temp array
		for(int i=0;i<n1;i++) {
			L[i]=arr[l+i];
			System.out.println("low"+(arr[l+i]));
		}
		for(int j=0;j<n2;++j) {
			R[j]=arr[mid+1+j];
			System.out.println("right"+(arr[mid+1+j]));
			
		}
		//merge the temp arryay
		int i=0,j=0;
		int k=l;
		while(i<n1 && j<n2) {
			if(L[i]<=R[j]) {
				arr[k]=L[i];
				i++;
			}
			else {
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		//copy the remainign i
		System.out.println("value of kk"+k);
		while(i<n1) {
			arr[k]=L[i];
			i++;
			k++;
		}
		//copy remainig j
		while(j<n2) {
			arr[k]=R[j];
			j++;
			k++;
		}
	
	
	}
	void display(int arr[]) { 
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
