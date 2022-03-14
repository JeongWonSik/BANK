<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
	<header>
		<div id="headerWrap"></div>
	</header>
	<main>
		<div id="formWrap">
			<form action="deposit.do" method="post">
				<table>
					<tr>
						<th>입금계좌 타입</th>
						<td>
							<c:choose>
								<c:when test= '${account.accType == "S".charAt(0)}'>
									일반통장
								</c:when>
								<c:otherwise>
									마이너스통장
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>입금 계좌번호</th>
						<td><input type="text" value = "${account.accNumber}" name="addNumber" readonly></td>
					</tr>
					<tr>
						<th>입금액</th>
						<td><input type="text" name="amount" id="depositMoney" placeholder="입금액"></td>
					</tr>
					<tr>
						<th>입금 버튼</th>
						<td><input type="submit" name="button" id="depositButton" value="입금하기"></td>
						<td><input type="button" onclick="#" value="취소하기"/></td>
					</tr>
				</table>
			</form>
		</div>
	</main>
	<footer>
		<div id="footerWrap"></div>
	</footer>
</body>
</html>