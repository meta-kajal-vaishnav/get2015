package Question3;

public class Postorder
{
	Node root = null;
	
	public void insertInTree ( int item )
	{
		Node newNode = new Node ();
		newNode.setNodeValue(item);
		newNode.setLeft(null);
		newNode.setRight(null);
		if ( root == null)
			root = newNode;
		else
			insertInTreeRecursive ( root, newNode );
	}
	
	
	public void insertInTreeRecursive ( Node parent, Node newNode )
	{
		if ( newNode.getNodeValue() < parent.getNodeValue() )		  // left subtree has values less than root
		{
			if ( parent.left == null )
			{
				parent.setLeft(newNode);
				return;
			}
			else
				insertInTreeRecursive ( parent.getLeft(), newNode );
		}
		else if ( newNode.getNodeValue() > parent.getNodeValue() )		// right subtree has values greater than root
		{
			if ( parent.right == null )
			{
				parent.setRight(newNode);
				return;
			}
			else
				insertInTreeRecursive ( parent.getRight(), newNode );
		}	
	}

	
	public void printPostorder()
	{
		printPostOrderRecursive ( root );  
	}
	
	public void printPostOrderRecursive ( Node root )		 // order of printing :  Left child , right child, Parent
	{
		if (root == null) 
			return;  
		printPostOrderRecursive ( root.getLeft() );  
		printPostOrderRecursive ( root.getRight() ); 
		System.out.print(root.getNodeValue()+ ", ");   
	}
	
}
