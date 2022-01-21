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
	<link rel = "stylesheet" type="text/css" href="../resources/css/sb-admin-2.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="../resources/js/list.js"></script>
</head>
<body>
	<h1>게시판 목록 리스트</h1>
	<%-- ${login}<!-- 세션 정보를 가지고 옴 --> --%>
	<c:if test="${login!=null}">
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<a href="/board/write" class="btn btn-primary">글쓰기</a>
		</div>
	</c:if>
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
		    <form id="actionForm" action="/board/list" method="get">
		        <div class="form-control bg-light border-0 small" style="height:50px">
		        	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		        	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				<%-- <input type="text" name="search" value="${pageMaker.cri.search}">
		        	<input type="text" name="keyword" value="${pageMaker.cri.keyword}"> --%>
		            <select name="search" id="search">
	              		<option value="t" id="t"  <c:if test="${pageMaker.cri.search=='t'}"> selected </c:if> >제목</option>
	              		<option value="c" id="c"  <c:if test="${pageMaker.cri.search=='c'}"> selected </c:if> >내용</option>
	              		<option value="w" id="w"  <c:if test="${pageMaker.cri.search=='w'}"> selected </c:if> >작성자</option>
	             		<option value="tc" id="tc"  <c:if test="${pageMaker.cri.search=='tc'}"> selected </c:if> >제목 + 내용</option>
	              		<option value="tcw" id="tcw"  <c:if test="${pageMaker.cri.search=='tcw'}" >selected </c:if> >제목 + 내용 + 작성자</option>
		          	</select>
		          	<input type="text" name="keyword" value="${pageMaker.cri.keyword}">
		          	<input type="submit" value="검색" class="btn btn-primary">
		        </div>
		        <div class="col-sm-12 col-md-7 dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
		        	<ul class="pagination">
		        		<c:if test="${pageMaker.prev}">
		        			<li class="paginate_button page-item previous" id="dataTable_previous">
			        			<a href="${pageMaker.startPage-1}" class="page-link">prev</a>
			        		</li>
		        		</c:if>
			        	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}"><!-- var = 변수명 -->
			        		<li class="paginate_button page-item ">
			        			<a href="${num}" class="page-link">${num}</a>
			        			<!-- <a href="/board/list?pageNum=${num}&amount=${pageMaker.cri.amount}" class="page-link">${num}</a> -->
			        		</li>
			        	</c:forEach>
			        	<c:if test="${pageMaker.next}">
		        			<li class="paginate_button page-item next" id="dataTable_next">
				        		<a href="${pageMaker.endPage+1}" class="page-link">next</a>
				        	</li>
		        		</c:if>
		        	</ul>
		        	  <!-- for(int i=1; i<=10; i++{
		        					System.out.println(i)
		        			}-->
		        </div>
		    </form>
	    </div>
	</div>
	
</body>
</html>