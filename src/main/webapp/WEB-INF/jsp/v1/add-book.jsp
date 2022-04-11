<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add book</title>
</head>
<body>

<jsp:include page="navbar.jsp"/>

<h2>Add Book</h2>

<c:url var="addBookUrl" value="/v1/book/addBook"/>
<form:form action="${addBookUrl}" method="post" modelAttribute="book">
<table>
<tr>
<td><form:label path="isbn">ISBN: </form:label></td>
<td><form:input type="text" path="isbn"/></td>
</tr>
<tr>
<td><form:label path="name">Name: </form:label></td>
<td><form:input type="text" path="name"/></td>
</tr>
<tr>
<td><form:label path="author">Author: </form:label></td>
<td><form:input type="text" path="author"/></td>
</tr>
</table>
<input type="submit" value="add"/>
</form:form>

<c:if test="${addBookSuccess}">
    <div id="success-message">Successfully added Book with ISBN: ${addedBookIsbn}</div>
</c:if>

<c:if test="${addBookFailure}">
    <div id="success-message">Failed to add Book with ISBN: ${addedBookIsbn}</div>
</c:if>

</body>
</html>