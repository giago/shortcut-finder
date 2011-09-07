package com.la.shortcuts.client.widgets;

import java.util.HashMap;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.TextBox;

public class KeyAwareTextBox extends TextBox implements KeyUpHandler, ChangeHandler {
	
	private static final HashMap<String, String> KEY_MAP_SUBSTITUTION = new HashMap<String, String>(); {
		KEY_MAP_SUBSTITUTION.put("17", "CTRL");
		KEY_MAP_SUBSTITUTION.put("16", "SHIFT");
		KEY_MAP_SUBSTITUTION.put("18", "ALT");
		KEY_MAP_SUBSTITUTION.put("112", "F1");
		KEY_MAP_SUBSTITUTION.put("113", "F2");
		KEY_MAP_SUBSTITUTION.put("114", "F3");
		KEY_MAP_SUBSTITUTION.put("115", "F4");
		KEY_MAP_SUBSTITUTION.put("116", "F5");
		KEY_MAP_SUBSTITUTION.put("117", "F6");
		KEY_MAP_SUBSTITUTION.put("118", "F7");
		KEY_MAP_SUBSTITUTION.put("119", "F8");
		KEY_MAP_SUBSTITUTION.put("120", "F9");
		KEY_MAP_SUBSTITUTION.put("121", "F10");
		KEY_MAP_SUBSTITUTION.put("122", "F11");
		KEY_MAP_SUBSTITUTION.put("123", "F12");

		KEY_MAP_SUBSTITUTION.put("40", "" + '\u25BC');
		//KEY_MAP_SUBSTITUTION.put("40", "" + '\u2193');  // down 25BC
		KEY_MAP_SUBSTITUTION.put("39", "" + '\u25BA');
		//KEY_MAP_SUBSTITUTION.put("39", "" + '\u2192');  // right 25BA
		KEY_MAP_SUBSTITUTION.put("38", "" + '\u25B2');
		//KEY_MAP_SUBSTITUTION.put("38", "" + '\u2191');  // up 25B2
		KEY_MAP_SUBSTITUTION.put("37", "" + '\u25C4');
		//KEY_MAP_SUBSTITUTION.put("37", "" + '\u2190');  //left trinagle 25C4

		KEY_MAP_SUBSTITUTION.put("33", "PAGE UP");
		KEY_MAP_SUBSTITUTION.put("34", "PAGE DOWN");
		
	}
	
	public KeyAwareTextBox() {
		addKeyUpHandler(this);
		addChangeHandler(this);
	}
	
	@Override
	public void onKeyUp(KeyUpEvent event) {
		int key = event.getNativeKeyCode();
		String text = getText();
		if(KEY_MAP_SUBSTITUTION.containsKey(Integer.toString(key))) {
			setText(text + KEY_MAP_SUBSTITUTION.get(Integer.toString(key)) + "+");
		}
	}
	
	@Override
	public void onChange(ChangeEvent event) {
		setText(getText().toUpperCase());
	}

	public String getKeysString() {		
		return getValue();
	}
	
	public void setKeysString(String value) {
		setValue(value);
	}

	


}
