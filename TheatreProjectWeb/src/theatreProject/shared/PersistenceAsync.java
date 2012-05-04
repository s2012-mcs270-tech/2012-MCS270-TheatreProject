package theatreProject.shared;

import theatreProject.shared.InventoryObject;
import theatreProject.shared.User;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersistenceAsync {

void getUser(String email, AsyncCallback<User> callback);
void saveUser(User user, AsyncCallback<Void> callback);

void getInventoryObject(String ID, AsyncCallback<InventoryObject> callback);
void saveObject(InventoryObject object, AsyncCallback<Void> callback);

}