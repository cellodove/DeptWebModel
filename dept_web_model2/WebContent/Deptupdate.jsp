<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 수정</title>
<style>
* {
	margin: 4px 0;
}

.controller {
	padding: 25px 0;
	margin: auto;
	width: 840px;
}

#updateTitle {
	text-align: center;
	background-color: rgb(100, 100, 100);
	width: 800px;
	height: 20px;
	padding: 12px 0;
	color: white;
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

#title {
	width: 700px;
	height: 24px;
}

textarea {
	width: 800px;
	height: 400px;
}

.button {
	width: 100px;
	padding: 5px 12px;
	border: none;
	background-color: rgb(150, 60, 60);
	color: white;
}

button {
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
		<div id="updateTitle">
			<b>부서 정보 수정</b>
		</div>
		<form action="./Deptupdate_save.do" method="post">
			<table>
			<tr>
					<td>부서번호</td>
					<td><input type="text" name="deptno"
						value="<c:out value='${deptDTO.deptno}'/>" readonly/></td>
				</tr>
				<tr>
					<td>부서명</td>
					<td><input type="text" name="dname"
						value="<c:out value='${deptDTO.dname}'/>" /></td>
				</tr>
				<tr>
					<td>부서 지역</td>
					<td><input type="text" name="loc" value="<c:out value='${deptDTO.loc}'/>" />
					</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="작성"
						class="button"></td>
					<td align="center"><input type="reset" value="내용 초기화"
						class="button"></td>
				</tr>
			</table>
			<div style="display: none;">
				<input type="text" name="deptno" value="<c:out value='${deptDTO.deptno}'/>" />
			</div>
		</form>
		<div align="center">
			<a href="./List.do">
				<button>리스트</button>
			</a>
		</div>
	</div>
</body>
</html>