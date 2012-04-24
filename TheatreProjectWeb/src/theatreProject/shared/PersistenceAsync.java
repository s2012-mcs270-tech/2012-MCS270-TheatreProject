package theatreProject.shared;
import theatreProject.domain.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersistenceAsync {

	void getUser(String name, AsyncCallback<User> callback);

	void saveUser(User user, AsyncCallback<Void> callback);

}