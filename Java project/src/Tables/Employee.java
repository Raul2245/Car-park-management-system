package Tables;

import java.sql.Date;

public class Employee {
	private int id;
	private String nname;
	private String surname;
	private int age;
	private int salary;
	private String adress;
	private String emp_role;
	private Date emp_date;
	private int lotid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	public Date getEmp_date() {
		return emp_date;
	}

	public void setEmp_date(Date emp_date) {
		this.emp_date = emp_date;
	}

	public int getLotid() {
		return lotid;
	}

	public void setLotid(int lotid) {
		this.lotid = lotid;
	}

	public Employee(int id, String nname, String surname, int age, int salary, String adress, String emp_role,
			Date emp_date, int lotid) {
		super();
		this.id = id;
		this.nname = nname;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
		this.adress = adress;
		this.emp_role = emp_role;
		this.emp_date = emp_date;
		this.lotid = lotid;
	}

	public Employee(String nname, String surname, int age, int salary, String adress, String emp_role, Date emp_date,
			int lotid) {
		super();
		this.id = id;
		this.nname = nname;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
		this.adress = adress;
		this.emp_role = emp_role;
		this.emp_date = emp_date;
		this.lotid = lotid;
	}

	public Employee(String nname, String surname, String adress, Date emp_date, String emp_role, int lotid) {
		super();
		
		this.nname = nname;
		this.surname = surname;
		
		this.adress = adress;
		this.emp_date = emp_date;
		this.emp_role = emp_role;
		
		this.lotid = lotid;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nname=" + nname + ", surname=" + surname + ", age=" + age + ", salary="
				+ salary + ", adress=" + adress + ", emp_role=" + emp_role + ", emp_date=" + emp_date + ", lotid="
				+ lotid + "]";
	}

}
