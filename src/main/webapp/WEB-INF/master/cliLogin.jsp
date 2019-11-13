<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="/css/signin.css" rel="stylesheet">

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

</head>

<body>

	<div class="container">
		        <img src="/assets/images/KoscomLogo.PNG" style="width: 14rem; height: 4rem;flot:left;margin-bottom: 1%;">
		<form class="form-signin" style="margin-top: 10%;" action='/master/cliLoginCheck'>
			<h2 class="form-signin-heading">회원기업 로그인</h2>
			<input type="hidden" name="quesFormGroupNo" value="${quesFormGroupNo}">
			<p><select class="form-control" id="selectCompany" name="companyNo"
                       style="margin: 0 auto;">
                <option id="choicCompany">회사를 선택하세요.</option>
                <c:forEach var="vo" items="${companyVO}" varStatus="status">
                    <c:set var="index" value="${index + 1}"/>
                    <option name="selCompanyName[${index}]" value="${vo.companyNo}">${vo.companyName}</option>
                    <!-- <p><input type="text" id="companyName" name = "companyName" placeholder="회사명" style = "width: 250px;height:38px;font-size:1.5rem;"></p> -->
                </c:forEach>
            </select></p>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="text" id="inputEmail" name="id" class="form-control"required="" autofocus=""> 
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
			<c:if test="${param.result eq 'fail' }">
	      		<p class="form-error" style="color:red;">
					아이디/패스워드를 확인해 주세요
				</p>
      		</c:if>
			<!-- <div class="checkbox">
				<label> 
				<input type="checkbox" value="remember-me">ID기억하기
				</label>
			</div> -->
			<button class="btn btn-lg btn-primary btn-block" id="login" type="submit">Sign in</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="/assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>