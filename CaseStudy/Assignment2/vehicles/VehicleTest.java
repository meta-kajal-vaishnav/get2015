package vehicles;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class VehicleTest {

	@Test
	public void testCarObjectPositive() throws VehicleManagementException {
		StaxParser objSaxParser = new StaxParser();
		String filePath = "C://Users/Kajal/workspace/CaseStudy2_1/src/vehicles/vehicle.xml";
		List<Vehicle> readVehicleFromConfig = objSaxParser.readConfig(filePath);
		assertTrue("True", readVehicleFromConfig.get(0) instanceof Car);
	}

	@Test
	public void testCarObjectNegative() throws VehicleManagementException {
		StaxParser objSaxParser = new StaxParser();
		String filePath = "C://Users/Kajal/workspace/CaseStudy2_1/src/vehicles/vehicle.xml";
		List<Vehicle> readVehicleFromConfig = objSaxParser.readConfig(filePath);
		assertFalse("False", readVehicleFromConfig.get(4) instanceof Car);
	}

	@Test
	public void testBikeObjectPositive() throws VehicleManagementException {
		StaxParser objSaxParser = new StaxParser();
		String filePath = "C://Users/Kajal/workspace/CaseStudy2_1/src/vehicles/vehicle.xml";
		List<Vehicle> readVehicleFromConfig = objSaxParser.readConfig(filePath);
		assertTrue("True", readVehicleFromConfig.get(4) instanceof Bike);
	}

	@Test
	public void testBikeObjectNegative() throws VehicleManagementException {
		StaxParser objSaxParser = new StaxParser();
		String filePath = "C://Users/Kajal/workspace/CaseStudy2_1/src/vehicles/vehicle.xml";
		List<Vehicle> readVehicleFromConfig = objSaxParser.readConfig(filePath);
		assertFalse("False", readVehicleFromConfig.get(0) instanceof Bike);
	}

}
