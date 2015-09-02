package Question2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RoomAllotment 
{
	int totalNumOfRooms = 5;
	HashMap allotedRooms = new HashMap();
	
	// book a room for new guest
	public int addGuest ( Guest objGuest )
	{
		boolean flag = false;
		int maxLimit = 10, index = 1, key;
		do
		{
			flag = false;
			key = objGuest.getAge() % index;
	
			// Get a set of entries
			Set set = allotedRooms.entrySet();
			// Get an iterator
			Iterator iterator = set.iterator();
			//display elements
			while ( iterator.hasNext() )
			{
				Map.Entry me = (Map.Entry)iterator.next();
				if ( me.getKey().equals ( key ) )            // if key already exist, i.e. room already occupied
				{
					index = index + 1;    // change index to get new key
					flag = true;
					break;
				}
			}
			if ( flag == false )
			{
				if ( key >= totalNumOfRooms )
				{	
					flag = true;
					index = index + 1;		
				}
				else
					allotedRooms.put ( key, objGuest.getGuestName() );    // book room
			}
		}
		while ( ( flag == true ) && ( index <= maxLimit ) );    // find new key
		return ( key+1 ) ;
	}
	
	// displays allocated rooms
	public void displayBookedRoomsList ()
	{
		// Get a set of entries
		Set set = allotedRooms.entrySet();
		// Get an iterator
		Iterator iterator = set.iterator();
		//display elements
		while ( iterator.hasNext() )
		{
			Map.Entry me = (Map.Entry)iterator.next();
			System.out.println ("Room number : "+(Integer.parseInt(me.getKey().toString())+1)+"\tGuest Name : "+me.getValue());
		}
	}
	
}
