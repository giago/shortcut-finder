package com.la.shortcuts.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.la.shortcuts.client.domain.Shortcut;

public interface ShortcutServiceAsync {
	
	void search(String keys, String tool, String platform, AsyncCallback<ArrayList<Shortcut>> callback);
	
	void create(Shortcut shortcut, AsyncCallback<Void> callback);

	void addUserShortcut(String email, Shortcut shortcut, AsyncCallback<Void> callback);
	
}
