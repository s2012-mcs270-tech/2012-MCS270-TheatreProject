package theatreProject.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import theatreProject.domain.shared.User;

@RemoteServiceRelativePath("loader")
public interface Loader extends RemoteService {
	User getUser();
}
