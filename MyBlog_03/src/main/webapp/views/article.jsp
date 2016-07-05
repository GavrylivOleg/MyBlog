<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<html>
<head>

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




<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>article</title>
</head>
<body>
	<div>
		<h1>${article.title}</h1>
	</div>
	<div>${article.text}</div>
	<div>
		<h4>Автор статті:${user.nickName}</h4>
	</div>
	
<%-- 	<div>${message.messageText}</div> --%>

	<span>Коментарі:</span>
	<c:forEach items="${message}" var="message">
	
								<div> ${message.getMessageText()}</div>
								
								<div> Автор : ${message.getUser().getNickName() }</div>
							</c:forEach>
	
	<sf:form modelAttribute="message" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Написати коментарій :</label>
			<textarea name="messageText" class="form-control" rows="2"></textarea>
		</div>


		<button type="submit" class="btn btn-default">Submit</button>
	</sf:form>
	
	
	
	
	
	
</body>
</html>

<style  type="text/css" >
body{
    width: 96%;
    margin-left: 2%;
}
header{
    height: 150px;
    border-radius: 5px;
    background: #ccccff
}
#top-image{
    height: 130px;
    width: 130px;
    top: 20px;
    background: #6699ff;
    position: absolute;
    left: 5%;
    border-radius: 5px;
}
#user-panel{
    position: absolute;
    top: 20px;
    right: 5%;
    padding: 10px;
    background: #9999ff;
    border-radius: 5px;
}
#user-panel img{
    width: 25px;
    height: 25px;
}
#main{
    margin-top: 3px;
}
#main .leftAside{
    float: left;
    position: relative;
    width: 250px;
    background: #ccccff;
    border-radius: 5px;
    height: 100%;
}
#main .leftAside p{
    width: 96%;
    margin-left: 2%;
    text-align: justify;
}
#main .leftAside h2{
    margin: 0px;
    margin-left: 2%;
    margin-top: 2%;
    width: 96%;
    padding: 5px 0px 5px 0px;
    border-radius: 5px 5px 0px 0px;
    background: #76a5fc;
    text-align: center;
}
#main .leftAside ul{
    margin: 0px;
    margin-left: 2%;
    margin-bottom: 2%;
    padding: 0px;
    width: 96%;
    list-style: none;
}
#main .leftAside ul li{
    margin: 0px;
    cursor: pointer;
    background: #76befc;
    padding: 7px 5px;
    border: 1px solid #6666ff;
    border-bottom: none;
}
#main .leftAside ul li:hover{
    -moz-transition: all 1s linear 0s;
    -webkit-transition: all 1s linear 0s;
    -o-transition: all 1s linear 0s;
    transition: all 1s linear 0s;
    background: #cce6fc;
    padding-left: 10%;
}
#main .leftAside ul li:first-child{
    
}
#main .leftAside ul li:last-child{
    border-bottom: 1px solid #6666ff;
    border-radius: 0px 0px 5px 5px;
}
#main .leftAside a{
    text-decoration: none;
    padding: 3px 2px;
}
#main article{
    margin-left: 260px;
    margin-bottom: 5px;
    background: #80abdb;
    border: 1px solid #40658d;
    border-radius: 5px;
}
#main article h1{
    font-size: 2em;
    padding: 3px 5px;
    margin: 0px;
    border-radius: 5px 5px 0px 0px;
}
#main article .text-article{
    padding: 5px;
    font-size: 15px;
    background: #cce6fc;
}
#main article .text-article label{
   margin-right: 10px;
}
#main article .fotter-article{
    height: 23px;
    background: #8babce;
    border-radius: 0px 0px 5px 5px;
    padding: 3px;
}
#main article .date-article, .read{
    float: right;
    margin-left: 10px;
}
footer{
    height: 80px;
    background: #6184aa;
    border-radius: 0px 0px 5px 5px;
    vertical-align: central;
}
footer div{
    padding-top: 35px;
    font-weight: bold;
    padding-left: 10px;
}
footer span {
    margin-right: 15px;
}

</style>

