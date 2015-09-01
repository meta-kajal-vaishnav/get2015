// Queue using linked list
package Question2;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueUsingLinkedList 
{
	LinkedList<Integer> objLinkedList = new LinkedList<Integer>();
	
	public void addItemInQueue ( int item )
	{
		objLinkedList.addLast(item);    // add at last
	}
	
	public int removeItemFromQueue ()
	{
		if ( objLinkedList.isEmpty() )  // queue empty
			return -1;
		else
			return objLinkedList.removeFirst();   //  remove from first
	}
	
	public void traverseQueue ()
	{
		if ( objLinkedList.isEmpty() )
			System.out.println("Queue is empty");
		else
		{
			Iterator iterator = objLinkedList.iterator();
			
			while ( iterator.hasNext() )
				System.out.println ( iterator.next() );
		}
	}
}
