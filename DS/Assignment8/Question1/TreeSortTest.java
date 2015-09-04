package Question1;

import static org.junit.Assert.*;
import org.junit.Test;

public class TreeSortTest 
{

	@Test
	public void testAscendingOrderOfRollNumbersPositive()   // positive case
	{
		int arrOfRollNumbers[] = {2,3,4,1,5};
		TreeSort objTreeSort = new TreeSort();
		objTreeSort.insertInTree ( arrOfRollNumbers );
		String strOutput = objTreeSort.printInAscending();
		String strExpected = "1, 2, 3, 4, 5, ";
		assertEquals ( "Matched", strExpected, strOutput );
	}
	
	
//	@Test
//	public void testAscendingOrderOfRollNumbersNegative()   // negative case
//	{
//		int arrOfRollNumbers[] = {2,3,4,1,5};
//		TreeSort objTreeSort = new TreeSort();
//		objTreeSort.insertInTree ( arrOfRollNumbers );
//		String strOutput = objTreeSort.printInAscending();
//		String strExpected = "1, 2, 4, 3, 5, ";
//		assertEquals ( "Not Matched", strExpected, strOutput );
//	}

}
