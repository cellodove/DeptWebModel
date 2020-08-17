<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>부서 정보</title>
<style>
* {
	margin: 4px 0;
}

.controller {
	padding: 25px 0;
	margin: auto;
	width: 840px;
}

table {
	width: 840px;
	margin: 25px 0;
	padding: 20px;
	border-collapse: collapse;
}

#category {
	width: 100px;
	height: 30px;
}

#deptTitle {
	text-align: center;
	background-color: rgb(100, 100, 100);
	width: 800px;
	height: 20px;
	padding: 12px 0;
	color: white;
}

#title {
	width: 700px;
	height: 24px;
}

#content {
	width: 800px;
	height: 400px;
	text-align: left;
}

textarea {
	width: 800px;
	height: 400px;
}

.btn1 {
	width: 100px;
	padding: 5px 12px;
	border: none;
	background-color: rgb(150, 60, 60);
	color: white;
}

btn2 {
	padding: 5px 12px;
	background-color: white;
	border-color: rgb(180, 180, 180);
	border-width: 1px;
}
textarea {
	resize: none;
}
</style>
</head>
<body>
	<div class="controller">
		<div id="deptTitle">
			<b>부서 정보 상세 보기</b>
		</div>
		<form method="post">
			<table>
				<tr>
					<td>부서번호</td>
					<td><input type="text" name="deptno" readonly
						value="<c:out value='${deptDTO.deptno}'/>" /></td>
				</tr>
				<tr>
					<td>부서명</td>
					<td><input type="text" name="dname" 
						value="<c:out value='${deptDTO.dname}'/>" readonly/></td>
				</tr>
				<tr>
					<td>부서 지역</td>
					<td><input type="text" name="loc" 
						value="<c:out value='${deptDTO.loc}'/>" readonly/></td>
				</tr>
				
			
			</table>
		</form>
		<div align="center">
				<a href="Deptdelete.do?deptno=<c:out value='${deptDTO.deptno}'/>">
						<button class="btn1">삭제</button></a>
						
				<a href="Deptupdate.do?deptno=<c:out value='${deptDTO.deptno}'/>">
						<button class="btn1">수정</button>	</a>
		</div>
		<div align="center">
			<a href="List.do">
				<button class="btn2">목록</button>
			</a>
		</div>
	</div>
</body>
</html>