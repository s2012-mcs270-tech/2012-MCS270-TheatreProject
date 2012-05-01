package theatreProject.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ReadOnlyInventory {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void readOnlyInventory(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");

		final VerticalPanel manguageUserPanel = new VerticalPanel();
		rootPanel.add(manguageUserPanel, 10 ,10 );
		manguageUserPanel.setSize("426px", "431px");

		final Label title = new Label("Read Only Inventory Page");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		manguageUserPanel.add(absolutePanel);
		absolutePanel.setSize("413px", "373px");

		Image image_1 = new Image((String) null);
		absolutePanel.add(image_1, 10, 10);
		image_1.setAltText("Image");
		image_1.setSize("170px", "137px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 194, 10);

		Label lblName = new Label("Name:");
		horizontalPanel.add(lblName);

		Label txtbxNameOfInventory = new Label();
		txtbxNameOfInventory.setText("Name of Inventory Object");
		horizontalPanel.add(txtbxNameOfInventory);

		HorizontalPanel horizontalPanel_6 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_6, 194, 65);

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_6.add(horizontalPanel_2);

		Label lblCheckInoutStatus = new Label("Check in/out Status:");
		horizontalPanel_2.add(lblCheckInoutStatus);

		Label lblStatus = new Label(" Status");
		horizontalPanel_2.add(lblStatus);

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_4, 10, 163);

		Label lblNewLabel = new Label("Description: ");
		horizontalPanel_4.add(lblNewLabel);

		Label lblLoremIpsum = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.");
		horizontalPanel_4.add(lblLoremIpsum);
		lblLoremIpsum.setSize("309px", "89px");

		HorizontalPanel horizontalPanel_5 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_5, 10, 273);

		Label lblDisclaimers = new Label("Disclaimers: ");
		horizontalPanel_5.add(lblDisclaimers);

		Label lblLoremIpsum_1 = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. ");
		horizontalPanel_5.add(lblLoremIpsum_1);

		Button btnMainMenu_1 = new Button("Main Menu");
		absolutePanel.add(btnMainMenu_1, 10, 333);

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_3, 194, 111);

		Label lblReturnDate = new Label("Return Date: ");
		horizontalPanel_3.add(lblReturnDate);

		DateLabel dateLabel = new DateLabel();
		horizontalPanel_3.add(dateLabel);
	}
}
