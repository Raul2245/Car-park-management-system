package Other;

import java.sql.Date;

public class HelperClass {
	private String string1;
	private String string2;
	private String string3;
	private String string4;
	private int int1;
	private int int2;
	private int int3;
	private Date date1;
	private Date date2;
	private Date date3;
	private double double1;

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public int getInt3() {
		return int3;
	}

	public void setInt3(int int3) {
		this.int3 = int3;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public String getString4() {
		return string4;
	}

	public void setString4(String string4) {
		this.string4 = string4;
	}
	
	public double getDouble1() {
		return double1;
	}

	public void setDouble1(double double1) {
		this.double1 = double1;
	}
	
	public HelperClass(String string1, String string2, String string3, int int1, int int2, int int3, Date date1,
			Date date2, Date date3) {
		super();
		this.string1 = string1;
		this.string2 = string2;
		this.string3 = string3;
		this.int1 = int1;
		this.int2 = int2;
		this.int3 = int3;
		this.date1 = date1;
		this.date2 = date2;
		this.date3 = date3;
	}

	public HelperClass(String string1, String string2, String string3, int int1, int int2, int int3) {
		super();
		this.string1 = string1;
		this.string2 = string2;
		this.string3 = string3;
		this.int1 = int1;
		this.int2 = int2;
		this.int3 = int3;
	}

	public HelperClass(String string1, String string2, int int1) {
		// TODO Auto-generated constructor stub
		this.string1 = string1;
		this.string2 = string2;
		this.int1 = int1;
	}

	public HelperClass(String string1, String string2, int int1, Date date1) {
		this.string1 = string1;
		this.string2 = string2;

		this.int1 = int1;

		this.date1 = date1;

	}

	public HelperClass(String string1, String string2, int int1, int int2) {
		this.string1 = string1;
		this.string2 = string2;

		this.int1 = int1;
		this.int2 = int2;

	}

	public HelperClass(String string1, int int1) {
		this.string1 = string1;
		this.int1 = int1;

	}

	public HelperClass(String string1, String string2, String string3, String string4, double double1) {
		this.string1 = string1;
		this.string2 = string2;
		this.string3 = string3;
		this.string4 = string4;
		this.double1 = double1;
	}

	public HelperClass(Date date1, double double1) {
		this.date1 = date1;
		this.double1 = double1;
	}
	
	public HelperClass(String string1, String string2, String string3, String string4, int int1, int int2) {
		super();
		this.string1 = string1;
		this.string2 = string2;
		this.string3 = string3;
		this.string4 = string4;
		this.int1 = int1;
		this.int2 = int2;
	}

	public HelperClass(String string1, String string2) {
		this.string1 = string1;
		this.string2 = string2;
	}

	public HelperClass(String string1, String string2, double double1) {
		this.string1 = string1;
		this.string2 = string2;
		this.double1 = double1;
	}

	public HelperClass(String string1, int int1, int int2, Date date1) {
		this.string1 = string1;
		this.int1 = int1;
		this.int2 = int2;
		this.date1 = date1;

	}

}
