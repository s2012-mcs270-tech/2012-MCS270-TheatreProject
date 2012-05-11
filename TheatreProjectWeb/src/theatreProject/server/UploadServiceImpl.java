package theatreProject.server;

import java.io.IOException;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import theatreProject.shared.InventoryObject;
import theatreProject.shared.Persistence;
import theatreProject.shared.PersistenceAsync;

@SuppressWarnings("serial")
public class UploadServiceImpl extends HttpServlet {
	public final static PersistenceAsync persistence = GWT.create(Persistence.class);
	public static InventoryObject thisObject;

	/* This is adapted from code in the BlobStore Tutorial written by the blogger "fishbone":
	 *  http://www.fishbonecloud.com/2010/12/tutorial-gwt-application-for-storing.html */

	//The FormPanel must submit to a servlet that extends HttpServlet  
	//RemoteServiceServlet cannot be used
	@SuppressWarnings("serial")
	//Start Blobstore and persistence manager
	BlobstoreService blobstoreService = BlobstoreServiceFactory
	.getBlobstoreService();
	PersistenceManager pm = PMF.get().getPersistenceManager();

	//Override the doPost method to store the Blob's meta-data
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		@SuppressWarnings("deprecation")
		Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
		BlobKey blobKey = blobs.get("upload");

		//Get the paramters from the request to populate the Message object
	
			persistence.getInventoryObject(req.getParameter("ID"));, new AsyncCallback<InventoryObject>() {
				@Override
				public void onFailure(Throwable caught) {
					thisObject = null;
				}
				@Override
				public void onSuccess(InventoryObject object) {
					thisObject = object;
				}
			});
		}

	}
