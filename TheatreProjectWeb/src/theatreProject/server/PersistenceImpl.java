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

import theatreProject.shared.Status;
import theatreProject.shared.Persistence;
import theatreProject.shared.InventoryObject;
import theatreProject.shared.User;

import com.google.appengine.api.images.Image;
import com.google.apphosting.api.ApiProxy;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersistenceImpl extends RemoteServiceServlet implements Persistence {
	private static final long serialVersionUID = 4858210141739739447L;

	private static final PersistenceManagerFactory pmf = PMF.get();

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
	
	public List<InventoryObject> returnAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(InventoryObject.class);
		return (List<InventoryObject>) query.execute();
	}

	public ArrayList<User> returnAllUser(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(User.class);
		return (ArrayList<User>) query.execute();
	}
	
	public String getUserInfoByName(String name){
		User theUser = null;
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

		ArrayList<InventoryObject> found = new ArrayList<InventoryObject>(); 
		String[] words = parameter.split(" ");
		List<InventoryObject> database = returnAll();
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
		List<InventoryObject> database = returnAll();
		for (InventoryObject obj : database) {
			String place = obj.getStatus().getLocation();
			if (!place.equals("warehouse")) outObjects.add(obj);
		}

		return outObjects;
	}

}