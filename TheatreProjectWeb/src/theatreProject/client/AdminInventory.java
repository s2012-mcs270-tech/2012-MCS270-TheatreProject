package theatreProject.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AdminInventory {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void adminOnlyInventory(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");

		final VerticalPanel manguageUserPanel = new VerticalPanel();
		rootPanel.add(manguageUserPanel, 10 ,10 );
		manguageUserPanel.setSize("435px", "531px");

		final Label title = new Label("Admin Inventory Page");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		manguageUserPanel.add(absolutePanel);
		absolutePanel.setSize("421px", "497px");

		Image image_1 = new Image((String) null);
		absolutePanel.add(image_1, 10, 10);
		image_1.setAltText("Image");
		image_1.setSize("170px", "137px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 194, 10);

		Label lblName = new Label("Name:");
		horizontalPanel.add(lblName);

		TextBox txtbxNameOfInventory = new TextBox();
		txtbxNameOfInventory.setText("Name of Inventory Object");
		horizontalPanel.add(txtbxNameOfInventory);

		HorizontalPanel horizontalPanel_6 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_6, 194, 65);

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_6.add(horizontalPanel_2);
		horizontalPanel_2.setWidth("206px");

		Label lblCheckInoutStatus = new Label("Check in/out Status: ");
		horizontalPanel_2.add(lblCheckInoutStatus);

		TextBox lblStatus = new TextBox();
		lblStatus.setText("In/Out");
		horizontalPanel_2.add(lblStatus);
		lblStatus.setWidth("54px");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_4, 10, 210);
		horizontalPanel_4.setSize("393px", "89px");

		Label lblNewLabel = new Label("Description: ");
		horizontalPanel_4.add(lblNewLabel);

		TextArea txtrLoremIpsumDolor = new TextArea();
		txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.");
		horizontalPanel_4.add(txtrLoremIpsumDolor);
		txtrLoremIpsumDolor.setSize("321px", "96px");

		HorizontalPanel horizontalPanel_5 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_5, 10, 338);
		horizontalPanel_5.setSize("393px", "54px");

		Label lblDisclaimers = new Label("Disclaimers: ");
		horizontalPanel_5.add(lblDisclaimers);

		TextArea textArea = new TextArea();
		textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.");
		horizontalPanel_5.add(textArea);
		textArea.setSize("321px", "96px");

		Button btnMainMenu_1 = new Button("Main Menu");
		absolutePanel.add(btnMainMenu_1, 331, 460);

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_3, 194, 111);
		horizontalPanel_3.setSize("209px", "34px");

		Label lblReturnDate = new Label("Return Date: ");
		horizontalPanel_3.add(lblReturnDate);

		TextBox txtbxMonthdayyear = new TextBox();
		txtbxMonthdayyear.setText("Month/Day/Year");
		horizontalPanel_3.add(txtbxMonthdayyear);
		txtbxMonthdayyear.setWidth("110px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 10, 159);
		horizontalPanel_1.setSize("182px", "34px");

		Label lblLocation = new Label("Location: ");
		horizontalPanel_1.add(lblLocation);

		TextBox textBox = new TextBox();
		textBox.setText("Month/Day/Year");
		horizontalPanel_1.add(textBox);
		textBox.setWidth("110px");

		HorizontalPanel horizontalPanel_7 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_7, 198, 159);
		horizontalPanel_7.setSize("207px", "34px");

		Label lblShowEndDate = new Label("Show End Date: ");
		horizontalPanel_7.add(lblShowEndDate);

		TextBox textBox_1 = new TextBox();
		textBox_1.setText("Month/Day/Year");
		horizontalPanel_7.add(textBox_1);
		textBox_1.setWidth("95px");

		Button btnNewButton = new Button("New button");
		btnNewButton.setText("Save");
		absolutePanel.add(btnNewButton, 10, 460);
	}
}
