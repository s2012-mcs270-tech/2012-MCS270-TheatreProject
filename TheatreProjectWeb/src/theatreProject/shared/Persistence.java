package theatreProject.shared;

import theatreProject.server.PersistenceImpl.InventoryObject;
import theatreProject.server.PersistenceImpl.User;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("persistence")
public interface Persistence extends RemoteService {
	User getUser(String email);
	void saveUser(User user);
	InventoryObject getInventoryObject(String ID);
	void saveObject(InventoryObject object);
}