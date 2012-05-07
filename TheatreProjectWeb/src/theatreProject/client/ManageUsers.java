package theatreProject.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import theatreProject.client.TheatreProjectWeb;
import theatreProject.shared.User;

public class ManageUsers {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void manageUserPage(){
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
		
		VerticalPanel verticalPanel_3 = new VerticalPanel();
		verticalPanel.add(verticalPanel_3);
		verticalPanel_3.setSize("151px", "232px");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		absolutePanel.add(verticalPanel_1, 238, 10);
		verticalPanel_1.setSize("151px", "265px");

		MenuBar menuBar_1 = new MenuBar(false);
		verticalPanel_1.add(menuBar_1);

		MenuItem mntmAdmin = new MenuItem("Admin", false, (Command) null);
		menuBar_1.addItem(mntmAdmin);
		
		VerticalPanel verticalPanel_4 = new VerticalPanel();
		verticalPanel_1.add(verticalPanel_4);
		verticalPanel_4.setSize("151px", "232px");

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		absolutePanel.add(verticalPanel_2, 419, 10);
		verticalPanel_2.setSize("168px", "266px");

		MenuBar menuBar_2 = new MenuBar(false);
		verticalPanel_2.add(menuBar_2);

		MenuItem mntmUserInformation = new MenuItem("User Information", false, (Command) null);
		menuBar_2.addItem(mntmUserInformation);

		TextArea txtrUserInfoGoes = new TextArea();		//Text area where the selected user/admin's information will be displayed
		txtrUserInfoGoes.setText("User info goes here");
		verticalPanel_2.add(txtrUserInfoGoes);
		txtrUserInfoGoes.setSize("158px", "215px");

		Button button = new Button("&larr;");		//Left arrow button
		absolutePanel.add(button, 192, 91);			//Moves selected admin in to the user column
		button.setSize("36px", "27px");

		Button button_1 = new Button("&rarr;");		//Right arrow button
		absolutePanel.add(button_1, 193, 124);		//Moves selected user in to the admin column
		button_1.setSize("36px", "27px");

		Button btnX = new Button("X");		//X button
		absolutePanel.add(btnX, 193, 157);	//Deletes selected user or selected admin from system
		btnX.setSize("36px", "27px");

		Label lblAddUser = new Label("Add User");		//Label indicating Add User part of page
		lblAddUser.setStyleName("h2");
		absolutePanel.add(lblAddUser, 45, 293);
		lblAddUser.setSize("141px", "18px");

		final TextBox txtbxName = new TextBox();		//Text box containing the name of the to be added user
		txtbxName.setText("Name");
		absolutePanel.add(txtbxName, 44, 313);
		txtbxName.setSize("128px", "18px");

		final TextBox txtbxEmail = new TextBox();		//Text box containing the email of the user to be added
		txtbxEmail.setText("email");
		absolutePanel.add(txtbxEmail, 238, 313);
		txtbxEmail.setSize("128px", "18px");
		
		final TextBox txtbxAdditionalInformation = new TextBox();		//Text box containing the additional information of user to be added
		txtbxAdditionalInformation.setText("Additional Information");
		absolutePanel.add(txtbxAdditionalInformation, 45, 360);
		txtbxAdditionalInformation.setSize("393px", "18px");

		Button btnAdd = new Button("Add");		//Button that will add a user with parameters equal to what is in
		btnAdd.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {		//Name, Email and AdditionalInformation textboxes
				String name = txtbxName.getText();
				String email = txtbxEmail.getText();
				String extraInfo = txtbxAdditionalInformation.getText();
				User newUser = new User(email, name, extraInfo);
			}
		});
		absolutePanel.add(btnAdd, 413, 313);

		

		Button btnMainPage = new Button("Main Page");		//Button that brings the application to the main page
		btnMainPage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				TheatreProjectWeb.mainPage();
			}
		});
		absolutePanel.add(btnMainPage, 506, 360);
	}
}
