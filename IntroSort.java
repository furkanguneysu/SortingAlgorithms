
public class IntroSort {

	HeapSort heap = new HeapSort();
	
	private int partitionFirst(int arr[],int low,int high) {
		int pivot = arr[low];
		int i=(high+1);
		for(int j=high;j>=0;j--) {
			if(arr[j]>pivot) {
			i--;
			swap(arr,i,j);
			}
		}
		swap(arr,i-1,low);
		return i-1;
	}
	
	private void introSort(int arr[],int low,int high,int depth) {
		if(depth == 0) {
			heap.sort(arr);
			return;
		}
	if(low<high) {
		int p = partitionFirst(arr,low,high);
		introSort(arr,low,p-1,depth-1);
		introSort(arr,p+1,high,depth-1);
	}
	}
	
	public void sort(int arr[],int low,int high) {
		int depth = maxDepthCalculator(arr);
		introSort(arr,low,high,depth);
	}
	
	
	private int maxDepthCalculator(int arr[]) {
		return (int) ((Math.log(arr.length)/Math.log(2))*2);
	}
	
	private void swap(int arr[],int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]=temp;
	}
	
	
}
