package com.la.shortcuts.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.la.shortcuts.client.domain.Shortcut;
import com.la.shortcuts.client.events.CreateShortcutEvent;
import com.la.shortcuts.client.events.SearchShortcutEvent;
import com.la.shortcuts.client.widgets.ShortcutField;

public class ShortcutForm extends VerticalPanel implements Resettable {
	
	private static final String WIDTH = "350";
	
	//private KeyAwareTextBox shortcut;
	private ShortcutField shortcutField;
	private TextArea definition;
	private TextBox action;
	private TextBox tool;
	private TextBox platform;
	private ListBox belt;
	
	public ShortcutForm(final HandlerManager eventBus) {
		super();
		
		// Create a table to layout the form options
	    FlexTable layout = new FlexTable();
	    layout.setCellSpacing(6);
	    layout.setWidth("300px");
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

	    // Add a title to the form
	    layout.setHTML(0, 0, "Create a Shortcut");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    // Add some standard form options
	    
	    layout.setHTML(1, 0, "Shortcut:");
	    shortcutField = new ShortcutField();
	    shortcutField.setWidth(WIDTH);
	    layout.setWidget(1, 1, shortcutField);
	    
	    layout.setHTML(2, 0, "Action:");
	    action = new TextBox();
	    action.setWidth(WIDTH);
	    layout.setWidget(2, 1, action);

	    layout.setHTML(3, 0, "Definition:");
	    definition = new TextArea();
	    definition.setHeight("100");
	    definition.setWidth(WIDTH);
	    layout.setWidget(3, 1, definition);
	    
	    layout.setHTML(4, 0, "Tool");
	    tool = new TextBox();
	    tool.setWidth(WIDTH);
	    layout.setWidget(4, 1, tool);

	    layout.setHTML(5, 0, "Platform");
	    platform = new TextBox();
	    platform.setWidth(WIDTH);
	    layout.setWidget(5, 1, platform);

	    layout.setHTML(6, 0, "Belt");
	    belt = new ListBox();
		belt.insertItem("White", 0);
		belt.insertItem("Black", 1);
		belt.insertItem("Master", 2);
		belt.setSelectedIndex(0);
	    belt.setWidth(WIDTH);
	    layout.setWidget(6, 1, belt);
	    
		Button addBtn = new Button("Add");
		addBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new CreateShortcutEvent(getShortcut()));
			}
		});
		Button addPlusBtn = new Button("Add+");
		addPlusBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new CreateShortcutEvent(getShortcut(), true));
			}
		});
		Button searchSimilarBtn = new Button("Similar");
		searchSimilarBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new SearchShortcutEvent(shortcutField.getKeysString(), tool.getText(), platform.getText()));
			}
		});
		// Add a title to the form
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(addBtn);
		hp.add(addPlusBtn);
		hp.add(searchSimilarBtn);
	    layout.setWidget(7, 0, hp);
	    cellFormatter.setColSpan(7, 0, 2);
	    cellFormatter.setHorizontalAlignment(7, 0, HasHorizontalAlignment.ALIGN_RIGHT);
	    
	    add(layout);
	}
	
	private Shortcut getShortcut() {
		Shortcut bean = new Shortcut();
		bean.setDefinition(definition.getText());
		bean.setAction(action.getText());
		bean.setTool(tool.getText());
		bean.setKeysString(shortcutField.getKeysString());
		bean.setPlatform(platform.getText());
		bean.setBelt(belt.getValue(belt.getSelectedIndex()));
		return bean;
	}

	@Override
	public void reset() {
		definition.setText(null);
		action.setText(null);
		tool.setText(null);
		shortcutField.reset();
		platform.setText(null);
		belt.setSelectedIndex(0);
	}

	@Override
	public void repeat() {
		definition.setText(null);
		shortcutField.reset();
		belt.setSelectedIndex(0);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
