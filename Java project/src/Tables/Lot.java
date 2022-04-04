package Tables;

public class Lot {
	private int id;
	private int size;
	private int locationid;
	private int current_size;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public int getCurrent_size() {
		return current_size;
	}

	public void setCurrent_size(int current_size) {
		this.current_size = current_size;
	}

	public Lot(int id, int size, int locationid, int current_size) {
		super();
		this.id = id;
		this.size = size;
		this.locationid = locationid;
		this.current_size = current_size;
	}

	@Override
	public String toString() {
		return "Lot [id=" + id + ", size=" + size + ", locationid=" + locationid + ", current_size=" + current_size
				+ "]";
	}

}
