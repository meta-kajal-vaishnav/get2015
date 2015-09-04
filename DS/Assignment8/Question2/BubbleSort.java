package Question2;

public class BubbleSort {
	int arr[];

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	// bubble sort
	public int[] bubbleSort() {
		// outer loop for traversing
		for (int index = 0; index < arr.length - 1; index++) {
			// inner loop for comparing
			for (int index1 = 0; index1 < arr.length - 1 - index; index1++) {
				// if element is greater than next element swap them
				if (arr[index1] > arr[index1 + 1]) {
					int temp = arr[index1];
					arr[index1] = arr[index1 + 1];
					arr[index1 + 1] = temp;
				}
			}
		}
		// return sorted array
		return arr;
	}
}
