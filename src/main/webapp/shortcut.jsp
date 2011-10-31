<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	 <head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	 	<meta name="google-site-verification" content="_2xl145Mddf4kPSbu7T3WlLme2wN1QPZusLJGgMefZ8" >
		<meta name="keywords" content="<c:out value="${shortcut.tool}" />,<c:out value="${shortcut.keysString}" />">
		<meta name="description" content="<c:out value="${shortcut.definition}" />">
		<title><c:out value="${shortcut.tool}" /> shortcut <c:out value="${shortcut.keysString}" /></title>
		<jsp:include page="fragments/traker.jsp"/>
		<jsp:include page="fragments/shortcuts.css"/>
	 </head>
	 <body>
	 	<jsp:include page="fragments/header.jsp"/>
	 	<jsp:include page="fragments/left.html"/>
	 	<center>
		 	<div class="sc-shortcut">
		 		<div class="sc-row">
		 			<div class="sc-label">Keys:</div><div class="sc-field"><h1><c:out value="${shortcut.keysString}" /></h1></div>
		 		</div>
		 		<div class="sc-row">
		 			<div class="sc-label">Tool:</div><div class="sc-field"><h2><a href="/?query=<c:out value="${shortcut.tool}" />" ><c:out value="${shortcut.tool}" /></a></h2></div>
		 		</div>
		 		<div class="sc-rowBig">
		 			<div class="sc-label">Description:</div><div class="sc-field"><h4><c:out value="${shortcut.definition}" /></h4></div>
		 		</div>
		 		<div class="sc-row">
		 			<div class="sc-label">Platform:</div><div class="sc-field"><h4><c:out value="${shortcut.platform}" /></h4></div>
		 		</div>
		 		<div class="sc-row">
		 			<div class="sc-label">Belt:</div><div class="sc-field"><h4><c:out value="${shortcut.belt}" /></h4></div>
		 		</div>
		 		<div class="sc-rowBig">
		 			<div class="sc-label">Comments:</div>
			 		<div class="sc-field">
						<iframe class="sc-commentFrame" frameborder="0"
						src="http://crappycomments.appspot.com/iframe.jsp?url=http://shortcut-finder.appspot.com/shortcutDetails/-<c:out value="${shortcut.id}" />" >
						Iframes not supported.</iframe>
					</div>
		 		</div>
		 	</div>
		</center>
	   	<jsp:include page="fragments/right.jsp"/>
		<jsp:include page="fragments/footer.html"/>
	 </body>
</html>
