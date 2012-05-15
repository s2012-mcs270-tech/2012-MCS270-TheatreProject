package theatreProject.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import theatreProject.client.TheatreProjectWeb;
import theatreProject.shared.PersistenceAsync;
import theatreProject.shared.User;
import com.google.gwt.user.client.ui.ListBox;
/* Manage user page. Add users to the data base with user info which includes email address full name
 *  and other useful information about the user (School, location, play they are involved with)
 *  You can also view all and remove users from the database. Upgrading and downgrading user to admin status is also possible 
 *  in this class. Access to this site has to be only for Terena or developers.
 */

public class ManageUsers {
	public final static PersistenceAsync persistence = TheatreProjectWeb.persistence;
	public static int selectedItem = 0;
	public static ListBox selectedListBox = null;


	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("deprecation")
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
		absolutePanel.setHeight("539px");
		
		final TextArea userInfoTextArea = new TextArea();
		absolutePanel.add(userInfoTextArea, 411, 59);
		userInfoTextArea.setSize("163px", "218px");
		userInfoTextArea.setReadOnly(true);
		
		final ListBox viewOnlyListBox = new ListBox();
		absolutePanel.add(viewOnlyListBox, 45, 59);
		viewOnlyListBox.setSize("141px", "228px");
		viewOnlyListBox.setVisibleItemCount(10);
		
		//Load selected view only user's extra information into the user information box
		viewOnlyListBox.addChangeListener(new ChangeListener()
		{
			@Override
			public void onChange(Widget sender) 
			{
				int itemSelected = viewOnlyListBox.getSelectedIndex();
			    String itemStringSelected = viewOnlyListBox.getValue(itemSelected); 
			    persistence.getUser(itemStringSelected, new AsyncCallback<User>()
			    {
			    	@Override
			    	public void onFailure(Throwable caught)
			    	{
			    		userInfoTextArea.setText("User information loading error");
			    	}
					@Override
					public void onSuccess(User result) {
						userInfoTextArea.setText(result.getExtraInfo());
					}
			    });
			
			}
		}
		);
		
		//Load view only user email information into the view only user list box
		final Label lblLoadingUserError = new Label("Sorry, the user could not be loaded!");
		absolutePanel.add(lblLoadingUserError, 45, 468);
		lblLoadingUserError.setVisible(false);
		
		persistence.returnAllUser(
				new AsyncCallback<ArrayList<User>>(){
					@Override
					public void onFailure(Throwable caught){ 
						lblLoadingUserError.setVisible(true);
					}
					@Override
					public void onSuccess(ArrayList<User> result){
						for (final User user: result)
						{
							viewOnlyListBox.addItem(user.getEmail());
						}
					}
				
				});
		//this doesn't work so far, it is onFailure in runtime, so the loadingUserError will show up
		
		//Load selected admin user's information into the user information box		
		final ListBox adminListBox = new ListBox();
		absolutePanel.add(adminListBox, 238, 59);
		adminListBox.setSize("147px", "228px");
		adminListBox.setVisibleItemCount(10);
		
		adminListBox.addChangeListener(new ChangeListener()
		{
			@Override
			public void onChange(Widget sender) 
			{
				int itemSelected = adminListBox.getSelectedIndex();
			    String itemStringSelected = adminListBox.getValue(itemSelected); 
			    persistence.getUserInfoByName(itemStringSelected, new AsyncCallback<String>()
			    {
			    	@Override
			    	public void onFailure(Throwable caught)
			    	{
			    		userInfoTextArea.setText("User information loading error");
			    	}
			    	public void onSuccess(String result)
			    	{
			    		userInfoTextArea.setText(result);
			    	}
			    });
			
			}
		}
		);
		
		//Load admin user email information into the admin user list box
		final Label lblLoadingAdminError = new Label("Sorry, the admins could not be loaded!");
		absolutePanel.add(lblLoadingAdminError, 45, 420);
		lblLoadingAdminError.setVisible(false);
		
		
		persistence.returnAllUser(
				new AsyncCallback<ArrayList<User>>(){
					@Override
					public void onFailure(Throwable caught){
						lblLoadingAdminError.setVisible(true);
					}
					@Override
					public void onSuccess(ArrayList<User> result){
						for (final User user: result){
							if (user.isAdmin())
							{
								adminListBox.addItem(user.getName());
							}
						}
					}
				});
		//this doesn't work so far, it is onFailure in runtime, so the loadingAdminError will show up, the same as 
		//loading all the view only user in the viewOnlyUserListBox

		final Label lblDowngradeError = new Label("Sorry, the admins could not be downgraded!");
		absolutePanel.add(lblDowngradeError, 45, 444);
		lblDowngradeError.setVisible(false);

