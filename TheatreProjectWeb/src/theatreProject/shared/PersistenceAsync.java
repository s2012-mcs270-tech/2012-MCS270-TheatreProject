package theatreProject.shared;
import java.util.ArrayList;

import theatreProject.domain.shared.Inventory;
import theatreProject.server.PersistenceImpl.InventoryObject;
import theatreProject.server.PersistenceImpl.User;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersistenceAsync {

void getUser(String email, AsyncCallback<User> callback);

void getInventoryObject(String ID, AsyncCallback<InventoryObject> callback);

}