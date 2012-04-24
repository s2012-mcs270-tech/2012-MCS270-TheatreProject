package theatreProject.shared;
import theatreProject.domain.shared.User;
import theatreProject.domain.shared.InventoryObject;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersistenceAsync {

	void getUser(String email, AsyncCallback<User> callback);

	void saveUser(User user, AsyncCallback<Void> callback);
	
	void getInventoryObject(String ID, AsyncCallback<InventoryObject> callback);
	
	void saveObject(InventoryObject object, AsyncCallback<Void> callback);

}