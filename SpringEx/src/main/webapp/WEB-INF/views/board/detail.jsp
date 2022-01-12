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
	  <!-- Bootstrap Core CSS -->
    <link rel = "stylesheet" type="text/css" href="../resources/css/bootstrap.css">
    <!-- MetisMenu CSS -->
    <link rel = "stylesheet" type="text/css" href="../resources/css/metisMenu.css">
    <!-- Custom Fonts -->
    <link rel = "stylesheet" type="text/css" href="../resources/css/font-awesome.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="../resources/js/detail.js"></script>
	<script type="text/javascript" src="../resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="../resources/js/metisMenu.js"></script>
	<script type="text/javascript" src="../resources/js/sb-admin-2.js"></script>
</head>
<body>
	<div class="form-group row">
		<div id="bno" class="col-sm-12 mb-3 mb-sm-0">
			<%-- <input type="text" id="aaa" value="${detail.bno}"> --%>
	    	${detail.bno}
	    </div><!-- BoardMapper의sql문장의 id값이 detail인 bno -->
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
	    <div class="panel-body">
	    	<button class="btn btn-primary btn-lg" id="addReplyBtn" data-toggle="modal" data-target="#myModal">
               	댓글 쓰기
            </button>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	             <div class="modal-dialog">
	                 <div class="modal-content">
	                     <div class="modal-header">
	                         <!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
	                         <h4 class="modal-title" id="myModalLabel">댓글</h4>
	                     </div>
	                     <div class="modal-body">
	                         <div>
	                         	<label>Replyer</label>
	                         	<input type="text" name="replyer">
	                         </div>
	                         <div>
	                         	<label>Reply</label>
	                         	<input type="text" name="reply">
	                         </div>
	                     </div>
	                     <div class="modal-footer">
	                     	<button type="button" class="btn btn-primary" id="modalRegisterBtn">댓글쓰기</button>
	                     	<button type="button" class="btn btn-primary" id="">댓글수정</button>
	                     	<button type="button" class="btn btn-primary" id="">댓글삭제</button>
	                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	                     </div>
	                 </div><!-- /.modal-content -->
	             </div><!-- /.modal-dialog -->
         	</div>
	    </div>
  	</div>
</body>
</html>