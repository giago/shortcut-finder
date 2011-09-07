package com.la.shortcuts.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SearchShortcutEvent extends GwtEvent<SearchShortcutHandler> {

	public static final GwtEvent.Type<SearchShortcutHandler> TYPE = new GwtEvent.Type<SearchShortcutHandler>();
	private String keys;
	private String tool;
	private String platform;
	
	public SearchShortcutEvent(String keys, String tool, String platform) {
		this.keys = keys;
		this.tool = tool;
		this.platform = platform;
	}
	
	@Override
	protected void dispatch(SearchShortcutHandler handler) {
		handler.search(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SearchShortcutHandler> getAssociatedType() {
		return TYPE;
	}
	
	public String getKeys() {
		return keys;
	}

	public String getTool() {
		return tool;
	}

	public String getPlatform() {
		return platform;
	}
	
}
