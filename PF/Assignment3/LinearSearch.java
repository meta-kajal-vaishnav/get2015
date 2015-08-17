// program to search location of an element in an array using linear search

import java.util.*;
public class LinearSearch 
{
	int position = 0;
	public static void main(String[] args)
	{
		int arr[] = null, arrSize, index, item, location = -2;
		Scanner sc = new Scanner (System.in);
		LinearSearch obj = null;
		try
		{
			System.out.println("Enter the size of array :");
		    arrSize = Integer.parseInt(sc.next());
		    if(arrSize==0)
		    	throw new ArrayIndexOutOfBoundsException();
		    
		    System.out.println("Enter the array :");
		    arr = new int [ arrSize ];
		    for(index=0; index<arrSize; index++)
		    	arr[index] = Integer.parseInt(sc.next());
		    
		    System.out.println("Enter the item to be searched :");
		    item = Integer.parseInt(sc.next());
		    
		    obj = new LinearSearch ();
		    
		    location = obj.linearSearch (arr, item);
		    //System.out.println("The item is found at position : "+location);
		    switch ( location )
		    {
		    	case -1 : System.out.println("The item is not found in the array.");
		    			  break;
		    	case -2 : System.out.println("The input array is empty.");
  			  			  break;
		    	default : System.out.println("The item is found at position : "+location);
  			  			  break;
		    }
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			if( sc != null )
				sc = null;
			if( obj != null )
				obj = null;
			if( arr != null )
				arr = null;
		}
	}
	
	
	int linearSearch ( int arr[], int item )
	{
		if(arr.length=='\0')
		{
			//throw new ArrayIndexOutOfBoundsException();
			return -2;
		}
		if( position == arr.length )
			return -1 ;                // reached end of array but not found the item
		if( item == arr[position] )    // if item found , return its position
			return ( position + 1 );
		else
		{	
			position++ ;
			return linearSearch ( arr, item );
		}
	}
}