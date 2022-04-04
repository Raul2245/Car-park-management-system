package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LotEventTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int lotid_COL = 1;
	private static final int eventid_COL = 2;
	private static final int emp_id_COL = 3;
	private static final int ev_date_COL = 4;

	private String[] columnNames = { "Action ID", "Lot ID", "Event ID", "Employee ID", "Action date" };
	private List<Lot_event> list;

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
		Lot_event temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case lotid_COL:
			return temp.getLotid();
		case eventid_COL:
			return temp.getEventid();
		case emp_id_COL:
			return temp.getEmp_id();
		case ev_date_COL:
			return temp.getEv_date();
		default:
			return temp.getEv_date();
		}
	}

	public LotEventTableModel(List<Lot_event> list) {
		super();
		this.list = list;
	}
}
