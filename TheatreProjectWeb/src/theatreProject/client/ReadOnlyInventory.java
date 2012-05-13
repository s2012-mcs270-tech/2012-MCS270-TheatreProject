package theatreProject.client;


import theatreProject.shared.InventoryObject;
import theatreProject.shared.Persistence;
import theatreProject.shared.PersistenceAsync;

import com.google.gwt.user.client.Timer;
//import com.google.apphosting.api.ApiProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class ReadOnlyInventory {
	private static final int RETRY_MS = 1000;
	public final static PersistenceAsync persistence = GWT.create(Persistence.class);
	public static InventoryObject thisObject;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void readOnlyInventory(final String ID){

		final Label txtDescription = new Label();
		final Label txtDisclaimers = new Label();
		final Label nameOfObject = new Label();
		final Label lblStatus = new Label();
		final Label txtStorageArea = new Label();
		
		Timer loadFields = new Timer(){	

			@Override
			public void run() {
				persistence.getInventoryObject(ID, new AsyncCallback<InventoryObject>() {
					@Override
					public void onFailure(Throwable caught) {
						thisObject = null;
					}
					@Override
					public void onSuccess(InventoryObject object) {
						thisObject = object;
						if(thisObject == null){
							schedule(RETRY_MS);
						} else {
							txtDescription.setText(thisObject.getDescription());
							txtDisclaimers.setText(thisObject.getDisclaimers());
							if (thisObject.getStatus().getLocation() == "warehouse") lblStatus.setText("IN");
							else lblStatus.setText("OUT");
							nameOfObject.setText(thisObject.getName());
							txtStorageArea.setText(thisObject.getStorageArea());
						}
					}
				});
			}

		};

		loadFields.run();



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

		manguageUserPanel.add(absolutePanel);
		absolutePanel.setSize("450px", "489px");

		nameOfObject.setStyleName("gwt-Heading2");
		absolutePanel.add(nameOfObject, 10, 0);
		nameOfObject.setSize("419px", "18px");

		Button btnMainMenu_1 = new Button("Main Menu");
		absolutePanel.add(btnMainMenu_1, 364, 452);

		//		Image image = new Image((String) null);
		//		image.setAltText("Image");
		//		absolutePanel.add(image, 10, 47);
		//		image.setSize("196px", "131px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 233, 90);
		horizontalPanel.setSize("211px", "34px");

		Label label = new Label("Check in/out Status: ");
		horizontalPanel.add(label);
		label.setWidth("92px");

		lblStatus.setStyleName("gwt-LabelSmall");
		horizontalPanel.add(lblStatus);
		lblStatus.setSize("97px", "22px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 10, 200);
		horizontalPanel_1.setSize("434px", "98px");

		Label label_1 = new Label("Description: ");
		horizontalPanel_1.add(label_1);

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_2, 10, 326);
		horizontalPanel_2.setSize("433px", "110px");

		Label label_2 = new Label("Disclaimers: ");
		horizontalPanel_2.add(label_2);

		ScrollPanel scrollPanel_1 = new ScrollPanel();
		horizontalPanel_2.add(scrollPanel_1);
		scrollPanel_1.setSize("348px", "98px");

		txtDescription.setStyleName("gwt-LabelSmall");
		scrollPanel_1.setWidget(txtDescription);
		txtDescription.setSize("100%", "100%");

		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("Label Box");
		absolutePanel.add(scrollPanel, 96, 200);
		scrollPanel.setSize("348px", "98px");

		txtDisclaimers.setStyleName("gwt-LabelSmall");
		scrollPanel.setWidget(txtDisclaimers);
		txtDisclaimers.setSize("100%", "100%");

		final Label lblYourItemCould = new Label("Your Item could not be found! Sorry!");
		lblYourItemCould.setVisible(false);
		absolutePanel.add(lblYourItemCould, 233, 41);

		//button handlers
		btnMainMenu_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rootPanel.clear();
				TheatreProjectWeb.mainPage();
			}
		});
	}
}

