package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Other.AllBrandTableModel;
import Other.AllKmTableModel;
import Other.AllLotsTableModel;
import Other.BestBrandTableModel;
import Other.DailyFuelAverageTableModel;
import Other.AllBrandForm;
import Other.DetailedRaportResult;
import Other.DetailedRaportTableModel;
import Other.DriverRoutesTableModel;
import Other.Employee40TableModel;
import Other.EventsNbTableModel;
import Other.HelperClass;
import Other.KmRKmVRatioTableModel;
import Other.LatestEmployeeTableModel;
import Other.NrBrandTableModel;
import Other.NrStatusesTableModel;
import Other.NumberOfEmployeesTableModel;
import Other.NumberOfEventsTableModel;
import Other.RaportResult;
import Other.Refills2TableModel;
import Other.RouteKmTableModel;
import Other.SalaryRaiseForm;
import Other.SameNameTableModel;
import Other.SameSalaryTableModel;
import Other.ShowEventsForm;
import Other.Top3RefillsTableModel;
import Other.Vehicle500TableModel;
import Other.VehicleRaportTableModel;
import Other.WorkLifeRatioTableModel;
import Tables.Alimentare;
import Tables.AlimentareTableModel;
import Tables.Brand;
import Tables.BrandTableModel;
import Tables.Driver;
import Tables.DriverAdd;
import Tables.DriverTableModel;
import Tables.Employee;
import Tables.EmployeeAdd;
import Tables.EmployeeTableModel;
import Tables.EventAdd;
import Tables.EventTableModel;
import Tables.Event_;
import Tables.Location;
import Tables.LocationTableModel;
import Tables.Lot;
import Tables.LotEventTableModel;
import Tables.LotTableModel;
import Tables.Lot_event;
import Tables.RefillAdd;
import Tables.Route;
import Tables.RouteTableModel;
import Tables.Vehicle;
import Tables.VehicleAdd;
import Tables.VehicleStatusTableModel;
import Tables.VehicleTableModel;
import Tables.Vehicle_status;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class MainView extends JDialog {
	AppManager am;
	private final JPanel contentPanel = new JPanel();
	public JTable table;
	private JTable table_1;
	private JTextField searchField;
	int currentTable = 1;

	/**
	 * Create the dialog.
	 */
	public MainView(AppManager am) {
		this.am = am;

		JLabel searchLabel = new JLabel("Choose a table then search");
		searchLabel.setBounds(10, 104, 240, 13);
		contentPanel.add(searchLabel);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Car Park");
		setBounds(100, 100, 706, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnNewButton = new JButton("Vehicles");
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchLabel.setText("Enter vehicle registration number");
				currentTable = 1;
				List<Vehicle> vehicles = null;
				try {
					vehicles = am.bd.getAllVehicles();

					VehicleTableModel vmodel = new VehicleTableModel(vehicles);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(10, 20, 100, 21);
		contentPanel.add(btnNewButton);

		JButton btnDrivers = new JButton("Drivers");
		btnDrivers.setBackground(new Color(250, 235, 215));
		btnDrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 2;
				searchLabel.setText("Enter driver's first name");
				List<Driver> list = null;
				try {
					list = am.bd.getAllDrivers();

					DriverTableModel vmodel = new DriverTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDrivers.setBounds(105, 20, 107, 21);
		contentPanel.add(btnDrivers);

		JButton btnEmployees = new JButton("Employees");
		btnEmployees.setBackground(new Color(250, 235, 215));
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 3;
				searchLabel.setText("Enter employee first name");
				List<Employee> list = null;
				try {
					list = am.bd.getAllEmployees();

					EmployeeTableModel vmodel = new EmployeeTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEmployees.setBounds(211, 20, 100, 21);
		contentPanel.add(btnEmployees);

		JButton btnNewButton_2_1 = new JButton("Events");
		btnNewButton_2_1.setBackground(new Color(250, 235, 215));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 4;
				searchLabel.setText("Enter lot ID");
				List<Lot_event> list = null;
				try {
					list = am.bd.getAllLotEvents();

					LotEventTableModel vmodel = new LotEventTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_1.setBounds(310, 20, 85, 21);
		contentPanel.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("Routes");
		btnNewButton_2_2.setBackground(new Color(250, 235, 215));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 5;
				searchLabel.setText("Enter departure of the route");
				List<Route> list = null;
				try {
					list = am.bd.getAllRoutes();

					RouteTableModel vmodel = new RouteTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_2.setBounds(353, 40, 100, 21);
		contentPanel.add(btnNewButton_2_2);

		JButton btnNewButton_2_3 = new JButton("Vehicle statuses");
		btnNewButton_2_3.setBackground(new Color(250, 235, 215));
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 6;
				searchLabel.setText("Enter status name");
				List<Vehicle_status> list = null;
				try {
					list = am.bd.getAllVS();

					VehicleStatusTableModel vmodel = new VehicleStatusTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_3.setBounds(10, 40, 145, 21);
		contentPanel.add(btnNewButton_2_3);

		JButton btnNewButton_2_4 = new JButton("Lots");
		btnNewButton_2_4.setBackground(new Color(250, 235, 215));
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 7;
				searchLabel.setText("Enter location ID");
				List<Lot> list = null;
				try {
					list = am.bd.getAllLots();

					LotTableModel vmodel = new LotTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_4.setBounds(495, 20, 78, 21);
		contentPanel.add(btnNewButton_2_4);

		JButton btnNewButton_1 = new JButton("Refills");
		btnNewButton_1.setBackground(new Color(250, 235, 215));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 8;
				searchLabel.setText("Enter vehicle registration number");
				List<Alimentare> list = null;
				try {
					list = am.bd.getAllAlimentari();

					AlimentareTableModel vmodel = new AlimentareTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(151, 40, 91, 21);
		contentPanel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Locations");
		btnNewButton_2.setBackground(new Color(250, 235, 215));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 9;
				searchLabel.setText("Enter city");
				List<Location> list = null;
				try {
					list = am.bd.getAllLocations();

					LocationTableModel vmodel = new LocationTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(240, 40, 114, 21);
		contentPanel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Brands");
		btnNewButton_3.setBackground(new Color(250, 235, 215));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 10;
				searchLabel.setText("Enter brand name");
				List<Brand> list = null;
				try {
					list = am.bd.getAllBrands();

					BrandTableModel vmodel = new BrandTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3.setBounds(382, 20, 114, 21);
		contentPanel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Event Types");
		btnNewButton_4.setBackground(new Color(250, 235, 215));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTable = 11;
				searchLabel.setText("Enter event type");
				List<Event_> list = null;
				try {
					list = am.bd.getAllEvents();

					EventTableModel vmodel = new EventTableModel(list);
					table.setModel(vmodel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MainView.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_4.setBounds(453, 40, 120, 21);
		contentPanel.add(btnNewButton_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(244, 164, 96)));
		scrollPane.setBounds(10, 127, 672, 265);
		contentPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		searchField = new JTextField();
		searchField.setBackground(new Color(245, 245, 245));
		searchField.setForeground(new Color(0, 0, 0));
		searchField.setBounds(260, 101, 215, 19);
		contentPanel.add(searchField);
		searchField.setColumns(10);

		JButton btnNewButton_15 = new JButton("Search");
		btnNewButton_15.setBackground(new Color(250, 235, 215));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				am.adm.makeConnection("User", "password");

				Statement statement = null;
				ResultSet searchResult = null;

				try {
					statement = am.adm.connection.createStatement();

					switch (currentTable) {
					case 1: {

						List<Vehicle> list = new ArrayList<Vehicle>();
						searchResult = statement
								.executeQuery("SELECT * FROM vehicle WHERE nb LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Vehicle vehicle = new Vehicle(searchResult.getInt("id"), searchResult.getString("nb"),
									searchResult.getInt("brandid"), searchResult.getInt("km"),
									searchResult.getInt("statusid"), searchResult.getInt("lotid"),
									searchResult.getInt("driverid"), searchResult.getDate("fuel_date"),
									searchResult.getInt("fuel"), searchResult.getInt("out_year"));

							list.add(vehicle);
						}
						System.out.println(list);
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						VehicleTableModel vmodel = new VehicleTableModel(list);
						table.setModel(vmodel);
						break;
					}

					case 2:
					// table = "driver";
					{
						List<Driver> list = new ArrayList<Driver>();
						searchResult = statement.executeQuery(
								"SELECT * FROM driver WHERE nname LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Driver temp = new Driver(searchResult.getInt("id"), searchResult.getString("nname"),
									searchResult.getString("surname"), searchResult.getInt("age"),
									searchResult.getInt("salary"), searchResult.getString("adress"),
									searchResult.getInt("routeid"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						DriverTableModel vmodel = new DriverTableModel(list);
						table.setModel(vmodel);
						break;
					}
					case 3:
					// table = "employee";
					{
						List<Employee> list = new ArrayList<Employee>();
						searchResult = statement.executeQuery(
								"SELECT * FROM employee WHERE nname LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Employee temp = new Employee(searchResult.getInt("id"), searchResult.getString("nname"),
									searchResult.getString("surname"), searchResult.getInt("age"),
									searchResult.getInt("salary"), searchResult.getString("adress"),
									searchResult.getString("emp_role"), searchResult.getDate("emp_date"),
									searchResult.getInt("lotid"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						EmployeeTableModel vmodel = new EmployeeTableModel(list);
						table.setModel(vmodel);
						break;
					}
					case 4:
					// table = "lot_event";
					{
						List<Lot_event> list = new ArrayList<Lot_event>();
						searchResult = statement.executeQuery(
								"SELECT * FROM lot_event WHERE lotid LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Lot_event temp = new Lot_event(searchResult.getInt("id"), searchResult.getInt("lotid"),
									searchResult.getInt("eventid"), searchResult.getInt("emp_id"),
									searchResult.getDate("ev_date"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						LotEventTableModel vmodel = new LotEventTableModel(list);
						table.setModel(vmodel);
						break;
					}

					case 5:
					// table = "route";
					{
						List<Route> list = new ArrayList<Route>();
						searchResult = statement.executeQuery(
								"SELECT * FROM route WHERE departure LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Route temp = new Route(searchResult.getInt("id"), searchResult.getString("departure"),
									searchResult.getString("arrival"), searchResult.getInt("distance"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						RouteTableModel vmodel = new RouteTableModel(list);
						table.setModel(vmodel);
						break;
					}
					case 6:
					// table = "vehicle_status";
					{
						List<Vehicle_status> list = new ArrayList<Vehicle_status>();
						searchResult = statement.executeQuery(
								"SELECT * FROM vehicle_status WHERE ttype LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Vehicle_status temp = new Vehicle_status(searchResult.getInt("id"),
									searchResult.getString("ttype"), searchResult.getString("details"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						VehicleStatusTableModel vmodel = new VehicleStatusTableModel(list);
						table.setModel(vmodel);
						break;
					}
					case 7:
					// table = "lot";
					{
						List<Lot> list = new ArrayList<Lot>();
						searchResult = statement.executeQuery(
								"SELECT * FROM lot WHERE locationid LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Lot temp = new Lot(searchResult.getInt("id"), searchResult.getInt("size"),
									searchResult.getInt("locationid"), searchResult.getInt("current_size"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						LotTableModel vmodel = new LotTableModel(list);
						table.setModel(vmodel);
						break;
					}
					case 8:
					// table = "alimentare";
					{
						List<Alimentare> list = new ArrayList<Alimentare>();
						searchResult = statement.executeQuery(
								"SELECT * FROM alimentare WHERE nr LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Alimentare temp = new Alimentare(searchResult.getInt("id"), searchResult.getString("nr"),
									searchResult.getInt("fuel"), searchResult.getDate("fueling_date"),
									searchResult.getInt("km"), searchResult.getInt("driverid"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						AlimentareTableModel vmodel = new AlimentareTableModel(list);
						table.setModel(vmodel);
						break;
					}
					case 9:
					// table = "location";
					{
						List<Location> list = new ArrayList<Location>();
						searchResult = statement.executeQuery(
								"SELECT * FROM location WHERE city LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Location temp = new Location(searchResult.getInt("id"), searchResult.getString("city"),
									searchResult.getString("street"), searchResult.getInt("nb"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						LocationTableModel vmodel = new LocationTableModel(list);
						table.setModel(vmodel);
						break;
					}
					case 10:
					// table = "brand";
					{
						List<Brand> list = new ArrayList<Brand>();
						searchResult = statement
								.executeQuery("SELECT * FROM brand WHERE nname LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Brand temp = new Brand(searchResult.getInt("id"), searchResult.getString("nname"),
									searchResult.getInt("fuel_capacity"));

							list.add(temp);
						}
						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						BrandTableModel vmodel = new BrandTableModel(list);
						table.setModel(vmodel);
						break;
					}
					case 11:
					// table = "event_";
					{
						List<Event_> list = new ArrayList<Event_>();
						searchResult = statement.executeQuery(
								"SELECT * FROM event_ WHERE details LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Event_ temp = new Event_(searchResult.getInt("id"), searchResult.getString("details"));

							list.add(temp);
						}

						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");
						EventTableModel vmodel = new EventTableModel(list);
						table.setModel(vmodel);
						break;
					}
					default:
					// table = "vehicle";
					{

						List<Vehicle> list = new ArrayList<Vehicle>();
						searchResult = statement
								.executeQuery("SELECT * FROM vehicle WHERE nb LIKE '%" + searchField.getText() + "%'");
						while (searchResult.next()) {
							Vehicle vehicle = new Vehicle(searchResult.getInt("id"), searchResult.getString("nb"),
									searchResult.getInt("brandid"), searchResult.getInt("km"),
									searchResult.getInt("statusid"), searchResult.getInt("lotid"),
									searchResult.getInt("driverid"), searchResult.getDate("fuel_date"),
									searchResult.getInt("fuel"), searchResult.getInt("out_year"));

							list.add(vehicle);
						}

						if (list.isEmpty())
							JOptionPane.showMessageDialog(null, "There is no result in this table.");

						VehicleTableModel vmodel = new VehicleTableModel(list);
						table.setModel(vmodel);

					}

						if (searchResult == null) {
							JOptionPane.showMessageDialog(null, "There is no result in this table.");

							return;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_15.setBounds(485, 100, 85, 21);
		contentPanel.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("Log Out");
		btnNewButton_16.setForeground(new Color(0, 0, 0));
		btnNewButton_16.setBackground(new Color(255, 239, 213));
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_16.setBounds(583, 10, 99, 107);
		contentPanel.add(btnNewButton_16);

		String[] optionList = { "Show average fuel consumption/km for a driver", "Register a completed route",
				"Vehicle report", "Detailed vehicle report", "Show all cars from a brand",
				"Show all events in which an employee is involved",
				"Salary raise for employees with > 5 events and 2 years seniority",
				"Delete employees with less than 2 events", "Total kilometers for each driver",
				"Show details about driver's routes", "Number of vehicles for each brand", "Show details about lots",
				"Number of vehicles for each status", "Employees employed in the last year",
				"Numeber of events for each employee", "Top 3 Drivers who made the most refills",
				"Breand with the biggest capacity", "Employees from lots with more than 10 cars",
				"Route Km/Vehicle Km Ratio", "All vehicles stored in Bucuresti", "Daily Fuel Average",
				"Number of events of each type", "Number of employees for each role",
				"Drivers and employees with the same salary", "Employees with the same name", "Time worked/Age Ratio",
				"Vehicles with less km than driver's route distance", "Most popular Brand",
				"Vehicle with the number of kilometers greater than 500", "Employees older than 40",
				"Refills in the last year" };
		JComboBox options = new JComboBox(optionList);
		options.setBackground(new Color(250, 235, 215));
		options.setBounds(10, 72, 561, 21);
		MainView mv1 = this;
		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = options.getSelectedIndex();
				switch (x) {
				case 0: {
					am.bd.averageConsumption();
					break;
				}
				case 1: {
					if (am.ui.getStatus() != 4)
						am.bd.registerRoute();
					else
						JOptionPane.showMessageDialog(mv1, "You don't have permission to do that.");
					break;
				}
				case 2: {
					List<RaportResult> res = am.bd.vehicleRaport();

					VehicleRaportTableModel vrmodel = new VehicleRaportTableModel(res);
					table.setModel(vrmodel);
					break;
				}
				case 3: {
					List<DetailedRaportResult> res = am.bd.detailedVehicleRaport();

					DetailedRaportTableModel drmodel = new DetailedRaportTableModel(res);
					table.setModel(drmodel);
					break;
				}
				case 4: {
					AllBrandForm abf = new AllBrandForm(am, mv1);
					break;
				}
				case 5: {
					ShowEventsForm sef = new ShowEventsForm(am, mv1);
					break;
				}
				case 6: {
					if (am.ui.getStatus() == 1) {
						SalaryRaiseForm srf = new SalaryRaiseForm(am);
					} else
						JOptionPane.showMessageDialog(mv1, "You don't have permission to do that.");
					break;
				}
				case 7: {
					if (am.ui.getStatus() == 1)
						am.bd.deleteEmployees();
					else
						JOptionPane.showMessageDialog(mv1, "You don't have permission to do that.");
					break;
				}
				case 8: {
					List<Driver> res = am.bd.getAllKm();

					AllKmTableModel vrmodel = new AllKmTableModel(res);
					table.setModel(vrmodel);
					break;
				}
				case 9: {
					List<Driver> res = am.bd.driverRoutes();

					DriverRoutesTableModel vrmodel = new DriverRoutesTableModel(res);
					table.setModel(vrmodel);
					break;
				}
				case 10: {
					List<Brand> res = am.bd.nrBrands();

					NrBrandTableModel vrmodel = new NrBrandTableModel(res);
					table.setModel(vrmodel);
					break;
				}
				case 11: {
					List<HelperClass> res = am.bd.allLots();

					AllLotsTableModel model = new AllLotsTableModel(res);
					table.setModel(model);
					break;
				}
				case 12: {
					List<HelperClass> res = am.bd.NrOfStatuses();

					NrStatusesTableModel model = new NrStatusesTableModel(res);
					table.setModel(model);
					break;
				}
				case 13: {
					List<HelperClass> res = am.bd.latestEmployees();

					LatestEmployeeTableModel model = new LatestEmployeeTableModel(res);
					table.setModel(model);
					break;
				}
				case 14: {
					List<HelperClass> res = am.bd.eventsNb();

					EventsNbTableModel model = new EventsNbTableModel(res);
					table.setModel(model);
					break;
				}
				case 15: {
					List<HelperClass> res = am.bd.top3Refills();

					Top3RefillsTableModel model = new Top3RefillsTableModel(res);
					table.setModel(model);
					break;
				}
				case 16: {
					List<Brand> res = am.bd.bestCapacity();

					BrandTableModel model = new BrandTableModel(res);
					table.setModel(model);
					break;
				}
				case 17: {
					List<Employee> res = am.bd.employees10V();

					EmployeeTableModel model = new EmployeeTableModel(res);
					table.setModel(model);
					break;
				}
				case 18: {
					List<HelperClass> res = am.bd.KmRKmVRatio();

					KmRKmVRatioTableModel model = new KmRKmVRatioTableModel(res);
					table.setModel(model);
					break;
				}
				case 19: {
					List<Vehicle> res = am.bd.vehiclesBucuresti();

					VehicleTableModel model = new VehicleTableModel(res);
					table.setModel(model);
					break;
				}
				case 20: {
					List<HelperClass> res = am.bd.dailyFuelAverage();

					DailyFuelAverageTableModel model = new DailyFuelAverageTableModel(res);
					table.setModel(model);
					break;
				}
				case 21: {
					List<HelperClass> res = am.bd.numberOfEvents();

					NumberOfEventsTableModel model = new NumberOfEventsTableModel(res);
					table.setModel(model);
					break;
				}
				case 22: {
					List<HelperClass> res = am.bd.numberOfEmployees();

					NumberOfEmployeesTableModel model = new NumberOfEmployeesTableModel(res);
					table.setModel(model);
					break;
				}
				case 23: {
					List<HelperClass> res = am.bd.sameSalary();

					SameSalaryTableModel model = new SameSalaryTableModel(res);
					table.setModel(model);
					break;
				}
				case 24: {
					List<HelperClass> res = am.bd.sameName();

					SameNameTableModel model = new SameNameTableModel(res);
					table.setModel(model);
					break;
				}
				case 25: {
					List<HelperClass> res = am.bd.workLifeRatio();

					WorkLifeRatioTableModel model = new WorkLifeRatioTableModel(res);
					table.setModel(model);
					break;
				}
				case 26: {
					List<HelperClass> res = am.bd.routeKm();

					RouteKmTableModel model = new RouteKmTableModel(res);
					table.setModel(model);
					break;
				}
				case 27: {
					List<HelperClass> res = am.bd.bestBrand();

					BestBrandTableModel model = new BestBrandTableModel(res);
					table.setModel(model);
					break;
				}
				case 28: {
					List<HelperClass> res = am.bd.vehicles500();

					Vehicle500TableModel model = new Vehicle500TableModel(res);
					table.setModel(model);
					break;
				}
				case 29: {
					List<HelperClass> res = am.bd.employee40();

					Employee40TableModel model = new Employee40TableModel(res);
					table.setModel(model);
					break;
				}
				case 30: {
					List<HelperClass> res = am.bd.refills2();

					Refills2TableModel model = new Refills2TableModel(res);
					table.setModel(model);
					break;
				}
				}
			}
		});
		contentPanel.add(options);

		if (am.ui.getStatus() != 4) {
			JButton newVehicle = new JButton("Add vehicle");
			newVehicle.setBackground(new Color(250, 235, 215));
			newVehicle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VehicleAdd va = new VehicleAdd(am.bd, 0, 0, null);
					va.setVisible(true);
				}
			});
			newVehicle.setBounds(10, 402, 145, 21);
			contentPanel.add(newVehicle);

			JButton newDriver = new JButton("Add Driver");
			newDriver.setBackground(new Color(250, 235, 215));
			newDriver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DriverAdd da = new DriverAdd(am.bd, 0, 0, null);
					da.setVisible(true);
				}
			});
			newDriver.setBounds(151, 402, 134, 21);
			contentPanel.add(newDriver);

			JButton newEmployee = new JButton("Add Employee");
			newEmployee.setBackground(new Color(250, 235, 215));
			newEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EmployeeAdd ea = new EmployeeAdd(am.bd, 0, 0, null);
					ea.setVisible(true);
				}
			});
			newEmployee.setBounds(281, 402, 138, 21);
			contentPanel.add(newEmployee);

			JButton newEvent = new JButton("Add event");
			newEvent.setBackground(new Color(250, 235, 215));
			newEvent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventAdd ev = new EventAdd(am.bd, 0, 0, null);
					ev.setVisible(true);
				}
			});
			newEvent.setBounds(418, 402, 134, 21);
			contentPanel.add(newEvent);

			JButton newAlimentare = new JButton("Add refill");
			newAlimentare.setBackground(new Color(250, 235, 215));
			newAlimentare.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RefillAdd ev = new RefillAdd(am.bd, 0, 0, null);
					ev.setVisible(true);
				}
			});
			newAlimentare.setBounds(548, 402, 134, 21);
			contentPanel.add(newAlimentare);

			if (am.ui.getStatus() != 2) {
				JButton btnNewButton_5 = new JButton("Update vehicle");
				btnNewButton_5.setBackground(new Color(250, 235, 215));
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 1)

						{
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_5, "You must select a vehicle.", getTitle(),
										row);
								return;
							}
							String temp = table.getValueAt(row, 0).toString();
							int temp1 = Integer.parseInt(temp);
							String temp2 = table.getValueAt(row, 1).toString();
							temp = table.getValueAt(row, 2).toString();
							int temp3 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 3).toString();
							int temp4 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 4).toString();
							int temp5 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 5).toString();
							int temp6 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 6).toString();
							int temp7 = Integer.parseInt(temp);
							Date dtemp = new Date(5);
							temp = table.getValueAt(row, 7).toString();
							Date temp8 = dtemp.valueOf(temp);
							temp = table.getValueAt(row, 8).toString();
							int temp9 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 9).toString();
							int temp10 = Integer.parseInt(temp);
							Vehicle vh = new Vehicle(temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9,
									temp10);
							VehicleAdd da = new VehicleAdd(am.bd, 1, temp1, vh);
							da.setVisible(true);
						} else
							JOptionPane.showMessageDialog(btnNewButton_5, "Please select the correct table.");
					}

				});
				btnNewButton_5.setBounds(10, 422, 145, 21);
				contentPanel.add(btnNewButton_5);

				JButton btnNewButton_6 = new JButton("Update Driver");
				btnNewButton_6.setBackground(new Color(250, 235, 215));
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 2)

						{
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_6, "You must select a driver.", getTitle(),
										row);
								return;
							}
							String tempDriver = table.getValueAt(row, 0).toString();
							int tempDriver1 = Integer.parseInt(tempDriver);
							String tempDriver2 = table.getValueAt(row, 1).toString();
							String tempDriver3 = table.getValueAt(row, 2).toString();
							tempDriver = table.getValueAt(row, 3).toString();
							int tempDriver4 = Integer.parseInt(tempDriver);
							tempDriver = table.getValueAt(row, 4).toString();
							int tempDriver5 = Integer.parseInt(tempDriver);
							String tempDriver6 = table.getValueAt(row, 5).toString();
							tempDriver = table.getValueAt(row, 6).toString();
							int tempDriver7 = Integer.parseInt(tempDriver);
							Driver dv = new Driver(tempDriver1, tempDriver2, tempDriver3, tempDriver4, tempDriver5,
									tempDriver6, tempDriver7);
							DriverAdd da = new DriverAdd(am.bd, 1, tempDriver1, dv);
							da.setVisible(true);
						} else
							JOptionPane.showMessageDialog(btnNewButton_6, "Please select the correct table.");
					}
				});
				btnNewButton_6.setBounds(151, 422, 134, 21);
				contentPanel.add(btnNewButton_6);

				JButton btnNewButton_7 = new JButton("Update Employee");
				btnNewButton_7.setBackground(new Color(250, 235, 215));
				btnNewButton_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 3)

						{
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_6, "You must select an employee.",
										getTitle(), row);
								return;
							}
							String temp = table.getValueAt(row, 0).toString();
							int temp1 = Integer.parseInt(temp);
							String temp2 = table.getValueAt(row, 1).toString();
							String temp3 = table.getValueAt(row, 2).toString();
							temp = table.getValueAt(row, 3).toString();
							int temp4 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 4).toString();
							int temp5 = Integer.parseInt(temp);
							String temp6 = table.getValueAt(row, 5).toString();
							String temp7 = table.getValueAt(row, 6).toString();
							Date dtemp = new Date(5);
							temp = table.getValueAt(row, 7).toString();
							Date temp8 = dtemp.valueOf(temp);
							temp = table.getValueAt(row, 8).toString();
							int temp9 = Integer.parseInt(temp);
							Employee ep = new Employee(temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9);
							EmployeeAdd da = new EmployeeAdd(am.bd, 1, temp1, ep);
							da.setVisible(true);
						} else
							JOptionPane.showMessageDialog(btnNewButton_6, "Please select the correct table.");
					}
				});
				btnNewButton_7.setBounds(283, 422, 136, 21);
				contentPanel.add(btnNewButton_7);

				JButton btnNewButton_8 = new JButton("Update Event");
				btnNewButton_8.setBackground(new Color(250, 235, 215));
				btnNewButton_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 4) {
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_5, "You must select an event.", getTitle(),
										row);
								return;
							}
							String temp = table.getValueAt(row, 0).toString();
							int temp1 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 1).toString();
							int temp2 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 2).toString();
							int temp3 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 3).toString();
							Date dtemp = new Date(5);
							temp = table.getValueAt(row, 4).toString();
							Date temp4 = dtemp.valueOf(temp);

							Lot_event l = new Lot_event(temp1, temp2, temp3, temp4);
							EventAdd da = new EventAdd(am.bd, 1, temp1, l);
							da.setVisible(true);
						} else
							JOptionPane.showMessageDialog(btnNewButton_5, "Please select the correct table.");
					}
				});
				btnNewButton_8.setBounds(418, 422, 134, 21);
				contentPanel.add(btnNewButton_8);

				JButton btnNewButton_9 = new JButton("Update refill");
				btnNewButton_9.setBackground(new Color(250, 235, 215));
				btnNewButton_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 8) {
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_5, "You must select a refill entry.",
										getTitle(), row);
								return;
							}
							String temp = table.getValueAt(row, 0).toString();
							int temp1 = Integer.parseInt(temp);
							String temp2 = table.getValueAt(row, 1).toString();
							temp = table.getValueAt(row, 2).toString();
							int temp3 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 2).toString();
							Date dtemp = new Date(5);
							temp = table.getValueAt(row, 3).toString();
							Date temp4 = dtemp.valueOf(temp);
							temp = table.getValueAt(row, 4).toString();
							int temp5 = Integer.parseInt(temp);
							temp = table.getValueAt(row, 5).toString();
							int temp6 = Integer.parseInt(temp);

							Alimentare a = new Alimentare(temp1, temp2, temp3, temp4, temp5, temp6);
							RefillAdd da = new RefillAdd(am.bd, 1, temp1, a);
							da.setVisible(true);

						} else
							JOptionPane.showMessageDialog(btnNewButton_5, "Please select the correct table.");
					}
				});
				btnNewButton_9.setBounds(548, 422, 134, 21);
				contentPanel.add(btnNewButton_9);

				JButton btnNewButton_10 = new JButton("Delete vehicle");
				btnNewButton_10.setBackground(new Color(250, 235, 215));
				btnNewButton_10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 1) {
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_6, "You must select a vehicle.", getTitle(),
										row);
								return;
							}
							String temp = table.getValueAt(row, 0).toString();
							int temp1 = Integer.parseInt(temp);
							try {
								am.bd.deleteVehicle(temp1);
								JOptionPane.showMessageDialog(btnNewButton_10,
										"You have succesfully deleted the vehicle with the ID: " + temp1);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else
							JOptionPane.showMessageDialog(btnNewButton_10, "Please select the correct table.");
					}
				});
				btnNewButton_10.setBounds(10, 442, 145, 21);
				contentPanel.add(btnNewButton_10);

				JButton btnNewButton_11 = new JButton("Delete Driver");
				btnNewButton_11.setBackground(new Color(250, 235, 215));
				btnNewButton_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 2) {
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_6, "You must select a driver.", getTitle(),
										row);
								return;
							}
							String tempDriver = table.getValueAt(row, 0).toString();
							int tempDriver1 = Integer.parseInt(tempDriver);
							try {
								am.bd.deleteDriver(tempDriver1);
								JOptionPane.showMessageDialog(btnNewButton_11,
										"You have succesfully deleted the driver with the ID: " + tempDriver1);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else
							JOptionPane.showMessageDialog(btnNewButton_11, "Please select the correct table.");
					}
				});
				btnNewButton_11.setBounds(151, 442, 134, 21);
				contentPanel.add(btnNewButton_11);

				JButton btnNewButton_12 = new JButton("Delete Employee");
				btnNewButton_12.setBackground(new Color(250, 235, 215));
				btnNewButton_12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 3) {
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_6, "You must select an employee.",
										getTitle(), row);
								return;
							}
							String temp = table.getValueAt(row, 0).toString();
							int temp1 = Integer.parseInt(temp);
							try {
								am.bd.deleteEmployee(temp1);
								JOptionPane.showMessageDialog(btnNewButton_11,
										"You have succesfully deleted the employee with the ID: " + temp1);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else
							JOptionPane.showMessageDialog(btnNewButton_11, "Please select the correct table");
					}
				});
				btnNewButton_12.setBounds(283, 442, 136, 21);
				contentPanel.add(btnNewButton_12);

				JButton btnNewButton_13 = new JButton("Delete Event");
				btnNewButton_13.setBackground(new Color(250, 235, 215));
				btnNewButton_13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 4) {
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_6, "You must select an event.", getTitle(),
										row);
								return;
							}
							String temp = table.getValueAt(row, 0).toString();
							int temp1 = Integer.parseInt(temp);
							try {
								am.bd.deleteEvent(temp1);
								JOptionPane.showMessageDialog(btnNewButton_11,
										"You have succesfully deleted the event with the ID: " + temp1);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

						else
							JOptionPane.showMessageDialog(btnNewButton_11, "Please select the right table.");
					}
				});
				btnNewButton_13.setBounds(418, 442, 134, 21);
				contentPanel.add(btnNewButton_13);

				JButton btnNewButton_14 = new JButton("Delete refill");
				btnNewButton_14.setBackground(new Color(250, 235, 215));
				btnNewButton_14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (currentTable == 8) {
							int row = table.getSelectedRow();

							if (row < 0) {
								JOptionPane.showMessageDialog(btnNewButton_6, "You must select a refill entry.",
										getTitle(), row);
								return;
							}
							String temp = table.getValueAt(row, 0).toString();
							int temp1 = Integer.parseInt(temp);
							try {
								am.bd.deleteRefill(temp1);
								JOptionPane.showMessageDialog(btnNewButton_11,
										"You have succesfully deleted the refill entry with the ID: " + temp1);
							} catch (SQLException e1) {

								e1.printStackTrace();
							}
						} else
							JOptionPane.showMessageDialog(btnNewButton_10, "Please select the correct table.");
					}
				});
				btnNewButton_14.setBounds(548, 442, 134, 21);
				contentPanel.add(btnNewButton_14);
			}
		}

		JLabel bgLabel = new JLabel();
		bgLabel.setBounds(-10, -25, 692, 633);
		contentPanel.setBackground(new Color(255, 228, 181));
	}
}
