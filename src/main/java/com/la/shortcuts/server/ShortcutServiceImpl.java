package com.la.shortcuts.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.la.shortcuts.client.ShortcutService;
import com.la.shortcuts.client.domain.Shortcut;
import com.la.shortcuts.server.dao.ShortcutDao;
import com.la.shortcuts.server.dao.impl.ShortcutDaoImpl;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ShortcutServiceImpl extends RemoteServiceServlet implements ShortcutService {

	private ShortcutDao shortcutDao = new ShortcutDaoImpl();
	
	public ArrayList<Shortcut> search(String keys, String tool, String platform) {
		return shortcutDao.search(keys, tool, platform);
	}

	public void create(Shortcut shortcut) {
		shortcutDao.create(shortcut);
	}

	@Override
	public void addUserShortcut(String email, Shortcut shortcut) {
		shortcutDao.addUserShortcut(email, shortcut);
	}
}
