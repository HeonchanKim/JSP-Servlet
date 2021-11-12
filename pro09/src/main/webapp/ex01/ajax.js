// document 객체의 ready 이벤트 핸들러 연결
$(function () {
	// 프로그램에서 참조하는 요소를 미리 탐색
	var $log = $("#log");
	
	// .request 요소에 click 이벤트 핸들러 연결
	$(".request").on("click", function () {
		// click 이벤트가 발생한 요소의 data-type 속성을 참조
		var type = $(this).attr("data-type");
		
		$log.append("REQUEST: dataType = " + type + "\n");
		
		// AjaxServlet으로 요청
		$.ajax({
			url: "/pro09/ajax", 		// Ajax 요청을 보낼 URL
			type: "get",				// GET 방식 으로 요청
			data: {"type": type },		// 요청 매개변수
			dataType: type, 			// 응답 받을 데이터의 형식
			
			complete: function (_jqXHR, textStatus) {
				$log.append("COMPLETE: " + textStatus + "\n");
			},
			
			success: function (data) {
				var result = data;
				
				$log.append("SUCCESS: type = " + type + "\n");
				
				if (type == "text")
					result = data.trim();
				else if (type == "xml") {
					var $response = $(data).find("response");
					var value = $response.find("type").text();
					
					result = "type = " + value;
				}
				else if(type == "json")
					result = "type = " + data.type;
					
				$log.append("SUCCESS: " + result + "\n");
			},
			
			error: function (_jqXHR, textStatus) {
				$log.append("ERROR: " + textStatus + "\n");
			}
		});
	});
});