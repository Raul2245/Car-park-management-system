package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class VehicleStatusTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int ttype_COL = 1;
	private static final int details_COL = 2;

	private String[] columnNames = { "Status ID", "Type", "Details" };
	private List<Vehicle_status> list;

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
		Vehicle_status temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case ttype_COL:
			return temp.getTtype();
		case details_COL:
			return temp.getDetails();
		default:
			return temp.getTtype();
		}
	}

	public VehicleStatusTableModel(List<Vehicle_status> list) {
		super();
		this.list = list;
	}
}
