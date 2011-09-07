package com.la.shortcuts.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.la.shortcuts.client.domain.Shortcut;

public class CreateShortcutEvent extends GwtEvent<CreateShortcutHandler> {

	public static final GwtEvent.Type<CreateShortcutHandler> TYPE = new GwtEvent.Type<CreateShortcutHandler>();
	private Shortcut shortcut;
	private Boolean keepRepeatableValues = false;
	
	public CreateShortcutEvent(Shortcut shortcut) {
		this.shortcut = shortcut;
	}

	public CreateShortcutEvent(Shortcut shortcut, boolean keepRepeatableValues) {
		this(shortcut);
		this.keepRepeatableValues = keepRepeatableValues;
	}
	
	@Override
	protected void dispatch(CreateShortcutHandler handler) {
		handler.create(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<CreateShortcutHandler> getAssociatedType() {
		return TYPE;
	}
	
	public Shortcut getShortcut(){
		return this.shortcut;
	}

	public void setKeepRepeatableValues(Boolean keepRepeatableValues) {
		this.keepRepeatableValues = keepRepeatableValues;
	}

	public Boolean getKeepRepeatableValues() {
		return keepRepeatableValues;
	}

}
