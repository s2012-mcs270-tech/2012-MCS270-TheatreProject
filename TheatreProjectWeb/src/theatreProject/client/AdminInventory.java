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
		manguageUserPanel.setSize("477px", "594px");

		final Label title = new Label("Admin Inventory Page");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		manguageUserPanel.add(absolutePanel);
		absolutePanel.setSize("459px", "552px");

		Image image_1 = new Image((String) null);
		absolutePanel.add(image_1, 10, 47);
		image_1.setAltText("Image");
		image_1.setSize("196px", "131px");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_4, 10, 261);
		horizontalPanel_4.setSize("434px", "98px");

		Label lblNewLabel = new Label("Description: ");
		horizontalPanel_4.add(lblNewLabel);

		TextArea txtrLoremIpsumDolor = new TextArea();
		txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.\tpublic void readOnlyInventory(){\n        final RootPanel rootPanel = RootPanel.get();\n        rootPanel.setStyleName(\"gwt-Root\");\n\n        final VerticalPanel manguageUserPanel = new VerticalPanel();\n        rootPanel.add(manguageUserPanel, 10 ,10 );\n        manguageUserPanel.setSize(\"426px\", \"431px\");\n\n        final Label title = new Label(\"Read Only Inventory Page\");\n        title.setStyleName(\"gwt-Header\");\n        manguageUserPanel.add(title);\n        title.setSize(\"338px\",\"25px\");\n\n        AbsolutePanel absolutePanel = new AbsolutePanel();\n        manguageUserPanel.add(absolutePanel);\n        absolutePanel.setSize(\"413px\", \"373px\");\n\n        Image image_1 = new Image((String) null);\n        absolutePanel.add(image_1, 10, 10);\n        image_1.setAltText(\"Image\");\n        image_1.setSize(\"170px\", \"137px\");\n\n        HorizontalPanel horizontalPanel = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel, 194, 10);\n\n        Label lblName = new Label(\"Name:\");\n        horizontalPanel.add(lblName);\n\n        Label txtbxNameOfInventory = new Label();\n        txtbxNameOfInventory.setText(\"Name of Inventory Object\");\n        horizontalPanel.add(txtbxNameOfInventory);\n\n        HorizontalPanel horizontalPanel_6 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_6, 194, 65);\n\n        HorizontalPanel horizontalPanel_2 = new HorizontalPanel();\n        horizontalPanel_6.add(horizontalPanel_2);\n\n        Label lblCheckInoutStatus = new Label(\"Check in/out Status:\");\n        horizontalPanel_2.add(lblCheckInoutStatus);\n\n        Label lblStatus = new Label(\" Status\");\n        horizontalPanel_2.add(lblStatus);\n\n        HorizontalPanel horizontalPanel_4 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_4, 10, 163);\n\n        Label lblNewLabel = new Label(\"Description: \");\n        horizontalPanel_4.add(lblNewLabel);\n\n        Label lblLoremIpsum = new Label(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.\");\n        horizontalPanel_4.add(lblLoremIpsum);\n        lblLoremIpsum.setSize(\"309px\", \"89px\");\n\n        HorizontalPanel horizontalPanel_5 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_5, 10, 273);\n\n        Label lblDisclaimers = new Label(\"Disclaimers: \");\n        horizontalPanel_5.add(lblDisclaimers);\n\n        Label lblLoremIpsum_1 = new Label(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. \");\n        horizontalPanel_5.add(lblLoremIpsum_1);\n\n        Button btnMainMenu_1 = new Button(\"Main Menu\");\n        absolutePanel.add(btnMainMenu_1, 10, 333);\n\n        HorizontalPanel horizontalPanel_3 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_3, 194, 111);\n\n        Label lblReturnDate = new Label(\"Return Date: \");\n        horizontalPanel_3.add(lblReturnDate);\n\n        DateLabel dateLabel = new DateLabel();\n        horizontalPanel_3.add(dateLabel);\n    }");
		horizontalPanel_4.add(txtrLoremIpsumDolor);
		txtrLoremIpsumDolor.setSize("342px", "96px");

		HorizontalPanel horizontalPanel_5 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_5, 10, 390);
		horizontalPanel_5.setSize("433px", "110px");

		Label lblDisclaimers = new Label("Disclaimers: ");
		horizontalPanel_5.add(lblDisclaimers);

		TextArea txtrLoremIpsumDolor_1 = new TextArea();
		txtrLoremIpsumDolor_1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.\tpublic void readOnlyInventory(){\n        final RootPanel rootPanel = RootPanel.get();\n        rootPanel.setStyleName(\"gwt-Root\");\n\n        final VerticalPanel manguageUserPanel = new VerticalPanel();\n        rootPanel.add(manguageUserPanel, 10 ,10 );\n        manguageUserPanel.setSize(\"426px\", \"431px\");\n\n        final Label title = new Label(\"Read Only Inventory Page\");\n        title.setStyleName(\"gwt-Header\");\n        manguageUserPanel.add(title);\n        title.setSize(\"338px\",\"25px\");\n\n        AbsolutePanel absolutePanel = new AbsolutePanel();\n        manguageUserPanel.add(absolutePanel);\n        absolutePanel.setSize(\"413px\", \"373px\");\n\n        Image image_1 = new Image((String) null);\n        absolutePanel.add(image_1, 10, 10);\n        image_1.setAltText(\"Image\");\n        image_1.setSize(\"170px\", \"137px\");\n\n        HorizontalPanel horizontalPanel = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel, 194, 10);\n\n        Label lblName = new Label(\"Name:\");\n        horizontalPanel.add(lblName);\n\n        Label txtbxNameOfInventory = new Label();\n        txtbxNameOfInventory.setText(\"Name of Inventory Object\");\n        horizontalPanel.add(txtbxNameOfInventory);\n\n        HorizontalPanel horizontalPanel_6 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_6, 194, 65);\n\n        HorizontalPanel horizontalPanel_2 = new HorizontalPanel();\n        horizontalPanel_6.add(horizontalPanel_2);\n\n        Label lblCheckInoutStatus = new Label(\"Check in/out Status:\");\n        horizontalPanel_2.add(lblCheckInoutStatus);\n\n        Label lblStatus = new Label(\" Status\");\n        horizontalPanel_2.add(lblStatus);\n\n        HorizontalPanel horizontalPanel_4 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_4, 10, 163);\n\n        Label lblNewLabel = new Label(\"Description: \");\n        horizontalPanel_4.add(lblNewLabel);\n\n        Label lblLoremIpsum = new Label(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.\");\n        horizontalPanel_4.add(lblLoremIpsum);\n        lblLoremIpsum.setSize(\"309px\", \"89px\");\n\n        HorizontalPanel horizontalPanel_5 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_5, 10, 273);\n\n        Label lblDisclaimers = new Label(\"Disclaimers: \");\n        horizontalPanel_5.add(lblDisclaimers);\n\n        Label lblLoremIpsum_1 = new Label(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. \");\n        horizontalPanel_5.add(lblLoremIpsum_1);\n\n        Button btnMainMenu_1 = new Button(\"Main Menu\");\n        absolutePanel.add(btnMainMenu_1, 10, 333);\n\n        HorizontalPanel horizontalPanel_3 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_3, 194, 111);\n\n        Label lblReturnDate = new Label(\"Return Date: \");\n        horizontalPanel_3.add(lblReturnDate);\n\n        DateLabel dateLabel = new DateLabel();\n        horizontalPanel_3.add(dateLabel);\n    }");
		horizontalPanel_5.add(txtrLoremIpsumDolor_1);
		txtrLoremIpsumDolor_1.setSize("339px", "96px");

		Button btnMainMenu_1 = new Button("Main Menu");
		absolutePanel.add(btnMainMenu_1, 363, 517);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 232, 100);
		horizontalPanel_1.setSize("211px", "34px");

		Label lblLocation = new Label("Location: ");
		horizontalPanel_1.add(lblLocation);

		TextBox txtbxSchoolroom = new TextBox();
		txtbxSchoolroom.setText("School/Room");
		horizontalPanel_1.add(txtbxSchoolroom);
		txtbxSchoolroom.setWidth("136px");

		HorizontalPanel horizontalPanel_7 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_7, 232, 153);
		horizontalPanel_7.setSize("211px", "34px");

		Label lblShowEndDate = new Label("Show End Date: ");
		horizontalPanel_7.add(lblShowEndDate);

		TextBox textBox_1 = new TextBox();
		textBox_1.setText("Month/Day/Year");
		horizontalPanel_7.add(textBox_1);
		textBox_1.setWidth("130px");

		Button btnNewButton = new Button("New button");
		btnNewButton.setText("Save");
		absolutePanel.add(btnNewButton, 10, 517);
		
		Button btnDeleteItem = new Button("Delete Item");
		absolutePanel.add(btnDeleteItem, 72, 517);
		
				HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
				absolutePanel.add(horizontalPanel_2, 232, 47);
				horizontalPanel_2.setSize("211px", "34px");
				
						Label lblCheckInoutStatus = new Label("Check in/out Status: ");
						horizontalPanel_2.add(lblCheckInoutStatus);
						lblCheckInoutStatus.setWidth("92px");
						
								TextBox lblStatus = new TextBox();
								lblStatus.setText("In/Out");
								horizontalPanel_2.add(lblStatus);
								lblStatus.setSize("97px", "22px");
								
								HorizontalPanel horizontalPanel_6 = new HorizontalPanel();
								absolutePanel.add(horizontalPanel_6, 232, 210);
								horizontalPanel_6.setSize("211px", "34px");
								
								Label lblEmailOfRenter = new Label("Email of Renter: ");
								horizontalPanel_6.add(lblEmailOfRenter);
								
								TextBox txtbxEmailAddress = new TextBox();
								txtbxEmailAddress.setText("Email address");
								horizontalPanel_6.add(txtbxEmailAddress);
								txtbxEmailAddress.setWidth("136px");
								
								HorizontalPanel horizontalPanel_8 = new HorizontalPanel();
								absolutePanel.add(horizontalPanel_8, 10, 192);
								horizontalPanel_8.setSize("196px", "34px");
								
								Label lblNameOfRenter = new Label("Name of Renter: ");
								horizontalPanel_8.add(lblNameOfRenter);
								lblNameOfRenter.setWidth("55px");
								
								TextBox txtbxName = new TextBox();
								txtbxName.setText("Name");
								horizontalPanel_8.add(txtbxName);
								txtbxName.setWidth("133px");
								
										TextBox txtbxNameOfInventory = new TextBox();
										txtbxNameOfInventory.setStyleName("gwt-Heading2");
										absolutePanel.add(txtbxNameOfInventory, 10, 10);
										txtbxNameOfInventory.setSize("419px", "18px");
										txtbxNameOfInventory.setText("Name of Inventory Object");
	}
}
