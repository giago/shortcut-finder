package com.la.shortcuts.client.widgets;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.DialogBox;

public class CustomDialogBox extends DialogBox {
	
	public CustomDialogBox(HandlerManager eventBus) {
		super(true);
		hide();
		setStyleName("customDialogBox");
	}

	public void show(String message){
		center();
		setAnimationEnabled(true);
		setText(message);
		show();
	}

}
