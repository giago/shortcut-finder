<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	 <head>
	 	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	 	<meta name="google-site-verification" content="_2xl145Mddf4kPSbu7T3WlLme2wN1QPZusLJGgMefZ8" >
	 	<meta name="msvalidate.01" content="364F6C3683765DDA25B9C9391E630E0D" />
		<meta name="keywords" content="shortcut,shortcuts,shortcut-finder,eclipse,netbeans,gmail,google chrome">
		<meta name="description" content="With this website you are able to find and keep the list of shortcuts you prefer">
		<title>Shortcuts finder</title>
		<jsp:include page="fragments/traker.jsp"/>
		<jsp:include page="fragments/shortcuts.css"/>
	 </head>
	 <body>
	 	<jsp:include page="fragments/header.jsp"/>
	 	<center>
	 		<div class="sc-searchForm">
	 			<form action="">
	 				<% 
	 					String query = request.getParameter("query");
	 					if(query == null) {
	 						query = "";
	 					}
	 				%>
	 				<input type="text" name="query" value="<%= query %>">
	 				<input type="submit" value="search">
	 			</form>
	 		</div>
		   	<jsp:include page="fragments/results.jsp"/>
		 </center>
		 <jsp:include page="fragments/left.html"/>
		 <jsp:include page="fragments/right.jsp"/>
		 <jsp:include page="fragments/footer.html"/>
	 </body>
</html>