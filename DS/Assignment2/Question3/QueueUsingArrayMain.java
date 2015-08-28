// queue using array
package Question3;

import java.util.Scanner;

public class QueueUsingArrayMain 
{
	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		Object item;
		QueueUsingArray objQueueUsingArray = new QueueUsingArray ();
		
		while (true)
		{	
			System.out.println("\n\nMenu : ");
			System.out.println("1). Add item in queue");
			System.out.println("2). Remove item from queue");
			System.out.println("3). Empty queue");
			System.out.println("4). Return least recently inserted item");
			System.out.println("5). Traverse queue");
			System.out.println("6). Exit");
			System.out.println("\nEnter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println("\nEnter item to add in queue : ");
					 item = sc.nextInt();
					 objQueueUsingArray.enqueue(item);
					 break;
						
				case 2 : item = objQueueUsingArray.dequeue();
					 System.out.println("Item deleted : "+item);
					 break;
						 
				case 3 : objQueueUsingArray.emptyQueue();
				 	 break;
				 		 
				case 4 : System.out.println("Item at front : "+objQueueUsingArray.getFront());
		 		 	 break;
						 
				case 5 : objQueueUsingArray.printQueue();
					 break;
						 
				case 6 : System.exit(0);
				 	 break;
				
				default : System.out.println("Please enter correct choice");
				  	  break;
			}
		}

	}
}
