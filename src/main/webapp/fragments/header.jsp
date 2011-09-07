<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%UserService userService = UserServiceFactory.getUserService(); User user = userService.getCurrentUser();%>
<div class="sc-header">
	<div class="sc-headerLeft">
		<a href="/shortcuts.jsp">Home</a>
		<a href="/tools.jsp">Tools</a>
		<a href="/dojo.jsp">Dojo</a>
		<a class="sc-new" href="/search.jsp">Google Search</a>
	</div>
	<div class="sc-headerRight">
    	<%if (user != null) {%>
    		 <a href="/editor.jsp">Create Shortcut</a>
			 <a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">Sign out <%=user.getNickname()%></a>
		<%} else {%>
			<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
		<%}%>
	</div>
</div>
<div class="sc-title">
	 <h1><a class="h1Link" href="/shortcuts.jsp" style="border:0px">Shortcuts</a></h1>
</div>