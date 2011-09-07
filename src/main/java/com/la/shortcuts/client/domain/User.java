package com.la.shortcuts.client.domain;

import com.google.gwt.user.client.rpc.IsSerializable;

public class User implements IsSerializable {
	
	private boolean admin;
	
	private String email;
	
	private String loginUrl;
	
	private String logoutUrl;

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}
	
}
