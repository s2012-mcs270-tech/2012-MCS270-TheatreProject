package theatreProject.domain.shared;
import java.io.Serializable;
import java.sql.Date;

import theatreProject.shared.InventoryObject;


public class Status implements Serializable {
	
	private String renter;
	private String location;
	private String rentDate;
	private String returnDate;
	private String showDay;
	
	public Status(){
		this.location = "warehouse";
	}
	
	public String getShowDay(){
		return showDay;
	}
	
	public void setShowDay(String showDay){
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
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Status))
			return false;
		Status other = (Status) o;
		if(this.renter == null && other.renter != null)
			return false;
		if(this.renter != null && !this.renter.equals(other.renter))
			return false;
		if(this.location == null && other.location != null)
			return false;
		if(this.location != null && !this.location.equals(other.location))
			return false;
		if(this.rentDate == null && other.rentDate != null)
			return false;
		if(this.rentDate != null && !this.rentDate.equals(other.rentDate))
			return false;
		if(this.returnDate == null && other.returnDate != null)
			return false;
		if(this.returnDate != null && !this.returnDate.equals(other.returnDate))
			return false;
		if(this.showDay == null && other.showDay != null)
			return false;
		if(this.showDay != null && !this.showDay.equals(other.showDay))
			return false;
		return true;
	}

	
}
