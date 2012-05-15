package theatreProject.client;

import theatreProject.shared.BlobService;
import theatreProject.shared.BlobServiceAsync;
import theatreProject.shared.PersistenceAsync;
import theatreProject.shared.InventoryObject;
import theatreProject.shared.Persistence;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.apphosting.api.ApiProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
/*
 * Admin inventory page is responsible for managing all of the important details and information for an object.
 * Only users that are registered and approved Admins get access to this page. If you are an admin and you search
 * for an item you automatically go to an admin object page.
 * Admins are responsible for editing, updating, and creating objects in the system.
 * Read only users can only view objects images, name, description, and disclaimer, and have
 * no editing capabilities. 
 * 
 * 
 * Admin Object Info:
 * Object Name
 * Check out Status
 * Image of the object
 * Object Location
 * Object Location within the warehouse
 * Show Date
 * Name of Renter
 * Description of item
 * Disclaimers of item
 * A hidden field stores the Item ID (The user does not need to see this, it is used to retrieve Item info and for blob image storage)
 */

public class AdminInventory {
	private static final int RETRY_MS = 1000;
	public final static PersistenceAsync persistence = GWT.create(Persistence.class);
	public static InventoryObject thisObject;
	private final static BlobServiceAsync blobService = GWT
			.create(BlobService.class);
	public static String newUrl;


	/**
	 * @wbp.parser.entryPoint
	 */
	public static void adminOnlyInventory(final String ID){
		final TextArea txtDescription = new TextArea();
		final TextArea txtDisclaimers = new TextArea();
		final TextBox txtShowDate = new TextBox();
		final TextBox txtLocation = new TextBox();
		final TextBox lblStatus = new TextBox();
		final TextBox txtbxEmailAddress = new TextBox();
		final TextBox nameOfObject = new TextBox();
		final Hidden hiddenID = new Hidden();
		final TextBox txtStroageArea = new TextBox();
		final Image image = new Image();

		Timer loadFields = new Timer(){

			//Retrieves object info from persistent database. Keeps attempting to call info. Leaves page blank until info is retrieved.
			@Override
			public void run() {
				persistence.getInventoryObject(ID, new AsyncCallback<InventoryObject>() {
					@Override
					public void onFailure(Throwable caught) {
						//Set object to null if object is not found. This leaves the page mostly blank until info is retrieved
						thisObject = null;
					}
					@Override
					public void onSuccess(InventoryObject object) {
						thisObject = object;
						if(thisObject == null){
							schedule(RETRY_MS);
						} else {
							txtDescription.setText(thisObject.getDescription());
							txtDisclaimers.setText(thisObject.getDisclaimers());
							txtShowDate.setText(thisObject.getStatus().getShowDay());
							txtLocation.setText(thisObject.getStatus().getLocation());
							if (thisObject.getStatus().getLocation() == "warehouse") lblStatus.setText("IN");
							else lblStatus.setText("OUT");
							txtbxEmailAddress.setText(thisObject.getStatus().getRenter());
							nameOfObject.setText(thisObject.getName());
							hiddenID.setValue(thisObject.getID());
							txtStroageArea.setText(thisObject.getStorageArea());
							image.setUrl(thisObject.getImageURL());
						}
					}
				});
			}

		};

		loadFields.run();

		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");

		final VerticalPanel manguageUserPanel = new VerticalPanel();
		rootPanel.add(manguageUserPanel, 10 ,10 );
		manguageUserPanel.setSize("498px", "627px");

		final Label title = new Label("Admin Inventory Page");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");
		
		//needed a form panel for the upload button or something
		final FormPanel uploadForm = new FormPanel();
		manguageUserPanel.add(uploadForm);
		
		//from MessageBoard
		uploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		uploadForm.setMethod(FormPanel.METHOD_POST);

		final AbsolutePanel absolutePanel = new AbsolutePanel();
		uploadForm.add(absolutePanel);
		absolutePanel.setSize("472px", "582px");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_4, 10, 291);
		horizontalPanel_4.setSize("434px", "98px");

		//Description Box
		Label lblNewLabel = new Label("Description: ");
		horizontalPanel_4.add(lblNewLabel);

		horizontalPanel_4.add(txtDescription);
		txtDescription.setSize("342px", "96px");

