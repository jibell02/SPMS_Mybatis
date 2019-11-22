<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="css/common.css"> -->
<style>
	#container{
		width:100%;
		margin:0 auto;
	}
	section{
		width:80%;
		margin:0 auto;
	}
	table {
		margin-top: 10px;
		width: 800px;
	}
	table, td, th {
		padding: 10px;
	}
	th {
		width:150px;
		text-align: right;
	}
	th:last-child {
		text-align: center;
	}
	th:last-child input{
		padding:5px 15px;
		margin-top:10px;
		background: #3A3A3A;
		color:white;
		border:1px solid #3A3A3A;
		border-radius: 5px;
	}
	th:last-child input:hover{
		color:#D5D5D5;
	}
</style>
</head>
<body>
	<div id="container">
		<%
			pageContext.include("header.jsp");
		%>
		<section>
			<form action="insert.do" method="post">
				<table>
					<tr>
						<th>프로젝트 이름</th>
						<td>
							<input type="text" name="name">
						</td>
					</tr>
					<tr>
						<th>프로젝트 내용</th>
						<td>
							<textarea rows="7" cols="70" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<th>시작날짜</th>
						<td>
							<input type="date" name="startDate">
						</td>
					</tr>
					<tr>
						<th>마감날짜</th>
						<td>
							<input type="date" name="endDate">
						</td>
					</tr>
					<tr>
						<th>상태</th>
						<td>
							<select name="state">
								<option>준비</option>
								<option>진행중</option>
								<option>종료</option>
								<option>보류</option>
							</select>
						</td>
					</tr>
					<tr>
						<th colspan="2">
							<input type="submit" value="저장">
							<input type="reset" value="취소">
						</th>
					</tr>
				</table>
			</form>
		</section>
		<%
			pageContext.include("footer.jsp");
		%>
	</div>	
</body>
</html>
