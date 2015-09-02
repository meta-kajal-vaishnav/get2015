package Question1;

import java.util.Scanner;

public class StackUsingLinkedListMain 
{

	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		Object item;
		StackUsingLinkedList objStackUsingLinkedList = new StackUsingLinkedList ();
		
		while (true)
		{	
			System.out.println("\n\nMenu : ");
			System.out.println("1). Push item in stack");
			System.out.println("2). Pop item from stack");
			System.out.println("3). Traverse stack");
			System.out.println("4). Exit");
			System.out.println("\nEnter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println("\nEnter item to push in stack : ");
						 item = sc.nextInt();
						 objStackUsingLinkedList.pushItemInStack(item);
						 break;
						
				case 2 : System.out.println (objStackUsingLinkedList.popItemFromStack() );
						 break;
						 
				case 3 : objStackUsingLinkedList.traverseStack();
						 break;
						 
				case 4 : System.exit(0);
				 		 break;
				
				default : System.out.println("Please enter correct choice");
				  		  break;
			}
		}

	}

}
