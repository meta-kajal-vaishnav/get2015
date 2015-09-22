package vehicles;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class VehicleDetailPrinterTest {

	@Test
	// tests attributes of car class
	public void testCarAttributes()  
	{
		Vehicle vehicleObj = VehicleHelper.createVehicle("Car","Make2","Model2");
		String strOutput = VehicleDetailPrinter.printVehicleSpecification (vehicleObj);
		String strExpected = "Make : Make2\tModel : Model2";
		assertEquals("Matched", strExpected, strOutput);
	}
	
	
	@Test
	// tests attributes of bike class
	public void testBikeAttributes()  
	{
		Vehicle vehicleObj = VehicleHelper.createVehicle("Bike","Make3","Model3");
		String strOutput = VehicleDetailPrinter.printVehicleSpecification (vehicleObj);
		String strExpected = "Make : Make3\tModel : Model3";
		assertEquals("Matched", strExpected, strOutput);
	}

	@Test
	// tests equals and hashcode method for Vehicle class - positive test case
	public void testEqualsAndHashcodeForVehiclePositive()  
	{
		Vehicle vehicleObj1 = VehicleHelper.createVehicle("Car","Make1","Model1");
		Vehicle vehicleObj2 = VehicleHelper.createVehicle("Bike","Make2","Model2");
		Vehicle vehicleObj3 = VehicleHelper.createVehicle("Car","Make3","Model3");
		Vehicle vehicleObj4 = VehicleHelper.createVehicle("Bike","Make2","Model4");
		Vehicle vehicleObj5 = VehicleHelper.createVehicle("Car","Make1","Model1");
		//set stores vehicles
		Set<Vehicle> vehicleSet = new HashSet<Vehicle>();
		vehicleSet.add(vehicleObj1);
		vehicleSet.add(vehicleObj2);
		vehicleSet.add(vehicleObj3);
		vehicleSet.add(vehicleObj4);
		vehicleSet.add(vehicleObj5);
		int outputSetSize = vehicleSet.size();
		int expectedSetSize = 4;
		assertEquals("Matched", expectedSetSize, outputSetSize);
	}
	
	@Test
	// tests equals and hashcode method for Vehicle class - positive test case
	public void testEqualsAndHashcodeForVehicleNegative()  
	{
		Vehicle vehicleObj1 = VehicleHelper.createVehicle("Car","Make1","Model1");
		Vehicle vehicleObj2 = VehicleHelper.createVehicle("Bike","Make2","Model2");
		Vehicle vehicleObj3 = VehicleHelper.createVehicle("Car","Make3","Model3");
		Vehicle vehicleObj4 = VehicleHelper.createVehicle("Bike","Make2","Model4");
		Vehicle vehicleObj5 = VehicleHelper.createVehicle("Car","Make1","Model1");
		//set stores vehicles
		Set<Vehicle> vehicleSet = new HashSet<Vehicle>();
		vehicleSet.add(vehicleObj1);
		vehicleSet.add(vehicleObj2);
		vehicleSet.add(vehicleObj3);
		vehicleSet.add(vehicleObj4);
		vehicleSet.add(vehicleObj5);
		int outputSetSize = vehicleSet.size();
		int expectedSetSize = 5;
		assertNotEquals("Not Matched", expectedSetSize, outputSetSize);
	}
	
	@Test
	// tests equals and hashcode method for car class - positive test case
	public void testEqualsAndHashcodeForCarPositive()  
	{
		Vehicle vehicleObj1 = VehicleHelper.createVehicle("Car","Make1","Model1");
		Vehicle vehicleObj2 = VehicleHelper.createVehicle("Car","Make2","Model2");
		Vehicle vehicleObj3 = VehicleHelper.createVehicle("Car","Make3","Model3");
		Vehicle vehicleObj4 = VehicleHelper.createVehicle("Car","Make2","Model4");
		Vehicle vehicleObj5 = VehicleHelper.createVehicle("Car","Make1","Model1");
		//set stores vehicles
		Set<Vehicle> vehicleSet = new HashSet<Vehicle>();
		vehicleSet.add(vehicleObj1);
		vehicleSet.add(vehicleObj2);
		vehicleSet.add(vehicleObj3);
		vehicleSet.add(vehicleObj4);
		vehicleSet.add(vehicleObj5);
		int outputSetSize = vehicleSet.size();
		int expectedSetSize = 4;
		assertEquals("Matched", expectedSetSize, outputSetSize);
	}
	
	@Test
	// tests equals and hashcode method for car class - positive test case
	public void testEqualsAndHashcodeForCarNegative()  
	{
	Vehicle vehicleObj1 = VehicleHelper.createVehicle("Car","Make1","Model1");
	Vehicle vehicleObj2 = VehicleHelper.createVehicle("Car","Make2","Model2");
	Vehicle vehicleObj3 = VehicleHelper.createVehicle("Car","Make3","Model3");
	Vehicle vehicleObj4 = VehicleHelper.createVehicle("Car","Make2","Model4");
	Vehicle vehicleObj5 = VehicleHelper.createVehicle("Car","Make1","Model1");
		//set stores vehicles
		Set<Vehicle> vehicleSet = new HashSet<Vehicle>();
		vehicleSet.add(vehicleObj1);
		vehicleSet.add(vehicleObj2);
		vehicleSet.add(vehicleObj3);
		vehicleSet.add(vehicleObj4);
		vehicleSet.add(vehicleObj5);
		int outputSetSize = vehicleSet.size();
		int expectedSetSize = 5;
		assertNotEquals("Matched", expectedSetSize, outputSetSize);
	}
	
	@Test
	// tests equals and hashcode method for bike class - positive test case
	public void testEqualsAndHashcodeForBikePositive()  
	{
		Vehicle vehicleObj1 = VehicleHelper.createVehicle("Bike","Make1","Model1");
		Vehicle vehicleObj2 = VehicleHelper.createVehicle("Bike","Make2","Model2");
		Vehicle vehicleObj3 = VehicleHelper.createVehicle("Bike","Make3","Model3");
		Vehicle vehicleObj4 = VehicleHelper.createVehicle("Bike","Make2","Model4");
		Vehicle vehicleObj5 = VehicleHelper.createVehicle("Bike","Make1","Model1");
		//set stores vehicles
		Set<Vehicle> vehicleSet = new HashSet<Vehicle>();
		vehicleSet.add(vehicleObj1);
		vehicleSet.add(vehicleObj2);
		vehicleSet.add(vehicleObj3);
		vehicleSet.add(vehicleObj4);
		vehicleSet.add(vehicleObj5);
		int outputSetSize = vehicleSet.size();
		int expectedSetSize = 4;
		assertEquals("Matched", expectedSetSize, outputSetSize);
	}
	
	@Test
	// tests equals and hashcode method for bike class - positive test case
	public void testEqualsAndHashcodeForBikeNegative()  
	{
		Vehicle vehicleObj1 = VehicleHelper.createVehicle("Bike","Make1","Model1");
		Vehicle vehicleObj2 = VehicleHelper.createVehicle("Bike","Make2","Model2");
		Vehicle vehicleObj3 = VehicleHelper.createVehicle("Bike","Make3","Model3");
		Vehicle vehicleObj4 = VehicleHelper.createVehicle("Bike","Make2","Model4");
		Vehicle vehicleObj5 = VehicleHelper.createVehicle("Bike","Make1","Model1");
		//set stores vehicles
		Set<Vehicle> vehicleSet = new HashSet<Vehicle>();
		vehicleSet.add(vehicleObj1);
		vehicleSet.add(vehicleObj2);
		vehicleSet.add(vehicleObj3);
		vehicleSet.add(vehicleObj4);
		vehicleSet.add(vehicleObj5);
		int outputSetSize = vehicleSet.size();
		int expectedSetSize = 5;
		assertNotEquals("Matched", expectedSetSize, outputSetSize);
	}
	
}
