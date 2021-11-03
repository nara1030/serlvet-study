const _program = {
	login : "/login.do",
}

function login(userId, userPw) {
	const url = _program.login;
	const id = encodeURI(encodeURI(userId), "UTF-8");
	const password = encodeURI(encodeURI(userPw), "UTF-8");
	
	const params = 'userId=' + id + '&userPassword=' + password;
	/*const params = {
			userId : id,
			userPassword : password
	}*/
	
	const xhr = new XMLHttpRequest();
	xhr.open('POST', url, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			
		}
	}
	
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); // 미추가 시 Request Payload 전송
	xhr.send(params);
	
	/*xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send(JSON.stringify(params));*/
}

// window.onload vs. document.onload
window.onload = function() {
	document.getElementById("btn").addEventListener('click', function() {
		var id = document.getElementById("usr_id").value;
		var password = document.getElementById("usr_pw").value;
		
		login(id, password);
	});
};

