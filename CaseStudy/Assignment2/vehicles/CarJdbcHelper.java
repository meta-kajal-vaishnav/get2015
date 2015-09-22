package vehicles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarJdbcHelper {

	// creates car table
	public static String createCarTable() throws VehicleManagementException {
		String createdVehicleType = null;
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "CREATE TABLE IF NOT EXISTS Car"
				+ "("
				+ "car_id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "ac tinyint(1),"
				+ "power_steering tinyint(1),"
				+ "accessory_kit tinyint(1),"
				+ "vehicle_id INT,"
				+ "CONSTRAINT `vehicle_key` FOREIGN KEY (vehicle_id) REFERENCES Vehicle (vehicle_id) ON DELETE CASCADE"
				+ ")";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			createdVehicleType = "Car Created";
		} catch (SQLException e) {
			throw new VehicleManagementException("Cannot create car : " + e);
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return createdVehicleType;
	}

	// insert in car table
	public static int insertInCarTable(Car objCar)
			throws VehicleManagementException {
		int countCar = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "INSERT INTO Car ( ac, power_steering, accessory_kit, vehicle_id ) VALUES (?,?,?,?)";

		try {
			ps = (PreparedStatement) con.prepareStatement(query);
			/* set variable in prepared statement */
			ps.setBoolean(1, objCar.getAC());
			ps.setBoolean(2, objCar.getPowerSteering());
			ps.setBoolean(3, objCar.getAccessoryKit());
			ps.setInt(4, objCar.getVehicleId());
			countCar = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return countCar;
	}

	// deletes from car table
	public static String deleteCarTable(int vehicleId)
			throws VehicleManagementException {
		String str = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "SELECT vehicle_id FROM Car WHERE vehicle_id = "
				+ vehicleId;
		try {
			stmt = con.createStatement();
			/* execute query using statement */
			rs = stmt.executeQuery(query);
			if (rs.next() == false)
				return "Id doesnot exist";
			else {
				stmt = null;
				query = "DELETE FROM Vehicle WHERE vehicle_id = " + vehicleId;
				try {
					stmt = con.createStatement();
					stmt.executeUpdate(query);
					str = "Car deleted";
				} catch (SQLException e) {
					throw new VehicleManagementException("Cannot delete car : "
							+ e);
				}
			}
		} catch (SQLException e) {
			throw new VehicleManagementException("Cannot delete car : " + e);
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
}
