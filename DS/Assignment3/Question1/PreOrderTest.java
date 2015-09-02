package Question1;

import static org.junit.Assert.*;
import org.junit.Test;

public class PreOrderTest 
{
	@Test
	public void testPreorder() 
	{
		Preorder objPreorder = new Preorder();
		objPreorder.insertInTree ( 40 );
		objPreorder.insertInTree ( 25 );
		objPreorder.insertInTree ( 78 );
		objPreorder.insertInTree ( 10 );
		objPreorder.insertInTree ( 32 );
		
		String outputPreorder = objPreorder.printPreorder();
		String expectedOrder = "40, 25, 10, 32, 78, ";
		
		assertEquals ( "Matched", expectedOrder, outputPreorder );
	}

}
