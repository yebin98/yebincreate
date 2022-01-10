<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- for문을 사용하기 위한 문법 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel = "stylesheet" type="text/css" href="../resources/css/all.css">
	<link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link rel = "stylesheet" type="text/css" href="../resources/css/dataTable.bootstrap4.css">
	<link rel = "stylesheet" type="text/css" href="../resources/css/sb-admin-2.css">
	<!-- <script type="text/javascript" src="resources/js/write.js"></script> -->
</head>
<body>
	<h1>게시판 목록 리스트</h1>
	<div class="card-body">
	    <div class="table-responsive">
	        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	            <thead>
	                <tr>
	                    <th>게시판번호</th>
	                    <th>제목</th>
	                    <th>작성자</th>
	                    <th>작성일</th>
	                    <th>조회수</th>
	                    <th>좋아요</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${list}" var="board"><!-- items=배열길이만큼 반복해라 -->
	            	<!-- for문과 비슷 -->
	            		<tr>
		                    <td>${board.bno}</td>
		                    <td><a href="/board/detail?bno=${board.bno}">${board.title}</a></td>
		                    <td>${board.writer}</td>
		                    <td>${board.regdate}</td>
		                    <td>${board.cnt}</td>
		                    <td>${board.good}</td>
		                </tr>
	            	</c:forEach>
	            </tbody>
	        </table>
		    <form action="" method="get">
		        <div class="form-control bg-light border-0 small" style="height:50px">
		            <select name="search" id="">
	              		<option value="t">제목</option>
	              		<option value="c">내용</option>
	              		<option value="w">작성자</option>
	             		<option value="tc">제목 + 내용</option>
	              		<option value="tcw">제목 + 내용 + 작성자</option>
		          	</select>
		          	<input type="text" name="keyword">
		          	<input type="submit" value="검색" class="btn btn-primary">
		        </div>
		        <div>
		        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}"><!-- var = 변수명 -->
		        		<ul>
		        			<li>${num}</li>
		        		</ul>
		        	</c:forEach>
		        	  <!-- for(int i=1; i<=10; i++{
		        					System.out.println(i)
		        			}-->
		        </div>
		    </form>
	    </div>
	</div>           
</body>
</html>