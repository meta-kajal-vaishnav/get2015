package Question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class SortingSystemTest 
{

	// positive test cases
	
	@Test
	public void testIfBubbleSortUsedPositive() 
	{
		int arrInput[] = {3,2,5,6,1}, typeOfSorting = 1, sortType = 0;    //  for bubble sort
		SortingSystem objSortingSystem = new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		String strOutput = objSortingSystem.printSortType(sortType);
		String strExpected = "\nBubble sort\n";
		
		assertEquals( "Matched", strExpected, strOutput );
	}
	
	@Test
	public void testIfQuickSortUsedPositive() 
	{
		int arrInput[] = {3,2,5,6,1,7,9,8,0,13,1}, typeOfSorting = 1, sortType = 0;    //  for quick sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		String strOutput = objSortingSystem.printSortType(sortType);
		String strExpected = "\nQuick sort\n";
		
		assertEquals( "Matched", strExpected, strOutput );
	}
	
	@Test
	public void testIfCountingSortUsedPositive() 
	{
		int arrInput[] = {3,2,5,6,1}, typeOfSorting = 2, sortType = 0;    // for counting sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		String strOutput = objSortingSystem.printSortType(sortType);
		String strExpected = "\nCounting sort\n";
		
		assertEquals( "Matched", strExpected, strOutput );
	}
	
	
	@Test
	public void testIfRadixSortUsedPositive() 
	{
		int arrInput[] = {232,112,456}, typeOfSorting = 2, sortType = 0;    // for radix sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		String strOutput = objSortingSystem.printSortType(sortType);
		String strExpected = "\nRadix sort\n";
		
		assertEquals( "Matched", strExpected, strOutput );
	}

	
	// positive test cases for testing result after sorting
	
	@Test
	public void testResultOfBubbleSortPositive() 
	{
		int arrInput[] = {3,2,5,6,1}, typeOfSorting = 1, sortType = 0;    //  for bubble sort
		SortingSystem objSortingSystem = new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		int arrOutput[] = objSortingSystem.printArray(arrInput);
		int arrExpected[] = {1,2,3,5,6};
		
		assertArrayEquals( "Matched", arrExpected, arrOutput );
	}
	
	@Test
	public void testResultOfQuickSortPositive() 
	{
		int arrInput[] = {3,2,5,6,1,7,9,8,0,13,1}, typeOfSorting = 1, sortType = 0;    //  for quick sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		int arrOutput[] = objSortingSystem.printArray(arrInput);
		int arrExpected[] = {0,1,1,2,3,5,6,7,8,9,13};
		
		assertArrayEquals( "Matched", arrExpected, arrOutput );
	}
	
	@Test
	public void testResultOfCountingSortPositive() 
	{
		int arrInput[] = {3,2,5,6,1}, typeOfSorting = 2, sortType = 0;    // for counting sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		int arrOutput[] = objSortingSystem.printArray(arrInput);
		int arrExpected[] = {1,2,3,5,6};
		
		assertArrayEquals( "Matched", arrExpected, arrOutput );
	}
	
	
	@Test
	public void testResultOfRadixSortPositive() 
	{
		int arrInput[] = {232,112,456}, typeOfSorting = 2, sortType = 0;    // for radix sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		int arrOutput[] = objSortingSystem.printArray(arrInput);
		int arrExpected[] = {112,232,456};
		
		assertArrayEquals( "Matched", arrExpected, arrOutput );
	}
	
	
	// negative test cases
	
	
	@Test
	public void testIfBubbleSortUsedNegative() 
	{
		int arrInput[] = {3,2,5,6,1}, typeOfSorting = 1, sortType = 0;    //  for bubble sort
		SortingSystem objSortingSystem = new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		String strOutput = objSortingSystem.printSortType(sortType);
		String strExpected = "\nQuick sort\n";
		
		assertNotEquals( "Not Matched", strExpected, strOutput );
	}
	
	@Test
	public void testIfQuickSortUsedNegative() 
	{
		int arrInput[] = {3,2,5,6,1,7,9,8,0,13,1}, typeOfSorting = 1, sortType = 0;    //  for quick sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		String strOutput = objSortingSystem.printSortType(sortType);
		String strExpected = "\nBubble sort\n";
		
		assertNotEquals( "Not Matched", strExpected, strOutput );
	}
	
	@Test
	public void testIfCountingSortUsedNegative() 
	{
		int arrInput[] = {3,2,5,6,1}, typeOfSorting = 2, sortType = 0;    // for counting sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		String strOutput = objSortingSystem.printSortType(sortType);
		String strExpected = "\nRadix sort\n";
		
		assertNotEquals( "Not Matched", strExpected, strOutput );
	}
	
	
	@Test
	public void testIfRadixSortUsedNegative() 
	{
		int arrInput[] = {232,112,456}, typeOfSorting = 2, sortType = 0;    // for radix sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		String strOutput = objSortingSystem.printSortType(sortType);
		String strExpected = "\nCounting sort\n";
		
		assertNotEquals( "Matched", strExpected, strOutput );
	}

	
	// negative test cases for testing result after sorting
	
	@Test
	public void testResultOfBubbleSortNegative() 
	{
		int arrInput[] = {3,2,5,6,1}, typeOfSorting = 1, sortType = 0;    //  for bubble sort
		SortingSystem objSortingSystem = new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		int arrOutput[] = objSortingSystem.printArray(arrInput);
		int arrExpected[] = {2,1,3,5,6};
		
		assertNotEquals("Not Matched", arrExpected, arrOutput );
	}
	
	@Test
	public void testResultOfQuickSortNegative() 
	{
		int arrInput[] = {3,2,5,6,1,7,9,8,0,13,1}, typeOfSorting = 1, sortType = 0;    //  for quick sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		int arrOutput[] = objSortingSystem.printArray(arrInput);
		int arrExpected[] = {1,0,1,2,3,5,6,7,8,9,13};
		
		assertNotEquals("Not Matched", arrExpected, arrOutput );
	}
	
	@Test
	public void testResultOfCountingSortNegative() 
	{
		int arrInput[] = {3,2,5,6,1}, typeOfSorting = 2, sortType = 0;    // for counting sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		int arrOutput[] = objSortingSystem.printArray(arrInput);
		int arrExpected[] = {3,2,1,5,6};
		
		assertNotEquals("Not Matched", arrExpected, arrOutput );
	}
	
	
	@Test
	public void testResultOfRadixSortNegative() 
	{
		int arrInput[] = {232,112,456}, typeOfSorting = 2, sortType = 0;    // for radix sort
		SortingSystem objSortingSystem =new SortingSystem();
		sortType = objSortingSystem.selectSortType ( arrInput, typeOfSorting, objSortingSystem, sortType );
		int arrOutput[] = objSortingSystem.printArray(arrInput);
		int arrExpected[] = {232,112,456};
		
		assertNotEquals("Not Matched", arrExpected, arrOutput );
	}
	
	
}
