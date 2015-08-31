package Question2;

public class Node<T> 
{
	// data held by node
	public int nodeValue;
	
	// left node in the list
		public Node<T> left;
	
	// right node in the list
	public Node<T> right;

	public int getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
	
}
