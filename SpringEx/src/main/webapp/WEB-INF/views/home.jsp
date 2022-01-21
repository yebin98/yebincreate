<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %><!-- 세션을 사용하지 않겠다. 세션을 적용한고 싶으면 지우거나 false를 true로 바꾸면 된다. -->
<html>
<head>
	<link rel = "stylesheet" type="text/css" href="resources/css/home.css">
	<script type="text/javascript" src="resources/js/home.js"></script>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
