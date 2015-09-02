import java.util.Scanner;

public class BinarySearchFunctionMain
{
	public static void main (String args[])
	{
		Scanner sc = null;
		int choice, arr[] = null;
		sc = new Scanner(System.in);
		BinarySearchFunction obj = new BinarySearchFunction();
		
		while (true)
		{	
			System.out.println("\n\nMenu : ");
			System.out.println("1). Enter values in array");
			System.out.println("2). Search item");
			System.out.println("3). Exit");
			System.out.println("\nEnter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println("\nEnter size of array : ");
						 int size = sc.nextInt();
						 arr = new int [size];
						 System.out.println("Enter items : ");
						 for ( int index = 0; index < size; index++ )
							 arr[index] = sc.nextInt();
						 break;
						
				case 2 : System.out.println("Enter item to search : ");
						 int item = sc.nextInt();
						 int left = 0, right = arr.length-1;
						 int position = obj.binaryFunction ( arr, left, right, item ) ;
						 if ( position == -1 )
							 System.out.println ("Item does not exist in array");
						 else
							 System.out.println ("Leftmost position : " + obj.binaryFunction ( arr, left, right, item ) );
						 break;
						 
				case 3 : System.exit(0);
				 		 break;
				
				default : System.out.println("Please enter correct choice");
				  		  break;
			}
		}
	}
}


//ip : 1,2,2,2,3,5 