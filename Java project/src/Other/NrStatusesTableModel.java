package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tables.Brand;
import Tables.Vehicle;

public class NrStatusesTableModel extends AbstractTableModel {


	private String[] columnNames = { "Status", "Number of vehicles", "Details"};

	private List<HelperClass> vehicles;
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
		HelperClass tempvehicle = vehicles.get(row);
		
		switch(col){
			
			case 0: return tempvehicle.getString1();
			case 2: return tempvehicle.getString2();
			case 1: return tempvehicle.getInt1();
			default: return tempvehicle.getString1();
		}
	}

	public NrStatusesTableModel(List<HelperClass> vehicles) {
		super();
		this.vehicles = vehicles;
	}
	
	

}
