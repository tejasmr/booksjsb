<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.rawgit.com/Chalarangelo/mini.css/v3.0.1/dist/mini-default.min.css">
<link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<title>Books</title>
</head>
<body>

<script>
toastr.options = {
  "debug": false,
  "positionClass": "toast-bottom-left",
  "onclick": null,
  "fadeIn": 300,
  "fadeOut": 1000,
  "timeOut": 2000,
  "extendedTimeOut": 1000
}
</script>

<c:url var="addBookUrl" value="/v2/book/addBook"/>
<form:form action="${addBookUrl}" method="post" modelAttribute="book">
<fieldset>
<legend>Add Book</legend>
<form:label path="isbn">ISBN: </form:label>
<form:input type="text" path="isbn" placeholder="Enter ISBN"/>
<form:label path="name">Name: </form:label>
<form:input type="text" path="name" placeholder="Enter Name"/>
<form:label path="author">Author: </form:label>
<form:input type="text" path="author" placeholder="Enter Author"/>
<input class="small primary" type="submit" value="Add"/>
</fieldset>
</form:form>

<table class="striped" style="overflow-x:hidden !important; table-border-style: 1px solid #bdbdbd">
<thead>
<tr>
<th>ISBN <form:form action="/v2/book/" method="get" modelAttribute="sorter" style="all:unset"><form:input type="hidden" path="sortBy" value="isbn"/><button type="submit" style="all:unset; color:blue"><i class="fa fa-sort"></i></button></form:form></th>
<th>Name <form:form action="/v2/book/" method="get" modelAttribute="sorter" style="all:unset"><form:input type="hidden" path="sortBy" value="name"/><button type="submit" style="all:unset; color:blue"><i class="fa fa-sort"></i></button></form:form></th>
<th>Author <form:form action="/v2/book/" method="get" modelAttribute="sorter" style="all:unset"><form:input type="hidden" path="sortBy" value="author"/><button type="submit" style="all:unset; color:blue"><i class="fa fa-sort"></i></button></form:form></th>
<th>Delete</th>
<th>Update</th>
</tr>
</thead>
<tbody>
<c:forEach items="${books}" var="book">
<tr>
<td data-label="ISBN">${book.isbn}</td>
<td data-label="Name">${book.name}</td>
<td data-label="Author">${book.author}</td>
<td data-label="Delete"><form:form id="a" action="/v2/book/deleteBook?isbn=${book.isbn}" method="post" style="all:unset"><input class="small secondary" type="submit" value="Delete" style="--universal-margin:0px"/></form:form></td>
<td data-label="Update"><form:form id="a" action="/v2/book/updateBook?isbn=${book.isbn}" method="get" style="all:unset"><button class="small" name="isbn" type="submit" value="${book.isbn}" style="--universal-margin:0px">Update</button></form:form></td>
</tr>
</c:forEach>
</tbody>
</table>


<c:if test="${deleteBookSuccess}">
	<script>toastr.success('Successfully deleted book with ISBN ${deletedBookIsbn}', 'Delete Success')</script>
</c:if>
<c:if test="${deleteBookFailure}">
	<script>toastr.success('Failed to delete book with ISBN ${deletedBookIsbn}', 'Delete Failure')</script>
</c:if>

<c:if test="${addBookSuccess}">
	<script>toastr.success('Successfully added book with ISBN ${deletedBookIsbn}', 'Add Success')</script>
</c:if>
<c:if test="${addBookFailure}">
	<script>toastr.success('Failed to add book with ISBN ${deletedBookIsbn}', 'Add Failure')</script>
</c:if>

<c:if test="${updateBookSuccess}">
	<script>toastr.success('Successfully updated book with ISBN ${deletedBookIsbn}', 'Update Success')</script>
</c:if>
<c:if test="${updateBookFailure}">
	<script>toastr.success('Failed to update book with ISBN ${deletedBookIsbn}', 'Update Failure')</script>
</c:if>

</body>
</html>