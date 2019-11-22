<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container{
		width:100%;
		margin:0 auto;
	}
	section{
		width:80%;
		margin:0 auto;
	}
	table{
		margin-top:10px;
		width:100%;
	}
	table, td, th{
		border:1px solid black;
		border-collapse: collapse;
		padding:10px;
	}
	th{
		text-align: center;
		width:200px;
	}
	.btnBox {
		font-weight: normal;
		line-height:50px;
		padding:20px;
		text-align: center;
	}
	a{
		color:black;
		text-decoration: none;
	}
	.btn{
		padding:5px 15px;
		margin-top:10px;
		background: #3A3A3A;
		color:white;
		border:1px solid #3A3A3A;
		border-radius: 5px;
	}
	.back{
		padding:5px 15px;
		margin-top:10px;
		background: white;
		color:black;
		border:1px solid #3A3A3A;
		border-radius: 5px;
	}
	.btn:hover{
		color:#D5D5D5;
	}
	.back:hover{
		color:gray;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<script>
$(function(){
		$("#deleteBtn").click(function(){
			var res = confirm("삭제하시겠습니까?");
			
			if(res == true){
				return true;
			}else{
				return false;
			}
		})
	})
</script>
</head>
<body>
	<div id="container">
		<%
			pageContext.include("header.jsp");
		%>
		<section>
			<table>
				<tr>
					<th>프로젝트 이름</th>
					<td>${spms.name }</td>
				</tr>
				<tr>
					<th>프로젝트 내용</th>
					<td>${spms.content }</td>
				</tr>
				<tr>
					<th>시작날짜</th>
					<td><fmt:formatDate value="${spms.startDate }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<th>종료날짜</th>
					<td><fmt:formatDate value="${spms.endDate }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<th>상태</th>
					<td>${spms.state }</td>
				</tr>
			</table>
			
			<div class="btnBox">
				<a href="${pageContext.request.contextPath }/update.do?no=${spms.no}" class="btn">수정</a>
				<a href="${pageContext.request.contextPath }/delete.do?no=${spms.no}" class="btn" id="deleteBtn">삭제</a>
				<a href="${pageContext.request.contextPath }/list.do" class="back">돌아가기</a>
			</div>
		</section>
		<%
			pageContext.include("footer.jsp");
		%>
	</div>	
</body>
</html>
