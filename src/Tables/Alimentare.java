package Tables;
import java.sql.Date;

public class Alimentare {
	private int id;
	private String nr;
	private int fuel;
	private Date fueling_date;
	private int km;
	private int driverid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public Date getFueling_date() {
		return fueling_date;
	}

	public void setFueling_date(Date fueling_date) {
		this.fueling_date = fueling_date;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getDriverid() {
		return driverid;
	}

	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}

	public Alimentare(int id, String nr, int fuel, Date fueling_date, int km, int driverid) {
		super();
		this.id = id;
		this.nr = nr;
		this.fuel = fuel;
		this.fueling_date = fueling_date;
		this.km = km;
		this.driverid = driverid;
	}
	
	public Alimentare( String nr, int fuel, Date fueling_date, int km, int driverid) {
		super();
		this.nr = nr;
		this.fuel = fuel;
		this.fueling_date = fueling_date;
		this.km = km;
		this.driverid = driverid;
	}

	@Override
	public String toString() {
		return "Alimentare [id=" + id + ", nr=" + nr + ", fuel=" + fuel + ", fueling_date=" + fueling_date + ", km="
				+ km + ", driverid=" + driverid + "]";
	}

}
