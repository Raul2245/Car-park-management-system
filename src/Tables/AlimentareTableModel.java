package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AlimentareTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int nr_COL = 1;
	private static final int fuel_COL = 2;
	private static final int fueling_date_COL = 3;
	private static final int km_COL = 4;
	private static final int driverid_COL = 5;

	private String[] columnNames = { "Refuel ID", "Registration Number", "Fuel", "Fueling Date", "Kilometers",
			"Driver ID" };

	private List<Alimentare> alimentari;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return alimentari.size();
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
		Alimentare temp = alimentari.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case nr_COL:
			return temp.getNr();
		case fuel_COL:
			return temp.getFuel();
		case km_COL:
			return temp.getKm();
		case fueling_date_COL:
			return temp.getFueling_date();
		case driverid_COL:
			return temp.getDriverid();
		default:
			return temp.getNr();
		}
	}

	public AlimentareTableModel(List<Alimentare> alimentari) {
		super();
		this.alimentari = alimentari;
	}
}
