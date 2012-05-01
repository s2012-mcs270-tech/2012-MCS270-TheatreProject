package theatreProject.shared;
import java.util.ArrayList;

import theatreProject.domain.shared.Inventory;
import theatreProject.server.PersistenceImpl.InventoryObject;
import theatreProject.server.PersistenceImpl.User;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("persistence")
public interface Persistence extends RemoteService {
	User getUser(String email);
	InventoryObject getInventoryObject(String ID);
}