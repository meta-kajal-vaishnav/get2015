// Queue using linked list
package Question2;

import java.util.Scanner;

public class QueueUsingLinkedListMain 
{

	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		QueueUsingLinkedList objQueueUsingLinkedList = new QueueUsingLinkedList ();
		
		while (true)
		{	
			System.out.println("\n\nMenu : ");
			System.out.println("1). Enter item in Queue");
			System.out.println("2). Remove item from Queue");
			System.out.println("3). Display queue");
			System.out.println("4). Exit");
			System.out.println("\nEnter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println("\nEnter item to add : ");
						 objQueueUsingLinkedList.addItemInQueue ( sc.nextInt() );
						 break;
						 
				case 2 : int item = objQueueUsingLinkedList.removeItemFromQueue ();
						 if ( item == -1 )
							 System.out.println("Queue is empty"); 
						 else
							 System.out.println ("Item removed : "+item);
				 		 break;	
				 		 
				case 3 : System.out.println("\nQueue: ");
						 objQueueUsingLinkedList.traverseQueue();
						 break;
						 
				case 4 : System.exit(0);
				 		 break;
				
				default : System.out.println("Please enter correct choice");
				  		  break;
			}
		}
	}

}
