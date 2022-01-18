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
	
	$("input[type='submit']").on("click", function(){
		//alert("aaa")
		//가상의 form 태그
		let formData = new FormData();//form태그와 같은 역활을 해주는 객체
		let inputFile=$("input[name='uploadFile']");
		let files=inputFile[0].files;
		console.log(files);
		
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
			url:"uploadAjaxAction",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result){
				alert("upload성공")
				console.log(result)
			}
		})
	})
})
