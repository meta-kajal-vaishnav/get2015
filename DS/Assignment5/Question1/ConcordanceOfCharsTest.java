package Question1;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConcordanceOfCharsTest {

	@Test
	public void test() 
	{
		ConcordanceOfChars objConcordanceOfChars = new ConcordanceOfChars();
		String inputStr = "hello World";
		String strExpected = "w : [5,]\nd : [9,]\ne : [1,]\nr : [7,]\no : [4,6,]\nl : [2,3,8,]\nh : [0,]";
		objConcordanceOfChars.insertInSet ( inputStr );
		String strOutput = objConcordanceOfChars.findPosition ( inputStr ) ;
	}

}
