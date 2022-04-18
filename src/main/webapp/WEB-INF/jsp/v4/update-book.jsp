<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Update Book v4</title>
<style>
<%@
include
file="/WEB-INF/jsp/common/styles/common.css"%>
</style>
</head>
<body class="bg-light">
<div class="col-md-8 order-md-1">
<h4 class="mb-3">Update Book</h4>

<c:url var="updateBookUrl" value="/v4/book/updateBook"/>
<form:form class="row g-2" action="${updateBookUrl}" method="post" modelAttribute="book">
	<div class="col-md">
		<div class="form-floating">
			<form:input type="text" readonly="true" path="isbn" class="form-control" id="isbn"
				placeholder="Enter ISBN" />
			<label for="isbn">ISBN</label>
		</div>			
	</div>
	<div class="col-md">
		<div class="form-floating">
			<form:input type="text" path="name" class="form-control" id="name"
				placeholder="Enter Name" />
			<label for="name">Name</label>
		</div>
	</div>
	<div class="col-md">
		<div class="form-floating">
			<form:input type="text" path="author" class="form-control"
				id="author" placeholder="Enter Author" />
		    <label for="author">Author</label>
		</div>
	</div>
	<input class="btn btn-warning" type="submit" value="Update"/>
</form:form>
</div>
</body>
</html>