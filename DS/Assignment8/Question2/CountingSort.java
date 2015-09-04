package Question2;

public class CountingSort 
{
	int arr[];

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
	public int[] countingSort ( int largestValue )
	{	
		// creating new array of size = largest element and initializing new array to zero
		int arrNew[] = new int [largestValue+1];
		for ( int index = 0; index < arrNew.length; index++ )
			arrNew [index] = 0;
		
		// if item in input array is equal to any index of new array then increase value at that index by one
		for ( int item : arr )
		{
			for ( int index = 0; index < arrNew.length; index++ )
			{
				if ( item == index )
					arrNew [index] += 1;
			}
		}
		
		// while value at index !=0 print index value of array
		for ( int index = 0, index1 = 0; index < arrNew.length; index++ )
		{
			while ( arrNew[index] != 0 )
			{
				arr[index1] = index;
				arrNew[index] -= 1;
				index1++;
			}
		}
		return arr;
	}
	
}
