$(function () {
	// 프로그램에서  참조하는 요소를 미리 탐색
	var $checkedDuplicate = $("[name=checkedDuplicate]");
	var $account = $("[name=account]");
	
	// #reg 요소에 submit 이벤트 핸들러 연결
	$("#reg").on("submit", function (event) {
		
		// 사용자가 account의 중복 검사를 했는지 확인
		// checkedDuplicate 입력 요소의 value 속성이 "true"인지 확인
		if ($checkedDuplicate.val() != "true") {
			alert("You should first check if there are duplicate accounts.");
			event.preventDefault();
			return false;
		}
		
		// 입력 양식의 유효성 검사(validation)
		// 사용자가 입력 요소들에게 제대로 값을 입력했는지 확인
		var lenAccount = $account.val().length;
		var lenPasswd= $(this).find("[name=passwd]").val().length;
		var lenName= $(this).find("[name=name]").val().length;
		var lenEmail= $(this).find("[name=email]").val().length;
		
		if (!lenAccount || !lenPasswd || !lenName || !lenEmail){
			alert("You must fill out all input forms!");
			event.preventDefault();
			return false;
		}
	});
	
	// #check-duplicate 요소에 click 이벤트 핸들러 연결
	// Ajax를 이용해 account 중복 검사
	$("#check-duplicate").on("click", function () {
		// account 요소에 입력한 값
		var account = $account.val();
		
		// account 요소에 입력한 값이 없으면 입력하도록 유도
		if (!account.length){
			alert("Enter your account and then check");
			$account.focus();
			return;
		}
		
		// Ajax를 이용해 account가 중복됐는지 확인
		$.getJSON("/pro09/check-duplicate", { account: account }, function (data) {
			// 사용자가 입력한 account가 없는 경우
			if (data.duplicate === false) {
				$checkedDuplicate.val("true");
				alert("You can use the account you entered.");
				$("[name=passwd]").focus();
			}
			else{
			// 사용자가 입력한 account가 이미 있는 경우
				$checkedDuplicate.val("false");
				alert("Duplicate account! Please re-enter!");
				$account.focus().select();
			}
		});
	});
});