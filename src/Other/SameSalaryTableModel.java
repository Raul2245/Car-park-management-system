package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class SameSalaryTableModel extends AbstractTableModel {

	private String[] columnNames = { "Driver First Name", "Driver Last Name", "Driver Salary", "Employee First Name",
			"Employee Last Name", "Employee Salary" };

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

		switch (col) {

		case 0:
			return temp.getString1();
		case 1:
			return temp.getString2();
		case 2:
			return temp.getInt1();
		case 3:
			return temp.getString3();
		case 4:
			return temp.getString4();
		case 5:
			return temp.getInt2();
		default:
			return temp.getString1();
		}
	}

	public SameSalaryTableModel(List<HelperClass> temp) {
		super();
		this.vehicles = temp;
	}

}
