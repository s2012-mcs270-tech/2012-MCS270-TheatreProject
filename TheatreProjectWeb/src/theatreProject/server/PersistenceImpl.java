package theatreProject.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import theatreProject.domain.shared.Status;
import theatreProject.shared.Persistence;

import com.google.appengine.api.images.Image;
import com.google.apphosting.api.ApiProxy;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersistenceImpl extends RemoteServiceServlet implements Persistence {
	private static final long serialVersionUID = 4858210141739739447L;

	private static final PersistenceManagerFactory pmf = PMF.get();

	@PersistenceCapable(identityType=IdentityType.APPLICATION)
	public static class User {
		@PrimaryKey
		@Persistent
		private String email;

		@Persistent
		private String name;

		@Persistent
		private String extraInfo;

		@Persistent
		private boolean isAdmin;


		public User(String email, String name, String extraInfo) {
			super();
			this.email = email;
			this.name = name;
			this.extraInfo = extraInfo;
			this.isAdmin = false;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isAdmin() {
			return isAdmin;
		}

		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}

		public String getExtraInfo() {
			return extraInfo;
		}

		public void setExtraInfo(String extraInfo) {
			this.extraInfo = extraInfo;
		}

		@Override
		public boolean equals(Object o){
			if(!(o instanceof User))
				return false;
			User other = (User) o;
			if(this.name == null && other.name != null)
				return false;
			if(this.name != null && !this.name.equals(other.name))
				return false;
			if(this.email == null && other.email != null)
				return false;
			if(this.email != null && !this.email.equals(other.email))
				return false;
			if(this.isAdmin != other.isAdmin)
				return false;
			if(this.extraInfo == null && other.extraInfo != null)
				return false;
			if(this.extraInfo != null && !this.extraInfo.equals(other.extraInfo))
				return false;
			return true;
		}

		@Override
		public int hashCode(){
			return email==null ? 0 : email.hashCode();
		}
	}

	public User getUser(String email){
		PersistenceManager persistenceManager = pmf.getPersistenceManager();
		try{
			return persistenceManager.getObjectById(User.class, email);
		} catch(JDOObjectNotFoundException e){
			return null;
		}
	}

	@Override
	public void saveUser(User user){
		pmf.getPersistenceManager().makePersistent(user);
	}

	private String getEmail(){
		// The test below just makes sure we didn't miss the lines in web.xml that
		// ensure the user has to be logged in. If this exception is thrown, web.xml
		// needs fixing.
		if(!ApiProxy.getCurrentEnvironment().isLoggedIn()){
			throw new IllegalStateException("not logged in");
		}
		// In the same way, ApiProxy.getCurrentEnvironment().isAdmin() could be used to
		// determine whether the currently logged in user is known to AppEngine as an
		// administrator of this application. I can't think of any reason to demonstrate
		// thatin the Land of Gack.
		return ApiProxy.getCurrentEnvironment().getEmail();
	}

	@PersistenceCapable(identityType=IdentityType.APPLICATION)
	public static class InventoryObject {
		@PrimaryKey
		@Persistent
		private String ID;

		@Persistent
		private String name;

		@Persistent
		private String storageArea;

		@Persistent
		private String image;

		@Persistent(serialized="true")
		private Status status;

		@Persistent
		private String disclaimers;

		@Persistent
		public String description;

		public InventoryObject() {
			super();
			//String uniqueID = generateID();
			//this.ID = uniqueID;
			this.status = new Status();
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
			if(this.ID == null && other.ID != null)
				return false;
			if(this.ID != null && !this.ID.equals(other.ID))
				return false;
			if(this.storageArea == null && other.storageArea != null)
				return false;
			if(this.storageArea != null && !this.storageArea.equals(other.storageArea))
				return false;
			if(this.image == null && other.image != null)
				return false;
			if(this.image != null && !this.image.equals(other.image))
				return false;
			if(this.status == null && other.image != null)
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

		@Override
		public int hashCode(){
			return ID==null ? 0 : ID.hashCode();
		}

		public String getID() {
			return this.ID;
		}

		public void setID(String newID) {
			this.ID = newID;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String newName) {
			this.name = newName;
		}

		public String getStorageArea() {
			return this.storageArea;
		}

		public void setStorageArea(String newStorageArea) {
			this.storageArea = newStorageArea;
		}

		public String getImage() {
			return this.image;
		}

		public void setImage(String newImage) {
			this.image = newImage;
		}

		public Status getStatus() {
			return this.status;
		}

		public void setStatus(Status newStatus) {
			this.status = newStatus;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String newDesc) {
			this.description = newDesc;
		}

		public String getDisclaimers() {
			return this.disclaimers;
		}

		public void setDisclaimers(String newDisc) {
			this.disclaimers = newDisc;
		}

	}


	@Override
	public InventoryObject getInventoryObject(String ID) {
		PersistenceManager persistenceManager = pmf.getPersistenceManager();
		try{
			return persistenceManager.getObjectById(InventoryObject.class, ID);
		} catch(JDOObjectNotFoundException e){
			return null;
		}
	}

	public PersistenceImpl() {
		super();

	}

	@Override
	public void saveObject(InventoryObject object) {
		pmf.getPersistenceManager().makePersistent(object);
	}

	public ArrayList<InventoryObject> search(String parameter) {

		ArrayList<InventoryObject> found = new ArrayList<InventoryObject>(); 
		String[] words = parameter.split(" ");

		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(InventoryObject.class);
		@SuppressWarnings("unchecked")
		List<InventoryObject> database = (List<InventoryObject>) query.execute();

		for (InventoryObject obj : database) {
			if (obj.description.indexOf(words[0])!=-1) {
				found.add(obj);
			}
		}
		if (words.length>1) {
			for (int i=1; i<words.length; i++) {	
				for (InventoryObject obj : found) {
					if ((obj.description.indexOf(words[i])==-1)) {
						found.remove(obj);
					}
				}
			}
		}
		return found;
	}

	public ArrayList<InventoryObject> checkOutList() {

		ArrayList<InventoryObject> outObjects = new ArrayList<InventoryObject>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(InventoryObject.class);
		@SuppressWarnings("unchecked")
		List<InventoryObject> database = (List<InventoryObject>) query.execute();

		for (InventoryObject obj : database) {
			String place = obj.status.getLocation();
			if (!place.equals("warehouse")) outObjects.add(obj);
		}

		return outObjects;
	}

}