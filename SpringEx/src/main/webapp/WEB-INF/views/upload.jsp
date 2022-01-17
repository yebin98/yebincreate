<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadAction" method="post" enctype="multipart/form-data"><!-- 파일 업로드나 이미지 업로드를 서버로 전송할 때 사용 -->
		<input type="file" name="uploadFile" multiple><!-- multiple : 파일 여러개 선택 가능 -->
		<input type="submit" value="전송">
	</form>
</body>
</html>