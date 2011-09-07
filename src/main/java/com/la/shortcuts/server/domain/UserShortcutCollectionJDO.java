package com.la.shortcuts.server.domain;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class UserShortcutCollectionJDO {

	@PrimaryKey
	@Persistent
	private String email;

	@Persistent
	private ArrayList<Long> shortcutIds;
	
	@Persistent
	private String tool;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setShortcutIds(ArrayList<Long> shortcutIds) {
		this.shortcutIds = shortcutIds;
	}

	public ArrayList<Long> getShortcutIds() {
		return shortcutIds;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getTool() {
		return tool;
	}
	
}
