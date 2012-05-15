package theatreProject.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import theatreProject.shared.Status;
import theatreProject.shared.Persistence;
import theatreProject.shared.InventoryObject;
import theatreProject.shared.User;

import com.google.appengine.api.images.Image;
import com.google.apphosting.api.ApiProxy;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersistenceImpl extends RemoteServiceServlet implements Persistence {
	private static final long serialVersionUID = 4858210141739739447L;

	private static final PersistenceManager pm = PMF.get().getPersistenceManager();
	
	public boolean isSystemAdmin() {
		return ApiProxy.getCurrentEnvironment().isAdmin();
	}

	public User getUser(String email){
		PersistenceManager persistenceManager = pm;
		try{
			return persistenceManager.getObjectById(User.class, email);
		} catch(JDOObjectNotFoundException e){
			return null;
		}
	}

	@Override
	public void saveUser(User user){
		pm.makePersistent(user);
	}

	public String getEmail(){
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

	

	@Override
	public InventoryObject getInventoryObject(String ID) {			//Returns the InventoryObject from persistence 
		try{														//assosicated with a specific InventoryObject's ID
			return pm.getObjectById(InventoryObject.class, ID);
		} catch(JDOObjectNotFoundException e){
			return null;
		}
	}

	public PersistenceImpl() {
		super();

	}

	@Override
	public void saveObject(InventoryObject object) {		//Takes an InventoryObject and makes persistence
		pm.makePersistent(object);
	}
	
	public void deleteObject(InventoryObject object) {		//Removes an InventoryObject from persistence
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			InventoryObject persistentObject = 
				pm.getObjectById(InventoryObject.class, object.getID());
			pm.deletePersistent(persistentObject);
			tx.commit();
		} catch(Exception e) {
			if(tx.isActive()){
				tx.rollback();
				e.printStackTrace();
			}
		}
	}
	
	public void deleteUser(User user){						//Removes an User from persistence
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			User persistentUser = 
				pm.getObjectById(User.class, user.getEmail());
			pm.deletePersistent(persistentUser);
			tx.commit();
		} catch(Exception e) {
			if(tx.isActive()){
				tx.rollback();
				e.printStackTrace();
			}
		}	}
	
	public List<InventoryObject> returnAll() {				//Returns a List consisting of all InventoryObjects 
		Query query = pm.newQuery(InventoryObject.class);	//in persistence
		return (List<InventoryObject>) query.execute();
	}

	public ArrayList<User> returnAllUser(){					//Returns a List consisting of all Users
		Query query = pm.newQuery(User.class);				//in persistence
		return (ArrayList<User>) query.execute();
	}
	
	public String getUserInfoByName(String name){			//Returns the ExtraInfo of an User associated with 
		User theUser = null;								//a specific User name
		ArrayList<User> allUsers = this.returnAllUser();
		for (User user: allUsers){
			if (user.getName() == name){
				theUser = user;
				return theUser.getExtraInfo();
			}
		}
		return null;
	}
	
	public ArrayList<InventoryObject> search(String parameter) {	
																																					
		ArrayList<InventoryObject> found = new ArrayList<InventoryObject>();	//Search function - Returns an ArrayList of 
		String[] words = parameter.split(" ");									//found InventoryObjects.
		List<InventoryObject> database = returnAll();							//InventoryObject considered "found"
		for (InventoryObject obj : database) {									//if all of the words in parameter can be found in the
			if (obj.description.indexOf(words[0])!=-1) {						//the description of the object	
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

	public ArrayList<InventoryObject> checkOutList() {								//Returns an ArryaList of all InventoryObjects
		ArrayList<InventoryObject> outObjects = new ArrayList<InventoryObject>();	//currently checked out
		List<InventoryObject> database = returnAll();								//If location variable in the InventoryObject's
		for (InventoryObject obj : database) {										//is not "warehouse" then object is checked out
			String place = obj.getStatus().getLocation();
			if (!place.equals("warehouse")) outObjects.add(obj);
		}

		return outObjects;
	}

}
