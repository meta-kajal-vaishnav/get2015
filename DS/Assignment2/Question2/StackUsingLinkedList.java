package Question2;

public class StackUsingLinkedList<T>
{
	Node<T> top ;
	
	public StackUsingLinkedList()
	{
		top = null;
	}
	
	// pushes items in stack
	public void pushItemInStack ( T item )
	{
		Node<T> newNode = new Node <T> ();
		newNode.setNodeValue(item);
		newNode.setnext(null);
	
		if ( top == null )	// if list is empty
			top = newNode ;
		else
		{
			newNode.setnext(top);
			top = newNode;
		}
	}
	
	
	// pops items in stack
	public T popItemFromStack ()
	{
		Node<T> newNode = new Node <T> ();
		
		if ( top == null )
			System.out.println("Underflow");
		else
		{
			newNode.setNodeValue ( top.getNodeValue() );
			newNode.setnext(null);
			//System.out.println ("Item popped : "+newNode.getNodeValue());
			top = top.getnext();
		}
		return newNode.getNodeValue();
	}
	
	// traverses linked list
	public void traverseStack ()
	{
		Node<T> curr = new Node<T>();
		curr = top;
		while ( curr != null )
		{
			System.out.println (curr.nodeValue);
			curr = curr.next;
		}
	}
	
	// if stack is empty
	public boolean  isEmpty()
	{
		return top ==null;
	}
}
