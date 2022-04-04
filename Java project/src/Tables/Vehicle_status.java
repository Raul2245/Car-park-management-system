package Tables;

public class Vehicle_status {
	private int id;
	private String ttype;
	private String details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Vehicle_status(int id, String ttype, String details) {
		super();
		this.id = id;
		this.ttype = ttype;
		this.details = details;
	}

	@Override
	public String toString() {
		return "Vehicle_status [id=" + id + ", ttype=" + ttype + ", details=" + details + "]";
	}

}
