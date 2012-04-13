import java.sql.Date;
public class status {
	
	private String renter;
	private String location;
	private Date rentDate;
	private Date returnDate;
	private Boolean inStore;
	
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
	public Boolean getInStore() {
		return inStore;
	}
	public void setInStore(Boolean inStore) {
		this.inStore = inStore;
	}
	
}