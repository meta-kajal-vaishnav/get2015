package Question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class NumOfUniqueCharInStringTest 
{
	
	@Test
	public void TestPositive()
	{
		NumOfUniqueCharInString objNumOfUniqueCharInString = new NumOfUniqueCharInString();
		String strInput = "hello";
		int countExpected = 4;
		assertEquals("Match", countExpected, objNumOfUniqueCharInString.findUniqueCharacters(strInput));	
	}

}
