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

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 35, 10);
		verticalPanel.setSize("151px", "265px");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		absolutePanel.add(verticalPanel_2, 419, 10);
		verticalPanel_2.setSize("168px", "266px");
		
		final TextArea txtrUserInfoGoes = new TextArea();					//Text area where the selected user/admin's information will be displayed
		txtrUserInfoGoes.setText("User Information");
		verticalPanel_2.add(txtrUserInfoGoes);
		txtrUserInfoGoes.setSize("158px", "215px");
		
		

		MenuBar menuBar = new MenuBar(false);
		verticalPanel.add(menuBar);

		MenuItem mntmViewOnlyUsers = new MenuItem("View Only Users", false, (Command) null);
		menuBar.addItem(mntmViewOnlyUsers);
		
		final StackPanel viewOnlyUsersPanel = new StackPanel();
		verticalPanel.add(viewOnlyUsersPanel);
		viewOnlyUsersPanel.setSize("151px", "231px");
		persistence.returnAllUser(
				new AsyncCallback<ArrayList<User>>(){
					@Override
					public void onFailure(Throwable caught){ 
						//put a label for error
					}
					@Override
					public void onSuccess(ArrayList<User> result){
						for (final User user: result){
							HorizontalPanel userPanel = new HorizontalPanel();
							viewOnlyUsersPanel.add(userPanel);
							Label userLabel = new Label(user.getName());
							userPanel.add(userLabel);
							userLabel.addClickHandler(new ClickHandler(){
								public void onClick(ClickEvent event){
									String info = user.getExtraInfo();
									txtrUserInfoGoes.setText(info);
								}
							});
						}
					}
				
				});

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		absolutePanel.add(verticalPanel_1, 238, 10);
		verticalPanel_1.setSize("151px", "265px");

		MenuBar menuBar_1 = new MenuBar(false);
		verticalPanel_1.add(menuBar_1);

		MenuItem mntmAdmin = new MenuItem("Admin", false, (Command) null);
		menuBar_1.addItem(mntmAdmin);
		
		final StackPanel adminPanel = new StackPanel();
		verticalPanel_1.add(adminPanel);
		adminPanel.setSize("151px", "231px");
		persistence.returnAllUser(
				new AsyncCallback<ArrayList<User>>(){
					@Override
					public void onFailure(Throwable caught){
						//put a label for error
					}
					@Override
					public void onSuccess(ArrayList<User> result){
						for (final User user: result){
							if (user.isAdmin()){
								HorizontalPanel userPanel = new HorizontalPanel();
								adminPanel.add(userPanel);
								Label userLabel = new Label(user.getName());
								userPanel.add(userLabel);
								userLabel.addClickHandler(new ClickHandler(){
									public void onClick(ClickEvent event){
										String info = user.getExtraInfo();
										txtrUserInfoGoes.setText(info);
									}
								});
							}
						}
					}
				});
		

		

		MenuBar menuBar_2 = new MenuBar(false);
		verticalPanel_2.add(menuBar_2);

		MenuItem mntmUserInformation = new MenuItem("User Information", false, (Command) null);
		menuBar_2.addItem(mntmUserInformation);

		

		Button button = new Button("&larr;");						//Right arrow button
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				viewOnlyUsersPanel.getWidget(viewOnlyUsersPanel.getSelectedIndex()); 
				
			}
		});
		absolutePanel.add(button, 192, 91);							//Moves selected user in to the admin column
		button.setSize("36px", "27px");

		Button button_1 = new Button("&rarr;");						//Left arrow button
		absolutePanel.add(button_1, 193, 124);						//Moves selected admin in to the user column
		button_1.setSize("36px", "27px");

		Button btnX = new Button("X");								//X button
		absolutePanel.add(btnX, 193, 157);							//Deletes selected user or selected admin from system
		btnX.setSize("36px", "27px");

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
						lblAddingUserError.setVisible(false);
						HorizontalPanel userPanel = new HorizontalPanel();
						viewOnlyUsersPanel.add(userPanel);
						Label userLabel = new Label(newUser.getName());
						userPanel.add(userLabel);
						userLabel.addClickHandler(new ClickHandler()
						{
							public void onClick(ClickEvent event)
							{
								String info = newUser.getExtraInfo();
								txtrUserInfoGoes.setText(info);
							}
						});
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

	}
}
