package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tables.Employee;
import Tables.Vehicle;

public class ShowEventsTableModel extends AbstractTableModel {

	private static final int nname_COL = 0;
	private static final int surname_COL = 1;
	private static final int emp_role_COL = 2;
	private static final int details_COL = 3;
	private static final int date_COL = 4;
	private static final int lotid_COL = 5;
	
	private String[] columnNames = { "First Name", "Last Name",
			"Role ID", "Event details", "Date", "Lot ID"};

	private List<Employee> temp;
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return temp.size();
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
		Employee tempvehicle = temp.get(row);
		
		switch(col){
			
			case nname_COL: return tempvehicle.getNname();
			case surname_COL: return tempvehicle.getSurname();
			case lotid_COL: return tempvehicle.getLotid();
			case emp_role_COL: return tempvehicle.getEmp_role();
			case details_COL: return tempvehicle.getAdress();
			case date_COL: return tempvehicle.getEmp_date();
			default: return tempvehicle.getNname();
		}
	}

	public ShowEventsTableModel(List<Employee> temp) {
		super();
		this.temp = temp;
	}
	
	

}
