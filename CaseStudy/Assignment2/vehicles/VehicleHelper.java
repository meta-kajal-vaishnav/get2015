// creates instance of various vehicle classes
package vehicles;

public class VehicleHelper {
	
	// creates instance of vehicle class
	public static Vehicle createVehicle( String vehicleType, String make, String model ) {
		if ( vehicleType.equals(VehicleType.Car) )
			return createCar ( make, model );
		else
			return createBike ( make, model );
	}
	
	
	// creates instance of car class
	public static Vehicle createCar( String make, String model ) {
		Car carObj = new Car();
		carObj.setMake(make);
		carObj.setModel(model);
//		carObj.setAC("yes");
//		carObj.setAccessoryKit("yes");
//		carObj.setPowerSteering("yes");
		return carObj;
	}
	

	// creates instance of bike class
	public static Bike createBike(String make, String model ) {
		Bike bikeObj = new Bike();
		bikeObj.setMake(make);
		bikeObj.setModel(model);
//		bikeObj.setHelmetPrice(1200);
//		bikeObj.setSelfStart("yes");
		return bikeObj;
	}
	
}
