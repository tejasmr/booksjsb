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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<title>Update Book v2</title>
</head>
<body>

<c:url var="updateBookUrl" value="/v2/book/updateBook"/>
<form:form action="${updateBookUrl}" method="post" modelAttribute="book">
<fieldset>
<legend>Update Book</legend>
<form:input type="hidden" path="isbn" value="${book.isbn}"/>
<form:label path="isbn">ISBN: </form:label>
<form:label path="isbn">${book.isbn}</form:label>
<form:label path="name">Name: </form:label>
<form:input type="text" path="name"/>
<form:label path="author">Author: </form:label>
<form:input type="text" path="author"/>
<input type="submit" value="Update"/>
</fieldset>
</form:form>

</body>
</html>