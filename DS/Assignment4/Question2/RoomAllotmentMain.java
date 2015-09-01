package Question2;

import java.util.HashMap;
import java.util.Scanner;

public class RoomAllotmentMain 
{

	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		int location;
		Object guestName, guestAge;
		RoomAllotment objRoomAllotment = new RoomAllotment();
		Guest objGuest = null;
		
		while (true)
		{	
			System.out.println("\n\nMenu : ");
			System.out.println("1). Book room");
			System.out.println("2). See list of alloted rooms");
			System.out.println("3). Exit");
			System.out.println("\nEnter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : objGuest = new Guest();
						 System.out.println("\nEnter your name : ");
						 objGuest.setGuestName( sc.next() );
						 System.out.println("\nEnter your age : ");
						 objGuest.setAge( sc.nextInt() );
						 int roomNumber = objRoomAllotment.addGuest ( objGuest );
						 System.out.println("Room number allotted : "+roomNumber);
						 break;
						
				case 2 : System.out.println("\nList of booked rooms : ");
						 objRoomAllotment.displayBookedRoomsList ();
						 break;
						 
				case 3 : System.exit(0);
				 		  break;
				
				default : System.out.println("Please enter correct choice");
				  		  break;
			}
		}

	}

}
