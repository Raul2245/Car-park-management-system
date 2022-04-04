package Tables;
import java.sql.Date;

public class Lot_event {
	private int id;
	private int lotid;
	private int eventid;
	private int emp_id;
	private Date ev_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLotid() {
		return lotid;
	}

	public void setLotid(int lotid) {
		this.lotid = lotid;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public Date getEv_date() {
		return ev_date;
	}

	public void setEv_date(Date ev_date) {
		this.ev_date = ev_date;
	}

	public Lot_event(int id, int lotid, int eventid, int emp_id, Date ev_date) {
		super();
		this.id = id;
		this.lotid = lotid;
		this.eventid = eventid;
		this.emp_id = emp_id;
		this.ev_date = ev_date;
	}

	public Lot_event(int lotid, int eventid, int emp_id, Date ev_date) {
		super();
		this.lotid = lotid;
		this.eventid = eventid;
		this.emp_id = emp_id;
		this.ev_date = ev_date;
	}
	
	@Override
	public String toString() {
		return "Lot_event [id=" + id + ", lotid=" + lotid + ", eventid=" + eventid + ", emp_id=" + emp_id + ", ev_date="
				+ ev_date + "]";
	}

}
