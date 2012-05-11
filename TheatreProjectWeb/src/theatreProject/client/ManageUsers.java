package theatreProject.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import theatreProject.client.TheatreProjectWeb;
import theatreProject.shared.InventoryObject;
import theatreProject.shared.Persistence;
import theatreProject.shared.PersistenceAsync;
import theatreProject.shared.User;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.ListBox;

public class ManageUsers {
	public final static PersistenceAsync persistence = GWT.create(Persistence.class);

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void manageUserPage(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");

		final VerticalPanel manageUserPanel = new VerticalPanel();
		rootPanel.add(manageUserPanel, 10 ,10 );
		manageUserPanel.setSize("629px", "504px");

		final Label title = new Label("User Mangagement");
		title.setStyleName("gwt-Header");
		manageUserPanel.add(title);
		title.setSize("338px","25px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		manageUserPanel.add(absolutePanel);
		absolutePanel.setHeight("445px");
		
		final ListBox viewOnlyListBox = new ListBox();
		absolutePanel.add(viewOnlyListBox, 45, 59);
		viewOnlyListBox.setSize("141px", "228px");
		viewOnlyListBox.setVisibleItemCount(5);
		
		persistence.returnAllUser(
				new AsyncCallback<ArrayList<User>>(){
					@Override
					public void onFailure(Throwable caught){ 
						//put a label for error
					}
					@Override
					public void onSuccess(ArrayList<User> result){
						for (final User user: result)
						{
							viewOnlyListBox.addItem(user.getName());
							//click hander!
						}
					}
				
				});
		
		
		final ListBox adminListBox = new ListBox();
		absolutePanel.add(adminListBox, 238, 59);
		adminListBox.setSize("147px", "228px");
		adminListBox.setVisibleItemCount(5);
		
		persistence.returnAllUser(
				new AsyncCallback<ArrayList<User>>(){
					@Override
					public void onFailure(Throwable caught){
						//put a label for error
					}
					@Override
					public void onSuccess(ArrayList<User> result){
						for (final User user: result){
							if (user.isAdmin())
							{
								adminListBox.addItem(user.getName());
								//click handler
							}
						}
					}
				});
		
		TextArea userInfoTextArea = new TextArea();
		absolutePanel.add(userInfoTextArea, 411, 59);
		userInfoTextArea.setSize("163px", "218px");
		
		

		

		Button leftMoveButton = new Button("&larr;");						//Right arrow button
		leftMoveButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//click handler!				
			}
		});
		absolutePanel.add(leftMoveButton, 193, 91);							//Moves selected user in to the admin column
		leftMoveButton.setSize("36px", "27px");

		Button rightMoveButton = new Button("&rarr;");						//Left arrow button
		absolutePanel.add(rightMoveButton, 193, 124);						//Moves selected admin in to the user column
		rightMoveButton.setSize("36px", "27px");

		Button deletButton = new Button("X");								//X button
		absolutePanel.add(deletButton, 193, 157);							//Deletes selected user or selected admin from system
		deletButton.setSize("36px", "27px");

		Label lblAddUser = new Label("Add User");					//Label indicating Add User part of page
		lblAddUser.setStyleName("h2");								
		absolutePanel.add(lblAddUser, 45, 293);
		lblAddUser.setSize("141px", "18px");

		final TextBox txtbxName = new TextBox();					//Text box containing the name of the to be added user
		txtbxName.setText("Name");
		absolutePanel.add(txtbxName, 44, 313);
		txtbxName.setSize("128px", "18px");

		final TextBox txtbxEmail = new TextBox();					//Text box containing the email of the user to be added
		txtbxEmail.setText("email");
		absolutePanel.add(txtbxEmail, 238, 313);
		txtbxEmail.setSize("128px", "18px");
		
		final TextBox txtbxAdditionalInformation = new TextBox();	//Text box containing the additional information of user to be added
		txtbxAdditionalInformation.setText("Additional Information");
		absolutePanel.add(txtbxAdditionalInformation, 45, 360);
		txtbxAdditionalInformation.setSize("393px", "18px");
		
		
		final Label lblAddingUserError = new Label("Sorry, the user could not be added!");
		absolutePanel.add(lblAddingUserError, 45, 402);
		lblAddingUserError.setVisible(false);

		Button btnAdd = new Button("Add");							//Button that will add a user with parameters equal to what is in
		btnAdd.addClickHandler(new ClickHandler() {					//Name, Email and AdditionalInformation textboxs
			public void onClick(ClickEvent event) {
				String name = txtbxName.getText();
				String email = txtbxEmail.getText();
				String extraInfo = txtbxAdditionalInformation.getText();
				final User newUser = new User(email, name, extraInfo);
				persistence.saveUser(newUser, 
						new AsyncCallback<Void>()
						{
					@Override
					public void onFailure(Throwable caught)
					{
						lblAddingUserError.setVisible(true);
					}
					@Override
					public void onSuccess(Void result)
					{
						viewOnlyListBox.addItem(newUser.getName());
						//add click handler!!!!!!!!!!!!!!!!!!!!!!!!!
					}
				});
			}
		});
		absolutePanel.add(btnAdd, 413, 313);

		

		Button btnMainPage = new Button("Main Page");				//Button that brings the application to the main page
		btnMainPage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				TheatreProjectWeb.mainPage();
			}
		});
		absolutePanel.add(btnMainPage, 506, 360);
		

		
		TextBox txtbxUsersInformation = new TextBox();
		txtbxUsersInformation.setStyleName("gwt-Button");
		txtbxUsersInformation.setText("User's Information");
		absolutePanel.add(txtbxUsersInformation, 430, 19);
		txtbxUsersInformation.setSize("122px", "16px");
		
		
		TextBox txtbxViewOnlyUsers = new TextBox();
		txtbxViewOnlyUsers.setStyleName("gwt-Button");
		txtbxViewOnlyUsers.setText("View Only Users");
		absolutePanel.add(txtbxViewOnlyUsers, 55, 19);
		txtbxViewOnlyUsers.setSize("104px", "16px");
		
		TextBox txtbxAdmins = new TextBox();
		txtbxAdmins.setStyleName("gwt-Button");
		txtbxAdmins.setText("Admins");
		absolutePanel.add(txtbxAdmins, 272, 19);
		txtbxAdmins.setSize("51px", "16px");

	}
}
