package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tables.Brand;
import Tables.Vehicle;

public class AllLotsTableModel extends AbstractTableModel {

	private static final int nb_COL = 0;
	private static final int brand_COL = 1;
	private static final int lotid_COL = 2;
	private static final int out_year_COL = 3;

	private String[] columnNames = { "Lot ID", "Current Size", "Maximum size", "City", "Street", "Number"};

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
			
			case 0: return tempvehicle.getInt1();
			case 1: return tempvehicle.getInt2();
			case 2: return tempvehicle.getInt3();
			case 3: return tempvehicle.getString1();
			case 4: return tempvehicle.getString2();
			case 5: return tempvehicle.getString3();
			default: return tempvehicle.getInt1();
		}
	}

	public AllLotsTableModel(List<HelperClass> vehicles) {
		super();
		this.vehicles = vehicles;
	}
	
	

}
