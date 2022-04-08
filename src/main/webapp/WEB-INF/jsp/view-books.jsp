<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Books</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h2>View Books</h2>
<table border="1|0">
<thead>
<tr>
<th>isbn <a href="viewBooks?sortBy=isbn">↕️↕️</a></th>
<th>name <a href="viewBooks?sortBy=name">↕️↕️</a></th>
<th>author <a href="viewBooks?sortBy=author">↕️↕️</a></th>
<th>delete</th>
<th>update</th>
</tr>
</thead>
<tbody>
<c:forEach items="${books}" var="book">
<tr>
<td>${book.isbn}</td>
<td>${book.name}</td>
<td>${book.author}</td>
<td><form:form id="a" action="deleteBook?isbn=${book.isbn}" method="post"><input type="submit" value="🗑️"/></form:form></td>
<td><form:form id="b" action="updateBook?isbn=${book.isbn}" method="get"><button name="isbn" type="submit" value="${book.isbn}">✏️</button></form:form></td>
</tr>
</c:forEach>
</tbody>
</table>
<c:if test="${deleteBookSuccess}">
    <div id="success-message">Successfully deleted Book with ISBN: ${deletedBookIsbn}</div>
</c:if>
<c:if test="${deleteBookFailure}">
    <div id="failure-message">Failed to delete Book with ISBN: ${deletedBookIsbn}</div>
</c:if>
</body>
</html>