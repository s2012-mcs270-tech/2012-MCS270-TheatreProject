package theatreProject.client;

import java.util.ArrayList;
import java.util.List;

import theatreProject.shared.User;
import theatreProject.shared.InventoryObject;
import theatreProject.shared.FieldVerifier;
import theatreProject.shared.Persistence;
import theatreProject.shared.PersistenceAsync;

//import com.google.apphosting.api.ApiProxy;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.DecoratedTabBar;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class TheatreProjectWeb implements EntryPoint {

	//needs to be persistent or something instead
	//private Inventory inventory = new Inventory(new ArrayList<InventoryObject>());

	public final static PersistenceAsync persistence = GWT.create(Persistence.class);
	public static int nextID = 1;
	public static User currentUser;
	
	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {
		//		String loadID = Window.Location.getParameter("id");
		//		//TODO : update for inventory calls
		//		if (loadID != null) ReadOnlyInventory.readOnlyInventory();
		//		else mainPage();
		mainPage();
	}

	public static void mainPage() {
		
		final Button btnSearch = new Button("Search");
		final Button btnViewAll = new Button("View All");
		final Button btnViewCheckedOut = new Button("View Checked Out");
		final Button btnAddItem = new Button("Add Item(s)");
		final Button btnManageUsers = new Button("Manage Users");
		
		btnSearch.setEnabled(false);
		btnViewAll.setEnabled(false);
		btnViewCheckedOut.setEnabled(false);
		btnAddItem.setEnabled(false);
		btnManageUsers.setEnabled(false);
		
		
		persistence.getEmail(new AsyncCallback<String>() {					//Returns the current user
			@Override
			public void onFailure(Throwable caught) {}
			@Override
			public void onSuccess(String result) {
				persistence.getUser(result, new AsyncCallback<User>() {
						
					@Override
					public void onFailure(Throwable caught) {}


					@Override
					public void onSuccess(User result) {
						currentUser = result;
						btnSearch.setEnabled(true);
						btnViewAll.setEnabled(true);
						btnViewCheckedOut.setEnabled(true);
						
						if(currentUser.isAdmin()) {
							btnAddItem.setEnabled(true);
							btnManageUsers.setEnabled(true);
									}
								}
						});
					}
				});
		
		
		// Use RootPanel.get() to get the entire body element
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");


		//mainPanel is the primary panel we put stuff in
		final VerticalPanel mainPanel = new VerticalPanel();
		rootPanel.add(mainPanel, 10, 10);
		mainPanel.setSize("388px", "441px");

		//initializers of labels
		final Label title = new Label("Theatre Web Application");
		title.setStyleName("gwt-Header");
		mainPanel.add(title);
		title.setSize("338px", "25px");

		final Label lblRules = new Label("And here are our rules.");
		mainPanel.add(lblRules);

		VerticalPanel verticalPanel = new VerticalPanel();
		mainPanel.add(verticalPanel);

		HorizontalPanel searchPanel = new HorizontalPanel();
		verticalPanel.add(searchPanel);
		searchPanel.setSize("269px", "44px");

		//search bar
		final TextBox searchParameters = new TextBox();
		searchPanel.add(searchParameters);
		searchParameters.setSize("185px", "41px");
		searchParameters.setText("Enter search terms here");

		//primary search button
		
		searchPanel.add(btnSearch);
		btnSearch.setHeight("53px");

		HorizontalPanel searchButtonsPanel = new HorizontalPanel();
		mainPanel.add(searchButtonsPanel);

		//button for viewing all items
		
		searchButtonsPanel.add(btnViewAll);
		btnViewAll.setSize("65px", "34px");

		//button to view all checkout out items
		
		searchButtonsPanel.add(btnViewCheckedOut);
		btnViewCheckedOut.setSize("129px", "35px");

		final Label lblSearchError = new Label("Sorry, an error has occured!");
		lblSearchError.setVisible(false);
		mainPanel.add(lblSearchError);

		final StackPanel searchResultsPanel = new StackPanel();
		mainPanel.add(searchResultsPanel);
		searchResultsPanel.setSize("357px", "155px");

		HorizontalPanel addItemsPanel = new HorizontalPanel();
		mainPanel.add(addItemsPanel);
		addItemsPanel.setWidth("254px");

		
		addItemsPanel.add(btnAddItem);
		btnAddItem.setSize("87px", "42px");

		final TextBox txtbxNumberOfItems = new TextBox();
		txtbxNumberOfItems.setText("Number of Items to add");
		addItemsPanel.add(txtbxNumberOfItems);
		txtbxNumberOfItems.setSize("137px", "31px");
		
		
		final ScrollPanel multipleOuterpanel = new ScrollPanel();
		mainPanel.add(multipleOuterpanel);
		multipleOuterpanel.setSize("261px", "36px");
		
				
				
		final VerticalPanel multiURLInnerPanel = new VerticalPanel();
		multipleOuterpanel.setWidget(multiURLInnerPanel);
		multiURLInnerPanel.setSize("100%", "100%");

		
		mainPanel.add(btnManageUsers);
		btnManageUsers.setSize("106px", "36px");

		
		

		//button handlers
		btnSearch.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				searchResultsPanel.clear();
				String parameters = searchParameters.getText();
				persistence.search(parameters, 
						new AsyncCallback<ArrayList<InventoryObject>>() {
					@Override
					public void onFailure(Throwable caught) {
						lblSearchError.setVisible(true);
					}
					@Override
					public void onSuccess(ArrayList<InventoryObject> result) {
						lblSearchError.setVisible(false);
						for (InventoryObject obj : result) {


							HorizontalPanel objectPanel = new HorizontalPanel();
							searchResultsPanel.add(objectPanel, obj.getName(), false);
							objectPanel.setSize("100%", "100%");

							Label objectLabel = new Label(obj.getName());
							objectPanel.add(objectLabel);

							objectLabel.addClickHandler(new ClickHandler() {
								public void onClick(ClickEvent event) {
									rootPanel.clear();
									AdminInventory.adminOnlyInventory("213");
									//TODO
									//go to correct item page for correct level of user
								}
							});
							//TODO
							//also, find how to insert the image and add a click handler for it too
							//also, find how to insert the image
						}
					}
				});

			}
		});

		btnViewCheckedOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				searchResultsPanel.clear();
				persistence.checkOutList(
						new AsyncCallback<ArrayList<InventoryObject>>() {
							@Override
							public void onFailure(Throwable caught) {
								lblSearchError.setVisible(true);
							}
							@Override
							public void onSuccess(ArrayList<InventoryObject> result) {
								lblSearchError.setVisible(false);
								for (InventoryObject obj : result) {
									HorizontalPanel objectPanel = new HorizontalPanel();
									searchResultsPanel.add(objectPanel);
									Label objectLabel = new Label(obj.getName());
									objectPanel.add(objectLabel);

									objectLabel.addClickHandler(new ClickHandler() {
										public void onClick(ClickEvent event) {
											rootPanel.clear();
											if(currentUser.isAdmin()) {
												AdminInventory.adminOnlyInventory("213");
											}
											else
											//TODO
											//go to correct item page for correct level of user
										}
									});
									//TODO
									//also, find how to insert the image and add a click handler for it too
									//also, find how to insert the image
								}
							}
						});
			}
		});

		//TODO : not working...
		btnViewAll.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				searchResultsPanel.clear();
				persistence.returnAll(
						new AsyncCallback<List<InventoryObject>>() {
							@Override
							public void onFailure(Throwable caught) {
								lblSearchError.setVisible(true);
							}
							@Override
							public void onSuccess(List<InventoryObject> result) {
								lblSearchError.setVisible(true);
								for (InventoryObject obj : result) {
									HorizontalPanel objectPanel = new HorizontalPanel();
									searchResultsPanel.add(objectPanel);
									Label objectLabel = new Label(obj.getName());
									objectPanel.add(objectLabel);

									objectLabel.addClickHandler(new ClickHandler() {
										public void onClick(ClickEvent event) {
											rootPanel.clear();
											//TODO
											//go to correct item page for correct level of user
										}
									});
									//TODO
									//also, find how to insert the image and add the same click handler for it too
								}
							}
						});
			}
		});


		btnAddItem.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int n = Integer.parseInt(txtbxNumberOfItems.getText());
				final ArrayList<String> urls = new ArrayList<String>();
				for(int i=0; i<n; i++){
					final InventoryObject obj = new InventoryObject();
					obj.setID(Integer.toString(nextID));
					nextID++;
					persistence.saveObject(obj, 
							new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {

						}
						@Override
						public void onSuccess(Void result) {
							urls.add("GACTheatreInventory.appspot.com?id="+obj.getID());
						}
					});
				}
				if (n==1) {			
					rootPanel.clear();
					AdminInventory.adminOnlyInventory(Integer.toString(nextID-1));
				}
				else {
					//TODO Test this. My war file is not complete so I can't  -Derek
					multiURLInnerPanel.clear();
					for(String url : urls) {
						Label urlLabel = new Label(url);
						urlLabel.setText(url);				//Sets label text to the URL
						urlLabel.setSize(null, "25px");		//A decent horizontal height for label to not cause cluter
						multipleOuterpanel.add(urlLabel);
					}

					//On that note, maybe have a way to find all "empty" items that have been created/initialized?
				}
			}
		});


		btnManageUsers.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				ManageUsers.manageUserPage();
			}
		});


		final Label lblContactInfo = new Label("Please contact Terena is you have any questions.");
		mainPanel.add(lblContactInfo);



	}
}
