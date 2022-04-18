
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
<title>Books API</title>
</head>
<body>
<h4 class="mb-3">Books API</h4>

<table class="table">
  <thead>
    <tr>
      <th scope="col">v#</th>
      <th scope="col">FrontEnd</th>
      <th scope="col">BackEnd</th>
      <th scope="col">DB</th>
      <th scope="col">Link</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">v1</th>
      <td>JSP+HTML</td>
      <td>Java Spring Boot</td>
      <td>Java Map</td>
	  <td><button class="btn btn-primary" onclick="location.href='/v1/book/'" type="button">v1</button></td>
    </tr>
    <tr>
      <th scope="row">v2</th>
      <td>JSP+HTML+MinCSS</td>
      <td>Java Spring Boot</td>
      <td>Java Map</td>
	  <td><button class="btn btn-primary" onclick="location.href='/v2/book/'" type="button">v2</button></td>
    </tr>
    <tr>
      <th scope="row">v3</th>
      <td>JSP+HTML+Bootstrap</td>
      <td>Java Spring Boot</td>
      <td>Java Map</td>
	  <td><button class="btn btn-primary" onclick="location.href='/v3/book/'" type="button">v3</button></td>
    </tr>
    <tr>
      <th scope="row">v4</th>
      <td>JSP+HTML+Bootstrap</td>
      <td>Java Spring Boot</td>
      <td>MongoDB</td>
      <td><button class="btn btn-primary" onclick="location.href='/v4/book/'" type="button">v4</button></td>
    </tr>
  </tbody>
</table>
</body>
</html>
