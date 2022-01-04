<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% System.out.println("abcd"); %>
</head>
<body>
<%@ include file="header.jsp" %>
	hello!!!
	index.jsp파일입니다.
<!-- <a href="서버주소?변수명=값"></a> -->
<a href="/sample/member?id=abcd&pw=1234&name=정자바">회원가입</a>
<!-- http://localhost:8080/%서버주소?id=abcd&pw=1234&name=정자바 -->

<!-- <form action="서버주소" method="get">
	<div>id:<input type="text" name="id" value="abcd"></div>
	<div>pw : <input type="password" name="pw" value="1234"></div>
	<div>name:<input type="text" name="name" value="정자바"></div>
	<input type="submit" value="회원가입">
</form>
<!-- http://localhost:8080/%서버주소?id=abcd&pw=1234&name=정자바 -->

<form action="/sample/memberDTO" method="get">
	<div>id:<input type="text" name="id" value="abcd"></div>
	<div>pw : <input type="password" name="pw" value="1234"></div>
	<div>name:<input type="text" name="name" value="정자바"></div>
	<input type="submit" value="회원가입">
</form>
<!-- http://localhost:8080/%서버주소 -->
</body>
</html>