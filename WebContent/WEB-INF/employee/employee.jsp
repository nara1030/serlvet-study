<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원 관리</title>
	<script src="/js/employee/employee.js"></script>	
</head>
<!-- dynamic web project : pom.xml 추가 시 아래와 같이 사용 -->
<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<body>
	<!-- HTML 네이밍 규칙 -->
	<form id="frm">
		<div id="search_condition">
			<input type="text" name="emp_name" id="emp_name" placeholder="이름을 입력하세요.">
			<select name="emp_rank" id="emp_rank">
				<option value="" selected>선택</option>
				<option value="1">대리</option>
				<option value="2">과장</option>
				<option value="3">차장</option>
			</select>
			<input type="button" id="btn" value="검색">
		</div>
	</form>
	<div>
		직원 목록
	</div>
	<table id="grid_table">
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.rank}</td>
			</tr>
		</c:forEach>
	</table>
	
	<table id="grid_template">
		<tr>
			<td class="empId"></td>
			<td class="empName"></td>
			<td class="empRank"></td>
		</tr>
	</table>
</body>
</html>