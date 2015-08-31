package Question2;

public class MirrorTree 
{
	Node root = null;
	
	public void insertInTree1 ( int item )
	{
		Node newNode = new Node ();
		newNode.setNodeValue(item);
		newNode.setLeft(null);
		newNode.setRight(null);
		if ( root == null)
			root = newNode;
		else
			insertInTree1Recursive ( root, newNode );
	}
	
	
	public void insertInTree1Recursive ( Node parent, Node newNode )
	{
		if ( newNode.getNodeValue() < parent.getNodeValue() )		// left subtree has values less than root
		{
			if ( parent.left == null )
			{
				parent.setLeft(newNode);
				return;
			}
			else
				insertInTree1Recursive ( parent.getLeft(), newNode );
		}
		else if ( newNode.getNodeValue() > parent.getNodeValue() )		 // right subtree has values greater than root
		{
			if ( parent.right == null )
			{
				parent.setRight(newNode);
				return;
			}
			else
				insertInTree1Recursive ( parent.getRight(), newNode );
		}	
	}
	
	
	public void insertInTree2 ( int item )
	{
		Node newNode = new Node ();
		newNode.setNodeValue(item);
		newNode.setLeft(null);
		newNode.setRight(null);
		if ( root == null)
			root = newNode;
		else
			insertInTree2Recursive ( root, newNode );
	}
	
	
	public void insertInTree2Recursive ( Node parent, Node newNode )
	{
		if ( newNode.getNodeValue() > parent.getNodeValue() )		 // left subtree has values greater than root
		{
			if ( parent.left == null )
			{
				parent.setLeft(newNode);
				return;
			}
			else
				insertInTree2Recursive ( parent.getLeft(), newNode );
		}
		else if ( newNode.getNodeValue() < parent.getNodeValue() )		 // right subtree has values less than root
		{
			if ( parent.right == null )
			{
				parent.setRight(newNode);
				return;
			}
			else
				insertInTree2Recursive ( parent.getRight(), newNode );
		}	
	}
	
	
	public int compareIfMirror ( MirrorTree objMirrorTree )
	{
		if ( ( root == null ) && ( objMirrorTree.root == null ) )
			return 1;
		if ( root.getNodeValue() == objMirrorTree.root.getNodeValue() )
		{
			while ( ( root.getLeft() != null ) && ( objMirrorTree.root.getRight() != null ) )
			{
				if ( root.left.getNodeValue() == objMirrorTree.root.right.getNodeValue() )
				{
					root = root.left;
					objMirrorTree.root = objMirrorTree.root.right;
					compareIfMirror ( objMirrorTree );
					return 1;
				}
				else
					return 0;
			}
			
			while ( ( root.getRight() != null ) && ( objMirrorTree.root.getLeft() != null ) )
			{
				if ( root.right.getNodeValue() == objMirrorTree.root.left.getNodeValue() )
				{
					root = root.right;
					objMirrorTree.root = objMirrorTree.root.left;
					compareIfMirror ( objMirrorTree );
					return 1;
				}
				else
					return 0;
			}
				
			return 1;
		}
		else
			return 0;
	}
	
	// inorder traversal
	public void traverseTree()
	{
		traverseTreeRecursive ( root );  
	}
	
	public void traverseTreeRecursive ( Node root )
	{
		if (root == null) 
			return;  
		traverseTreeRecursive ( root.getLeft() ); 
		System.out.print(root.getNodeValue()+ ", "); 
		traverseTreeRecursive ( root.getRight() );  
	}
	
}
