package Tables;

public class Driver {
	private int id;
	private String nname;
	private String surname;
	private int age;
	private int salary;
	private String adress;
	private int routeid;

	public String aux;
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

	public int getRouteid() {
		return routeid;
	}

	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}

	public Driver(int id, String nname, String surname, int age, int salary, String adress, int routeid) {
		super();
		this.id = id;
		this.nname = nname;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
		this.adress = adress;
		this.routeid = routeid;
	}

	public Driver(String nname, String surname, int age, int salary, String adress, int routeid) {
		super();
		this.nname = nname;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
		this.adress = adress;
		this.routeid = routeid;
	}
	
	public Driver(String nname, String surname, int age, int salary, int routeid) {
		super();
		this.nname = nname;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
		this.routeid = routeid;
	}
	
	public Driver(String nname, String surname, String adress, String aux, int routeid) {
		super();
		this.nname = nname;
		this.surname = surname;
		this.adress = adress;
		this.aux = aux;
		this.routeid = routeid;
	}
	
	@Override
	public String toString() {
		return "Driver [id=" + id + ", nname=" + nname + ", surname=" + surname + ", age=" + age + ", salary=" + salary
				+ ", adress=" + adress + ", routeid=" + routeid + "]";
	}

}
