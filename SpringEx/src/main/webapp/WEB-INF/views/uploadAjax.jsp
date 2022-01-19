<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="../resources/js/uploadAjax.js"></script>
</head>
<body>
	<div><!--가상의 form태그를 만들어 줌-->
        <input type="file" name="uploadFile" multiple>
    </div>
    <input type="submit" value="전송"><!-- submit : form태그의 action으로 가야 함 하지만 form태그가 없으므로 js로 처리해야 한다. -->
   	<div id="uploadResult">
   		<ul></ul>
   	</div>
</body>
</html>