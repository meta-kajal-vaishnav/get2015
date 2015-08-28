package Question1;

public class Node<T> 
{
	// data held by node
	public T nodeValue;
	
	// next node in the list
	public Node<T> next;
	
	// default constructor with no initial value
	public Node()
	{
		nodeValue = null;
		next = null;
	}

	public T getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(T nodeValue) {
		this.nodeValue = nodeValue;
	}

	public Node<T> getnext() {
		return next;
	}

	public void setnext(Node<T> next) {
		this.next = next;
	}
}
