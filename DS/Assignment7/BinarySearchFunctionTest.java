import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchFunctionTest 
{

	@Test
	public void testPositionPositive() 
	{
		int arr [] = {1,2,2,2,3,5}, left = 0, right = arr.length-1, itemToSearch = 2;
		BinarySearchFunction obj = new BinarySearchFunction();
		int positionOutput = obj.binaryFunction ( arr, left, right, itemToSearch );
		int positionExpected = 1;
		assertEquals ( "Matched", positionExpected, positionOutput );
	}

	
	@Test
	public void testItemNotFound() 
	{
		int arr [] = {1,2,2,2,3,5}, left = 0, right = arr.length-1, itemToSearch = 6;
		BinarySearchFunction obj = new BinarySearchFunction();
		int positionOutput = obj.binaryFunction ( arr, left, right, itemToSearch );
		int positionExpected = -1;
		assertEquals ( "Matched", positionExpected, positionOutput );
	}
	
//	@Test
//	public void testPositionNegative() 
//	{
//		int arr [] = {1,2,2,2,3,5}, left = 0, right = arr.length-1, itemToSearch = 2;
//		BinarySearchFunction obj = new BinarySearchFunction();
//		int positionOutput = obj.binaryFunction ( arr, left, right, itemToSearch );
//		int positionExpected = 2;
//		assertEquals ( "Not Matched", positionExpected, positionOutput );
//	}
	
}
