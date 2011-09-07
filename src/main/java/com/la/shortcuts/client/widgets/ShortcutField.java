package com.la.shortcuts.client.widgets;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.la.shortcuts.client.view.Resettable;

public class ShortcutField extends VerticalPanel implements Resettable {
	
	private KeyAwareTextBox keyAwareTextBox;
	private TextBox textBox;
	
	public ShortcutField() {
		Label keyAwareLabel = new Label("Key aware text box");
		keyAwareLabel.setStyleName("smallLabel");
		add(keyAwareLabel);
		add(getKeyAwareTextBox());
		Label textBoxLabel = new Label("Normal text box");
		textBoxLabel.setStyleName("smallLabel");
		add(textBoxLabel);
		add(getTextBox());
	}
	
	private KeyAwareTextBox getKeyAwareTextBox() {
		keyAwareTextBox = new KeyAwareTextBox();
		keyAwareTextBox.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				if(keyAwareTextBox.getText() != null && !keyAwareTextBox.getText().equals(textBox.getText())) {
					textBox.setText(keyAwareTextBox.getText());
					textBox.setCursorPos(textBox.getText().length());
				}
			}
		});
		return keyAwareTextBox;
	}

	private TextBox getTextBox() {
		textBox = new TextBox();
		textBox.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				if(textBox.getText() != null && !textBox.getText().equals(keyAwareTextBox.getText())) {
					keyAwareTextBox.setText(textBox.getText());
					keyAwareTextBox.setCursorPos(keyAwareTextBox.getText().length());
				}
			}
		});	
		textBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				textBox.setText(textBox.getText().toUpperCase());
				keyAwareTextBox.setText(textBox.getText());
			}
		});
		return textBox;
	}

	@Override
	public void reset() {
		keyAwareTextBox.setKeysString(null);
		keyAwareTextBox.setText(null);
		textBox.setText(null);
	}
	
	@Override
	public void setWidth(String width) {
		super.setWidth(width);
		textBox.setWidth(width);
		keyAwareTextBox.setWidth(width);
	}

	public String getKeysString() {
		return keyAwareTextBox.getKeysString();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void repeat() {
		// TODO Auto-generated method stub
	}

}
