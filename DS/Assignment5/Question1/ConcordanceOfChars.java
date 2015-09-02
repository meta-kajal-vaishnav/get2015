package Question1;

import java.util.HashSet;
import java.util.Set;

public class ConcordanceOfChars 
{
	Set<Character> inputSet = new HashSet<Character>(); 
	
	// set does not take duplicate values
	public void insertInSet ( String str )
	{
		for ( int index = 0; index<str.length(); index++ )
			inputSet.add(str.charAt(index));
	}
	
	// finding position of all characters
	public String findPosition ( String str )
	{
		String answer = "";
		for ( char val : inputSet )
		{
			String position = "[";
			for ( int index = 0; index<str.length(); index++ )
			{	
				if ( val == str.charAt(index) )   // recording locations of any character in a string
					position += index+",";
			}
			answer += val +" : "+position+"]\n";
		}
		return answer;
	}
}