		HorizontalPanel horizontalPanel_5 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_5, 10, 418);
		horizontalPanel_5.setSize("433px", "110px");

		Label lblDisclaimers = new Label("Disclaimers: ");
		horizontalPanel_5.add(lblDisclaimers);

		horizontalPanel_5.add(txtDisclaimers);
		txtDisclaimers.setSize("339px", "96px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 232, 119);
		horizontalPanel_1.setSize("211px", "34px");

		Label lblLocation = new Label("Location: ");
		horizontalPanel_1.add(lblLocation);

		horizontalPanel_1.add(txtLocation);
		txtLocation.setWidth("136px");

		HorizontalPanel horizontalPanel_7 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_7, 232, 179);
		horizontalPanel_7.setSize("211px", "34px");

		Label lblShowEndDate = new Label("Show End Date: ");
		horizontalPanel_7.add(lblShowEndDate);

		horizontalPanel_7.add(txtShowDate);
		txtShowDate.setWidth("130px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_2, 233, 47);
		horizontalPanel_2.setSize("211px", "49px");

		Label lblCheckInoutStatus = new Label("Check in/out Status: ");
		horizontalPanel_2.add(lblCheckInoutStatus);
		lblCheckInoutStatus.setWidth("92px");

		horizontalPanel_2.add(lblStatus);
		lblStatus.setSize("97px", "22px");

		HorizontalPanel horizontalPanel_6 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_6, 232, 237);
		horizontalPanel_6.setSize("212px", "36px");

		Label lblEmailOfRenter = new Label("Location in Warehouse: ");
		horizontalPanel_6.add(lblEmailOfRenter);
		lblEmailOfRenter.setWidth("90px");

		horizontalPanel_6.add(txtStroageArea);
		txtStroageArea.setWidth("103px");
		txtbxEmailAddress.setWidth("111px");

		HorizontalPanel horizontalPanel_8 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_8, 10, 219);
		horizontalPanel_8.setSize("196px", "34px");


		final Label lblNameOfRenter = new Label("Name of Renter: ");
		horizontalPanel_8.add(lblNameOfRenter);
		lblNameOfRenter.setWidth("55px");

		horizontalPanel_8.add(txtbxEmailAddress);
		txtbxEmailAddress.setWidth("133px");

		nameOfObject.setStyleName("gwt-Label");
		absolutePanel.add(nameOfObject, 10, 10);
		nameOfObject.setSize("419px", "18px");

		//TODO : All this image stuff.  Right now, just tried to mirror max's
		//absolutePanel.add(image, 10, 47);
		//image.setSize("198px", "127px");

		final FileUpload upload = new FileUpload();
		absolutePanel.add(upload, 61, 179);
		upload.setSize("165px", "18px");
		upload.setName("upload");
		
		Button btnUpload = new Button("Upload");
		absolutePanel.add(btnUpload, -1, 179);
		btnUpload.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				blobService.getBlobStoreUploadUrl(new AsyncCallback<String>(){
					@Override
					public void onFailure(Throwable caught) {
						image.setAltText("The image can't be loaded");
					}
					@Override
					public void onSuccess(String url) {
						uploadForm.setAction(url.toString());
						uploadForm.submit();
						newUrl = url;
					}
				});
			}
		});
		
		uploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				image.setUrl(newUrl);
				thisObject.setImage(newUrl);
				Anchor link = new Anchor("uploaded file", newUrl);
				link.setTarget("_blank");
				
				absolutePanel.add(link, 10, 47);
			}
		});


		//Main Menu Button
		Button btnMainMenu_1 = new Button("Main Menu");
		btnMainMenu_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				TheatreProjectWeb.mainPage();
			}
		});
		absolutePanel.add(btnMainMenu_1, 364, 545);


		//save buttons
		Button btnSaveButton = new Button("New button");
		btnSaveButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//start by setting thisObject parameters to current txtbxs
				thisObject.setName(nameOfObject.getText());
				thisObject.setDescription(txtDescription.getText());
				thisObject.setDisclaimers(txtDisclaimers.getText());
				thisObject.setStorageArea(txtStroageArea.getText());
				thisObject.getStatus().setLocation(txtLocation.getText());
				thisObject.getStatus().setRenter(lblNameOfRenter.getText());
				thisObject.getStatus().setShowDay(txtShowDate.getText());

				//then save out the changes
				persistence.saveObject(thisObject, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
					}
					@Override
					public void onSuccess(Void result) {
						//when saved, it returns to the main page
						rootPanel.clear();
						TheatreProjectWeb.mainPage();
					}
				});
			}
		});

		btnSaveButton.setText("Save");
		absolutePanel.add(btnSaveButton, 10, 545);

		//Delete button
		Button btnDeleteItem = new Button("Delete Item");
		btnDeleteItem.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				persistence.deleteObject(thisObject, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {

					}
					@Override
					public void onSuccess(Void result) {
						//when deleted, it returns to the main page
						rootPanel.clear();
						TheatreProjectWeb.mainPage();
					}

				});
			}
		});
		absolutePanel.add(btnDeleteItem, 73, 545);
		
		//TODO
		//Still need to implement the image box and the uplaod button into this class
		
	}
}
