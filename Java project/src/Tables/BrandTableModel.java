package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BrandTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int nname_COL = 1;
	private static final int fuel_capacity_COL = 2;

	private String[] columnNames = { "Brand ID", "Brand name", "Max Fuel capacity" };
	private List<Brand> list;

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
		Brand temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case nname_COL:
			return temp.getNname();
		case fuel_capacity_COL:
			return temp.getFuel_capacity();
		default:
			return temp.getNname();
		}
	}

	public BrandTableModel(List<Brand> list) {
		super();
		this.list = list;
	}
}
