import java.sql.Date;


public class Status {
	
	private String renter;
	private String location;
	private Date rentDate;
	private Date returnDate;
	
	public Status(String renter, String location, Date rentDate, Date returnDate){
		this.renter = renter;
		this.location = location;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}
	
	public String getRenter() {
		return renter;
	}
	public void setRenter(String renter) {
		this.renter = renter;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getRentDate() {
		return rentDate;
	}
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}
