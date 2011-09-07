package com.la.shortcuts.server.domain;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ShortcutJDO implements IsSerializable {

	public enum Belt {
		WHITE("White"), BLACK("Black"), MASTER("Master");
		private String friendlyName;		
		Belt(String friendlyName) { this.friendlyName = friendlyName; }
		public String toString() { return friendlyName; }
	}
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent
	private String action;

	@Persistent
	private String definition;
	
	@Persistent
	private String tool;
	
	@Persistent
	private ArrayList<String> tags;
	
	@Persistent
	private String keysString;
	
	@Persistent
	private Boolean approved = true;
	
	@Persistent
	private Long votes;
	
	@Persistent
	private Date createdDate;
	
	@Persistent
	private String platform;
	
	@Persistent
	private Belt belt;
	
	public ShortcutJDO(){}
	
	public ShortcutJDO(String definition, String action, String tool, 
			String keysString, String platform, Belt belt) {
		super();
		this.setAction(action);
		this.setDefinition(definition);
		this.tool = tool;
		this.keysString = keysString;
		this.createdDate = new Date();
		this.belt = belt;
		this.setPlatform(platform);
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
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
	
	public String getCleanKeysString() {
		String clean = keysString;
		if(clean == null) {
			return null;
		}
		return clean.replace("%", "PERCENTAGE");
	}

	public void setKeysString(String keysString) {
		this.keysString = keysString;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getApproved() {
		return approved;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
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

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatform() {
		return platform;
	}

	public Belt getBelt() {
		return belt;
	}

	public String getBeltFiendlyName() {
		return belt.toString();
	}

	public void setBelt(Belt belt) {
		this.belt = belt;
	}

	public void setBelt(String belt) {
		this.belt = Belt.valueOf(belt.toUpperCase());
	}

}
