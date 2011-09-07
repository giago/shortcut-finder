package com.la.shortcuts.server.dao;

import java.util.ArrayList;
import java.util.List;

import com.la.shortcuts.client.domain.Shortcut;


public interface ShortcutDao {
	
	ArrayList<Shortcut> search(String keys, String tool, String platform);
	
	ArrayList<Shortcut> getUserShortcut(String email, int offset);
	
	Shortcut get(Long id);
	
	void create(Shortcut shortcut);
	
	void addUserShortcut(String email, Shortcut shortcut);

	List<String> getReletiveUrls();

	List<String> getTools();

	ArrayList<Shortcut> search(String filter, int offset);

}
