package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tables.Driver;

public class DriverRoutesTableModel extends AbstractTableModel {


	private String[] columnNames = { "First name", "Last Name", "Departure", "Arrival", "Distance" };
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
		case 0:
			return temp.getNname();
		case 1:
			return temp.getSurname();
		case 2:
			return temp.getAdress();
		case 3:
			return temp.aux;

		case 4:
			return temp.getRouteid();
		default:
			return temp.getNname();
		}
	}

	public DriverRoutesTableModel(List<Driver> list) {
		super();
		this.list = list;
	}
}
