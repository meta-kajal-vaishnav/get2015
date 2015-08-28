// convert infix to postfix

package Question2;

import java.util.Scanner;

public class InfixToPostfixMain
{	
	public static void main(String[] args)
	{
		int precedence;
		String strInfix = "";
		Scanner sc = new Scanner(System.in);
		
		StackUsingLinkedList<Character> objStackUsingLinkedList = new StackUsingLinkedList<Character> (); 
		
		InfixToPostfix objInfixToPostfix = new InfixToPostfix();
		
		System.out.println ("Enter the infix string : ");
		strInfix = sc.next();
		
		for ( int index = 0; index < strInfix.length(); index++ )
		{
			char charInfix = strInfix.charAt(index);
			
			precedence = objInfixToPostfix.checkPrecedence ( charInfix, objStackUsingLinkedList );
			
			if ( precedence == 0 )         // if item in input string is character
				objInfixToPostfix.strPostfix = objInfixToPostfix.strPostfix + charInfix;
			else if ( precedence == 3 )    // if item is  = '('   , push it
				objStackUsingLinkedList.pushItemInStack(charInfix);
			else if ( precedence == 4 )    // if item is  = ')'   , pop items till '(' comes, and pop '('  also
 			{
				while ( objStackUsingLinkedList.top.nodeValue != '(' )
				{
					Object item = objStackUsingLinkedList.popItemFromStack();
					objInfixToPostfix.strPostfix = objInfixToPostfix.strPostfix.concat(item.toString());
				}
				Object item = objStackUsingLinkedList.popItemFromStack();
			}
			else
				objInfixToPostfix.infixToPostfix ( precedence, charInfix, objStackUsingLinkedList );
		}
		
		// pops operators left in stack
		while ( objStackUsingLinkedList.top != null )
			objInfixToPostfix.strPostfix += objStackUsingLinkedList.popItemFromStack();
		
		System.out.println ( "\nInfix to postfix : "+objInfixToPostfix.strPostfix );
	}

}




