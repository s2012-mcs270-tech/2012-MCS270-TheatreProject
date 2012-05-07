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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.DecoratedTabBar;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.DateLabel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class TheatreProjectWeb implements EntryPoint {

	//needs to be persistent or something instead
	//private Inventory inventory = new Inventory(new ArrayList<InventoryObject>());

	public final static PersistenceAsync persistence = GWT.create(Persistence.class);
	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {
		mainPage();
	}

	public static void mainPage() {

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

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("269px", "44px");

		//search bar
		final TextBox searchParameters = new TextBox();
		horizontalPanel_1.add(searchParameters);
		searchParameters.setSize("185px", "41px");
		searchParameters.setText("Enter search terms here");

		//primary search button
		final Button btnSearch = new Button("Search");
		horizontalPanel_1.add(btnSearch);
		btnSearch.setHeight("53px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		mainPanel.add(horizontalPanel_2);

		//button for viewing all items
		final Button btnViewAll = new Button("View All");
		horizontalPanel_2.add(btnViewAll);
		btnViewAll.setSize("65px", "34px");

		//button to view all checkout out items
		final Button btnViewCheckedOut = new Button("View Checked Out");
		horizontalPanel_2.add(btnViewCheckedOut);
		btnViewCheckedOut.setSize("129px", "35px");
		
		final Label lblSorryAnError = new Label("Sorry, an error has occured!");
		lblSorryAnError.setVisible(false);
		mainPanel.add(lblSorryAnError);

		final StackPanel stackPanel = new StackPanel();
		mainPanel.add(stackPanel);
		stackPanel.setSize("357px", "155px");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		stackPanel.add(verticalPanel_1, "New widget", false);
		verticalPanel_1.setSize("100%", "120px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		mainPanel.add(horizontalPanel);
		horizontalPanel.setWidth("254px");

		Button btnAddItem = new Button("Add Item(s)");
		horizontalPanel.add(btnAddItem);
		btnAddItem.setSize("87px", "42px");

		final TextBox txtbxNumberOfItems = new TextBox();
		txtbxNumberOfItems.setText("Number of Items to add");
		horizontalPanel.add(txtbxNumberOfItems);
		txtbxNumberOfItems.setSize("137px", "31px");

		final Button btnManageUsers = new Button("Manage Users");
		//if (ApiProxy.getCurrentEnvironment().isAdmin()){
		mainPanel.add(btnManageUsers);
		btnManageUsers.setSize("106px", "36px");
		//}
		//Ask Max


		//button handlers
		btnSearch.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				stackPanel.clear();
				String parameters = searchParameters.getText();
				persistence.search(parameters, 
						new AsyncCallback<ArrayList<InventoryObject>>() {
					@Override
					public void onFailure(Throwable caught) {
						lblSorryAnError.setVisible(true);
					}
					@Override
					public void onSuccess(ArrayList<InventoryObject> result) {
						lblSorryAnError.setVisible(false);
						for (InventoryObject obj : result) {
							HorizontalPanel objectPanel = new HorizontalPanel();
							stackPanel.add(objectPanel);
							Label objectLabel = new Label(obj.getName());
							objectPanel.add(objectLabel);

							objectLabel.addClickHandler(new ClickHandler() {
								public void onClick(ClickEvent event) {
									rootPanel.clear();
									//go to correct item page for correct level of user
								}
							});

							//also, find how to insert the image and add a click handler for it too
							//also, find how to insert the image
						}
					}
				});

			}
		});

		btnViewCheckedOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				stackPanel.clear();
				persistence.checkOutList(
						new AsyncCallback<ArrayList<InventoryObject>>() {
							@Override
							public void onFailure(Throwable caught) {
								lblSorryAnError.setVisible(true);
							}
							@Override
							public void onSuccess(ArrayList<InventoryObject> result) {
								lblSorryAnError.setVisible(false);
								for (InventoryObject obj : result) {
									HorizontalPanel objectPanel = new HorizontalPanel();
									stackPanel.add(objectPanel);
									Label objectLabel = new Label(obj.getName());
									objectPanel.add(objectLabel);

									objectLabel.addClickHandler(new ClickHandler() {
										public void onClick(ClickEvent event) {
											rootPanel.clear();
											//go to correct item page for correct level of user
										}
									});

									//also, find how to insert the image and add a click handler for it too
									//also, find how to insert the image
								}
							}
						});
			}
		});

		btnViewAll.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				stackPanel.clear();
				persistence.returnAll(
						new AsyncCallback<List<InventoryObject>>() {
							@Override
							public void onFailure(Throwable caught) {
								lblSorryAnError.setVisible(true);
							}
							@Override
							public void onSuccess(List<InventoryObject> result) {
								lblSorryAnError.setVisible(true);
								for (InventoryObject obj : result) {
									HorizontalPanel objectPanel = new HorizontalPanel();
									stackPanel.add(objectPanel);
									Label objectLabel = new Label(obj.getName());
									objectPanel.add(objectLabel);

									objectLabel.addClickHandler(new ClickHandler() {
										public void onClick(ClickEvent event) {
											rootPanel.clear();
											//go to correct item page for correct level of user
										}
									});

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
					persistence.saveObject(obj, 
							new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {

						}
						@Override
						public void onSuccess(Void result) {
							urls.add("url?"+obj.getID());
						}
					});
				}
				if (n==1) {
					//needs to be cleaned up, to send to the right item and right access level
					rootPanel.clear();
					ReadOnlyInventory.readOnlyInventory();
				}
				else {
					//pop-up or something listing urls.
					//On that note, maybe have a way to find all "empty" items that have been created?
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
