
import java.util.Random;
public class test {
	
	static void print(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static int[] arrayGenerator(int size,char choice) {//s-same,i-increasing,d-decreasing,r-random,else null
		int[] arr = new int[size];
		Random rand = new Random();
		if(choice == 's') {
			for(int i=0;i<arr.length;i++) {
				arr[i]=1;
			}
		}
		else if(choice == 'i') {
			for(int i=0;i<arr.length;i++) {
				arr[i]=i;
			}
		}
		else if(choice == 'd') {
			for(int i=arr.length-1;i>0;i--) {
				arr[arr.length-1-i]=i;
			}
		}
		else if(choice == 'r') {
			for(int i=0;i<arr.length;i++) {
				arr[i]=rand.nextInt();
			}
		}
		else {
			return arr;
		}
		
		return arr;
		
	}


	public static void main(String[] args) {
		SortingClass sc = new SortingClass();
		int arr[]=arrayGenerator(1000,'d');
		//int arr[] = {5,36,98,65,36,3,2,1,5,43,5,-9,6,7};
		long startTime=System.currentTimeMillis();
		sc.dualPivotQuickSort(arr);
		//sc.quickSort(arr, "MidOfFirstMidLastElement");
		//sc.quickSort(arr, "RandomElement");
		//sc.heapSort(arr);
		//sc.quickSort(arr, "FirstElement");
		//sc.introSort(arr);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime+"");
		
		
	}

}
