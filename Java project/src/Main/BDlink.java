package Main;

import Tables.Alimentare;
import Tables.Brand;
import Tables.Driver;
import Tables.Employee;
import Tables.Event_;
import Tables.Location;
import Tables.Lot;
import Tables.Lot_event;
import Tables.Route;
import Tables.Vehicle;
import Tables.VehicleTableModel;
import Tables.Vehicle_status;

import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Other.AverageConsumptionForm;
import Other.DetailedRaportResult;
import Other.HelperClass;
import Other.RaportResult;
import Other.RegisterRouteForm;
import Other.VehicleRaportTableModel;

public class BDlink {
	AppManager am;

	public BDlink(AppManager am) {
		super();
		this.am = am;
	}

	public List<Vehicle> getAllVehicles() throws Exception {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM vehicle");

			while (resultSet.next()) {

				Vehicle vehicle = new Vehicle(resultSet.getInt("id"), resultSet.getString("nb"),
						resultSet.getInt("brandid"), resultSet.getInt("km"), resultSet.getInt("statusid"),
						resultSet.getInt("lotid"), resultSet.getInt("driverid"), resultSet.getDate("fuel_date"),
						resultSet.getInt("fuel"), resultSet.getInt("out_year"));

				vehicles.add(vehicle);
			}

			return vehicles;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Alimentare> getAllAlimentari() throws Exception {
		List<Alimentare> list = new ArrayList<Alimentare>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM alimentare");

			while (resultSet.next()) {
				Alimentare temp = new Alimentare(resultSet.getInt("id"), resultSet.getString("nr"),
						resultSet.getInt("fuel"), resultSet.getDate("fueling_date"), resultSet.getInt("km"),
						resultSet.getInt("driverid"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Brand> getAllBrands() throws Exception {
		List<Brand> list = new ArrayList<Brand>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM brand");

			while (resultSet.next()) {
				Brand temp = new Brand(resultSet.getInt("id"), resultSet.getString("nname"),
						resultSet.getInt("fuel_capacity"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Driver> getAllDrivers() throws Exception {
		List<Driver> list = new ArrayList<Driver>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM driver");

			while (resultSet.next()) {
				Driver temp = new Driver(resultSet.getInt("id"), resultSet.getString("nname"),
						resultSet.getString("surname"), resultSet.getInt("age"), resultSet.getInt("salary"),
						resultSet.getString("adress"), resultSet.getInt("routeid"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<Employee>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM employee");

			while (resultSet.next()) {
				Employee temp = new Employee(resultSet.getInt("id"), resultSet.getString("nname"),
						resultSet.getString("surname"), resultSet.getInt("age"), resultSet.getInt("salary"),
						resultSet.getString("adress"), resultSet.getString("emp_role"), resultSet.getDate("emp_date"),
						resultSet.getInt("lotid"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Event_> getAllEvents() throws Exception {
		List<Event_> list = new ArrayList<Event_>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM event_");

			while (resultSet.next()) {
				Event_ temp = new Event_(resultSet.getInt("id"), resultSet.getString("details"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Location> getAllLocations() throws Exception {
		List<Location> list = new ArrayList<Location>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM location");

			while (resultSet.next()) {
				Location temp = new Location(resultSet.getInt("id"), resultSet.getString("city"),
						resultSet.getString("street"), resultSet.getInt("nb"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Lot_event> getAllLotEvents() throws Exception {
		List<Lot_event> list = new ArrayList<Lot_event>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM lot_event");

			while (resultSet.next()) {
				Lot_event temp = new Lot_event(resultSet.getInt("id"), resultSet.getInt("lotid"),
						resultSet.getInt("eventid"), resultSet.getInt("emp_id"), resultSet.getDate("ev_date"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Lot> getAllLots() throws Exception {
		List<Lot> list = new ArrayList<Lot>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM lot");

			while (resultSet.next()) {
				Lot temp = new Lot(resultSet.getInt("id"), resultSet.getInt("size"), resultSet.getInt("locationid"),
						resultSet.getInt("current_size"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Route> getAllRoutes() throws Exception {
		List<Route> list = new ArrayList<Route>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM route");

			while (resultSet.next()) {
				Route temp = new Route(resultSet.getInt("id"), resultSet.getString("departure"),
						resultSet.getString("arrival"), resultSet.getInt("distance"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<Vehicle_status> getAllVS() throws Exception {
		List<Vehicle_status> list = new ArrayList<Vehicle_status>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			am.adm.makeConnection("Admin", "admdtbs123");
			statement = am.adm.connection.createStatement();
			JButton btnNewButton = null;
			if (statement == null)
				JOptionPane.showMessageDialog(btnNewButton, "The connection was not made");
			resultSet = statement.executeQuery("SELECT * FROM vehicle_status");

			while (resultSet.next()) {
				Vehicle_status temp = new Vehicle_status(resultSet.getInt("id"), resultSet.getString("ttype"),
						resultSet.getString("details"));

				list.add(temp);
			}

			return list;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public void addUser(String username, String password, String fname, String lname, String email) {
		am.adm.makeConnection("Admin", "admdtbs123");

		Statement statement = null;
		ResultSet users = null;

		try {
			statement = am.adm.connection.createStatement();
			users = statement.executeQuery("SELECT * FROM accounts");

			boolean flagUsername = false;
			boolean flagEmail = false;
			while (users.next()) {
				String tempUser = users.getString("username");
				String tempEmail = users.getString("email");

				System.out.println(tempUser + tempEmail);
				if (tempUser.indexOf(username) != -1)
					flagUsername = true;
				if (tempEmail.indexOf(email) != -1)
					flagEmail = true;

			}
			if (flagUsername == true) {
				JOptionPane.showMessageDialog(null, "Username already exists.");

				return;
			}
			if (flagEmail == true) {
				JOptionPane.showMessageDialog(null, "Email already exists.");
				return;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		am.adm.makeConnection("Admin", "admdtbs123");
		String query = "INSERT INTO accounts(nname, surname, email, username, pass) VALUES('" + fname + "', '" + lname
				+ "', '" + email + "', '" + username + "', '" + password + "');";

		String query1 = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "';";

		String query2 = "GRANT SELECT, INSERT ON `car_park` . * TO '" + username + "'@'localhost';";

		try {
			Statement sta = am.adm.connection.createStatement();
			sta.execute(query);
			sta.execute(query1);
			sta.execute(query2);
			JOptionPane.showMessageDialog(null, "User was succesfully created.");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error creating user.");
		}
	}

	public void addVehicle(Vehicle ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement(
					"INSERT INTO vehicle(nb, brandid, km, statusid, lotid, driverid, fuel_date, fuel, out_year) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

			st.setString(1, ob.getNb());
			st.setInt(2, ob.getBrandid());
			st.setInt(3, ob.getKm());
			st.setInt(4, ob.getStatusid());
			st.setInt(5, ob.getLotid());
			st.setInt(6, ob.getDriverid());
			st.setDate(7, ob.getFuel_date());
			st.setInt(8, ob.getFuel());
			st.setInt(9, ob.getOut_year());

			st.execute();
		} finally {
			st.close();
		}
	}

	private static void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {

		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(PreparedStatement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);
	}

	public void addDriver(Driver ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement(
					"INSERT INTO driver(nname, surname, age, salary, adress, routeid) VALUES (?, ?, ?, ?, ?, ?);");

			st.setString(1, ob.getNname());
			st.setString(2, ob.getSurname());
			st.setInt(3, ob.getAge());
			st.setInt(4, ob.getSalary());
			st.setString(5, ob.getAdress());
			st.setInt(6, ob.getRouteid());

			st.execute();
		} finally {
			st.close();
		}
	}

	public void updateDriver(int id, Driver ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement(
					"UPDATE driver SET nname = ?, surname = ?, age = ?, salary = ?, adress = ?, routeid = ? WHERE id = ?;");

			st.setString(1, ob.getNname());
			st.setString(2, ob.getSurname());
			st.setInt(3, ob.getAge());
			st.setInt(4, ob.getSalary());
			st.setString(5, ob.getAdress());
			st.setInt(6, ob.getRouteid());
			st.setInt(7, id);

			st.execute();
		} finally {
			st.close();
		}
	}

	public void deleteDriver(int id) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement("DELETE FROM driver WHERE id = ?;");
			st.setInt(1, id);
			st.execute();
		} finally {
			st.close();
		}
	}

	public void updateVehicle(int id, Vehicle ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement(
					"UPDATE vehicle SET nb = ?, brandid = ?, km = ?, statusid = ?, lotid = ?, driverid = ?, fuel_date = ?, fuel = ?, out_year = ? WHERE id = ?;");

			st.setString(1, ob.getNb());
			st.setInt(2, ob.getBrandid());
			st.setInt(3, ob.getKm());
			st.setInt(4, ob.getStatusid());
			st.setInt(5, ob.getLotid());
			st.setInt(6, ob.getDriverid());
			st.setDate(7, ob.getFuel_date());
			st.setInt(8, ob.getFuel());
			st.setInt(9, ob.getOut_year());
			st.setInt(10, id);

			st.execute();
		} finally {
			st.close();
		}
	}

	public void deleteVehicle(int id) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement("DELETE FROM vehicle WHERE id = ?;");
			st.setInt(1, id);
			st.execute();
		} finally {
			st.close();
		}
	}

	public void deleteEmployee(int id) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement("DELETE FROM employee WHERE id = ?;");
			st.setInt(1, id);
			st.execute();
		} finally {
			st.close();
		}

	}

	public void deleteEvent(int id) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement("DELETE FROM lot_event WHERE id = ?;");
			st.setInt(1, id);
			st.execute();
		} finally {
			st.close();
		}
	}

	public void deleteRefill(int id) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement("DELETE FROM alimentare WHERE id = ?;");
			st.setInt(1, id);
			st.execute();
		} finally {
			st.close();
		}
	}

	public void addEmployee(Employee ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement(
					"INSERT INTO employee(nname, surname, age, salary, adress, emp_role, emp_date, lotid) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

			st.setString(1, ob.getNname());
			st.setString(2, ob.getSurname());
			st.setInt(3, ob.getAge());
			st.setInt(4, ob.getSalary());
			st.setString(5, ob.getAdress());
			st.setString(6, ob.getEmp_role());
			st.setDate(7, ob.getEmp_date());
			st.setInt(8, ob.getLotid());

			st.execute();
		} finally {
			st.close();
		}
	}

	public void updateEmployee(int id, Employee ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement(
					"UPDATE employee SET nname = ?, surname = ?, age = ?, salary = ?, adress = ?, emp_role = ?, emp_date = ?,lotid = ? WHERE id = ?;");

			st.setString(1, ob.getNname());
			st.setString(2, ob.getSurname());
			st.setInt(3, ob.getAge());
			st.setInt(4, ob.getSalary());
			st.setString(5, ob.getAdress());
			st.setString(6, ob.getEmp_role());
			st.setDate(7, ob.getEmp_date());
			st.setInt(8, ob.getLotid());
			st.setInt(9, id);

			st.execute();
		} finally {
			st.close();
		}
	}

	public void addEvent(Lot_event ob, String nb) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		CallableStatement st = null;
		try {
			st = am.adm.connection.prepareCall("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			
			//st = am.adm.connection
					//.prepareStatement("INSERT INTO lot_event(lotid, eventid, emp_id, ev_date) VALUES (?, ?, ?, ?);");
			
			st = am.adm.connection.prepareCall("CALL inregistrare_eveniment(?, ?, ?, ?);");
			
			st.setString(4, nb);
			st.setInt(1, ob.getEventid());
			st.setInt(3, ob.getEmp_id());
			st.setDate(2, ob.getEv_date());

			st.execute();
		} finally {
			st.close();
		}
	}

	public void updateEvent(int id, Lot_event ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement(
					"UPDATE lot_event SET lotid = ?, eventid = ?, emp_id = ?, ev_date = ? WHERE id = ?;");

			st.setInt(1, ob.getLotid());
			st.setInt(2, ob.getEventid());
			st.setInt(3, ob.getEmp_id());
			st.setDate(4, ob.getEv_date());
			st.setInt(5, id);

			st.execute();
		} finally {
			st.close();
		}
	}

	public void addRefill(Alimentare ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement("CALL alimentare_vehicul(?, ?, ?, ?)");

			st.setString(1, ob.getNr());
			st.setInt(3, ob.getKm());
			st.setDate(2, ob.getFueling_date());
			st.setInt(4, ob.getDriverid());

			st.execute();
		} finally {
			st.close();
		}
	}

	public void updateRefill(int id, Alimentare ob) throws SQLException {
		am.adm.makeConnection("Admin", "admdtbs123");

		PreparedStatement st = null;
		try {
			st = am.adm.connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			st.execute();
			st = am.adm.connection.prepareStatement(
					"UPDATE alimentare SET nr = ?, fuel = ?, fueling_date = ?, km = ?, driverid = ?  WHERE id = ?;");

			st.setString(1, ob.getNr());
			st.setInt(2, ob.getFuel());
			st.setDate(3, ob.getFueling_date());
			st.setInt(4, ob.getKm());
			st.setInt(5, ob.getDriverid());
			st.setInt(6, id);

			st.execute();
		} finally {
			st.close();
		}
	}

	public void averageConsumption() {
		AverageConsumptionForm acf = new AverageConsumptionForm(am);
	}

	public void registerRoute() {
		RegisterRouteForm rrf = new RegisterRouteForm(am);
	}

	public List<RaportResult> vehicleRaport() {
		List<RaportResult> list = new ArrayList<RaportResult>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("CALL raport_vehicule();");
			st.execute();
			res = st.getResultSet();

			while (res.next()) {
				RaportResult rr = new RaportResult(res.getString("Numar inmatriculare"), res.getInt("Anul fabricatiei"),
						res.getDouble("Consum Mediu"));
				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<DetailedRaportResult> detailedVehicleRaport() {
		List<DetailedRaportResult> list = new ArrayList<DetailedRaportResult>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("CALL raport_detaliat_vehicule();");
			st.execute();
			res = st.getResultSet();

			while (res.next()) {
				DetailedRaportResult rr = new DetailedRaportResult(res.getString("Numar inmatriculare"),
						res.getInt("Anul fabricatiei"), res.getDate("Ultima alimentare"), res.getInt("ID Sofer"),
						res.getDouble("Consum Mediu"));
				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<Vehicle> getAllBrandCars(String brand, String status) {
		List<Vehicle> list = new ArrayList<Vehicle>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("CALL all_brand_cars(?, ?);");
			st.setString(1, brand);
			st.setString(2, status);

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				Vehicle rr = new Vehicle(res.getString("Numar inmatriculare"), res.getString("Firma producatoare"),
						res.getInt("Lotul"), res.getInt("Anul fabricatiei"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<Employee> showEvents(int employee) {
		List<Employee> list = new ArrayList<Employee>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("CALL show_events(?);");
			st.setInt(1, employee);

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				Employee rr = new Employee(res.getString("Nume angajat"), res.getString("Prenume angajat"),
						res.getString("Post"), res.getDate("Data"), res.getString("Eveniment"), res.getInt("Lot"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public void salaryRaise(int employee) {
		am.adm.makeConnection("Admin", "admdtbs123");

		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("CALL marire_salariu(?);");
			st.setInt(1, employee);

			st.execute();
			JOptionPane.showMessageDialog(null, "Salary raise successful.");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1);
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	public void deleteEmployees() {
		am.adm.makeConnection("Admin", "admdtbs123");

		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("CALL delete_employees();");

			st.execute();
			JOptionPane.showMessageDialog(null, "Deletion successful.");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1);
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public List<Driver> getAllKm() {
		List<Driver> list = new ArrayList<Driver>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT d.nname AS 'Nume',\r\n" + "		d.surname AS 'Prenume',\r\n"
					+ "        d.age AS 'Varsta',\r\n" + "        d.salary AS 'Salariu',\r\n"
					+ "        SUM(a.km) AS 'Kilometri parcursi'\r\n" + "FROM driver d\r\n"
					+ "LEFT JOIN alimentare a ON a.driverid = d.id\r\n" + "GROUP BY d.id\r\n" + "ORDER BY d.age;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				Driver rr = new Driver(res.getString("Nume"), res.getString("Prenume"), res.getInt("Varsta"),
						res.getInt("Salariu"), res.getInt("Kilometri parcursi"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<Driver> driverRoutes() {
		List<Driver> list = new ArrayList<Driver>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT d.nname AS 'Nume',\r\n" + "		d.surname AS 'Prenume',\r\n"
					+ "        r.departure AS 'Pornire',\r\n" + "        r.arrival AS 'Sosire',\r\n"
					+ "        r.distance AS 'Kilometraj'\r\n" + "FROM driver d\r\n"
					+ "LEFT JOIN route r ON r.id = d.routeid \r\n" + "GROUP BY r.id\r\n" + "ORDER BY r.distance;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				Driver rr = new Driver(res.getString("Nume"), res.getString("Prenume"), res.getString("Pornire"),
						res.getString("Sosire"), res.getInt("Kilometraj"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<Brand> nrBrands() {
		List<Brand> list = new ArrayList<Brand>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT b.nname AS 'Nume Producator',\r\n"
					+ "		COUNT(v.id) AS 'Numar de vehicule'\r\n" + "FROM vehicle v\r\n"
					+ "RIGHT JOIN brand b ON v.brandid = b.id\r\n" + "GROUP BY b.id\r\n" + "ORDER BY COUNT(v.id);");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				Brand rr = new Brand(res.getString("Nume Producator"), res.getInt("Numar de vehicule"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> allLots() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT l.id AS 'ID lot',\r\n"
					+ "		COUNT(v.id) AS 'Dimensiune curenta',\r\n" + "        l.size AS 'Dimensiune maxima',\r\n"
					+ "        ll.city AS 'Oras',\r\n" + "        ll.street AS 'Strada',\r\n"
					+ "        ll.nb AS 'Numarul'\r\n" + "FROM vehicle v\r\n" + "RIGHT JOIN lot l ON v.lotid = l.id\r\n"
					+ "LEFT JOIN location ll ON l.locationid = ll.id\r\n" + "GROUP BY l.id;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Oras"), res.getString("Strada"),
						res.getString("Numarul"), res.getInt("ID lot"), res.getInt("Dimensiune curenta"),
						res.getInt("Dimensiune maxima"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> NrOfStatuses() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection
					.prepareCall("SELECT vs.ttype AS 'Status',\r\n" + "		COUNT(v.id) AS 'Numar de vehicule',\r\n"
							+ "        vs.details AS 'Detalii'\r\n" + "FROM vehicle_status vs \r\n"
							+ "LEFT JOIN vehicle v ON vs.id = v.statusid\r\n" + "GROUP BY vs.ttype;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Status"), res.getString("Detalii"),
						res.getInt("Numar de vehicule"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> latestEmployees() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT e.nname AS 'Nume angajat',\r\n"
					+ "		e.surname AS 'Prenume angajat', \r\n" + "        e.emp_date AS 'Data angajarii',\r\n"
					+ "        DATEDIFF(CURRENT_DATE(), e.emp_date) AS 'Vechime'\r\n" + "FROM employee e\r\n"
					+ "HAVING DATEDIFF(CURRENT_DATE(), e.emp_date) < 1095;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume angajat"), res.getString("Prenume angajat"),
						res.getInt("Vechime"), res.getDate("Data angajarii"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> eventsNb() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT e.id AS 'ID angajat', \r\n"
					+ "		e.nname AS 'Nume angajat',\r\n" + "		e.surname AS 'Prenume angajat',\r\n"
					+ "        COUNT(le.id) AS 'Numar evenimente'\r\n" + "FROM employee e \r\n"
					+ "LEFT JOIN lot_event le ON le.emp_id = e.id\r\n" + "GROUP BY e.id\r\n"
					+ "ORDER BY COUNT(le.id) DESC;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume angajat"), res.getString("Prenume angajat"),
						res.getInt("Numar evenimente"), res.getInt("ID angajat"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> top3Refills() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT d.id AS 'ID sofer',\r\n" + "		d.nname AS 'Nume sofer',\r\n"
					+ "        d.surname AS 'Prenume sofer',\r\n" + "        COUNT(a.id) AS 'Numar de alimentari'\r\n"
					+ "FROM driver d\r\n" + "LEFT JOIN alimentare a ON a.driverid = d.id\r\n" + "GROUP BY d.id\r\n"
					+ "ORDER BY COUNT(a.id) DESC\r\n" + "LIMIT 3;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume sofer"), res.getString("Prenume sofer"),
						res.getInt("ID sofer"), res.getInt("Numar de alimentari"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<Brand> bestCapacity() {
		List<Brand> list = new ArrayList<Brand>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT b.id AS 'Brand ID',\r\n" + "b.nname AS 'Nume',\r\n"
					+ "		b.fuel_capacity AS 'Capacitate'\r\n" + "FROM brand b\r\n"
					+ "ORDER BY fuel_capacity DESC\r\n" + "LIMIT 1;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				Brand rr = new Brand(res.getInt("Brand ID"), res.getString("Nume"), res.getInt("Capacitate"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<Employee> employees10V() {
		List<Employee> list = new ArrayList<Employee>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall(
					"SELECT *\r\n" + "FROM employee\r\n" + "WHERE lotid IN (\r\n" + "		SELECT l.id \r\n"
							+ "        FROM lot l\r\n" + "        LEFT JOIN vehicle v ON l.id = v.lotid\r\n"
							+ "        GROUP BY l.id\r\n" + "        HAVING COUNT(v.id) > 2)\r\n" + "ORDER BY lotid;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				Employee rr = new Employee(res.getInt("id"), res.getString("nname"), res.getString("surname"),
						res.getInt("age"), res.getInt("salary"), res.getString("adress"), res.getString("emp_role"),
						res.getDate("emp_date"), res.getInt("lotid"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> KmRKmVRatio() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT d.nname AS 'Nume',\r\n" + "		d.surname AS 'Prenume',\r\n"
					+ "        r.departure AS 'Pornire',\r\n" + "        r.arrival AS 'Sosire',\r\n"
					+ "        r.distance / v.km AS 'Ratio'\r\n" + "FROM driver d\r\n"
					+ "LEFT JOIN route r ON d.routeid = r.id\r\n" + "LEFT JOIN vehicle v ON d.id = v.driverid\r\n"
					+ "ORDER BY r.distance / v.km;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume"), res.getString("Prenume"),
						res.getString("Pornire"), res.getString("Sosire"), res.getDouble("Ratio"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<Vehicle> vehiclesBucuresti() {
		List<Vehicle> list = new ArrayList<Vehicle>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT *\r\n" + "FROM vehicle v\r\n"
					+ "LEFT JOIN lot l ON v.lotid = l.id\r\n" + "LEFT JOIN location ll ON l.locationid = ll.id\r\n"
					+ "WHERE ll.city = 'Bucuresti'\r\n" + "ORDER BY v.id;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				Vehicle rr = new Vehicle(res.getInt("id"), res.getString("nb"), res.getInt("brandid"), res.getInt("km"),
						res.getInt("statusid"), res.getInt("lotid"), res.getInt("driverid"), res.getDate("fuel_date"),
						res.getInt("fuel"), res.getInt("out_year"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> dailyFuelAverage() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT a.fueling_date AS 'Data',\r\n"
					+ "		AVG( (SELECT b.fuel_capacity \r\n" + "			FROM brand b \r\n"
					+ "            LEFT JOIN vehicle v ON v.brandid = b.id \r\n"
					+ "            WHERE (v.brandid = b.id AND STRCMP(v.nb, a.nr) = 0))) AS 'Media de combustibil'\r\n"
					+ "FROM alimentare a\r\n" + "GROUP BY a.fueling_date\r\n" + "ORDER BY AVG(a.fueling_date);");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getDate("Data"), res.getDouble("Media de combustibil"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> numberOfEvents() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall(
					"SELECT ev.details AS 'Eveniment',\r\n" + "		COUNT(le.id) AS 'Numarul de evenimente'\r\n"
							+ "FROM event_ ev\r\n" + "LEFT JOIN lot_event le ON ev.id = le.eventid\r\n"
							+ "GROUP BY ev.id\r\n" + "ORDER BY COUNT(le.id);");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Eveniment"), res.getInt("Numarul de evenimente"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> numberOfEmployees() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT e.emp_role AS 'Post',\r\n"
					+ "		COUNT(e.id) AS 'Numar de angajati'\r\n" + "FROM employee e\r\n" + "GROUP BY e.emp_role;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Post"), res.getInt("Numar de angajati"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> sameSalary() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT DISTINCT d.nname AS 'Nume sofer',\r\n"
					+ "		d.surname AS 'Prenume sofer',\r\n" + "        d.salary AS 'Salariu sofer',\r\n"
					+ "		e.nname AS 'Nume angajat',\r\n" + "        e.surname AS 'Prenume angajat',\r\n"
					+ "        e.salary AS 'Salariu angajat'\r\n" + "FROM driver d, employee e\r\n"
					+ "WHERE d.salary = e.salary;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume sofer"), res.getString("Prenume sofer"),
						res.getString("Nume angajat"), res.getString("Prenume angajat"), res.getInt("Salariu sofer"),
						res.getInt("Salariu angajat"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> sameName() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT DISTINCT d.nname AS 'Nume sofer',\r\n"
					+ "		d.surname AS 'Prenume sofer'\r\n" + "FROM employee d, employee dd\r\n"
					+ "WHERE (d.surname = dd.surname AND d.nname != dd.nname) OR (d.nname = dd.nname AND d.surname != dd.surname) OR (d.surname = dd.surname AND d.nname = dd.nname AND d.id != dd.id);\r\n");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume sofer"), res.getString("Prenume sofer"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> workLifeRatio() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT e.nname AS 'Nume angajat',\r\n"
					+ "		e.surname AS 'Prenume angajat',\r\n"
					+ "        DATEDIFF(CURRENT_DATE(), e.emp_date) / (365 * e.age) AS 'Ratio'\r\n"
					+ "FROM employee e\r\n" + "ORDER BY DATEDIFF(CURRENT_DATE(), e.emp_date) / (365 * e.age) DESC;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume angajat"), res.getString("Prenume angajat"),
						res.getDouble("Ratio"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> routeKm() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT d.nname AS 'Nume sofer',\r\n"
					+ "		d.surname AS 'Prenume sofer',\r\n" + "        r.distance AS 'Distanta rutei',\r\n"
					+ "        v.km AS 'Kilometrajul masinii'\r\n" + "FROM driver d\r\n"
					+ "LEFT JOIN route r ON d.routeid = r.id\r\n" + "LEFT JOIN vehicle v ON d.id = v.driverid\r\n"
					+ "WHERE r.distance < v.km;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume sofer"), res.getString("Prenume sofer"),
						res.getInt("Distanta rutei"), res.getInt("Kilometrajul masinii"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> bestBrand() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT b.nname AS 'Firma producatoare',\r\n"
					+ "		COUNT(le.id) AS 'Numar interactiuni'\r\n" + "FROM brand b\r\n"
					+ "LEFT JOIN vehicle v ON b.id = v.brandid\r\n" + "LEFT JOIN lot_event le ON v.lotid = le.lotid\r\n"
					+ "GROUP BY b.nname\r\n" + "ORDER BY COUNT(le.id) DESC\r\n" + "LIMIT 1;");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Firma producatoare"), res.getInt("Numar interactiuni"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> vehicles500() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT * \r\n" + "FROM vehicule");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Numar_inmatriculare"), res.getInt("Kilometraj"),
						res.getInt("Combustibil"), res.getDate("Data_ultimei_alimentari"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> employee40() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT * \r\n" + "FROM angajati");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Nume"), res.getString("Prenume"), res.getInt("Varsta"),
						res.getInt("Salariu"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	public List<HelperClass> refills2() {
		List<HelperClass> list = new ArrayList<HelperClass>();
		am.adm.makeConnection("Admin", "admdtbs123");

		ResultSet res = null;
		CallableStatement st = null;
		try {

			st = am.adm.connection.prepareCall("SELECT * \r\n" + "FROM alimentari");

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				HelperClass rr = new HelperClass(res.getString("Numar_inmatriculare"), res.getInt("Kilometri_parcursi"),
						res.getInt("Sofer"), res.getDate("Data_alimentarii"));

				list.add(rr);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}
}
