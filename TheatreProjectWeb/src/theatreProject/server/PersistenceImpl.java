package theatreProject.server;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import theatreProject.domain.shared.InventoryObject;
import theatreProject.domain.shared.Status;
import theatreProject.domain.shared.User;
import theatreProject.shared.Persistence;

import com.google.appengine.api.images.Image;
import com.google.apphosting.api.ApiProxy;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersistenceImpl extends RemoteServiceServlet implements Persistence {
	private static final long serialVersionUID = 4858210141739739447L;

	@PersistenceCapable(identityType=IdentityType.APPLICATION)
	private static class SavedUser {
		@PrimaryKey
		@Persistent
		private String email;

		@Persistent
		private String name;

		@Persistent
		private String extraInfo;

		@Persistent
		private boolean isAdmin;

		@Persistent(serialized = "true")
		private User user;


		public SavedUser(String email, String name, String extraInfo, boolean isAdmin, User user) {
			super();
			this.email = email;
			this.user = user;
			this.name = name;
			this.extraInfo = extraInfo;
			this.isAdmin = isAdmin;

		}


		public String getEmail() {
			return email;
		}

		public String getName() {
			return name;
		}

		public String getExtraInfo() {
			return extraInfo;
		}

		public boolean getIsAdmin() {
			return isAdmin;
		}

		public User getUser() {
			return user;
		}
	}

	public User getUser(String email){
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try{
			return persistenceManager.getObjectById(SavedUser.class, email).getUser();
		} catch(JDOObjectNotFoundException e){
			return null;
		}
	}

	public void saveUser(User user){
		String email = getEmail(); 
		String name = user.getName();
		String extraInfo = user.getExtraInfo();
		boolean isAdmin = user.isAdmin();
		SavedUser su = new SavedUser(email, name, extraInfo, isAdmin, user);
		PMF.get().getPersistenceManager().makePersistent(su);
	}

	private String getEmail(){
		// The test below just makes sure we didn't miss the lines in web.xml that
		// ensure the user has to be logged in.  If this exception is thrown, web.xml
		// needs fixing.
		if(!ApiProxy.getCurrentEnvironment().isLoggedIn()){
			throw new IllegalStateException("not logged in");
		}
		// In the same way, ApiProxy.getCurrentEnvironment().isAdmin() could be used to
		// determine whether the currently logged in user is known to AppEngine as an
		// administrator of this application.  I can't think of any reason to demonstrate
		// thatin the Land of Gack.
		return ApiProxy.getCurrentEnvironment().getEmail();
	}

	//The persistence for the object goes here.  We are unsure at the moment if
	//we cram it into one file or not, but it's here for now, along with references
	//in persistence and the async.

	@PersistenceCapable(identityType=IdentityType.APPLICATION)
	private static class SavedObject {
		@PrimaryKey
		@Persistent
		private String ID;
		
		@Persistent
		private String storageArea;
		
		@Persistent
		private Image image;
		
		@Persistent
		private Status status;
		
		@Persistent
		private String disclaimers;
		
		@Persistent
		private String description;
		
		@Persistent (serialized = "true")
		private InventoryObject object;
		
		public SavedObject(String ID, String storageArea, Image image, Status status, String disclaimers, String description, InventoryObject object) {
			super();
			this.ID = ID;
			this.storageArea = storageArea;
			this.image = image;
			this.status = status;
			this.disclaimers = disclaimers;
			this.description = description;
			this.object = object;
		}
		
		public String getID() {
			return this.ID;
		}
		
		public String getStorageArea() {
			return this.storageArea;
		}
		
		public Image getImage() {
			return this.image;
		}
		
		public Status getStatus() {
			return this.status;
		}
		
		public String getDisclaimers() {
			return this.disclaimers;
		}
		
		public String getDescription() {
			return this.description;
		}
		
		public InventoryObject getObject() {
			return this.object;
		}
	}


	@Override
	public InventoryObject getInventoryObject(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveObject(InventoryObject object) {
		// TODO Auto-generated method stub

	}


	public PersistenceImpl() {
		super();

	}
}

