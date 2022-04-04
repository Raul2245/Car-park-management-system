package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LocationTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int city_COL = 1;
	private static final int street_COL = 2;
	private static final int nb_COL = 3;

	private String[] columnNames = { "Location ID", "City", "Street", "Number"};
	private List<Location> list;

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
		Location temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case city_COL:
			return temp.getCity();
		case street_COL:
			return temp.getStreet();
		case nb_COL:
			return temp.getNb();
		default:
			return temp.getCity();
		}
	}

	public LocationTableModel(List<Location> list) {
		super();
		this.list = list;
	}
}
