package Question3;

import java.util.Scanner;

public class PostorderMain
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner ( System.in );
		Postorder objPostorder = new  Postorder();
		int item = 0;
		while (true)
		{
			System.out.println ("\nMenu : ");
			System.out.println ("1). Add values in tree");
			System.out.println ("2). Display tree");
			System.out.println ("3). Exit");
			System.out.println ("\nEnter your choice : ");
			int choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println ("\nEnter item ");
					 item = sc.nextInt();
					 objPostorder.insertInTree ( item );
					 break;
						 
				case 2 : System.out.println("Tree in postorder: ");
					 objPostorder.printPostorder();
				 	 break;
				
				case 3 : System.exit(0);
					 break;
						 
				default : System.out.println("Please enter correct choice");
					  break;
			}
		}
	}
}


/*  ip : 40, 25, 78, 10, 32 
    op : 10, 30, 25, 78, 40
*/
