<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



</head>

<body>
	<div id="user-panel">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<sec:authentication property="name" />
			<span><a target="_blanc" href="addGroupArticles">Додати
					категорію статті</a></span>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<span><a target="_blanc" href="addArticle">Додати статтю</a></span>
		</sec:authorize>
		<span><a target="_blanc" href="saveUser">Реєстрація</a></span> <span>
			<a href="login">Вхід в акаунт</a>
		</span>
		<sf:form action="logout" method="post">
			<input type="submit" value="logout">
		</sf:form>
	</div>
</body>
</html>
