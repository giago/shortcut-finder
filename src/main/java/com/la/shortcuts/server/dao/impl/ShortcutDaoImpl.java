package com.la.shortcuts.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.la.shortcuts.client.domain.Shortcut;
import com.la.shortcuts.server.dao.PMF;
import com.la.shortcuts.server.dao.ShortcutDao;
import com.la.shortcuts.server.domain.ShortcutJDO;
import com.la.shortcuts.server.domain.UserShortcutCollectionJDO;
import com.la.shortcuts.server.mapper.BeanMapper;
import com.la.shortcuts.server.tagger.Tagger;

public class ShortcutDaoImpl implements ShortcutDao {
	
	private static final int PAGE_SIZE = 20;

	@Override
	public void create(Shortcut shortcut) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
            pm.makePersistent(BeanMapper.convertToJDO(shortcut));
        } finally {
            pm.close();
        }
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Shortcut> search(String filter, int offset) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(ShortcutJDO.class);
		String filters = "approved == true";
		ArrayList<String> list = Tagger.tag(filter, 2);
		if(!list.isEmpty()) {
			for(String key : list) {
				filters += " && ";
				filters += "tags == '" + key.toLowerCase() + "'";
			}
		}
		
		query.setFilter(filters);
		query.setOrdering("votes desc");
		query.setRange(offset, offset + PAGE_SIZE);
		
	    try {
	    	return BeanMapper.convertToVO((List<ShortcutJDO>)query.execute()); 
	    } finally {
	        query.closeAll();
	        pm.close();
	    }
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Shortcut> search(String keys, String tool, String platform) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(ShortcutJDO.class);
		String filter = "";
		if(!"".equals(keys)) {
			filter = "keysString == '" + keys + "' && ";
		}
		if(!"".equals(tool)) {
			filter = filter + "tool == '" + tool + "' && ";
		}
		if(!"".equals(platform)) {
			filter = filter + "platform == '" + platform + "' && ";
		}
		if(!"".equals(filter)) {
			query.setFilter(filter.substring(0, filter.length()-4));
		}
		query.setOrdering("votes desc");
		query.setRange(0, 10);
	    try {
	    	return BeanMapper.convertToVO((List<ShortcutJDO>)query.execute()); 
	    } finally {
	        query.closeAll();
	        pm.close();
	    }
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addUserShortcut(String email, Shortcut shortcut) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(UserShortcutCollectionJDO.class);
		query.setFilter("email == '" + email + "'");
		try {
			UserShortcutCollectionJDO userShortcut;
			List<UserShortcutCollectionJDO> result = (List<UserShortcutCollectionJDO>)query.execute();
	    	if(result== null || result.isEmpty()) {
	    		userShortcut = new UserShortcutCollectionJDO();
				userShortcut.setEmail(email);
				userShortcut.setShortcutIds(new ArrayList<Long>());
	    	} else {
	    		userShortcut = result.get(0);
	    	}
	    	if(!userShortcut.getShortcutIds().contains(shortcut.getId())){	    		
	    		userShortcut.getShortcutIds().add(shortcut.getId());
	    	}
        } finally {
        	query.closeAll();
            pm.close();
        }
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Shortcut> getUserShortcut(String email, int offset) {
		ArrayList<Shortcut> list = new ArrayList<Shortcut>();
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query1 = pm.newQuery(UserShortcutCollectionJDO.class);
		Query query2 = null;
		query1.setFilter("email == '" + email + "'");
		try {
			UserShortcutCollectionJDO userShortcut;
			List<UserShortcutCollectionJDO> result = (List<UserShortcutCollectionJDO>)query1.execute();
	    	if(result!= null && !result.isEmpty()) {
	    		userShortcut = result.get(0);
	    		query2 = pm.newQuery(ShortcutJDO.class, ":ids.contains(id)");
	    		query2.setOrdering("votes desc");
	    		query2.setRange(offset, offset + PAGE_SIZE);
	    		list = BeanMapper.convertToVO((List<ShortcutJDO>)query2.execute(userShortcut.getShortcutIds()));
	    	}
	    	return list;
        } finally {
        	query1.closeAll();
        	if(query2!=null) query2.closeAll();
            pm.close();
        }
	}

	@Override
	public Shortcut get(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();		
	    try {
	    	ShortcutJDO shortcut = (ShortcutJDO) pm.getObjectById(ShortcutJDO.class, id);
	    	if(shortcut == null) {
	    		return null;
	    	}	
	    	Long votes = shortcut.getVotes();
    		if(votes == null) {
    			votes = new Long(0);
    		}
	    	shortcut.setVotes(votes + 1);
	    	pm.makePersistent(shortcut);
	    	return BeanMapper.convertToVO(shortcut);
	    } finally {
	        pm.close();
	    }
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getReletiveUrls() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(ShortcutJDO.class);
		query.setOrdering("votes desc");
	    try {
	    	List<ShortcutJDO> shortcuts =  (List<ShortcutJDO>)query.execute(); 
	    	List<String> relativeUrl = new ArrayList<String>();
	    	for(ShortcutJDO shortcut : shortcuts) {
	    		relativeUrl.add(shortcut.getCleanKeysString() + "-" + shortcut.getId());
	    	}
	    	return relativeUrl;
	    } finally {
	        query.closeAll();
	        pm.close();
	    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTools() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(ShortcutJDO.class);
	    try {
	    	List<Shortcut> shortcuts =  BeanMapper.convertToVO((List<ShortcutJDO>)query.execute()); 
	    	List<String> relativeUrl = new ArrayList<String>();
	    	for(Shortcut shortcut : shortcuts) {
	    		relativeUrl.add(shortcut.getKeysString() + "-" + shortcut.getId());
	    	}
	    	return relativeUrl;
	    } finally {
	        query.closeAll();
	        pm.close();
	    }
	}
	
}