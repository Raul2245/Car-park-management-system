package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tables.Brand;
import Tables.Vehicle;

public class NrBrandTableModel extends AbstractTableModel {

	private static final int nb_COL = 0;
	private static final int brand_COL = 1;
	private static final int lotid_COL = 2;
	private static final int out_year_COL = 3;

	private String[] columnNames = { "Brand Name", "Number of cars"};

	private List<Brand> vehicles;
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
		Brand tempvehicle = vehicles.get(row);
		
		switch(col){
			
			case 0: return tempvehicle.getNname();
			case 1: return tempvehicle.getFuel_capacity();
			
			default: return tempvehicle.getNname();
		}
	}

	public NrBrandTableModel(List<Brand> vehicles) {
		super();
		this.vehicles = vehicles;
	}
	
	

}
