package com.la.shortcuts.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.la.shortcuts.client.domain.Shortcut;

@RemoteServiceRelativePath("shortcut")
public interface ShortcutService extends RemoteService {
	
	ArrayList<Shortcut> search(String keys, String tool, String platform);
	
	void create(Shortcut shortcut);
	
	void addUserShortcut(String email, Shortcut shortcut);
}
