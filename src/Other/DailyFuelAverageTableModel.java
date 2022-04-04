package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class DailyFuelAverageTableModel extends AbstractTableModel {


	private String[] columnNames = { "Date", "Daily average" };

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
			
			case 0: return temp.getDate1();
			case 1: return temp.getDouble1();
			default: return temp.getDate1();
		}
	}

	public DailyFuelAverageTableModel(List<HelperClass> temp) {
		super();
		this.vehicles = temp;
	}
	
	

}
