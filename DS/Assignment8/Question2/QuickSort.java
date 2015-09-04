package Question2;

public class QuickSort {
	int arr[];

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	// initially pivot is = first element of array and end = arr.length
	public int[] quickSort(int pivot, int end) {
		// storeIndex contains pivot's next element
		int storeIndex = pivot + 1;

		// traverse array for sorting
		for (int index = pivot + 1; index < end; index++) {
			if (arr[index] < arr[pivot]) {
				// swap index and storeIndex
				int temp = arr[index];
				arr[index] = arr[storeIndex];
				arr[storeIndex] = temp;
				// increment storeIndex
				storeIndex++;
			}
		}

		// swap pivot and storeIndex-1
		int temp = arr[pivot];
		arr[pivot] = arr[storeIndex - 1];
		arr[storeIndex - 1] = temp;

		// element has reached its correct position so increment pivot by one
		if (pivot == storeIndex - 1) {
			pivot = pivot + 1;
			// pivot has reached end of array
			if (pivot == end - 1)
				return arr; // return sorted array
		}
		quickSort(pivot, end);
		return arr;
	}

}
