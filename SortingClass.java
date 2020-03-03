

public class SortingClass implements sortingAlgorithms{
	private HeapSort heap=new HeapSort();
	private QuickSort quick=new QuickSort();
	private IntroSort intro=new IntroSort();
	
	@Override
	public void heapSort(int[] arr) {
		heap.sort(arr);
		
	}
	@Override
	public void quickSort(int[] arr, String pivotType) {
		if(pivotType.equals("FirstElement")) {
			quick.sortFirstPivot(arr, 0, arr.length-1);
		}
		else if(pivotType.equals("RandomElement")) {
			quick.sortRandomPivot(arr, 0, arr.length-1);
		}
		else if(pivotType.equals("MidOfFirstMidLastElement")) {
			quick.sortMedianOf3(arr, 0, arr.length-1);
		}
		else {
			System.out.println("invalid pivotType");
			return;
		}
		
	}
	@Override
	public void dualPivotQuickSort(int[] arr) {
		quick.sortDualPivot(arr, 0, arr.length-1);
	}
	@Override
	public void introSort(int[] arr) {
		intro.sort(arr,0,arr.length-1);
	}
	
	
	
	
	

}
