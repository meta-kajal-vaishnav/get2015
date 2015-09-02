package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingLinkedListTest 
{

	@Test
	public void testEnqueue()
	{
		QueueUsingLinkedList objQueueUsingLinkedList = new QueueUsingLinkedList ();
		for ( int index = 0; index < 4; index++ )
			objQueueUsingLinkedList.addItemInQueue ( index+1 );
		
		String strOutput = objQueueUsingLinkedList.traverseQueue();
		String strExpected = "1\n2\n3\n4\n";
		
		assertEquals ( "Matched", strExpected, strOutput );
	}
	
	
	@Test
	public void testDequeue()
	{
		QueueUsingLinkedList objQueueUsingLinkedList = new QueueUsingLinkedList ();
		for ( int index = 0; index < 4; index++ )
			objQueueUsingLinkedList.addItemInQueue ( index+1 );
		
		objQueueUsingLinkedList.removeItemFromQueue ();
		
		String strOutput = objQueueUsingLinkedList.traverseQueue();
		String strExpected = "2\n3\n4\n";
		
		assertEquals ( "Matched", strExpected, strOutput );
	}

}
