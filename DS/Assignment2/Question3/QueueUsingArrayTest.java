package Question3;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueUsingArrayTest
{

	@Test
	public void testDeque() 
	{
		QueueUsingArray objQueueUsingArray = new QueueUsingArray();
		for ( int index = 1; index<=3; index++ )
			objQueueUsingArray.enqueue(index);
		
		String outputStr = objQueueUsingArray.dequeue().toString();
		String expectedStr = "1";
		
		assertEquals ("Matched", expectedStr, outputStr);
	}

}
