package theatreProject.shared;
import theatreProject.server.PersistenceImpl.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoaderAsync {

	void getUser(AsyncCallback<User> callback);

}

