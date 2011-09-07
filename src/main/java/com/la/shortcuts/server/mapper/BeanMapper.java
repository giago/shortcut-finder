package com.la.shortcuts.server.mapper;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.la.shortcuts.client.domain.Shortcut;
import com.la.shortcuts.server.domain.ShortcutJDO;
import com.la.shortcuts.server.domain.ShortcutJDO.Belt;
import com.la.shortcuts.server.tagger.Tagger;

public class BeanMapper {
	
	public static ArrayList<Shortcut> convertToVO(List<ShortcutJDO> list) {
		ArrayList<Shortcut> result = new ArrayList<Shortcut>();
		for(ShortcutJDO jdo : list) {
			result.add(convertToVO(jdo));
		}
		return result; 
	}
	
	public static Shortcut convertToVO(ShortcutJDO jdo) {
		Shortcut vo = new Shortcut();
		vo.setId(jdo.getId());
		vo.setDefinition(jdo.getDefinition());
		vo.setAction(jdo.getAction());
		vo.setTool(jdo.getTool());
		vo.setKeysString(jdo.getKeysString());
		Long votes = jdo.getVotes();
		if(votes == null) {
			votes = Long.valueOf(0);
		}
		vo.setVotes(votes);
		vo.setPlatform(jdo.getPlatform());
		Belt belt = jdo.getBelt();
		if(belt == null) {
			belt = Belt.WHITE;
		}
		vo.setBelt(belt.toString());
		return vo;
	}
	
	public static ShortcutJDO convertToJDO(Shortcut vo) {
		ShortcutJDO jdo = new ShortcutJDO();
		jdo.setDefinition(vo.getDefinition());
		jdo.setAction(vo.getAction());
		jdo.setTool(vo.getTool());
		jdo.setKeysString(vo.getKeysString());
		jdo.setCreatedDate(new Date());
		jdo.setTags(Tagger.tag(vo.getAction() + " " + vo.getDefinition() + " " + vo.getTool()));
		jdo.setPlatform(vo.getPlatform());
		jdo.setBelt(vo.getBelt());
		return jdo;
	}

}
