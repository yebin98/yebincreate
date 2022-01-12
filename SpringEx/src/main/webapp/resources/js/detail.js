/**
 * 
 */
$(document).ready(function(){
	// 댓글쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click",function(){
		//alert("aa")
		//모달창을 띄워라
		$(".modal fade").modal("show");
		//$(".modal").Modal("show");
	});
	//bno값
	let bno = $("#bno").html();//시작하자마자 들고와야함
	
	//console.log(replyService);//replyService 함수 호출
	//댓글쓰기 버튼(id값이 modalRegisterBtn)을 클릭하면
	$("#modalRegisterBtn").on("click",function(){
		//alert("aa")
		//console.log($("#aaa").val());
		//replyService.add({replyer:"정자바",reply:"2번 게시판에 대한 댓글쓰기",bno:bno});//인수     자바문법을 자바스크립트 문법으로 바꿈:json
		
		//사용자가 입력한 댓글내용을 저장
		let reply = $("input[name='reply']").val()//클릭할 때 나타나야함
		//사용자가 입력한 댓글작성자를 저장
		let replyer = $("input[name='replyer']").val()//클릭할 때 나타나야함
		
		replyService.add({replyer:replyer,reply:reply,bno:bno});
		
	})
})
let replyService=(function(){//replyService 함수 선언
	//댓글쓰기를 하기 위한 함수 선언
	function add(reply){//매게변수
		//console.log("reply")
		$.ajax({
			url:"/replies/new",//form태그 대신
			type:"post",
			data:JSON.stringify(reply), //JSON.stringify : 자바스크립트의 값을 JSON문자열로 변환
			contentType:"application/json;charset=utf-8",//한글 깨짐 방지
			success:function(){//통신이 정상적으로 성공했으면
				
			},
			error:function(){//통신이 비정상적으로 처리가 되어 error가 있으면
				
			}
		})
	}
	//댓글 목록리스트를하기 위한 함수 선언
	//댓글 수정을 하기 위한 함수 선언
	//댓글 삭제를 하기 위한 함수 선언
	//return {name:"AAAA"};
	return {add:add};
})()
