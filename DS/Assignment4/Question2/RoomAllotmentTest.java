package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomAllotmentTest 
{

	@Test
	public void testRoomAllocated() 
	{
		RoomAllotment objRoomAllotment = new RoomAllotment();
		
		int outputRoomNum = objRoomAllotment.addGuest ( new Guest ("AAA", 41) );
		int expectedRoomNum = 1;
		
		assertEquals ("Matched", expectedRoomNum, outputRoomNum );
	}

}
