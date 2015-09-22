package vehicles;

import java.util.List;
import java.util.Scanner;

public class VehicleMain {
	public static void main(String args[]) throws VehicleManagementException {
		Scanner sc = null;
		StaxParser objStaxParser = null;

		try {
			int choice = 0, vehicleId = 0;
			String filePath = "C://Users/Kajal/workspace/CaseStudy2_1/src/vehicles/vehicle.xml";
			objStaxParser = new StaxParser();
			sc = new Scanner(System.in);

			List<Vehicle> readVehicleFromConfig;
			readVehicleFromConfig = objStaxParser.readConfig(filePath);

			while (true) {
				System.out.println("\n\nMenu");
				System.out.println("1). create table");
				System.out.println("2). insert into table");
				System.out.println("3). delete all");
				System.out.println("4). delete a car");
				System.out.println("5). delete a bike");
				System.out.println("6). exit");
				System.out.println("Enter choice : ");
				choice = sc.nextInt();
				switch (choice) {
				case 1: // create table
					System.out.println(VehicleJdbcHelper.createVehicleTable());
					System.out.println(CarJdbcHelper.createCarTable());
					System.out.println(BikeJdbcHelper.createBikeTable());
					break;

				case 2:
					for (Vehicle objVehicle : readVehicleFromConfig) {
						System.out.println(objVehicle);
						// insert in table
						String insertedVehicleType = VehicleJdbcHelper
								.insertInVehicleTable(objVehicle);
						System.out.println(insertedVehicleType);
					}
					break;

				case 3:
					System.out.println(VehicleJdbcHelper.deleteVehicleTable());
					break;

				case 4:
					System.out
							.println("Enter vehicle id of car to be deleted : ");
					vehicleId = sc.nextInt();
					System.out.println(CarJdbcHelper.deleteCarTable(vehicleId));
					break;

				case 5:
					System.out
							.println("Enter vehicle id of car to be deleted : ");
					vehicleId = sc.nextInt();
					System.out.println(BikeJdbcHelper
							.deleteBikeTable(vehicleId));
					break;

				case 6:
					System.exit(0);
					break;

				default:
					System.out.println("Enter correct choice");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (sc != null) {
				sc = null;
			}
			if (objStaxParser != null) {
				objStaxParser = null;
			}
		}

	}
}
