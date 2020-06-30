//스크립트 링크가 바디 위에 있따면 window의 load 이벤트 안에 작성
window.addEventListener('load',function(event){
	//id를 가지고 필요한 객체들을 찾아오기
	var registerform = document.getElementById("registerform");
	var msg = document.getElementById("msg");
	var useremail = document.getElementById("useremail");
	var emailmsg = document.getElementById("emailmsg");
	var userpassword = document.getElementById("userpassword");
	var passwordmsg = document.getElementById("passwordmsg");
	var passwordchk = document.getElementById("passwordchk");
	var username = document.getElementById("username");
	var namemsg = document.getElementById("namemsg");
	var usergender = document.getElementById("usergender");
	var userimage = document.getElementById("userimage");
	var registerbtn = document.getElementById("registerbtn");
	var mainbtn = document.getElementById("mainbtn");
	
	mainbtn.addEventListener('click',function(event){
		location.href = "../";
	});
	
	//email 중복 검사 통과 여부를 저장할 변수
	var emailCheck = false;
	
	//email을 작성하고 포커스가 떠나면 중복 검사를 실행
	useremail.addEventListener('focusout',function(event){
		if(useremail.value.trim().length==0){
			emailmsg.innerHTML = "이메일을 입력해주세요";
			emailmsg.style.color = "red";
			//검사하지 않고 리턴
			return;
		}
		//ajax 요청 객체를 생성
		var request = new XMLHttpRequest();
		//요청 생성
		request.open('get','emailcheck'+'?'+'useremail='+useremail.value,true);
		//요청 전송
		request.send('');
		//결과를 받기 위한 부분 생성
		request.addEventListener('load',function(event){
			//결과를 파싱
			var data = JSON.parse(event.target.responseText);
			if(data.result == true){
				emailmsg.innerHTML = "사용가능한 이메일";
				emailmsg.style.color = "blue";
				//email 중복 검사를 통과 했다고 표시
				emailCheck = true;
			}else{
				emailmsg.innerHTML = "사용중인 이메일";
				emailmsg.style.color = "red";
				//email 중복 검사를 통과 못했다고 표시
				emailCheck = false;
			}
		});
	});
	
	var nameCheck = false;
	username.addEventListener('focusout',function(event){
		//입력한 내용이 없을 때는 검사하지 않음
		if(username.value.trim().length<1){
			namemsg.innerHTML = "이름을 입력해주세요";
			namemsg.style.color = "red";
			nameCheck = false;
			//검사하지 않고 리턴
			return;
		}
		var request = new XMLHttpRequest();
		request.open('get','namecheck?username='+username.value,true);
		request.send('');
		
		request.addEventListener('load',function(event){
			//결과를 파싱
			var data = JSON.parse(event.target.responseText);
			if(data.result == true){
				//메시지 출력
				namemsg.innerHTML = '사용 가능한 이름';
				namemsg.style.color = 'green';
				//표시
				nameCheck = true;
				
			}else{
				//메시지 출력
				namemsg.innerHTML = '이미 사용중인  이름';
				namemsg.style.color = 'red';
				//표시
				nameCheck = false;
			}
		});
	});
	
	//회원가입 버튼을 누르면
	registerbtn.addEventListener('click',function(event){
		//폼의 데이터를 전송할 때는 유효성 검사를 해주어야 합니다.
		//필수 항목 검사, 형식에 맞는지 , 값의 제한이 있는 경우 그 값인지 등
		if(useremail.value.trim().length<1){
			emailmsg.innerHTML = "이메일은 필수 항목입니다.";
			emailmsg.style.color = "red";
			return;
		}
		//형식 검사 - 정규식 사용
		var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(emailRegExp.test(useremail.value) == false){
			
			emailmsg.innerHTML = "이메일 형식에 맞지 않습니다.";
			emailmsg.style.color = "red";
			return;
		}
		if(emailCheck == false){
			emailmsg.innerHTML = "이미 가입된 이메일 입니다.";
			emailmsg.style.color = "red";
			return;
		}
				
	});
	
});