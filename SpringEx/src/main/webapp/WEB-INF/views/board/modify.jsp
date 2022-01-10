<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type="text/css" href="../resources/css/all.css">
	<link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
	<link rel = "stylesheet" type="text/css" href="../resources/css/sb-admin-2.css">
</head>
<body>
	<h1>글 수정화면 입니다.</h1>
	<form action="/board/modify" method="post">
		<div class="form-group row">
			 <div class="col-sm-12 mb-3 mb-sm-0">
		        <input type="text" value="${detail.bno}" name="bno" class="form-control form-control-user" id="exampleFirstName"
		            placeholder="title" readonly>
		    </div><!-- name="" : 서버에 데이터 연결, model과 연결 -->
		    <div class="col-sm-12 mb-3 mb-sm-0">
		        <input type="text" value="${detail.title}" name="title" class="form-control form-control-user" id="exampleFirstName"
		            placeholder="title">
		    </div><!-- name="" : 서버에 데이터 연결, model과 연결 -->
		    <div class="col-sm-12 mb-3 mb-sm-0">
		    	<textarea rows="10" cols="20" name="content" class="form-control form-control-user" id="exampleFirstName" placeholder="content">${detail.content}</textarea>
		    </div>
		    <div class="col-sm-12 mb-3 mb-sm-0">
		    	<!-- <span class="text">글쓰기</span> -->
		    	<input type="submit" value="글수정" class="btn btn-primary btn-icon-split">
		    </div>
       </div>
	</form>
</body>
</html>