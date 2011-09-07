<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<% 
String query = request.getParameter("query"); 
if(query == null) {
	query = "";
}
String offset = request.getParameter("offset");
if(offset == null) {
	offset = "0";
}
int offsetValue;
try {
	offsetValue = Integer.valueOf(offset);
} catch(Exception e) {
	offsetValue = 0;
}
String next = "query=" + query + "&offset=" + String.valueOf(offsetValue + 20);
String previous = null;
if(offsetValue != 0) {
	int newOffset = offsetValue - 20;
	if(newOffset <= 0) {
		newOffset = 0;
	}
	previous = "query=" + query + "&offset=" + String.valueOf(offsetValue - 20);
}
%>
<div class="sc-results">
	<c:if test="${not empty requestScope.results}" >
		<div class="sc-navigation">
			<div class="sc-navigationNext"><a href="/?<%= next %>">next</a></div>
			<%if(previous != null) { 
				%><div class="sc-navigationPrevious"><a href="/?<%= previous %>">previous</a></div><%
			}%>
		</div>
		<c:forEach items="${requestScope.results}" var="shortcut">
			<div class="sc-result">
				<div class="sc-resultKeys"><a href="/shortcutDetails/<c:out value="${shortcut.cleanKeysString}" />-<c:out value="${shortcut.id}" />" ><c:out value="${shortcut.keysString}" /></a></div>
				<div class="sc-resultDescription"><c:out value="${shortcut.definition}" /> <span class="sc-resultTool">(<a href="/?query=<c:out value="${shortcut.tool}" />" ><c:out value="${shortcut.tool}" /></a>)</span></div>
				<div class="sc-resultVotes"><c:out value="${shortcut.votes}" /></div>
			</div>
		</c:forEach>
		<div class="sc-navigation">
			<div class="sc-navigationNext"><a href="/?<%= next %>">next</a></div>
			<%if(previous != null) { 
				%><div class="sc-navigationPrevious"><a href="/?<%= previous %>">previous</a></div><%
			}%>
		</div>
	</c:if>
	<c:if test="${empty requestScope.results}" >
		<%if(offsetValue == 0){%>
			<div class="da-result">No results <a href="/search.jsp?query=<%= query %>">search with google</a></div>
		<%} else { %> 
			<div class="da-result">No more results <a href="/?<%= previous %>go back</a> or <a href="/search.jsp?query=<%= query %>">search with google</a></div>
		<%}%>
	</c:if>
</div>