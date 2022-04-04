package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DetailedRaportTableModel extends AbstractTableModel {
	private static final int nb_COL = 0;
	private static final int out_year_COL = 1;
	private static final int fuel_date_COL = 2;
	private static final int driverid_COL = 3;
	private static final int avg_cons_COL = 4;
	
	private String[] columnNames = { "Registration Number", "Year", "Fuel date", "Driver ID", "Average consumption" };

	private List<DetailedRaportResult> res;
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return res.size();
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
		DetailedRaportResult temp = res.get(row);
		
		switch(col){
			case nb_COL: return temp.getNb();
			case out_year_COL: return temp.getOut_year();
			case fuel_date_COL: return temp.getFueld_date();
			case driverid_COL: return temp.getDriverid();
			case avg_cons_COL: return temp.getAvg_cons();
			default: return temp.getNb();
		}
	}

	public DetailedRaportTableModel(List<DetailedRaportResult> list) {
		super();
		this.res = list;
	}
	
	

}
