<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%@ page import="java.net.URLEncoder"%>
<%response.sendRedirect("targetPage.jsp?MyParam="+URLEncoder.encode("Русский текст","UTF-8"));%>


<html>

<head>


<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="resources/css/vertMenu.css">


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>


<title>blog</title>
</head>



<body>

	<div id="main">
		<aside class="leftAside">
			<ul class="drop_vert_menu">

				<c:forEach var="groupArticles" items="${group}">
					<li><a href="#"><span>${groupArticles.groupName}</span></a>
						<ul>

							<c:forEach items="${groupArticles.getGrouplist()}" var="article">
								<li><a href="article/${article.id}"><span>${article.getTitle()}
									</span></a></li>
							</c:forEach>

						</ul>
				</c:forEach>
			</ul>
		</aside>


		<c:forEach var="article" items="${articles}">
			<article>
				<h1>${article.title}</h1>
				<div class="text-article">${fn:substring(article.text,0,300)}
					...</div>
				<div class="fotter-article">
					<%--  <span><a href="article/${article.id}/${article.title}">Читати</a></span> --%>
					<span><a href="article/${article.id}">Читати ,</a></span> <span>автор
						статті:${article.user.getNickName()}</span> <span class="date-article">Дата
						статті: ${article.date}</span>
				</div>
			</article>
		</c:forEach>
	</div>
</body>
</html>

