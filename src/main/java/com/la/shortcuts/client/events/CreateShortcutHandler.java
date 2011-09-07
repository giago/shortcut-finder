package com.la.shortcuts.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface CreateShortcutHandler extends EventHandler {
	
	void create(CreateShortcutEvent event);

}
