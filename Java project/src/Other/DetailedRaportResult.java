package Other;

import java.sql.Date;

public class DetailedRaportResult {
	private String nb;
	private int out_year;
	private Date fuel_date;
	private int driverid;
	private double avg_cons;
	
	public Date getFueld_date() {
		return fuel_date;
	}
	public void setFueld_date(Date fueld_date) {
		this.fuel_date = fueld_date;
	}
	public int getDriverid() {
		return driverid;
	}
	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}
	
	public String getNb() {
		return nb;
	}
	public void setNb(String nb) {
		this.nb = nb;
	}
	public int getOut_year() {
		return out_year;
	}
	public void setOut_year(int out_year) {
		this.out_year = out_year;
	}
	public double getAvg_cons() {
		return avg_cons;
	}
	public void setAvg_cons(double avg_cons) {
		this.avg_cons = avg_cons;
	}

	
	public DetailedRaportResult(String nb, int out_year, Date fuel_date, int driverid, double avg_cons) {
		super();
		this.nb = nb;
		this.out_year = out_year;
		this.fuel_date = fuel_date;
		this.driverid = driverid;
		this.avg_cons = avg_cons;
	}
	
	
}
