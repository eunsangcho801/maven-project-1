<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglib.jsp"%>
<%@ include file="/jsp/head.jsp"%>
<%@ include file="/jsp/meta.jsp"%>
<title>Related Projects</title>
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
						<td width="400px"><span style="font-size: 24px; color: white;" title="${popTitle}"><tag:limitTag limitLength="50" content="${popTitle}"/></span></td>
						<td><button type="button" class="btn btn-default" onclick="javascript:self.close();">Close</button></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="container">
			<div class=poprow>
				<p><b>Total : ${fn:length(comProject)}</b></p>
				<c:forEach items="${comProject}" var="vo" varStatus="status">
					<span>${vo.name}</span>
					<br />
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
