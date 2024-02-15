<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglib.jsp"%>
<%@ include file="/jsp/head.jsp"%>
<%@ include file="/jsp/meta.jsp"%>
<title>Identified License</title>
<script type="text/javascript">
	
</script>
</head>

<body style="overflow-X: hidden">
	<div class="popup">
		<div class="navbar navbar-fixed">
			<div class="container">
				<table width="600px">
					<tr>
						<td width="20px"></td>
						<td width="400px"><span style="font-size: 24px; color: white;">Identified License</span></td>
						<td><button type="button" class="btn btn-default" onclick="javascript:self.close();">Close</button></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="container">
			<br />
			<div class="poprow">
				<c:forEach items="${comLicense}" var="vo" varStatus="status">
					<span>${vo.name}</span> : <fmt:formatNumber value="${vo.license}" /> (${vo.percent}%)<br />
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
