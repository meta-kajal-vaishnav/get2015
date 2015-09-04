package Question2;

import java.util.ArrayList;
import java.util.List;

public class RadixSort 
{
	int arr[];

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
	public int[] radixSort ( int largestValue )
	{	
		int maxBucketSize = 10;   // since buckets are from 0  to  9
		
		// create list of integer type of length maxBucketSize. Each element of this list is again a list itself
		List<Integer> bucket[] = new ArrayList [maxBucketSize];
		for ( int index = 0; index < bucket.length; index++ )
			bucket[index] = new ArrayList<Integer>();
		
		int count = 1;
		
		// loop runs till no of digits in largest number 
		while ( largestValue/count > 0 )
		{
			// takes digit at unit's place when while loop is run first time. Second time it takes digit at tenth place & so on.
			for ( int index = 0; index < arr.length; index++ )
			{
				int unitsDigit = ( arr[index] / count ) % 10; 
				bucket[unitsDigit].add ( arr[index] );
			}
			
			int index = -1;
			
			// take all digits from lists in FIFO manner & place them again in array for further processing
			for ( List<Integer> item : bucket )
			{
				for ( int item1 : item )
				{
					index++;
					arr[index] = item1;
				}
				// clear each list.
				item.clear();
			}
			
			count *= 10;	// update count
		}
		
		return arr;   // return sorted array
	}
}
