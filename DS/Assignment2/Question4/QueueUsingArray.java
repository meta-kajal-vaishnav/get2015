// queue using array
package Question4;

public class QueueUsingArray<T>
{
	static int SIZE = 5;
	Student arr[] = new Student [SIZE];
	int front = -1, rear = -1;
	
	// add item in queue
	public void enqueue ( Student item )
	{
		if ( ( front == -1 ) && ( rear == -1 ) )    // inserting at 1st position
		{
			front = 0;
			rear = 0;
			arr[rear] = item;
		}
		else
		{
			rear = rear + 1;
			if ( rear == arr.length )
			{	
				int size = arr.length + SIZE;
				Student newData[] = new Student[size];
				for(int count=0; count<arr.length; count++)
					newData[count] = arr[count];
				arr = newData;
				
			}
			arr[rear] = item;
		}
	}
	
	
	// remove item from queue
	public Student dequeue ()
	{
		Student item = null;
		if ( ( front == -1 ) && ( rear == -1 ) )
			System.out.println("Underflow");
		else
		{
			if ( front>rear)
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
	public Student getFront()
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
				System.out.println ( "Student Name : "+arr[index].getStudentName()+"\tRank : "+arr[index].getStudentRank()+"\tCollege Alloted : "+arr[index].getCollegeName() );
			}
		}	
		else
			System.out.println ("Queue is empty");
	}
	
}
