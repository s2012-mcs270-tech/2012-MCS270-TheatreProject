import java.awt.Image;

import javax.net.ssl.SSLEngineResult.Status;

public class InventoryObject {	
	private String ID;
	private String storageArea;
	private Image picture;
	private Status status;
	
	public InventoryObject(String name, String storageArea, Image picture, Status status) {
		this.ID = name;
		this.storageArea = storageArea;
		this.picture = picture;
		this.status = status;
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
}
