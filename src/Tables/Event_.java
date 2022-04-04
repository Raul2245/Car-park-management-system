package Tables;

public class Event_ {
	private int id;
	private String details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Event_(int id, String details) {
		super();
		this.id = id;
		this.details = details;
	}

	@Override
	public String toString() {
		return "Event_ [id=" + id + ", details=" + details + "]";
	}

}
