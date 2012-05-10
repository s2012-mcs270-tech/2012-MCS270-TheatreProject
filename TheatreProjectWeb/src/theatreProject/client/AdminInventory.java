package theatreProject.client;

import theatreProject.shared.PersistenceAsync;
import theatreProject.shared.InventoryObject;
import theatreProject.shared.Persistence;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.apphosting.api.ApiProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AdminInventory {
	public final static PersistenceAsync persistence = GWT.create(Persistence.class);
	public static InventoryObject thisObject;


	/**
	 * @wbp.parser.entryPoint
	 */
	public static void adminOnlyInventory(int ID){		
		persistence.getInventoryObject(ID, new AsyncCallback<InventoryObject>() {
			@Override
			public void onFailure(Throwable caught) {
				thisObject = null;
			}
			@Override
			public void onSuccess(InventoryObject object) {
				thisObject = object;
			}
		});
		
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

		final Label lblCouldNotFind = new Label("COULD NOT FIND SELECTED ITEM. SORRY!");
		lblCouldNotFind.setVisible(false);
		lblCouldNotFind.setStyleName("h1");
		absolutePanel.add(lblCouldNotFind, 50, 87);
		lblCouldNotFind.setSize("312px", "24px");

//		Image image_1 = new Image((String) null);
//		absolutePanel.add(image_1, 10, 47);
//		image_1.setAltText("Image");
//		image_1.setSize("196px", "131px");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_4, 10, 261);
		horizontalPanel_4.setSize("434px", "98px");

		Label lblNewLabel = new Label("Description: ");
		horizontalPanel_4.add(lblNewLabel);

		final TextArea txtDescription = new TextArea();
		txtDescription.setText(thisObject.getDescription());
		horizontalPanel_4.add(txtDescription);
		txtDescription.setSize("342px", "96px");

		HorizontalPanel horizontalPanel_5 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_5, 10, 390);
		horizontalPanel_5.setSize("433px", "110px");

		Label lblDisclaimers = new Label("Disclaimers: ");
		horizontalPanel_5.add(lblDisclaimers);

		final TextArea txtDisclaimers = new TextArea();
		txtDisclaimers.setText(thisObject.getDisclaimers());
		horizontalPanel_5.add(txtDisclaimers);
		txtDisclaimers.setSize("339px", "96px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 232, 100);
		horizontalPanel_1.setSize("211px", "34px");

		Label lblLocation = new Label("Location: ");
		horizontalPanel_1.add(lblLocation);

		final TextBox txtLocation = new TextBox();
		txtLocation.setText(thisObject.getStatus().getLocation());
		horizontalPanel_1.add(txtLocation);
		txtLocation.setWidth("136px");

		HorizontalPanel horizontalPanel_7 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_7, 232, 153);
		horizontalPanel_7.setSize("211px", "34px");

		Label lblShowEndDate = new Label("Show End Date: ");
		horizontalPanel_7.add(lblShowEndDate);

		final TextBox txtShowDate = new TextBox();
		txtShowDate.setText(thisObject.getStatus().getShowDay());
		horizontalPanel_7.add(txtShowDate);
		txtShowDate.setWidth("130px");

		Button btnDeleteItem = new Button("Delete Item");
		absolutePanel.add(btnDeleteItem, 72, 517);

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_2, 232, 47);
		horizontalPanel_2.setSize("211px", "34px");

		Label lblCheckInoutStatus = new Label("Check in/out Status: ");
		horizontalPanel_2.add(lblCheckInoutStatus);
		lblCheckInoutStatus.setWidth("92px");

		final TextBox lblStatus = new TextBox();
		if (thisObject.getStatus().getLocation() == "warehouse") lblStatus.setText("IN");
		else lblStatus.setText("OUT");
		horizontalPanel_2.add(lblStatus);
		lblStatus.setSize("97px", "22px");

		HorizontalPanel horizontalPanel_6 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_6, 232, 210);
		horizontalPanel_6.setSize("211px", "34px");


		//TODO
		//We only have a renter at the moment...  Which is a string.  Either or, not both, name and email right now.  Could switch it.
		Label lblEmailOfRenter = new Label("Email of Renter: ");
		horizontalPanel_6.add(lblEmailOfRenter);

		final TextBox txtbxEmailAddress = new TextBox();
		txtbxEmailAddress.setText(thisObject.getStatus().getRenter());
		horizontalPanel_6.add(txtbxEmailAddress);
		txtbxEmailAddress.setWidth("136px");

		HorizontalPanel horizontalPanel_8 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_8, 10, 192);
		horizontalPanel_8.setSize("196px", "34px");


		final Label lblNameOfRenter = new Label("Name of Renter: ");
		horizontalPanel_8.add(lblNameOfRenter);
		lblNameOfRenter.setWidth("55px");
		//

		TextBox txtbxName = new TextBox();
		txtbxName.setText("Name");
		horizontalPanel_8.add(txtbxName);
		txtbxName.setWidth("133px");

		final TextBox txtbxNameOfInventory = new TextBox();
		txtbxNameOfInventory.setStyleName("gwt-Heading2");
		absolutePanel.add(txtbxNameOfInventory, 10, 10);
		txtbxNameOfInventory.setSize("419px", "18px");
		txtbxNameOfInventory.setText(thisObject.getName());

		//Main Menu Button
		Button btnMainMenu_1 = new Button("Main Menu");
		btnMainMenu_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				TheatreProjectWeb.mainPage();
			}
		});
		absolutePanel.add(btnMainMenu_1, 363, 517);


		//save buttons
		Button btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//start by setting thisObject parameters to current txtbxs
				//TODO
				
				//then save out the changes
				persistence.saveObject(thisObject, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						lblCouldNotFind.setVisible(true);								
					}
					@Override
					public void onSuccess(Void result) {
						lblCouldNotFind.setVisible(false);
						//when saved, it returns to the main page
						rootPanel.clear();
						TheatreProjectWeb.mainPage();
					}
				});
			}
		});

		btnNewButton.setText("Save");
		absolutePanel.add(btnNewButton, 10, 517);

		//TODO
		//Delete item still not operational

	}
}
