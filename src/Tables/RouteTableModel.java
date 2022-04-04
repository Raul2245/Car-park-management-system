package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RouteTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int departure_COL = 1;
	private static final int arrival_COL = 2;
	private static final int distance_COL = 3;

	private String[] columnNames = { "Route ID", "Departure", "Arrival", "Distance" };
	private List<Route> list;

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
		Route temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case departure_COL:
			return temp.getDeparture();
		case arrival_COL:
			return temp.getArrival();
		case distance_COL:
			return temp.getDistance();
		default:
			return temp.getDeparture();
		}
	}

	public RouteTableModel(List<Route> list) {
		super();
		this.list = list;
	}
}
