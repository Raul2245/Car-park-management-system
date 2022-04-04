package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class Refills2TableModel extends AbstractTableModel {


	private String[] columnNames = { "Registration Number", "Refil Date", "Number of km since last refill", "Driver ID"};

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
		HelperClass temp = vehicles.get(row);
		
		switch(col){
			
			case 0: return temp.getString1();
			case 2: return temp.getInt1();
			case 3: return temp.getInt2();
			case 1: return temp.getDate1();
			default: return temp.getString1();
		}
	}

	public Refills2TableModel(List<HelperClass> temp) {
		super();
		this.vehicles = temp;
	}
	
	

}
