
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>add group articles</title>
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
</head>

<body>


	<sf:form modelAttribute="groupArticles" method="post">

		<div class="form-group">
			<label for="exampleInputEmail1">name</label>
			<sf:input path="groupName" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="title of article" />
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</sf:form>


	<form action="deleteGroupArticles" method="post">
		<input name="nameGroup" type="text"> <input
			value="delete article" type="submit"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

	<c:forEach items="${groups}" var="group">
       ${group.groupName}
        <br>
	</c:forEach>



</body>
</html>



