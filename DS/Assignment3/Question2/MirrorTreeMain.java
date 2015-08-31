package Question2;

import java.util.Scanner;

public class MirrorTreeMain 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner ( System.in );
		MirrorTree objMirrorTree1 = new  MirrorTree();
		MirrorTree objMirrorTree2 = new  MirrorTree();
		int item = 0;
		while (true)
		{
			System.out.println ("\nMenu : ");
			System.out.println ("1). Add values in tree1");
			System.out.println ("2). Add values in tree2");
			System.out.println ("3). Check Mirror tree");
			System.out.println ("4). Display tree1");
			System.out.println ("5). Display tree2");
			System.out.println ("6). Exit");
			System.out.println ("\nEnter your choice : ");
			int choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println ("\nEnter item ");
					 item = sc.nextInt();
					 objMirrorTree1.insertInTree1 ( item );
					 break;
						 
				case 2 : System.out.println ("\nEnter item ");
					 item = sc.nextInt();
					 objMirrorTree2.insertInTree2 ( item );
					 break;
						 
				case 3 : int result = objMirrorTree1.compareIfMirror ( objMirrorTree2 );
					 if ( result == 1 )
						 System.out.println("Tree 2 is mirror of tree1");
					 else
						 System.out.println("Tree 2 is not a mirror of tree1");
					 break;
						 
				case 4 : System.out.println("Tree1's inorder traversal : ");
					 objMirrorTree1.traverseTree ();
				 	 break;
				
				case 5 : System.out.println("Tree2's inorder traversal : ");
					 objMirrorTree2.traverseTree ();
				 	 break;
		 		 
				case 6 : System.exit(0);
					 break;
			}
		}
	}
}
/*  ip : 40, 25, 78, 10, 32 
op : 10, 25, 32, 40, 78
*/
