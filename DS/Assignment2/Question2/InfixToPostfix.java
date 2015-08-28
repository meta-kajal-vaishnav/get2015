// convert infix to postfix

package Question2;

public class InfixToPostfix
{
	int precedence1;
	String strPostfix = "";
	
	// converts infix to postfix
	public void infixToPostfix( int precedence2, char charInfix, StackUsingLinkedList objStackUsingLinkedList )
	{
		if ( objStackUsingLinkedList.isEmpty() == false )
		{	
			while ( objStackUsingLinkedList.isEmpty() == false )
			{
				if ( objStackUsingLinkedList.top.nodeValue.equals("(") || objStackUsingLinkedList.top.nodeValue.equals(")") );  // do nothing
				else
				{
					int precedence3 = checkPrecedence ( objStackUsingLinkedList.top.nodeValue.toString().charAt(0),objStackUsingLinkedList );
					// if incoming char has higher precedence then char at top of stack, then pop element from stack
					if ( precedence3 <= precedence2 )
					{
						Object item = objStackUsingLinkedList.popItemFromStack();
						strPostfix = strPostfix.concat(item.toString());    // concat popped item in output string
					}
					else
						break;
				}
			}
			objStackUsingLinkedList.pushItemInStack ( charInfix );     // push incoming char, after items in stack of greater precedence were popped
		}	
		else      // if stack is empty, push item in it
			objStackUsingLinkedList.pushItemInStack ( charInfix );
	}
	
	// returns precedence
	public int checkPrecedence ( char charInfix, StackUsingLinkedList objStackUsingLinkedList )
	{
		int precedence = 0;
		switch ( charInfix )
		{
			case '*' :
				
			case '/' : precedence = 2;
					   break;
					   
			case '+' :
				
			case '-' : precedence = 1;
					   break;
			
			case '(' : precedence = 3;
					   break;
					   
			case ')' : precedence = 4;
				   	   break;
				   
			default : precedence = 0; 
		}
		return precedence;
	}
}
