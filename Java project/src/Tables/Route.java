package Tables;

public class Route {
	private int id;
	private String departure;
	private String arrival;
	private int distance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Route(int id, String departure, String arrival, int distance) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", departure=" + departure + ", arrival=" + arrival + ", distance=" + distance + "]";
	}

}
