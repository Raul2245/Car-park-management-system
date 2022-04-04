package Tables;

public class Brand {
	private int id;
	private String nname;
	private int fuel_capacity;

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

	public int getFuel_capacity() {
		return fuel_capacity;
	}

	public void setFuel_capacity(int fuel_capacity) {
		this.fuel_capacity = fuel_capacity;
	}

	public Brand(int id, String nname, int fuel_capacity) {
		super();
		this.id = id;
		this.nname = nname;
		this.fuel_capacity = fuel_capacity;
	}
	
	public Brand(String nname, int fuel_capacity) {
		super();
		this.nname = nname;
		this.fuel_capacity = fuel_capacity;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", nname=" + nname + ", fuel_capacity=" + fuel_capacity + "]";
	}

}
