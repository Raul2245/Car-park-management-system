package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tables.Vehicle;

public class AllBrandTableModel extends AbstractTableModel {

	private static final int nb_COL = 0;
	private static final int brand_COL = 1;
	private static final int lotid_COL = 2;
	private static final int out_year_COL = 3;

	private String[] columnNames = { "Registration Number", "Brand",
			"Lot ID", "Year" };

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
			
			case nb_COL: return tempvehicle.getNb();
			case brand_COL: return tempvehicle.getBrand();
			case lotid_COL: return tempvehicle.getLotid();
			case out_year_COL: return tempvehicle.getOut_year();
			default: return tempvehicle.getNb();
		}
	}

	public AllBrandTableModel(List<Vehicle> vehicles) {
		super();
		this.vehicles = vehicles;
	}
	
	

}
