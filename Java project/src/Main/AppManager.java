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
import Tables.Vehicle_status;

public class AppManager {
	public UI ui = new UI(this);
	public Admin adm = new Admin(this);
	public BDlink bd = new BDlink(this);
	public Registration reg = new Registration(this);
	public MainView mv = new MainView(this);
	public static void main(String[] args) {
		new AppManager();
	}

	public AppManager() {
	}
}
