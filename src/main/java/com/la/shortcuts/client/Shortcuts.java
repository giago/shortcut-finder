package com.la.shortcuts.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.la.shortcuts.client.domain.Shortcut;
import com.la.shortcuts.client.events.CreateShortcutEvent;
import com.la.shortcuts.client.events.CreateShortcutHandler;
import com.la.shortcuts.client.events.SearchShortcutEvent;
import com.la.shortcuts.client.events.SearchShortcutHandler;
import com.la.shortcuts.client.view.Constants;
import com.la.shortcuts.client.view.ShortcutForm;
import com.la.shortcuts.client.view.ShortcutGrid;
import com.la.shortcuts.client.widgets.CustomDialogBox;

/**
 * Shortcut finder ... is just an idea to have a search engine just for
 * shortcuts. Target : Developer and smart software customer. Goal : Simple,
 * search and add, vote shortcuts
 * 
 * Idea: - -
 * 
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Shortcuts implements EntryPoint, CreateShortcutHandler, SearchShortcutHandler {

	private final ShortcutServiceAsync shortcutService = GWT.create(ShortcutService.class);
	private HandlerManager eventBus;
	private ShortcutForm shortcutForm;
	private ShortcutGrid shortcutGrid;
	private CustomDialogBox dialogBox;

	public Shortcuts() {
		super();
		eventBus = new HandlerManager(this);
		shortcutForm = new ShortcutForm(eventBus);
		shortcutGrid = new ShortcutGrid(eventBus);
		RootPanel.get("gwtHookForm").add(shortcutForm);
		RootPanel.get("gwtHookGrid").add(shortcutGrid);
		dialogBox = new CustomDialogBox(eventBus);
	}

	@Override
	public void onModuleLoad() {
		setUpHandler();
	}

	@Override
	public void create(final CreateShortcutEvent event) {
		shortcutService.create(event.getShortcut(), new AsyncCallback<Void>() {
			public void onFailure(Throwable caught) {
				showServerSuccessful(Constants.SERVER_ERROR);
				updateFormAfterOperation(event.getKeepRepeatableValues());
			}

			public void onSuccess(Void result) {
				showServerSuccessful(Constants.ADD_SHORTCUT_SUCCESSFULL);
				updateFormAfterOperation(event.getKeepRepeatableValues());
			}
		});
	}
	
	@Override
	public void search(final SearchShortcutEvent event) {
		shortcutService.search(event.getKeys(), event.getTool(), event.getPlatform(), new AsyncCallback<ArrayList<Shortcut>>() {
			public void onFailure(Throwable caught) {
				showServerSuccessful("problem with the server : " + caught.getMessage());
				shortcutGrid.update(null);
			}

			@Override
			public void onSuccess(ArrayList<Shortcut> result) {
				shortcutGrid.update(result);
			}
		});
	}
	
	private void updateFormAfterOperation(Boolean repeat) {
		if(repeat) {
			shortcutForm.repeat();
		} else {
			shortcutForm.reset();
		}
	}
	
	private void showServerSuccessful(String message) {
		dialogBox.show(message);
	}
	
	private void setUpHandler() {
		eventBus.addHandler(CreateShortcutEvent.TYPE, this);
		eventBus.addHandler(SearchShortcutEvent.TYPE, this);
	}
	
}
