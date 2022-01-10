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
    <!-- <link rel = "stylesheet" type="text/css" href="../resources/css/dataTable.bootstrap4.css"> -->
	<link rel = "stylesheet" type="text/css" href="../resources/css/sb-admin-2.css">
	
</head>
<body>
	<div class="form-group row">
	    <div class="col-sm-12 mb-3 mb-sm-0">
	    	${detail.title}
	    </div><!-- name="" : 서버에 데이터 연결, model과 연결 -->
	    <div class="col-sm-12 mb-3 mb-sm-0">
	    	${detail.content}
	    </div>
	    <div class="col-sm-12 mb-3 mb-sm-0">
	    	<a href="/board/modify?bno=${detail.bno}">수정</a>
	    	<a href="/board/remove?bno=${detail.bno}">삭제</a>
	    </div>
  	</div>
</body>
</html>