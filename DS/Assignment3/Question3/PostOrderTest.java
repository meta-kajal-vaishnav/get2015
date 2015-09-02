package Question3;

import static org.junit.Assert.*;
import org.junit.Test;

public class PostOrderTest 
{
	@Test
	public void testPostorder() 
	{
		Postorder objPostorder = new Postorder();
		objPostorder.insertInTree ( 40 );
		objPostorder.insertInTree ( 25 );
		objPostorder.insertInTree ( 78 );
		objPostorder.insertInTree ( 10 );
		objPostorder.insertInTree ( 32 );
		
		String outputPostorder = objPostorder.printPostorder();
		String expectedOrder = "10, 32, 25, 78, 40, ";
		
		assertEquals ( "Matched", expectedOrder, outputPostorder );
	}

}
