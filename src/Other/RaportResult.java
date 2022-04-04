package Other;

public class RaportResult {
	private String nb;
	private int out_year;
	private double avg_cons;
	
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
	public RaportResult(String nb, int out_year, double avg_cons) {
		super();
		this.nb = nb;
		this.out_year = out_year;
		this.avg_cons = avg_cons;
	}
	@Override
	public String toString() {
		return "RaportResult [nb=" + nb + ", out_year=" + out_year + ", avg_cons=" + avg_cons + "]";
	}
	
	
}
