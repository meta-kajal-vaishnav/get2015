// performs search using binary function

public class BinarySearchFunction 
{
	
	public int binaryFunction ( int arr[], int left, int right, int item )
	{
		int position = 0, mid = ( left + right ) / 2;
		
		if ( ( mid == left ) && ( mid == right ) )
		{
			if( arr[mid] == item )
				return mid;
			else 
				return -1;   // item does not exist in array
		}
		
		if ( item == arr[mid] )
		{
			position = mid;
			
			if ( (mid-1) < left )  // if new left crosses old left then stop and return mid 
				return position;
			
			if (binaryFunction ( arr, left, mid-1, item ) == -1)  // if item not found in sub partition return mid of original partition
				return position;
			else
				return binaryFunction ( arr, left, mid-1, item );  // return new position returned by sub partition
		}
		
		else if ( item < arr[mid] )  // look into left partition
		{
			return binaryFunction ( arr, left, mid-1, item );
		}
		
		else if ( item > arr[mid] && mid != right )   // look into right partition
		{	
			return binaryFunction ( arr, mid+1, right, item );
		}
		return mid;
	}
	
}
