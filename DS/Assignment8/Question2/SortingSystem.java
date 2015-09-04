package Question2;

public class SortingSystem {
	public int selectSortType(int arrNumbers[], int typeOfSorting,
			SortingSystem objSortingSystem, int sortType) {
		switch (typeOfSorting) {
		case 1:
			if (arrNumbers.length <= 10) // call bubble sort
			{
				sortType = 1;
				BubbleSort objBubbleSort = new BubbleSort();
				objBubbleSort.setArr(arrNumbers);
				arrNumbers = objBubbleSort.bubbleSort();
			} else // call quick sort
			{
				sortType = 2;
				int pivot = 0;
				QuickSort objQuickSort = new QuickSort();
				objQuickSort.setArr(arrNumbers);
				arrNumbers = objQuickSort.quickSort(pivot, arrNumbers.length);
			}
			break;

		case 2:
			int largestValue = arrNumbers[0];
			// finding largest item
			for (int item : arrNumbers) {
				if (item > largestValue)
					largestValue = item;
			}
			if (largestValue <= 99) // call counting sort
			{
				sortType = 3;
				CountingSort objCountingSort = new CountingSort();
				objCountingSort.setArr(arrNumbers);
				arrNumbers = objCountingSort.countingSort(largestValue);
			} else // call radix sort
			{
				sortType = 4;
				RadixSort objRadixSort = new RadixSort();
				objRadixSort.setArr(arrNumbers);
				arrNumbers = objRadixSort.radixSort(largestValue);
			}
			break;
		}
		return sortType;
	}

	// prints type of sorting selected by system
	public String printSortType(int sortType) {
		String strSortType = "";
		switch (sortType) {
		case 1:
			strSortType = "\nBubble sort\n";
			break;
		case 2:
			strSortType = "\nQuick sort\n";
			break;
		case 3:
			strSortType = "\nCounting sort\n";
			break;
		case 4:
			strSortType = "\nRadix sort\n";
			break;
		}

		return strSortType;
	}

	// prints result of array after sorting
	public int[] printArray(int arrNew[]) {
		for (int item : arrNew) {
			System.out.print(item + ", ");
		}
		return arrNew;
	}

}
