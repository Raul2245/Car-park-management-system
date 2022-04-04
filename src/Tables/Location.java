package Tables;

public class Location {
	private int id;
	private String city;
	private String street;
	private int nb;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public Location(int id, String city, String street, int nb) {
		super();
		this.id = id;
		this.city = city;
		this.street = street;
		this.nb = nb;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", street=" + street + ", nb=" + nb + "]";
	}

}
