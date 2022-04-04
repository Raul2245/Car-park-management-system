package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EventTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int details_COL = 1;

	private String[] columnNames = { "Event ID", "Details" };
	private List<Event_> list;

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
		Event_ temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case details_COL:
			return temp.getDetails();
		default:
			return temp.getDetails();
		}
	}

	public EventTableModel(List<Event_> list) {
		super();
		this.list = list;
	}
}
