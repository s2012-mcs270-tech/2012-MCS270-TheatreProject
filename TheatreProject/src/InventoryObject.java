import java.awt.Image;

import javax.net.ssl.SSLEngineResult.Status;

public class InventoryObject {	
	private String ID;
	private String storageArea;
	private Image picture;
	private Status status;
	String description;
	String classification;
	
	public InventoryObject(String name, String storageArea, Image picture, Status status, String description,String classification) {
		this.ID = name;
		this.storageArea = storageArea;
		this.picture = picture;
		this.status = status;
		this.description = description;
		this.classification = classification;
	}
	public String getClassification(){
		return classification;
	}
	public void setClassification(String classification){
		this.classification = classification;
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
}
