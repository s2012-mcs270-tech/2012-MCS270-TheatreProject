package theatreProject.domain.shared;
import com.google.appengine.api.images.*;

public class InventoryObject {
	private String name;
	private String ID;
	private String storageArea;
	private Image picture;
	private Status status;
	private String disclaimers;
	String description;

	public InventoryObject(String ID, String name, String storageArea, Image picture, Status status, String description, String disclaimers) {
		this.name = name; 
		this.ID = ID;
		this.storageArea = storageArea;
		this.picture = picture;
		this.status = status;
		this.disclaimers = disclaimers;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
