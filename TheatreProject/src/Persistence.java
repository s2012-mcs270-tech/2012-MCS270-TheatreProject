import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("persistence")
public interface Persistence extends RemoteService {
	User getUser(String name);
	void saveUser(User user);
}
