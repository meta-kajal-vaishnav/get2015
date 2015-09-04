package Question1;

public class TreeSort 
{
	Node root = null;  // initialize root node to null
	
	public void insertInTree ( int item[] )
	{
		// insert each roll number in tree
		for ( int index = 0; index < item.length; index++ )
		{
			// creating new node for each roll number
			Node newNode = new Node ();
			newNode.setNodeValue ( item[index] );
			newNode.setLeft(null);
			newNode.setRight(null);
			
			// if root is null , insert in root
			if ( root == null)
				root = newNode;
			else
				insertInTreeRecursive ( root, newNode );   // else insert in tree at correct position
		}
	}
	
	
	public void insertInTreeRecursive ( Node parent, Node newNode )
	{
		if ( newNode.getNodeValue() < parent.getNodeValue() )      // left subtree has values less than root
		{
			if ( parent.left == null )  // if node is leaf node insert new node as its leaf
			{
				parent.setLeft(newNode);
				return;
			}
			else
				insertInTreeRecursive ( parent.getLeft(), newNode );   // traverse tree till leaf node is reached
		}
		else if ( newNode.getNodeValue() > parent.getNodeValue() )   // right subtree has values greater than root
		{
			if ( parent.right == null )  // if node is leaf node insert new node as its leaf
			{
				parent.setRight(newNode);
				return;
			}
			else
				insertInTreeRecursive ( parent.getRight(), newNode );   // traverse tree till leaf node is reached
		}	
	}

	
	public String printInAscending()
	{
		return printInorderRecursive ( root );  
	}
	
	public String printInorderRecursive ( Node root )   //  inorder of printing :  Left child , Parent, right child
	{
		if (root == null) 
			return "";  
		return printInorderRecursive ( root.getLeft() ) 
				+ root.getNodeValue()+ ", " 
				+ printInorderRecursive ( root.getRight() ); 
	}
}
