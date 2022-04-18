<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">	
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js" ></script>
<link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
<style>
<%@
include
file="/WEB-INF/jsp/common/styles/common.css"%>
</style>
<title>Books v4</title>
</head>
<body class="bg-light">
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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
		
	<div class="col-md-8 order-md-1">
		<h4 class="mb-3">Add Book</h4>

		<c:url var="addBookUrl" value="/v4/book/addBook" />
		<form:form class="row g-2" action="${addBookUrl}" method="post"
			modelAttribute="book">
			<div class="col-md">
				<div class="form-floating">
					<form:input type="text" path="isbn" class="form-control" id="isbn"
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
			<input class="btn btn-primary" type="submit" value="Add" />
		</form:form>
	</div>
	<br>
	<table id="sortTable"
		class="table table-striped table-bordered table-sm">
		<thead>
			<tr>
				<th class="th-sm">ISBN 
					<form:form action="/v4/book/"
						method="get" modelAttribute="sorter" style="all:unset">
						<form:input type="hidden" path="sortBy" value="isbn" />
						<form:input type="hidden" path="order" value="ASC" />
						<button type="submit">
							<i class="fa fa-sort-down"></i>
						</button>
					</form:form>
					<form:form action="/v4/book/"
						method="get" modelAttribute="sorter" style="all:unset">
						<form:input type="hidden" path="sortBy" value="isbn" />
						<form:input type="hidden" path="order" value="DESC" />
						<button type="submit">
							<i class="fa fa-sort-up"></i>
						</button>
					</form:form>
				</th>
				<th>Name 
					<form:form action="/v4/book/" method="get"
						modelAttribute="sorter" style="all:unset">
						<form:input type="hidden" path="sortBy" value="name" />
						<form:input type="hidden" path="order" value="ASC" />
						<button type="submit">
							<i class="fa fa-sort-down"></i>
						</button>
					</form:form>
					<form:form action="/v4/book/" method="get"
						modelAttribute="sorter" style="all:unset">
						<form:input type="hidden" path="sortBy" value="name" />
						<form:input type="hidden" path="order" value="DESC" />
						<button type="submit">
							<i class="fa fa-sort-up"></i>
						</button>
					</form:form>
				</th>
				<th>Author 
					<form:form action="/v4/book/" method="get"
						modelAttribute="sorter" style="all:unset">
						<form:input type="hidden" path="sortBy" value="author" />
						<form:input type="hidden" path="order" value="ASC" />
						<button type="submit">
							<i class="fa fa-sort-down"></i>
						</button>
					</form:form>
					
					<form:form action="/v4/book/" method="get"
						modelAttribute="sorter" style="all:unset">
						<form:input type="hidden" path="sortBy" value="author" />
						<form:input type="hidden" path="order" value="DESC" />
						<button type="submit">
							<i class="fa fa-sort-up"></i>
						</button>
					</form:form>
				</th>
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
					<td data-label="Delete"><form:form id="a"
							action="/v4/book/deleteBook?isbn=${book.isbn}" method="post"
							style="all:unset">
							<input class="btn btn-danger" type="submit" value="Delete"
								style="-universal-margin: 0px" />
						</form:form></td>
					<td data-label="Update"><form:form id="a"
							action="/v4/book/updateBook?isbn=${book.isbn}" method="get"
							style="all:unset">
							<button class="btn btn-warning" name="isbn" type="submit"
								value="${book.isbn}" style="-universal-margin: 0px">Update</button>
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<c:if test="${deleteBookSuccess}">
		<script>
			toastr.success(
					'Successfully deleted book with ISBN ${deletedBookIsbn}',
					'Delete Success')
		</script>
	</c:if>
	<c:if test="${deleteBookFailure}">
		<script>
			toastr.error('Failed to delete book with ISBN ${deletedBookIsbn}',
					'Delete Failure')
		</script>
	</c:if>

	<c:if test="${addBookSuccess}">
		<script>
			toastr.success(
					'Successfully added book with ISBN ${deletedBookIsbn}',
					'Add Success')
		</script>
	</c:if>
	<c:if test="${addBookFailure}">
		<script>
			toastr.error('Failed to add book with ISBN ${deletedBookIsbn}',
					'Add Failure')
		</script>
	</c:if>

	<c:if test="${updateBookSuccess}">
		<script>
			toastr.success(
					'Successfully updated book with ISBN ${deletedBookIsbn}',
					'Update Success')
		</script>
	</c:if>
	<c:if test="${updateBookFailure}">
		<script>
			toastr.error('Failed to update book with ISBN ${deletedBookIsbn}',
					'Update Failure')
		</script>
	</c:if>

</body>
</html>