package theatreProject.shared;

import java.util.ArrayList;
import java.util.List;

import theatreProject.shared.InventoryObject;
import theatreProject.shared.User;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersistenceAsync {
	
void getEmail(AsyncCallback<String> callback);
void isSystemAdmin(AsyncCallback<Boolean> callback);

void getUser(String email, AsyncCallback<User> callback);
void saveUser(User user, AsyncCallback<Void> callback);
void deleteUser(User user, AsyncCallback<Void> callback);


void getInventoryObject(String ID, AsyncCallback<InventoryObject> callback);
void saveObject(InventoryObject object, AsyncCallback<Void> callback);
void deleteObject(InventoryObject object, AsyncCallback<Void> callback);

void search(String parameter, AsyncCallback<ArrayList<InventoryObject>> callback);
void checkOutList(AsyncCallback<ArrayList<InventoryObject>> callback);
void returnAll(AsyncCallback<List<InventoryObject>> callback);
void returnAllUser(AsyncCallback<ArrayList<User>> asyncCallback);
void getUserInfoByName(String name, AsyncCallback<String> asyncCallback);
}