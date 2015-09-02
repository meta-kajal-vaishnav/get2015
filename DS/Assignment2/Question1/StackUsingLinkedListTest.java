package Question1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StackUsingLinkedListTest 
{

	@Test
	public void testPop() 
	{
		StackUsingLinkedList objStackUsingLinkedList = new StackUsingLinkedList();
		for ( int index = 1; index<=3; index++ )
			objStackUsingLinkedList.pushItemInStack(index);
		
		String outputStr = objStackUsingLinkedList.popItemFromStack();
		String expectedStr = "3";
		
		assertEquals ("Matched", expectedStr, outputStr);
	}

}
