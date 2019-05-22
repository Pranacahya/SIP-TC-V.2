<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!Doctype html>
<head>
	<title>User testing field</title>
</head>
<body>
	<form:form action="learnProcess" method="GET">
		<input type="text" name="students"
			placeholder="What's your name">
		<input type="submit">
	</form:form>
	
</body>