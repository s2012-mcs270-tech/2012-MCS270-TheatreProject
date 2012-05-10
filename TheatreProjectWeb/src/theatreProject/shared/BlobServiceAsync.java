package theatreProject.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BlobServiceAsync {

	void getBlobStoreUploadUrl(AsyncCallback<String> callback);

}