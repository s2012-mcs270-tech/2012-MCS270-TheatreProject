package theatreProject.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import theatreProject.client.TheatreProjectWeb;

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
				TheatreProjectWeb.mainPage();
			}
		});
		absolutePanel.add(btnMainPage, 506, 360);
	}
}
