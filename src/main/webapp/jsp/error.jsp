<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ include file="/jsp/taglib.jsp"%>

<html>
<head>
<%@ include file="/jsp/head.jsp"%>
<%@ include file="/jsp/meta.jsp"%>
<title>TIZEN Web</title>
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-brand" style="color: white;">TIZEN Web</div>
		</div>
	</div>

	<div class="jumbotron">
		<div class="container">
			<h2>Error Page</h2>
			<br />
			<%=new java.util.Date()%>
		</div>
	</div>

	<div class="container">
		<div class="row">
			Error Type : <%= exception.getClass().getName() %><br>
			Error Message : <%= exception.getMessage() %><br>
		</div>
	</div>
</body>
</html>
