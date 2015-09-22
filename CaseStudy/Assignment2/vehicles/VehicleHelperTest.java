package vehicles;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleHelperTest {
	
	@Test
	public void testCreationOfCarInstance() {
		Vehicle vehicleObj = VehicleHelper.createVehicle("Car","Make2","Model2");
		//assertNotNull(vehicleObj);
		assertTrue(vehicleObj instanceof Car);
	}
	
	@Test
	public void testCreationOfBikeInstance() {
		Vehicle vehicleObj = VehicleHelper.createVehicle("Bike","Make3","Model3");
		//assertNotNull(vehicleObj);
		assertTrue(vehicleObj instanceof Bike);
	}
	
}
