$(document).ready(function(){
	
	// 파일의 크기와 확장자를 검사하는 함수
	
	// 서버에서 설정해 놓은 파일크기 설정
	let maxSize=5242880;//5MB
	// 서버에서 허용 불가능한 확장자 설정(정규식) : 규칙(파일 검증)
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	
	function checkExtension(fileSize,fileName){//파일크기 ,확장자
		//사용자가 선택한 파일의 크기사 서버에서 설정해 놓은 파일의 크기보다 이상이면,
		if(fileSize>=maxSize){//사용자가 선택한 파일크기>=서버에서 설정해 놓은 파일크기
			alert("파일 사이즈 초과")
			return false;
		}
		//사용자가 선택한 파일의 확장자가 서버에서 설정해 놓은 화질의 확장자와 일치하지 않으면,
		if(regex.test(fileName)){
			//실행하지 마라
			alert("해당 종류의 파일은 업로드 할 수 없습니다.")
			return false;
		}
		return true;
	}
	let formObj = $("form[role='form']")// form태그가 있어 그걸 가지고옴으로써 밑에 있는 가상의form태그의 역활을 한다.
	//글쓰기 버튼을 클릭하면
	$("input[type='submit']").on("click",function(e){
		e.preventDefault();
		var str="";
		//li태그에 있는
		$("#uploadResult ul li").each(function(i,obj){
			console.log(obj);
			//data선택자를 이용하여 input태그의 value값으로 셋팅
			/*
			 * data함수
			 * <span>
			 * $("span").data("age",13) => <span data-age="13"> data함수 괄호안에 매개변수가 두개면 setter
			 * <span data-age="13">
			 * $("span").data("age") => 13 data함수 괄호안에 매개변수가 두개면 getter
			 * */
			str+="<input type='hidden' name='attachList["+i+"].fileName' value='"+$(obj).data("filename")+"'>"
			str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+$(obj).data("uuid")+"'>"
			str+="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+$(obj).data("path")+"'>"
			str+="<input type='hidden' name='attachList["+i+"].image' value='"+$(obj).data("type")+"'>"
		})
		formObj.append(str).submit();// append : insert append를 통해서 jsp의 제목작성란, 내용작성란(board/write)과 위의 내용이 합처졌다.
		//html : 덮어쓰기
	})
	//파일 선택의 내용이 변경되면
	$("input[type='file']").on("change", function(e){
//		alert("aaa")	
//		//가상의 form 태그
		let formData = new FormData();//form태그와 같은 역활을 해주는 객체
		let inputFile=$("input[name='uploadFile']");
		let files=inputFile[0].files;
		console.log(files);

		e.preventDefault();
		//console.log("aa");
		for(let i=0; i<files.length; i++){
			//파일의 크기가 이상이면
			if(!checkExtension(files[i].size,files[i].name)){
				//밑에 있는거 하지 마라
				return false;
			}
			formData.append("uploadFile",files[i]);//append: 데이터를  뒤에서 부터 차례로 배열로 저장(뒤에 차례로 누적) 
		}
		
		//ajax를 이용해서 컨트롤러 연결
		//formData자체를 데이터로 전송하고, formData를 데이터로 전송할 때에는 processData와 contentType이 반드시 false이여야 함.
		$.ajax({
			url:"/uploadAjaxAction",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result){//사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후 : 콜백함수
				alert("upload성공")
//				console.log(result)//result : Array=>배열
//				console.log(result[0].fileName)
//				console.log(result[1].fileName)
//				console.log(result[2].fileName)
//				showUploadedFile함수 호출
				showUploadedFile(result);
			}
		})//$.ajax끝
	})
})//$(document).ready(function(){ 끝

//사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후 웹브라우저에 파일을 띄워라에 대한 함수 선언(showUploadedFile)
function showUploadedFile(uploadresultArr){
	var str="";
	$(uploadresultArr).each(function(i,obj){//each : 제이쿼리 for문
		console.log(obj)
		if(!obj.image){//사용자가 업로드한 파일의 타입이 이미지가 아니면(excel파일, ppt파일)
			var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
			str+="<li data-path='"+obj.uploadPath+"'";
			str+="data-uuid='"+obj.uuid+"'data-filename='"+obj.fileName+"'data-type='"+obj.image+"'>"; 
			str+="<a href='/download?fileName="+fileCallPath+"'>"+obj.fileName+"</a></li>"
		}else{//사용자가 업로드한 파일의 타입이 이미지이면(.jpg .png .gif)
			var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);//\ 표시를 /로 바꿔줌
			console.log(fileCallPath)
			//img태그를 사용해서 웹브라우저 이미지 출력
			//str+="<li>"+"이미지파일"+"</li>"
			str+="<li data-path='"+obj.uploadPath+"'";
			str+="data-uuid='"+obj.uuid+"'data-filename='"+obj.fileName+"'data-type='"+obj.image+"'>"; 
			str+="<img src='/display?fileName="+fileCallPath+"'></li>"
		}
	})
	$("#uploadResult ul").html(str)
}