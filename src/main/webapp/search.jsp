<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	 <head>
	 	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta name="keywords" content="shortcut,shortcuts,shortcut-finder,google search">
		<meta name="description" content="Result page for google search">
		<title>Shortcuts finder google results</title>
		<jsp:include page="fragments/traker.jsp"/>
		<jsp:include page="fragments/shortcuts.css"/>
	 </head>
	 <body>
	 	<jsp:include page="fragments/header.jsp"/>
	 	<center>
	 		<% 
	 		String query = request.getParameter("query");
	 		if(query == null) {
	 			query = "";
	 		}
			%>
			<form action="search.jsp" id="cse-search-box">
			  <div>
			    <input type="hidden" name="cx" value="partner-pub-2374318088795044:8lsvfk-myn7" />
			    <input type="hidden" name="cof" value="FORID:10" />
			    <input type="hidden" name="ie" value="ISO-8859-1" />
			    <input type="text" name="q" size="20" value="<%= query %>"/>
			    <input type="submit" name="sa" value="Search" />
			  </div>
			</form>
			<script type="text/javascript" src="http://www.google.com/cse/brand?form=cse-search-box&amp;lang=en"></script>
			<div id="cse-search-results"></div>
			<script type="text/javascript">
			  var googleSearchIframeName = "cse-search-results";
			  var googleSearchFormName = "cse-search-box";
			  var googleSearchFrameWidth = 800;
			  var googleSearchDomain = "www.google.com";
			  var googleSearchPath = "/cse";
			</script>
			<script type="text/javascript" src="http://www.google.com/afsonline/show_afs_search.js"></script>	
		 </center>
		 <jsp:include page="fragments/left.html"/>
		 <jsp:include page="fragments/right.jsp"/>
		 <jsp:include page="fragments/footer.html"/>
	 </body>
</html>