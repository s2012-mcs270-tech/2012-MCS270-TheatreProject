package theatreProject.server;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import theatreProject.domain.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersistenceImpl extends RemoteServiceServlet implements Persistence {
	private static final long serialVersionUID = 7649793065322010032L;

	@PersistenceCapable(identityType=IdentityType.APPLICATION)
	private static class SavedUser {
		@SuppressWarnings("unused")
		@PrimaryKey
		private String email;

		@Persistent(serialized = "true")
		private User user;

		public SavedUser(String email, User user) {
			super();
			this.email = email;
			this.user = user;
		}

		public User getUser() {
			return user;
		}
	}

	public User getUser(String name){
		String email = this.getEmail();
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try{
			return persistenceManager.getObjectById(SavedPlayer.class, emailAndName).getPlayer();
		} catch(JDOObjectNotFoundException e){
			return null;
		}
	}

	public void savePlayer(Person player){
		String emailAndName = getEmailAndName(player.getName()); 
	    SavedPlayer sp = new SavedPlayer(emailAndName, player);
	    PMF.get().getPersistenceManager().makePersistent(sp);
	}
	
	private String getEmailAndName(String name){
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
		return ApiProxy.getCurrentEnvironment().getEmail() + ":" + name;
	}

	public PersistenceImpl() {
		super();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUser(theatreProject.server.User user) {
		// TODO Auto-generated method stub
		
	}
}

