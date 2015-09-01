package Question1;

public class ConcordanceOfCharsMain 
{
	public static void main(String[] args) 
	{	
		String inputStr = "";
		
		ConcordanceOfChars objConcordanceOfChars = new ConcordanceOfChars ();
		for ( int index = 0; index < args.length; index++ )
			inputStr += args[index];
		
		objConcordanceOfChars.insertInSet ( inputStr );
		
		objConcordanceOfChars.findPosition ( inputStr );
	}
}
