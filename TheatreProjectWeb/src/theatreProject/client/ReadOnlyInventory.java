package theatreProject.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;

public class ReadOnlyInventory {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void readOnlyInventory(){
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-Root");

		final VerticalPanel manguageUserPanel = new VerticalPanel();
		rootPanel.add(manguageUserPanel, 10 ,10 );
		manguageUserPanel.setSize("466px", "538px");

		final Label title = new Label("Read Only Inventory Page");
		title.setStyleName("gwt-Header");
		manguageUserPanel.add(title);
		title.setSize("338px","25px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		manguageUserPanel.add(absolutePanel);
		absolutePanel.setSize("450px", "489px");

		Button btnMainMenu_1 = new Button("Main Menu");
		absolutePanel.add(btnMainMenu_1, 364, 452);
		
		Label textBox = new Label();
		textBox.setText("Name of Inventory Object");
		textBox.setStyleName("gwt-Heading2");
		absolutePanel.add(textBox, 10, 0);
		textBox.setSize("419px", "18px");
		
		Image image = new Image((String) null);
		image.setAltText("Image");
		absolutePanel.add(image, 10, 47);
		image.setSize("196px", "131px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 224, 47);
		horizontalPanel.setSize("211px", "34px");
		
		Label label = new Label("Check in/out Status: ");
		horizontalPanel.add(label);
		label.setWidth("92px");
		
		Label textBox_1 = new Label();
		textBox_1.setStyleName("gwt-LabelSmall");
		textBox_1.setText("In/Out");
		horizontalPanel.add(textBox_1);
		textBox_1.setSize("97px", "22px");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 10, 200);
		horizontalPanel_1.setSize("434px", "98px");
		
		Label label_1 = new Label("Description: ");
		horizontalPanel_1.add(label_1);
		
		TextArea textArea = new TextArea();
		textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.\tpublic void readOnlyInventory(){\n        final RootPanel rootPanel = RootPanel.get();\n        rootPanel.setStyleName(\"gwt-Root\");\n\n        final VerticalPanel manguageUserPanel = new VerticalPanel();\n        rootPanel.add(manguageUserPanel, 10 ,10 );\n        manguageUserPanel.setSize(\"426px\", \"431px\");\n\n        final Label title = new Label(\"Read Only Inventory Page\");\n        title.setStyleName(\"gwt-Header\");\n        manguageUserPanel.add(title);\n        title.setSize(\"338px\",\"25px\");\n\n        AbsolutePanel absolutePanel = new AbsolutePanel();\n        manguageUserPanel.add(absolutePanel);\n        absolutePanel.setSize(\"413px\", \"373px\");\n\n        Image image_1 = new Image((String) null);\n        absolutePanel.add(image_1, 10, 10);\n        image_1.setAltText(\"Image\");\n        image_1.setSize(\"170px\", \"137px\");\n\n        HorizontalPanel horizontalPanel = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel, 194, 10);\n\n        Label lblName = new Label(\"Name:\");\n        horizontalPanel.add(lblName);\n\n        Label txtbxNameOfInventory = new Label();\n        txtbxNameOfInventory.setText(\"Name of Inventory Object\");\n        horizontalPanel.add(txtbxNameOfInventory);\n\n        HorizontalPanel horizontalPanel_6 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_6, 194, 65);\n\n        HorizontalPanel horizontalPanel_2 = new HorizontalPanel();\n        horizontalPanel_6.add(horizontalPanel_2);\n\n        Label lblCheckInoutStatus = new Label(\"Check in/out Status:\");\n        horizontalPanel_2.add(lblCheckInoutStatus);\n\n        Label lblStatus = new Label(\" Status\");\n        horizontalPanel_2.add(lblStatus);\n\n        HorizontalPanel horizontalPanel_4 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_4, 10, 163);\n\n        Label lblNewLabel = new Label(\"Description: \");\n        horizontalPanel_4.add(lblNewLabel);\n\n        Label lblLoremIpsum = new Label(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.\");\n        horizontalPanel_4.add(lblLoremIpsum);\n        lblLoremIpsum.setSize(\"309px\", \"89px\");\n\n        HorizontalPanel horizontalPanel_5 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_5, 10, 273);\n\n        Label lblDisclaimers = new Label(\"Disclaimers: \");\n        horizontalPanel_5.add(lblDisclaimers);\n\n        Label lblLoremIpsum_1 = new Label(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. \");\n        horizontalPanel_5.add(lblLoremIpsum_1);\n\n        Button btnMainMenu_1 = new Button(\"Main Menu\");\n        absolutePanel.add(btnMainMenu_1, 10, 333);\n\n        HorizontalPanel horizontalPanel_3 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_3, 194, 111);\n\n        Label lblReturnDate = new Label(\"Return Date: \");\n        horizontalPanel_3.add(lblReturnDate);\n\n        DateLabel dateLabel = new DateLabel();\n        horizontalPanel_3.add(dateLabel);\n    }");
		horizontalPanel_1.add(textArea);
		textArea.setSize("342px", "96px");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_2, 10, 326);
		horizontalPanel_2.setSize("433px", "110px");
		
		Label label_2 = new Label("Disclaimers: ");
		horizontalPanel_2.add(label_2);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.\tpublic void readOnlyInventory(){\n        final RootPanel rootPanel = RootPanel.get();\n        rootPanel.setStyleName(\"gwt-Root\");\n\n        final VerticalPanel manguageUserPanel = new VerticalPanel();\n        rootPanel.add(manguageUserPanel, 10 ,10 );\n        manguageUserPanel.setSize(\"426px\", \"431px\");\n\n        final Label title = new Label(\"Read Only Inventory Page\");\n        title.setStyleName(\"gwt-Header\");\n        manguageUserPanel.add(title);\n        title.setSize(\"338px\",\"25px\");\n\n        AbsolutePanel absolutePanel = new AbsolutePanel();\n        manguageUserPanel.add(absolutePanel);\n        absolutePanel.setSize(\"413px\", \"373px\");\n\n        Image image_1 = new Image((String) null);\n        absolutePanel.add(image_1, 10, 10);\n        image_1.setAltText(\"Image\");\n        image_1.setSize(\"170px\", \"137px\");\n\n        HorizontalPanel horizontalPanel = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel, 194, 10);\n\n        Label lblName = new Label(\"Name:\");\n        horizontalPanel.add(lblName);\n\n        Label txtbxNameOfInventory = new Label();\n        txtbxNameOfInventory.setText(\"Name of Inventory Object\");\n        horizontalPanel.add(txtbxNameOfInventory);\n\n        HorizontalPanel horizontalPanel_6 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_6, 194, 65);\n\n        HorizontalPanel horizontalPanel_2 = new HorizontalPanel();\n        horizontalPanel_6.add(horizontalPanel_2);\n\n        Label lblCheckInoutStatus = new Label(\"Check in/out Status:\");\n        horizontalPanel_2.add(lblCheckInoutStatus);\n\n        Label lblStatus = new Label(\" Status\");\n        horizontalPanel_2.add(lblStatus);\n\n        HorizontalPanel horizontalPanel_4 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_4, 10, 163);\n\n        Label lblNewLabel = new Label(\"Description: \");\n        horizontalPanel_4.add(lblNewLabel);\n\n        Label lblLoremIpsum = new Label(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. Proin vel neque eu nunc posuere rutrum in id libero. Nam felis lectus, porta et faucibus et, dapibus vitae nulla.\");\n        horizontalPanel_4.add(lblLoremIpsum);\n        lblLoremIpsum.setSize(\"309px\", \"89px\");\n\n        HorizontalPanel horizontalPanel_5 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_5, 10, 273);\n\n        Label lblDisclaimers = new Label(\"Disclaimers: \");\n        horizontalPanel_5.add(lblDisclaimers);\n\n        Label lblLoremIpsum_1 = new Label(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sapien ipsum, feugiat eu commodo id, elementum vitae justo. \");\n        horizontalPanel_5.add(lblLoremIpsum_1);\n\n        Button btnMainMenu_1 = new Button(\"Main Menu\");\n        absolutePanel.add(btnMainMenu_1, 10, 333);\n\n        HorizontalPanel horizontalPanel_3 = new HorizontalPanel();\n        absolutePanel.add(horizontalPanel_3, 194, 111);\n\n        Label lblReturnDate = new Label(\"Return Date: \");\n        horizontalPanel_3.add(lblReturnDate);\n\n        DateLabel dateLabel = new DateLabel();\n        horizontalPanel_3.add(dateLabel);\n    }");
		horizontalPanel_2.add(textArea_1);
		textArea_1.setSize("339px", "96px");
	}
}
