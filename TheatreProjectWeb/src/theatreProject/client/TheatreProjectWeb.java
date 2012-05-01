package theatreProject.client;

import java.util.ArrayList;

import theatreProject.server.PersistenceImpl.User;
import theatreProject.server.PersistenceImpl.InventoryObject;
import theatreProject.shared.FieldVerifier;
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


		//button events
		// TODO
		btnSearch.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//				ArrayList<InventoryObject> foundItems;
				//				String parameters = searchParameters.getText();
				//				foundItems = inventory.search(parameters);
				//					//this is the displayObjects method, below
				//					for (InventoryObject obj : foundItems) {
				//						HorizontalPanel objectPanel = new HorizontalPanel();
				//						searchResultsPanel.add(objectPanel);
				//						Label objectLabel = new Label(obj.getName());
				//						objectPanel.add(objectLabel);
				//also, find how to insert the image
				//add a click event for the label to take to the items page
				//					}
			}
		});

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

		btnViewCheckedOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//ArrayList<InventoryObject> found = inventory.checkOutList();
				//pass the parameter found to the displayObjects method
			}
		});

		btnViewAll.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//pass the parameter database from our inventory into displayObjects
				//method from above
			}
		});

		StackPanel stackPanel = new StackPanel();
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

		TextBox txtbxNumberOfItems = new TextBox();
		txtbxNumberOfItems.setText("Number of Items to add");
		horizontalPanel.add(txtbxNumberOfItems);
		txtbxNumberOfItems.setSize("137px", "31px");

		final Button btnManageUsers = new Button("Manage Users");
		mainPanel.add(btnManageUsers);
		btnManageUsers.setSize("106px", "36px");

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
