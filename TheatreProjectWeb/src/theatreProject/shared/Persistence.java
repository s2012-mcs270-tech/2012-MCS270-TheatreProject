package theatreProject.shared;

import java.util.ArrayList;
import java.util.List;

import theatreProject.shared.InventoryObject;
import theatreProject.shared.User;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("persistence")
public interface Persistence extends RemoteService {
	String getEmail();
	boolean isSystemAdmin();
	
	User getUser(String email);
	void saveUser(User user);
	void deleteUser(User user);
	
	InventoryObject getInventoryObject(String ID);
	void saveObject(InventoryObject object);
	void deleteObject(InventoryObject object);
	
	ArrayList<InventoryObject> search(String parameter);
	ArrayList<InventoryObject> checkOutList();
	List<InventoryObject> returnAll();
	ArrayList<User> returnAllUser();
	String getUserInfoByName(String name);
}