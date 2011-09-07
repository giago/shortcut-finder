package com.la.shortcuts.server.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.la.shortcuts.server.dao.ShortcutDao;
import com.la.shortcuts.server.dao.impl.ShortcutDaoImpl;

public class SitemapFilter implements Filter {

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
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("relativeUrls", getRelativeUrls());
		request.setAttribute("tools", getTools());
        chain.doFilter(request, response);
	}
	
	private List<String> getTools() {
		return Arrays.asList("eclipse", "word", "netbeans", "excel", "gmail", "chrome", "speedy-links" , "windows", "vlc", "intellij", "firebug");
	}

	private List<String> getRelativeUrls() {
		return dao.getReletiveUrls();
	}

}
