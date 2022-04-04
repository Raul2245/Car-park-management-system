package Tables;

import java.sql.Date;
import java.time.Year;

public class Vehicle {
	private int id;
	private String nb;
	private int brandid;
	private int km;
	private int statusid;
	private int lotid;
	private int driverid;
	private Date fuel_date;
	private int fuel;
	private int out_year;

	private String brand;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNb() {
		return nb;
	}

	public void setNb(String nb) {
		this.nb = nb;
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public int getLotid() {
		return lotid;
	}

	public void setLotid(int lotid) {
		this.lotid = lotid;
	}

	public int getDriverid() {
		return driverid;
	}

	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}

	public Date getFuel_date() {
		return fuel_date;
	}

	public void setFuel_date(Date fuel_date) {
		this.fuel_date = fuel_date;
	}

	public int getFuel() {
		return fuel;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public int getOut_year() {
		return out_year;
	}

	public void setOut_year(int out_year) {
		this.out_year = out_year;
	}

	public Vehicle(int id, String nb, int brandid, int km, int statusid, int lotid, int driverid, Date fuel_date,
			int fuel, int out_year) {
		super();
		this.id = id;
		this.nb = nb;
		this.brandid = brandid;
		this.km = km;
		this.statusid = statusid;
		this.lotid = lotid;
		this.driverid = driverid;
		this.fuel_date = fuel_date;
		this.fuel = fuel;
		this.out_year = out_year;
	}

	public Vehicle(String nb, int brandid, int km, int statusid, int lotid, int driverid, Date date, int fuel,
			int out_year) {
		super();
		this.nb = nb;
		this.brandid = brandid;
		this.km = km;
		this.statusid = statusid;
		this.lotid = lotid;
		this.driverid = driverid;
		this.fuel_date = date;
		this.fuel = fuel;
		this.out_year = out_year;
	}

	public Vehicle(String nb, String brand, int lotid, int out_year) {
		super();
		this.nb = nb;
		this.brand = brand;
	
		this.lotid = lotid;
	
		this.out_year = out_year;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", nb=" + nb + ", brandid=" + brandid + ", km=" + km + ", statusid=" + statusid
				+ ", lotid=" + lotid + ", driverid=" + driverid + ", fuel_date=" + fuel_date + ", fuel=" + fuel
				+ ", out_year=" + out_year + "]";
	}

}
