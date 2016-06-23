<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<title><title:getAsString name="title" /></title>
</head>
<body>
	<header>
		<title:insertAttribute name="header" />
	</header>
	<div>
		<title:insertAttribute name="body" />
	</div>
	<footer>
		<title:insertAttribute name="footer" />
	</footer>
</body>
</html>