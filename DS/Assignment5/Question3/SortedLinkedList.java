//  a program to insert a number in sorted LinkList. Use recursive approach.
package Question3;

import java.util.Iterator;
import java.util.LinkedList;

public class SortedLinkedList
{
	LinkedList<Integer> objLinkedList = new LinkedList<Integer>();
	
	// add items in linked list
	public void addItemInSortedLinkedList ( int item, int index )
	{
		if ( objLinkedList.isEmpty() )    // if empty,  insert item at end
			objLinkedList.add(item);
		else
		{	
			if ( item < objLinkedList.get(index) )    // if item is smaller then insert in list at required position
				objLinkedList.add(index, item);
			else
			{
				if ( index+1 == objLinkedList.size() )   // if end of list has come , then insert item at end
					objLinkedList.add(item);
				else
					addItemInSortedLinkedList ( item, index+1 ); // recursive call to function to find position where item is smaller then that already present in list
			}
		}
	}
	
	// traverse linked list
	public void traverseLinkedList ()
	{
		Iterator iterator = objLinkedList.iterator();
		
		while ( iterator.hasNext() )
			System.out.println ( iterator.next() );
	}
	
}
