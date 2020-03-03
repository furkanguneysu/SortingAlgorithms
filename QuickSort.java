import java.util.Random;

public class QuickSort {
	
	private int partitionLast(int arr[],int low,int high) {
		int pivot = arr[high];
		int i = (low-1);
		for(int j=low; j<high; j++) {
			if(arr[j]<pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}
	
	public void sortLastPivot(int arr[],int low,int high) {
		if(low<high) {
			int pi = partitionLast(arr,low,high);
			sortLastPivot(arr,low,pi-1);
			sortLastPivot(arr,pi+1,high);
			
		}
	}
	
	private int partitionFirst(int arr[],int low,int high) {
		int pivot = arr[low];
		int i=(high+1);
		for(int j=high;j>0;j--) {
			if(arr[j]>pivot) {
			i--;
			swap(arr,i,j);
			}
		}
		swap(arr,i-1,low);
		return i-1;
	}
	
	public void sortFirstPivot(int arr[],int low,int high) {
		if(low<high) {
			int pi = partitionFirst(arr,low,high);
			sortFirstPivot(arr,pi+1,high);
			sortFirstPivot(arr,low,pi-1);
		}
	}	
	
	private int partitionRandom(int arr[],int low,int high) {//Used first element as pivot
		Random rand = new Random();
		int pivotIndex = (low + rand.nextInt(high-low)+1);
		swap(arr,pivotIndex,low);
		return partitionFirst(arr,low,high);
	}
	
	public void sortRandomPivot(int arr[],int low,int high) {
		if(low<high) {
		int p = partitionRandom(arr,low,high);
		sortRandomPivot(arr,p+1,high);
		sortRandomPivot(arr,low,p-1);
		
		}
	}
	
	private int partitionMOT(int arr[],int low,int high) {
		int pivotIndex = medianOf3(arr,low,high);
		swap(arr,pivotIndex,low);
		return partitionFirst(arr,low,high);
		
	}
	
	public void sortMedianOf3(int arr[],int low,int high) {
		if(low<high) {
		int p = partitionMOT(arr,low,high);
		sortMedianOf3(arr,low,p-1);
		sortMedianOf3(arr,p+1,high);
		}
	}
	
	private int medianOf3(int arr[], int low, int high) {
		
		int center = (low+high)/2;
		if((arr[high]>arr[low])!=(arr[high]>arr[center])) {
			return high;
		}
		else if((arr[low]>arr[high])!=(arr[low]>arr[center])) {
			return center;
		}
		else {
			return center;
		}
	  }
	
	private int[] partitionDualPivot(int arr[], int low, int high) {
		int pivots[] = new int[2];
		
		if(arr[low]>arr[high]) {
			swap(arr,low,high);
		}
		int j = low+1;
		int g = high-1, k=low+1, p=arr[low], q=arr[high];
		while(k<=g) {
			if(arr[k]<p) {
				swap(arr,k,j);
				j++;
			}
			else if(arr[k]>=q) {
				while(arr[g]>q && k<g) {
					g--;
				}
				swap(arr,k,g);
				g--;
				if(arr[k]<p) {
					swap(arr,k,j);
					j++;
				}
			}
			k++;
		}
		j--;
		g++;
		swap(arr,low,j);
		swap(arr,high,g);
		pivots[0]=j;
		pivots[1]=g;
		
		return pivots;
		
		/*
		if(arr[low]>arr[high]) {
			swap(arr,low,high);
		}
		pivots[0]=partitionFirst(arr,low,high);
		pivots[1]=partitionFirst(arr,low,high);
		return pivots;
		*/
	}
	
	public void sortDualPivot(int arr[],int low,int high) {
		if(low<high) {
			int[] pivots = partitionDualPivot(arr,low,high);
			int lowP = pivots[0];
			int highP = pivots[1];
			sortDualPivot(arr,low,lowP-1);
			sortDualPivot(arr,lowP+1,highP-1);
			sortDualPivot(arr,highP+1,high);
		}
	}
	
	private void swap(int arr[],int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]=temp;
	}

	public void print(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
