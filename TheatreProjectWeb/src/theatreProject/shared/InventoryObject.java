package theatreProject.shared;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import theatreProject.shared.Status;

/*
 *Responsible for storing all the information about an object in our inventory.
 *
 *Inventory Object Info:
 *
 *Inventory ID number
 *Object name
 *Where it is stored
 *The Url of where the object image is stored
 *Disclaimers
 *Description of the item
 *Also holds the status of the object (Status is stored in another class)
 *
 */

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class InventoryObject implements Serializable{

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String ID;

	@Persistent
	private String name;

	@Persistent
	private String storageArea;

	@Persistent
	private String imageURL;

	@Persistent(serialized="true")
	private Status status;

	@Persistent
	private String disclaimers;

	@Persistent
	public String description;

	public InventoryObject() {
		super();
		this.status = new Status();
		
		//TEMPORARY\\
		description = "red chair flower";
		disclaimers = "The chair is very beautiful, but we can paint it a differnt color.";
		name = "name of object";
		storageArea = "warehouse";
		imageURL = "www.joerox.com";
		//END TEMP\\
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof InventoryObject))
			return false;
		InventoryObject other = (InventoryObject) o;
		if(this.name == null && other.name != null)
			return false;
		if(this.name != null && !this.name.equals(other.name))
			return false;
		if(!(this.ID == other.ID))
			return false;
		if(this.storageArea == null && other.storageArea != null)
			return false;
		if(this.storageArea != null && !this.storageArea.equals(other.storageArea))
			return false;
		if(this.imageURL == null && other.imageURL != null)
			return false;
		if(this.imageURL != null && !this.imageURL.equals(other.imageURL))
			return false;
		if(this.status == null && other.imageURL != null)
			return false;
		if(this.status != null && !this.status.equals(other.status))
			return false;
		if(this.description == null && other.description != null)
			return false;
		if(this.description != null && !this.description.equals(other.description))
			return false;
		if(this.disclaimers == null && other.disclaimers != null)
			return false;
		if(this.disclaimers != null && !this.disclaimers.equals(other.disclaimers))
			return false;
		return true;
	}

	public String getID() {
		return ID;
	}

	public void setID(String newID) {
		ID = newID;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getStorageArea() {
		return storageArea;
	}

	public void setStorageArea(String newStorageArea) {
		storageArea = newStorageArea;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImage(String newImageURL) {
		this.imageURL = newImageURL;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status newStatus) {
		status = newStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDesc) {
		description = newDesc;
	}

	public String getDisclaimers() {
		return disclaimers;
	}

	public void setDisclaimers(String newDisc) {
		disclaimers = newDisc;
	}

}