		//a leftward arrow button which downgrades the selected admin
		Button leftMoveButton = new Button("&larr;");						
		leftMoveButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int selected = adminListBox.getSelectedIndex();
				final String selectedString = adminListBox.getValue(selected);
				adminListBox.removeItem(selected);
				persistence.getUser(selectedString, new AsyncCallback<User>()
					    {
					    	@Override
					    	public void onFailure(Throwable caught){
					    		lblDowngradeError.setVisible(true);		    	
					    	}
					    	
					    	public void onSuccess(User result)
					    	{
					    		viewOnlyListBox.addItem(selectedString);
					    		result.setAdmin(false);
					    	}
					    });			
				}
		});
		//in the UI perspective, this works, but the user is not changed in the persistence
		
		absolutePanel.add(leftMoveButton, 193, 91);							
		leftMoveButton.setSize("36px", "27px");

		final Label lblUpgradeError = new Label("Sorry, the user could not be upgrade!");
		absolutePanel.add(lblUpgradeError, 45, 492);
		lblUpgradeError.setVisible(false);
		
		//a rightward button that upgrades the selected viewOnlyUser to admin
		Button rightMoveButton = new Button("&rarr;");						
		rightMoveButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int selected = viewOnlyListBox.getSelectedIndex();
				final String selectedString = viewOnlyListBox.getValue(selected);
				viewOnlyListBox.removeItem(selected);
				persistence.getUser(selectedString, new AsyncCallback<User>()
						{
							@Override
							public void onFailure(Throwable caught){
								lblUpgradeError.setVisible(true);
							}
							public void onSuccess(User result)
							{
								adminListBox.addItem(selectedString);
								result.setAdmin(true);
							}
				});
			}
		});
		//in the UI perspective, this works, but the user is not changed in the persistence
		
		absolutePanel.add(rightMoveButton, 193, 124);						
		rightMoveButton.setSize("36px", "27px");
		
		final Label lblDeleteError = new Label("Sorry, the user could not be delete!");
		absolutePanel.add(lblDeleteError, 45, 492);
		lblDeleteError.setVisible(false);
		
		//a button that delects the selected viewOnlyUser or admin
		Button deletButton = new Button("X");								
		deletButton.addClickHandler(new ClickHandler() 
		{
			
			public void onClick(ClickEvent event) 
			{
				
				if (!((viewOnlyListBox.getSelectedIndex() == -1) && (adminListBox.getSelectedIndex() ==-1))){
					if (viewOnlyListBox.getSelectedIndex() != -1){
						selectedListBox = viewOnlyListBox;
						selectedItem = viewOnlyListBox.getSelectedIndex();
					}
					else {
						selectedListBox = adminListBox;
						selectedItem = adminListBox.getSelectedIndex();
					}
					persistence.getUser(selectedListBox.getItemText(selectedItem), new AsyncCallback<User>(){
						@Override
						public void onFailure(Throwable caught){
							lblDeleteError.setVisible(true);
						}
						public void onSuccess(User result){
							selectedListBox.removeItem(selectedItem);
							userInfoTextArea.setText("");
							//need a method to delete this user in the persistence
						}
					});
					
				}
			}
		});
		//in the UI perspective, this works, but the user is not changed in the persistence
		
		absolutePanel.add(deletButton, 193, 157);							
		deletButton.setSize("36px", "27px");

		Label lblAddUser = new Label("Add User");					
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
		txtbxAdditionalInformation.setSize("320px", "18px");
		
		
		final Label lblAddingUserError = new Label("Sorry, the user could not be added!");
		absolutePanel.add(lblAddingUserError, 45, 396);
		lblAddingUserError.setVisible(false);
		
		
		//Button that will add a user with parameters equal to what is in
		//Name, Email and AdditionalInformation textboxs
		Button btnAdd = new Button("Add");							
		btnAdd.addClickHandler(new ClickHandler() {					
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
						
						viewOnlyListBox.addItem(newUser.getEmail());
					}
				});
			}
		});
		absolutePanel.add(btnAdd, 413, 313);

		
		//Button that brings the application to the main page
		Button btnMainPage = new Button("Main Page");				
		btnMainPage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				TheatreProjectWeb.mainPage();
			}
		});
		absolutePanel.add(btnMainPage, 411, 363);
		
		Label lblViewOnlyUsers = new Label("View Only User's");
		absolutePanel.add(lblViewOnlyUsers, 52, 19);
		
		Label lblAdministors = new Label("Administors");
		absolutePanel.add(lblAdministors, 270, 19);
		
		Label lblUserInformation = new Label("User Information");
		absolutePanel.add(lblUserInformation, 434, 19);

	}
}
