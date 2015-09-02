package Question2;

import java.util.Scanner;

public class NumOfUniqueCharInStringMain
{

	public static void main(String[] args)
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		NumOfUniqueCharInString objNumOfUniqueCharInString = new NumOfUniqueCharInString ();
		
		while (true)
		{	
			System.out.println("\n\nMenu : ");
			System.out.println("1). Find unique characters in string");
			System.out.println("2). Display cache");
			System.out.println("3). Exit");
			System.out.println("\nEnter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println("\nEnter string : ");
						 int count = objNumOfUniqueCharInString.findUniqueCharacters ( sc1.nextLine() ); 
						 System.out.println("Number of unique characters = "+count);
						 break;
						
				case 2 : System.out.println("\nCache : ");
						 objNumOfUniqueCharInString.displayCache();
						 break;
						 
				case 3 : System.exit(0);
				 		 break;
				
				default : System.out.println("Please enter correct choice");
				  		  break;
			}
		}

	}
}
