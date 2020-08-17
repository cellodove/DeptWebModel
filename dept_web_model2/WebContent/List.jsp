<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서정보 조회</title>
<style>
.controller {
	padding: 25px 0;
	margin: auto;
	width: 840px;
	text-align: center;
}
table {
	width: 840px;
	padding: 10px 0;
	border-collapse: collapse;
}
th {
	background-color: rgb(100, 100, 100);
	color: white;
}
button {
	margin: 4px 0;
	padding: 10px 0;
	width: 840px;
	background-color: rgb(255, 80, 80);
	color: white;
	border: none;
}
a {
	text-decoration: none;
	color: black;
}
a:hover {
	text-decoration-line: underline;
}
</style>
</head>
<body>
<div class="controller">
<table>
<tr>
<th width="100px">부서번호</th>
<th width="100px">부서명</th>
<th width="100px">부서 주소</th>
</tr>
<tr>
<c:forEach var="deptlist" items="${deptlist}">
	<td><c:out value="${deptlist.deptno}" /></td>	
	<td><b><a href="Listview.do?deptno=<c:out value="${deptlist.deptno}" /> "><c:out value="${deptlist.dname}" /></a></b></td>
	<td><c:out value="${deptlist.loc}" /></td>
	</tr>
</c:forEach>
</table>
<p>
<button onclick="location.href='./Insert_view.do'">글쓰기</button><br />

</p>
</div>
</body>
</html>