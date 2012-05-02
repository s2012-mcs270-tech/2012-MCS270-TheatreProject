package theatreProject.domain.shared;
import java.io.Serializable;
import java.sql.Date;


public class Status implements Serializable {
	
	private String renter;
	private String location;
	private Date rentDate;
	private Date returnDate;
	private Date showDay;
	
	public Status(String renter, String location, Date rentDate, Date returnDate, Date showDay){
		this.renter = renter;
		this.location = location;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.showDay = showDay;
	}
	
	public Date getShowDay(){
		return showDay;
	}
	
	public void setShowDay(Date showDay){
		this.showDay = showDay;
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
