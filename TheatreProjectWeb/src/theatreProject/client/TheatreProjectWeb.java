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
		//mainPage();
		//mangageUserPage();
		//readOnlyInventory();
		adminOnlyInventory();
	}


	public void manageUserPage(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");

		final VerticalPanel manageUserPanel = new VerticalPanel();
		rootPanel.add(manageUserPanel, 10 ,10 );
		manageUserPanel.setSize("792px", "522px");

		final Label title = new Label("User Mangagement");
		title.setStyleName("gwt-Header");
		manageUserPanel.add(title);
		title.setSize("338px","25px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		manageUserPanel.add(absolutePanel);
		absolutePanel.setHeight("445px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 35, 10);
		verticalPanel.setSize("151px", "265px");

		MenuBar menuBar = new MenuBar(false);
		verticalPanel.add(menuBar);

		MenuItem mntmViewOnlyUsers = new MenuItem("View Only Users", false, (Command) null);
		menuBar.addItem(mntmViewOnlyUsers);

		ListBox listBox = new ListBox();
		listBox.setVisibleItemCount(10);
		verticalPanel.add(listBox);
		listBox.setSize("152px", "228px");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		absolutePanel.add(verticalPanel_1, 238, 10);
		verticalPanel_1.setSize("151px", "265px");

		MenuBar menuBar_1 = new MenuBar(false);
		verticalPanel_1.add(menuBar_1);

		MenuItem mntmAdmin = new MenuItem("Admin", false, (Command) null);
		menuBar_1.addItem(mntmAdmin);

		ListBox listBox_1 = new ListBox();
		listBox_1.setVisibleItemCount(5);
		verticalPanel_1.add(listBox_1);
		listBox_1.setSize("152px", "231px");

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		absolutePanel.add(verticalPanel_2, 419, 10);
		verticalPanel_2.setSize("151px", "263px");

		MenuBar menuBar_2 = new MenuBar(false);
		verticalPanel_2.add(menuBar_2);

		MenuItem mntmUserInformation = new MenuItem("User Information", false, (Command) null);
		menuBar_2.addItem(mntmUserInformation);

		TextArea txtrUserInfoGoes = new TextArea();
		txtrUserInfoGoes.setText("User info goes here");
		verticalPanel_2.add(txtrUserInfoGoes);
		txtrUserInfoGoes.setSize("158px", "226px");

		Button button = new Button("&larr;");
		absolutePanel.add(button, 192, 91);
		button.setSize("36px", "27px");

		Button button_1 = new Button("&rarr;");
		absolutePanel.add(button_1, 192, 138);
		button_1.setSize("36px", "30px");

		Button btnX = new Button("X");
		absolutePanel.add(btnX, 192, 182);

		Label lblAddUser = new Label("Add User");
		lblAddUser.setStyleName("h2");
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

		Button btnMainPage = new Button("Main Page");
		btnMainPage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				mainPage();
			}
		});
		absolutePanel.add(btnMainPage, 506, 360);
	}

	public void readOnlyInventory(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");

		final VerticalPanel manguageUserPanel = new VerticalPanel();
		rootPanel.add(manguageUserPanel, 10 ,10 );
		manguageUserPanel.setSize("433px", "367px");

		final Label title = new Label("Read Only Inventory Page");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		manguageUserPanel.add(verticalPanel_2);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel_2.add(horizontalPanel_1);
		horizontalPanel_1.setSize("408px", "134px");

		Image image_1 = new Image((String) null);
		image_1.setAltText("Image");
		horizontalPanel_1.add(image_1);
		image_1.setSize("163px", "131px");

		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel);
		verticalPanel.setSize("187px", "118px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);

		Label lblName = new Label("Name:");
		horizontalPanel.add(lblName);

		Label txtbxNameOfInventory = new Label();
		txtbxNameOfInventory.setText("Name of Inventory Object");
		horizontalPanel.add(txtbxNameOfInventory);

		HorizontalPanel horizontalPanel_6 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_6);

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_6.add(horizontalPanel_2);

		Label lblCheckInoutStatus = new Label("Check in/out Status:");
		horizontalPanel_2.add(lblCheckInoutStatus);

		Label lblStatus = new Label(" Status");
		horizontalPanel_2.add(lblStatus);

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel_3);

		Label lblReturnDate = new Label("Return Date: ");
		horizontalPanel_3.add(lblReturnDate);

		DateLabel dateLabel = new DateLabel();
		horizontalPanel_3.add(dateLabel);

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		manguageUserPanel.add(horizontalPanel_4);

		Label lblNewLabel = new Label("Description: ");
		horizontalPanel_4.add(lblNewLabel);

		Label lblLoremIpsum = new Label("Lorem Ipsum");
		horizontalPanel_4.add(lblLoremIpsum);

		HorizontalPanel horizontalPanel_5 = new HorizontalPanel();
		manguageUserPanel.add(horizontalPanel_5);

		Label lblDisclaimers = new Label("Disclaimers: ");
		horizontalPanel_5.add(lblDisclaimers);

		Label lblLoremIpsum_1 = new Label("Lorem Ipsum");
		horizontalPanel_5.add(lblLoremIpsum_1);
		
		Button btnMainMenu_1 = new Button("Main Menu");
		manguageUserPanel.add(btnMainMenu_1);

		Image image = new Image((String) null);
		manguageUserPanel.add(image);
	}

	public void adminOnlyInventory(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");

		final VerticalPanel manguageUserPanel = new VerticalPanel();
		rootPanel.add(manguageUserPanel, 10 ,10 );
		manguageUserPanel.setSize("433px", "367px");

		final Label title = new Label("Admin Inventory Page");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");


		VerticalPanel verticalPanel_2 = new VerticalPanel();
		manguageUserPanel.add(verticalPanel_2);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel_2.add(horizontalPanel_1);
		horizontalPanel_1.setSize("432px", "177px");

		Image image_1 = new Image((String) null);
		image_1.setAltText("Image");
		horizontalPanel_1.add(image_1);
		image_1.setSize("163px", "131px");

		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel);
		verticalPanel.setSize("187px", "118px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);

		Label lblName = new Label("Name:");
		horizontalPanel.add(lblName);

		TextBox txtbxNameOfInventory = new TextBox();
		txtbxNameOfInventory.setText("Name of Inventory Object");
		horizontalPanel.add(txtbxNameOfInventory);

		HorizontalPanel horizontalPanel_6 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_6);

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_6.add(horizontalPanel_2);

		Label lblCheckInoutStatus = new Label("Check in/out Status:");
		horizontalPanel_2.add(lblCheckInoutStatus);

		TextBox lblStatus = new TextBox();
		lblStatus.setText("Status");
		horizontalPanel_2.add(lblStatus);

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel_3);

		Label lblReturnDate = new Label("Return Date: ");
		horizontalPanel_3.add(lblReturnDate);
		
		TextBox txtbxMonthdayyear = new TextBox();
		txtbxMonthdayyear.setText("month/day/year");
		horizontalPanel_3.add(txtbxMonthdayyear);

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		manguageUserPanel.add(horizontalPanel_4);

		Label lblNewLabel = new Label("Description: ");
		horizontalPanel_4.add(lblNewLabel);

		TextBox lblLoremIpsum = new TextBox();
		horizontalPanel_4.add(lblLoremIpsum);

		HorizontalPanel horizontalPanel_5 = new HorizontalPanel();
		manguageUserPanel.add(horizontalPanel_5);

		Label lblDisclaimers = new Label("Disclaimers: ");
		horizontalPanel_5.add(lblDisclaimers);

		TextBox lblLoremIpsum_1 = new TextBox();
		horizontalPanel_5.add(lblLoremIpsum_1);
		
		Button btnMainMenu = new Button("Main Menu");
		manguageUserPanel.add(btnMainMenu);

		Image image = new Image((String) null);
		manguageUserPanel.add(image);
	}


	public void mainPage() {

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
				manageUserPage();
			}
		});


		final Label lblContactInfo = new Label("Please contact Terena is you have any questions.");
		mainPanel.add(lblContactInfo);
	}
}