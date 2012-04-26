package theatreProject.client;

import java.util.ArrayList;

import theatreProject.domain.shared.InventoryObject;
import theatreProject.domain.shared.Inventory;

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
		//mainPage();
		mangageUserPage();
	}
	
	
	public void mangageUserPage(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");
		
		final VerticalPanel manguageUserPanel = new VerticalPanel();
		rootPanel.add(manguageUserPanel, 10 ,10 );
		manguageUserPanel.setSize("792px", "522px");
		
		final Label title = new Label("User Mangagement");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		manguageUserPanel.add(absolutePanel);
		absolutePanel.setHeight("445px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 45, 32);
		verticalPanel.setSize("141px", "243px");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		absolutePanel.add(verticalPanel_1, 238, 32);
		verticalPanel_1.setSize("135px", "243px");
		
		Label lblUserInformation = new Label("User Information");
		absolutePanel.add(lblUserInformation, 413, 10);
		
		Label lblViewonlyUsers = new Label("View-Only Users");
		absolutePanel.add(lblViewonlyUsers, 45, 10);
		lblViewonlyUsers.setSize("141px", "18px");
		
		Label lblAdmins = new Label("Admins");
		absolutePanel.add(lblAdmins, 238, 10);
		lblAdmins.setSize("135px", "18px");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		absolutePanel.add(verticalPanel_2, 413, 30);
		verticalPanel_2.setSize("141px", "243px");
		
		Button button = new Button("<---");
		absolutePanel.add(button, 192, 91);
		
		Button button_1 = new Button("<---");
		button_1.setText("--->");
		absolutePanel.add(button_1, 192, 138);
		button_1.setSize("36px", "30px");
		
		Button btnX = new Button("X");
		absolutePanel.add(btnX, 192, 182);
		
		Label lblAddUser = new Label("Add User");
		absolutePanel.add(lblAddUser, 45, 293);
		lblAddUser.setSize("141px", "18px");
		
		TextBox txtbxName = new TextBox();
		txtbxName.setText("Name");
		absolutePanel.add(txtbxName, 44, 313);
		txtbxName.setSize("128px", "18px");
		
		TextBox txtbxEmail = new TextBox();
		txtbxEmail.setText("email");
		absolutePanel.add(txtbxEmail, 238, 313);
		txtbxEmail.setSize("128px", "18px");
		
		Button btnAdd = new Button("Add");
		absolutePanel.add(btnAdd, 413, 313);
		
		TextBox txtbxAdditionalInformation = new TextBox();
		txtbxAdditionalInformation.setText("Additional Information");
		absolutePanel.add(txtbxAdditionalInformation, 45, 360);
		txtbxAdditionalInformation.setSize("393px", "18px");
	}
	
	public void readOnlyInventory(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");
		
		final VerticalPanel manguageUserPanel = new VerticalPanel();
		rootPanel.add(manguageUserPanel, 10 ,10 );
		manguageUserPanel.setSize("430px", "280px");
		
		final Label title = new Label("Read Only Inventory Page");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");
	}
	
	
	public void mainPage() {

		// Use RootPanel.get() to get the entire body element
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");
		
		
		//mainPanel is the primary panel we put stuff in
		final VerticalPanel mainPanel = new VerticalPanel();
		rootPanel.add(mainPanel, 10, 10);
		mainPanel.setSize("430px", "280px");
		
		//initializers of labels
		final Label title = new Label("Theatre Web Application");
		title.setStyleName("gwt-Header");
		mainPanel.add(title);
		title.setSize("338px", "25px");
		
		final Label lblRules = new Label("And here are our rules.");
		mainPanel.add(lblRules);
		
		//panel to hold the search bar and button
		final HorizontalPanel searchBarPanel = new HorizontalPanel();
		mainPanel.add(searchBarPanel);
		searchBarPanel.setSize("284px", "34px");
		
		//search bar
		final TextBox searchParameters = new TextBox();
		searchParameters.setText("Enter search terms here");
		searchBarPanel.add(searchParameters);
		
		//primary search button
		final Button btnSearch = new Button("Search");
		searchBarPanel.add(btnSearch);
		
		
		//panel to hold the view all and view checked out buttons
		final HorizontalPanel searchAllPanel = new HorizontalPanel();
		mainPanel.add(searchAllPanel);
		
		//button for viewing all items
		final Button btnViewAll = new Button("View All");
		searchAllPanel.add(btnViewAll);
		
		//button to view all checkout out items
		final Button btnViewCheckedOut = new Button("View Checked Out");
		searchAllPanel.add(btnViewCheckedOut);
		
		//an empty panel which will get the search results put into it
		final VerticalPanel searchResultsPanel = new VerticalPanel();
		mainPanel.add(searchResultsPanel);
		
		final Button btnManageUsers = new Button("Manage Users");
		mainPanel.add(btnManageUsers);
		
		
		final Label lblContactInfo = new Label("Please contact Terena is you have any questions.");
		mainPanel.add(lblContactInfo);
		

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
		
		btnViewAll.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//pass the parameter database from our inventory into displayObjects
					//method from above
			}
		});
		
		btnViewCheckedOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//ArrayList<InventoryObject> found = inventory.checkOutList();
				//pass the parameter found to the displayObjects method
			}
		});
	
		btnManageUsers.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				mangageUserPage();
			}
		});
	}
}