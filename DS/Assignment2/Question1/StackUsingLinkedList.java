package Question1;

public class StackUsingLinkedList
{
	Node top = null;
	
	// pushes items in stack
	public void pushItemInStack ( Object item )
	{
		Node<Object> newNode = new Node <Object> ();
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
	public void popItemFromStack ()
	{
		if ( top == null )
			System.out.println("Underflow");
		else
		{
			Node<Object> newNode = new Node <Object> ();
			newNode.setNodeValue ( top.getNodeValue() );
			System.out.println ("Item popped : "+newNode.getNodeValue());
			top = top.getnext();
		}
	}
	
	
	// traverses linked list
	public void traverseStack ()
	{
		Node<Object> curr = new Node<Object>();
		curr = top;
		while ( curr != null )
		{
			System.out.println (curr.nodeValue);
			curr = curr.next;
		}
	}
	
	
}
