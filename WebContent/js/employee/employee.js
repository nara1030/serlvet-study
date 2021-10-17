// window.onload vs. document.onload
window.onload = function() {
	document.getElementById("btn").addEventListener('click', function() {
		var name = document.getElementById("emp_name").value;
		console.log(name);
	});
};