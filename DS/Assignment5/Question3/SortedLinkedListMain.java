//  a program to insert a number in sorted LinkList. Use recursive approach.
package Question3;

import java.util.Scanner;

public class SortedLinkedListMain 
{
	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		SortedLinkedList objSortedLinkedList = new SortedLinkedList ();
		
		while (true)
		{	
			System.out.println("\n\nMenu : ");
			System.out.println("1). Enter item in list");
			System.out.println("2). Display linked list");
			System.out.println("3). Exit");
			System.out.println("\nEnter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println("\nEnter item to add : ");
						 objSortedLinkedList.addItemInSortedLinkedList ( sc.nextInt(), 0 );
						 break;
						
				case 2 : System.out.println("\nLinked List : ");
						 objSortedLinkedList.traverseLinkedList();
						 break;
						 
				case 3 : System.exit(0);
				 		 break;
				
				default : System.out.println("Please enter correct choice");
				  		  break;
			}
		}
	}

}
