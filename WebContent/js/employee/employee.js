const _program = {
	search : "/employee.do",
}

function search(empName, empRank) {
	const url = _program.search;
	const name = encodeURI(encodeURI(empName), "UTF-8");
	const rank = encodeURI(encodeURI(empRank), "UTF-8");
	const queryString = '?empName=' + name + '&empRank=' + rank;
	
	const xhr = new XMLHttpRequest();
	// xhr.open('GET', url + queryString, true);
	xhr.open('GET', url + queryString);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			// document.getElementsByTagName('html')[0].innerHTML = xhr.responseText;
		}
	}
	// xhr.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
	
	xhr.send();
}

// window.onload vs. document.onload
window.onload = function() {
	document.getElementById("btn").addEventListener('click', function() {
		var name = document.getElementById("emp_name").value;
		var rank = document.getElementById("emp_rank").value;
		
		search(name, rank);
	});
};

