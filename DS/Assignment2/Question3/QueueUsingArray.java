// queue using array
package Question3;

public class QueueUsingArray
{
	int arr[] = new int [5];
	int front = -1, rear = -1;
	
	// add item in queue
	public void enqueue ( Object item )
	{
		if ( ( front == -1 ) && ( rear == -1 ) )    // inserting at 1st position
		{
			front = 0;
			rear = 0;
			arr[rear] = Integer.parseInt(item.toString());
		}
		else
		{
			rear = rear + 1;
			if ( rear == arr.length )
				System.out.println("Overflow");
			else
				arr[rear] = Integer.parseInt(item.toString());
		}
	}
	
	
	// remove item from queue
	public Object dequeue ()
	{
		Object item = 0;
		if ( ( front == -1 ) && ( rear == -1 ) )
			System.out.println("Underflow");
		else
		{
			if ( front > rear)
				System.out.println ("Queue is empty");
			else
			{
				item = arr[front];
				front = front+1;
			}
		}
		
		return item;
	}
	
	
	// empty queue
	public void emptyQueue()
	{
		for ( int index = front; index <= rear; index++)
		{
			dequeue();
		}
		front = -1;
		rear = -1;
	}
	
	
	// return item at front
	public Object getFront()
	{
		return arr[rear];
	}
	
	
	// print queue
	public void printQueue()
	{
		if ( ( front != -1 ) && ( rear != -1 ) )
		{
			for ( int index = front; index <= rear; index++)
			{
				System.out.println ( arr[index] );
			}
		}	
		else
			System.out.println ("Queue is empty");
	}
	
}
