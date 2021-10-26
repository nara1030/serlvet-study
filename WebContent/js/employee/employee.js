const _program = {
	search : "/employee.json",
}

function search(empName, empRank) {
	const url = _program.search;
	const name = encodeURI(encodeURI(empName), "UTF-8");
	const rank = encodeURI(encodeURI(empRank), "UTF-8");
	const queryString = '?empName=' + name + '&empRank=' + rank;
	
	const xhr = new XMLHttpRequest();
	xhr.open('GET', url + queryString, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//console.log(xhr.responseText);
			const data = JSON.parse(xhr.responseText);
			
			document.getElementById("grid_table").innerHTML = "";
			
			// let str = "";
			let trs = [];
			if (data.length !== 0) {
				for (let i = 0, len = data.length; i < len; i++) {
					/*
					str += "<tr><td>";
					str += data[i].id;
					str += "</td>";
					str += "<td>";
					str += data[i].name;
					str += "</td>";
					str += "<td>";
					str += data[i].rank;
					str += "</td></tr>";
					*/
					
					trs[i] = document.querySelector("#grid_template tr").cloneNode(true); // true를 줘야 자식 노드까지 복제
					trs[i].querySelector(".empId").innerText = data[i].id;
					trs[i].querySelector(".empName").innerText = data[i].name;
					trs[i].querySelector(".empRank").innerText = data[i].rank;
					
					document.getElementById("grid_table").appendChild(trs[i]);
				}
			}
			
			// document.getElementById("grid_table").innerHTML = str;
		}
	}
	// xhr.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
	
	xhr.send();
}

// window.onload vs. document.onload
window.onload = function() {
	document.getElementById("grid_template").style.display = "none";
	
	document.getElementById("btn").addEventListener('click', function() {
		var name = document.getElementById("emp_name").value;
		var rank = document.getElementById("emp_rank").value;
		
		search(name, rank);
	});
};

