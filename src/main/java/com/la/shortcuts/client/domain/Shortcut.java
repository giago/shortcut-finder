package com.la.shortcuts.client.domain;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Shortcut implements IsSerializable {
	
    private Long id;
    
    private String action;
    
    private String definition;
	
	private String tool;
	
	private ArrayList<String> keys;
	
	private String keysString;
	
	private Long votes;
	
	private String platform;
	
	private String belt;
	
	public Shortcut(){}
	
	public Shortcut(String definition, String action, String tool, ArrayList<String> keys, String keysString, String platform, String belt) {
		super();
		this.setDefinition(definition);
		this.setAction(action);
		this.tool = tool;
		this.keys = keys;
		this.keysString = keysString;
		this.belt = belt;
		this.setPlatform(platform);
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public ArrayList<String> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<String> keys) {
		this.keys = keys;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeysString() {
		return keysString;
	}

	public void setKeysString(String keysString) {
		this.keysString = keysString;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getDefinition() {
		return definition;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public Long getVotes() {
		return votes;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatform() {
		return platform;
	}

	public void setBelt(String belt) {
		this.belt = belt;
	}

	public String getBelt() {
		return this.belt;
	}
	
	public String getCleanKeysString() {
		String clean = keysString;
		if(clean == null) {
			return null;
		}
		return clean.replace("%", "PERCENTAGE");
	}
}
