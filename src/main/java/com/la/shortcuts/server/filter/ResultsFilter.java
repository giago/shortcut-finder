package com.la.shortcuts.server.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.la.shortcuts.client.domain.Shortcut;
import com.la.shortcuts.server.dao.ShortcutDao;
import com.la.shortcuts.server.dao.impl.ShortcutDaoImpl;

public class ResultsFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
	private ShortcutDao dao;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		dao = new ShortcutDaoImpl();
	}
	
	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		int offset = getOffset(request);
		String query = getQuery(request);
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("results", getShortcutList(query, offset));
		request.setAttribute("offset",  offset);
        chain.doFilter(request, response);
	}

	private int getOffset(ServletRequest request) {
		String offset = request.getParameter("offset");
		if(offset == null) {
			return 0;
		}		
		try {
			int newOffset = Integer.valueOf(offset);
			if(newOffset < 0) {
				return 0;
			} else {
				return newOffset;
			}
		} catch(Exception e) {			
			return 0;
		}
	}

	private List<Shortcut> getShortcutList(String query, int offset) {
		return dao.search(query, offset);
	}
	
	private String getQuery(ServletRequest request) {
		String query = request.getParameter("query");
		if(query == null) {
			query = "";
		}
		return query;
	}



}
