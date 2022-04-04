package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class NumberOfEventsTableModel extends AbstractTableModel {


	private String[] columnNames = { "Event", "Number of events"};

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
			case 1: return temp.getInt1();
			default: return temp.getString1();
		}
	}

	public NumberOfEventsTableModel(List<HelperClass> temp) {
		super();
		this.vehicles = temp;
	}
	
	

}
