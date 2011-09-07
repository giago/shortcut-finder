package com.la.shortcuts.client.view;

import java.util.ArrayList;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.la.shortcuts.client.domain.Shortcut;

public class ShortcutGrid extends Composite {
	
	private FlowPanel panel;
	
	public ShortcutGrid(HandlerManager eventBus) {
		panel = new FlowPanel();
		initWidget(panel);
	}
	
	public void update(ArrayList<Shortcut> shortcuts) {
		drawGrid(shortcuts);
	}
	
	private void drawGrid(ArrayList<Shortcut> shortcuts) {
		panel.clear();
		if(shortcuts == null || shortcuts.isEmpty()) {
			FlowPanel row = new FlowPanel();
			row.setStyleName("sc-editorResult");
			row.add(getLabelPanel("Description", "No result found"));
			panel.add(row);
		} else {
			for(Shortcut shortcut : shortcuts) {
				panel.add(getRow(shortcut));
			}
		}
	}

	private Widget getRow(Shortcut shortcut) {
		FlowPanel row = new FlowPanel();
		row.setStyleName("sc-editorResult");
		row.add(getLabelPanel("Keys", shortcut.getKeysString()));
		row.add(getLabelPanel("Tool", shortcut.getTool()));
		row.add(getLabelPanel("Platform", shortcut.getPlatform()));
		row.add(getLabelPanel("Description", shortcut.getDefinition()));
		return row;
	}
	
	private FlowPanel getLabelPanel(String style, String value) {
		FlowPanel panel = new FlowPanel();
		panel.setStyleName("sc-editorResult" + style);
		panel.add(new Label(value));
		return panel;
	}
}
