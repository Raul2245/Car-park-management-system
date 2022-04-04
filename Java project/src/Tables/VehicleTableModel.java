package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class VehicleTableModel extends AbstractTableModel {
	private static final int ID_COL = 0;
	private static final int nb_COL = 1;
	private static final int brandid_COL = 2;
	private static final int km_COL = 3;
	private static final int statusid_COL = 4;
	private static final int lotid_COL = 5;
	private static final int driverid_COL = 6;
	private static final int fuel_date_COL = 7;
	private static final int fuel_COL = 8;
	private static final int out_year_COL = 9;

	private String[] columnNames = { "Vehicle ID", "Registration Number", "Brand ID", "Kilometers", "Status ID",
			"Lot ID", "Driver ID", "Last Fueling Date", "Fuel", "Year" };

	private List<Vehicle> vehicles;
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vehicles.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Vehicle tempvehicle = vehicles.get(row);
		
		switch(col){
			case ID_COL: return tempvehicle.getId();
			case nb_COL: return tempvehicle.getNb();
			case brandid_COL: return tempvehicle.getBrandid();
			case km_COL: return tempvehicle.getKm();
			case statusid_COL: return tempvehicle.getStatusid();
			case lotid_COL: return tempvehicle.getStatusid();
			case driverid_COL: return tempvehicle.getDriverid();
			case fuel_date_COL: return tempvehicle.getFuel_date();
			case fuel_COL: return tempvehicle.getFuel();
			case out_year_COL: return tempvehicle.getOut_year();
			default: return tempvehicle.getNb();
		}
	}

	public VehicleTableModel(List<Vehicle> vehicles) {
		super();
		this.vehicles = vehicles;
	}
	
	

}
