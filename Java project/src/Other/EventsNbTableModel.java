package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class EventsNbTableModel extends AbstractTableModel {


	private String[] columnNames = { "Employee ID", "First Name", "Last Name", "Number of Events"};

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
			
			case 0: return temp.getInt2();
			case 1: return temp.getString1();
			case 2: return temp.getString2();
			case 3: return temp.getInt1();
			default: return temp.getString1();
		}
	}

	public EventsNbTableModel(List<HelperClass> temp) {
		super();
		this.vehicles = temp;
	}
	
	

}
