package theatreProject.client;

import com.google.gwt.core.client.EntryPoint;
import theatreProject.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.user.client.ui.PushButton;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TheatreProjectWeb implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	
	public void onModuleLoad() {
		final Label errorLabel = new Label();
		final PushButton sendButton = new PushButton("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("Search");
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		RootPanel.get("sendButtonContainer").add(sendButton, 183, 154);

		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("errorLabelContainer");
		rootPanel.add(errorLabel, 10, 84);
		errorLabel.setSize("430px", "1px");
		
		TextArea contact = new TextArea();
		contact.setText("Please contact Ternea if you have any questions");
		contact.setName("contact");
		rootPanel.add(contact, 10, 303);
		contact.setSize("438px", "36px");

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
	}
}
