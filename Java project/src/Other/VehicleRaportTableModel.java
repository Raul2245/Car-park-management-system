package Other;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class VehicleRaportTableModel extends AbstractTableModel {
	private static final int nb_COL = 0;
	private static final int out_year_COL = 1;
	private static final int avg_cons_COL = 2;
	
	private String[] columnNames = { "Registration Number", "Year", "Average consumption" };

	private List<RaportResult> res;
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
		RaportResult temp = res.get(row);
		
		switch(col){
			case nb_COL: return temp.getNb();
			case out_year_COL: return temp.getOut_year();
			case avg_cons_COL: return temp.getAvg_cons();
			default: return temp.getNb();
		}
	}

	public VehicleRaportTableModel(List<RaportResult> list) {
		super();
		this.res = list;
	}
	
	

}
