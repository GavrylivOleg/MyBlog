
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<title>save user</title>
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

	<sf:form modelAttribute="user" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">User name</label>
			<sf:input path="userName" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="userName" />
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label>
			<sf:input path="password" type="password" class="form-control"
				id="exampleInputPassword1" placeholder="password" />
		</div>

		<div class="form-group">
			<label for="exampleInputPassword1">confirmPassword</label>
			<sf:input path="confirmPassword" type="password" class="form-control"
				id="exampleInputPassword1" placeholder="confirmPassword" />
		</div>

		<div class="form-group">
			<label for="exampleInputPassword1">Email</label>
			<sf:input path="email" type="email" class="form-control"
				id="exampleInputPassword1" placeholder="email" />
		</div>

		<div class="form-group">
			<label for="exampleInputPassword1">nickName</label>
			<sf:input path="nickName" type="text" class="form-control"
				id="exampleInputPassword1" placeholder="nickName" />
		</div>

		<button type="submit" class="btn btn-default">Submit</button>
	</sf:form>

	<%-- 
    <sf:form modelAttribute="user" method="post">
        <label>user name</label>
        <sf:input path="userName" size="5"/>
        <label>password</label>
        <sf:input path="password" size="5"/>
        <label>email</label>
        <sf:input path="email" size="5"/>
        <label>phone</label>
        <sf:input path="phone" size="5"/>
        <input type="submit">
    </sf:form> 
    
    --%>

	<sec:authorize access="hasRole('ROLE_ADMIN')">

		<form action="deleteUsers" method="post">
			<input name="usernames" type="text"> <input
				value="delete user" type="submit"> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>


		<c:forEach items="${users}" var="user">
        ${user.userName} -> ${user.email}
        <br>
		</c:forEach>
	</sec:authorize>

</body>
</html>
