package theatreProject.domain.shared;
import com.google.appengine.api.images.*;

public class InventoryObject {	
	private String ID;
	private String storageArea;
	private Image picture;
	private Status status;
	String description;
	String disclaimers;
	
	public InventoryObject(String name, String storageArea, Image picture, Status status, String description, String disclaimers) {
		this.ID = name;
		this.storageArea = storageArea;
		this.picture = picture;
		this.status = status;
		this.description = description;
		this.disclaimers = disclaimers;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getstorageArea() {
		return storageArea;
	}
	public void setstorageArea(String storageArea) {
		this.storageArea = storageArea;
	}
	public Image getPicture() {
		return picture;
	}
	public void setPicture(Image picture) {
		this.picture = picture;
	}
	public Status getStatus(){
		return status;
	}
	public void setStatus(Status status){
		this.status = status;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDisclaimers() {
		return disclaimers;
	}
	
	public void setDisclaimers(String disclaimers) {
		this.disclaimers = disclaimers;
	}
}
