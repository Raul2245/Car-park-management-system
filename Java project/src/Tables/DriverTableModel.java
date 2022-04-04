package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DriverTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int nname_COL = 1;
	private static final int surname_COL = 2;
	private static final int age_COL = 3;
	private static final int salary_COL = 4;
	private static final int adress_COL = 5;
	private static final int routeid_COL = 6;

	private String[] columnNames = { "Driver ID", "First name", "Last Name", "Age", "Salary", "Adress", "Route ID" };
	private List<Driver> list;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
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
		Driver temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case nname_COL:
			return temp.getNname();
		case surname_COL:
			return temp.getSurname();
		case age_COL:
			return temp.getAge();
		case salary_COL:
			return temp.getSalary();
		case adress_COL:
			return temp.getAdress();
		case routeid_COL:
			return temp.getRouteid();
		default:
			return temp.getNname();
		}
	}

	public DriverTableModel(List<Driver> list) {
		super();
		this.list = list;
	}
}
