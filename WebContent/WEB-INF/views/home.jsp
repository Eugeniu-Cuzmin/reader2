<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Home</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>

	<div class="page-wrapper">
		<header class="container">
			<a href="${contextPath}/register.html">Register</a> <span>|</span> <a
				href="${contextPath}/login.html">Login</a>
		</header>
		<div class="container">
			<ul>
				<li><a class="btn btn-default" 
					href="${contextPath}/home.html">Home</a></li>
				<li><a class="btn btn-default" 
					href="${contextPath}/users.html">All Users</a></li>
				<li><a class="btn btn-default" 
					href="${contextPath}/stories.html">All Stories</a></li>
			</ul>



		</div>
		<footer class="container"></footer>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
