<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglib.jsp"%>
<%@ include file="/jsp/head.jsp"%>
<%@ include file="/jsp/meta.jsp"%>
<title>TIZEN Web</title>
<script type="text/javascript">
</script>
</head>

<body>
	<div class="navbar">
		<div class="container">
			<div class="navbar-brand"> TIZEN Web</div>
		</div>
	</div>

	<div class="jumbotron">
		<div class="container">
			<h2>Main Page</h2>
			<br />
			<%=new java.util.Date()%>
		</div>
	</div>

	<div class="detail">
		<div class="container">
			<h3>Page Link</h3>
			<h4>
				1. <a href="<c:url value='/dashboard/idpProjectList'/>">Identifying Progress</a>
			</h4>
			<h4>
				2. <a href="<c:url value='/dashboard/bomComponentList'/>">Bill Of Materials - Component</a>
			</h4>
			<h4>
				3. <a href="<c:url value='/dashboard/bomLicenseList'/>">Bill Of Materials - License</a>
			</h4>
		</div>
	</div>
</body>
</html>
