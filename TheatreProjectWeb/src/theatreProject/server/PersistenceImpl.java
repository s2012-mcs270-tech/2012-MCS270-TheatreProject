package theatreProject.server;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import theatreProject.domain.shared.User;
import theatreProject.shared.Persistence;

import com.google.apphosting.api.ApiProxy;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersistenceImpl extends RemoteServiceServlet implements Persistence {
	private static final long serialVersionUID = 4858210141739739447L;

	@PersistenceCapable(identityType=IdentityType.APPLICATION)
	private static class SavedUser {
		@SuppressWarnings("unused")
		@PrimaryKey
		@Persistent
		private String email;
		
		@Persistent
		String name;
		
		@Persistent
		String extraInfo;
		
		@Persistent
		boolean isAdmin;

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

		public User getUser() {
			return user;
		}
		
		public String getEmail() {
			return email;
		}
		
		public String getName() {
			return name;
		}
		
		public String extraInfo() {
			return extraInfo;
		}
	}

	public User getUser(String name){
		String email = this.getEmail();
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

	public PersistenceImpl() {
		super();

	}
}

