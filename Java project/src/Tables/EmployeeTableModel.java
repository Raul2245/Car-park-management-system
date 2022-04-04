package Tables;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel {
	private static final int id_COL = 0;
	private static final int nname_COL = 1;
	private static final int surname_COL = 2;
	private static final int age_COL = 3;
	private static final int salary_COL = 4;
	private static final int adress_COL = 5;
	private static final int emp_role_COL = 6;
	private static final int emp_date_COL = 7;
	private static final int lotid_COL = 8;

	private String[] columnNames = { "Employee ID", "First name", "Last Name", "Age", "Salary", "Adress", "Role", "Employment date", "Lot" };
	private List<Employee> list;

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
		Employee temp = list.get(row);

		switch (col) {
		case id_COL:
			return temp.getId();
		case nname_COL:
			return temp.getNname();
		case surname_COL:
			return temp.getSurname();
		case age_COL:
			return temp.getAge();
		case salary_COL:
			return temp.getSalary();
		case adress_COL:
			return temp.getAdress();
		case emp_role_COL:
			return temp.getEmp_role();
		case emp_date_COL:
			return temp.getEmp_date();
		case lotid_COL:
			return temp.getLotid();
		default:
			return temp.getNname();
		}
	}

	public EmployeeTableModel(List<Employee> list) {
		super();
		this.list = list;
	}
}
