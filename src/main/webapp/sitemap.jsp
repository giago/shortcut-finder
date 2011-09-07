<?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd">
	<url>
		<loc>http://shortcut-finder.appspot.com/</loc>
		<changefreq>always</changefreq>
		<priority>1.00</priority>
	</url>
	<url><loc>http://shortcut-finder.appspot.com/?query=eclipse</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/?query=gmail</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/?query=chrome</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/?query=netbeans</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/?query=vlc</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/?query=excel</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/?query=word</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/about.jsp</loc><changefreq>monthly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/shortcuts.jsp</loc><changefreq>always</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/shortcut.jsp</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/tools.jsp</loc><changefreq>always</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/help.jsp</loc><changefreq>weekly</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/privacy.jsp</loc><changefreq>always</changefreq></url>
	<url><loc>http://shortcut-finder.appspot.com/terms.jsp</loc><changefreq>always</changefreq></url>
	<c:forEach items="${requestScope.relativeUrls}" var="relativeUrl"><url><loc>http://shortcut-finder.appspot.com/shortcutDetails/<c:out value="${relativeUrl}" /></loc></url></c:forEach>
	<c:forEach items="${requestScope.tools}" var="tool"><url><loc>http://shortcut-finder.appspot.com/?q=<c:out value="${tool}" /></loc></url></c:forEach>
</urlset>