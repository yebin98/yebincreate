/**
 * 폼테그의 serch와 keyword를 가지고 와라 
 */
$(document).ready(function(){
	let actionForm = $("#actionForm")
	// 현재페이지 번호를 클릭하면
	$(".paginate_button a").on("click",function(e){//$("a")로 작성하면 a태그 전부가 선택된다
		//alert("aaa")
		e.preventDefault();
		actionForm.find("input[name='pageNum']").val($(this).attr("href"))// form태그 안에 있는 pageNum 값을 가지고 와라
		// actionForm.find("select[name='search']").val($(this).attr("selected"))
		// actionForm.find("input[name='pageNum']") = <input type="text" name="pageNum" value="${pageMaker.cri.pageNum}"> 
		// val  = ${pageMaker.cri.pageNum}
		// attr("href") = 내가 선택한 값을 ${num}에 넣어라
		actionForm.submit();// form태그 안에 있는 값을 controller로 보내라
		
	})
	//검색버튼을 클릭하면
	$("input[type='submit']").on("click", function(e){
		e.preventDefault();//실제로 구현할 때는 필요없음(test용)
		//pageNum의 값을 1로 설정
		actionForm.find("input[name='pageNum']").val("1")
		actionForm.submit();
	})
	
//	$(".btn btn-primary").on("click",function(){
//		actionForm.find("select[name='search']").val($(this).attr("selected"))
//		actionForm.submit();
//	})
	
//	let search = $("#search")
//
////	$("#search").val(test).prop("selected", true);
//	
//	 if(search == 't'){
//	        $('#t').attr('selected','selected');
//	    } else if(search == 'c'){
//	    	$('#c').attr('selected','selected');
//	    } else if(search == 'w'){
//	    	$('#w').attr('selected','selected');
//	    } else if(search == 'tc'){
//	    	$('#tc').attr('selected','selected');
//	    } else if(search == 'tcw'){
//	        $('#tcw').attr('selected','selected');
//	    }
})
