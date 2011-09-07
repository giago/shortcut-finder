package com.la.shortcuts.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.la.shortcuts.client.domain.Shortcut;
import com.la.shortcuts.server.dao.ShortcutDao;
import com.la.shortcuts.server.dao.impl.ShortcutDaoImpl;

public class ShortcutLoaderFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
	private ShortcutDao dao;
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		dao = new ShortcutDaoImpl();
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext context = filterConfig.getServletContext();
		StringBuffer url = ((HttpServletRequest)request).getRequestURL();
		Shortcut shortcut = getShortcut(url.substring(url.lastIndexOf("-") + 1));
		if(shortcut == null) {
			context.getRequestDispatcher("/shortcuts.jsp").forward(request, response);
		} else {
			request.setAttribute("shortcut", shortcut);			
			context.getRequestDispatcher("/shortcut.jsp").forward(request, response);
		}
	}

	private Shortcut getShortcut(String possibleID) {
		Long id = null;
		try {
			id = Long.valueOf(possibleID);
			return dao.get(id);
		} catch (Exception e) {
			return null;
		}
	}

}
