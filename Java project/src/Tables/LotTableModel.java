package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LotTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int size_COL = 1;
	private static final int locationid_COL = 2;
	private static final int current_size_COL = 3;

	private String[] columnNames = { "Lot ID", "Size", "Location ID", "Current Size" };
	private List<Lot> list;

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
		Lot temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case size_COL:
			return temp.getSize();
		case locationid_COL:
			return temp.getLocationid();
		case current_size_COL:
			return temp.getCurrent_size();
		default:
			return temp.getSize();
		}
	}

	public LotTableModel(List<Lot> list) {
		super();
		this.list = list;
	}
}
