<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglib.jsp"%>
<%@ include file="/jsp/head.jsp"%>
<%@ include file="/jsp/meta.jsp"%>
<title>TIZEN Web</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnBom").bind('click', function () {
			location.assign("bomComponentList?platformVersion="+$("select option:selected").val());
		});

		$("#btnExcel").bind('click', function () {
			var status = $(':radio[name="rdoStatus"]:checked').val();
			location.assign("../excel/excelDown?target=idpProjectList&platformVersion="+$("select option:selected").val()+"&status="+status);
		});		

		$("#platformVersion").bind('change', function () {
			location.assign("idpProjectList?platformVersion="+$("select option:selected").val());
		});

		$(':radio[name="rdoStatus"]').bind('click', function () {
			var status = $(':radio[name="rdoStatus"]:checked').val();
			location.assign("idpProjectList?platformVersion="+$("select option:selected").val()+"&status="+status);
		});
		
		// $(':radio[name="rdoStatus"]:radio[value="${status}"]').attr("checked",true);
				
		// $("#listTable").stupidtable();
		
		/*
		$("#listTable thead tr th").bind('mouseover', function () {
			$(this).css("background-image","url(../images/title_bg2.gif)");
		});
		
		$("#listTable thead tr th").bind('mouseout', function () {
			$(this).css("background-image","url(../images/title_bg.gif)");
		});
		*/
	});
	
	function openLicensePop()
	{
		var licenseWin = window.open("../popup/licensePop?platformVersion="+$("select option:selected").val(), 'popName', 'scrollbars=yes, width=640, height=600, resizable=no');
	    if (window.focus) {licenseWin.focus();}
	    if (!licenseWin.closed) {licenseWin.focus();}
	}
</script>
</head>

<body>
	<div class="navbar">
		<div class="container">
			<div class="navbar-brand">TIZEN Web</div>
		</div>
	</div>
	
	<div class="jumbotron">
		<div class="container">
			<h2 id="title">Identifying Progress</h2>
			<table>
				<tbody>
					<tr>
						<th align="left" width="450">
							<span id="span">Platform Version : </span> 
							<select id="platformVersion" name="platformVersion">
								<option value="">Select Platform Version</option>
								<c:forEach items="${tizenVerList}" var="vo" varStatus="status">
								<option value="${vo.code}"<c:if test="${platformVersion == vo.code}"> selected</c:if>>${vo.name}</option>
								</c:forEach>
							</select>
						</th>
						<th align="right">
							<button id="btnIdp" type="button" class="btn btn-primary">Identifying Progress</button>&nbsp;&nbsp;
							<button id="btnBom" type="button" class="btn btn-default">Bill Of Materials</button>
						</th>						
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Summary -->
	<div class="summary">
		<div class="container">
			<h3>Summary</h3>
			<table class="sortable table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th align="center" width="100">Project</th>
						<th align="center" width="100">Owners</th>
						<th align="center" width="140">Status</th>
						<th align="center" width="120">Total Files</th>
						<th align="center" width="120">Matched Files</th>
						<th align="center" width="130">Pending Files</th>
						<th align="center" width="390">Identified License</th>
						<th align="center" width="100">Conflict</th>
					</tr>
				</thead>
				<tbody>
					<tr class="even">
						<td align="center">${idpSummary.cnt}</td>
						<td align="center">${idpSummary.owner}</td>
						<td align="left">
							<c:forEach items="${comStatus}" var="vo" varStatus="status">
								${vo.status}: ${vo.cnt}<br />
							</c:forEach> 
							<c:if test="${fn:length(comStatus) == 0}">-</c:if>
						</td>
						<td align="center"><fmt:formatNumber value="${idpSummary.totalFiles}" /></td>
						<td align="center"><fmt:formatNumber value="${idpSummary.matchedFiles}" /></td>
						<td align="center"><fmt:formatNumber value="${idpSummary.pendingFiles}" /> (${idpSummary.pendingPercent}%)</td>
						<td align="left">
							<c:forEach items="${comLicense}" var="vo" varStatus="status" begin="0" end="4">
								${vo.name}: <fmt:formatNumber value="${vo.license}" /> (${vo.percent}%) <br />
							</c:forEach>
							<c:if test="${fn:length(comLicense) > 5}"><a href="#" onclick="openLicensePop()" style="color: blue;">+ more</a></c:if> 
							<c:if test="${fn:length(comLicense) == 0}">-</c:if>
						</td>
						<td align="center"><fmt:formatNumber value="${idpSummary.conflict}" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<br />
	<!-- Summary End -->

	<!-- Detail -->
	<div class="detail">
		<div class="container">
			<h3>Detail (Total ${fn:length(idpList)} projects)</h3>		
			<table class="search">
				<tbody>
					<tr>
						<th align="left" width="70%">
							Status :
							<input type="radio" name="rdoStatus" value="all" <c:if test="${status eq 'all'}">checked="checked"</c:if>>All
							<input type="radio" name="rdoStatus" value="Done" <c:if test="${status eq 'Done'}">checked="checked"</c:if>> Done
							<input type="radio" name="rdoStatus" value="In Progress" <c:if test="${status eq 'In Progress'}">checked="checked"</c:if>> In Progress
							<input type="radio" name="rdoStatus" value="Not Analyzed" <c:if test="${status eq 'Not Analyzed'}">checked="checked"</c:if>> Not Analyzed
						</th>						
						<th>  
						</th>
						<th align="right" width="10%">
							<button id="btnExcel" type="button" class="btn btn-sm btn-default">Excel Down</button>
						</th>
					</tr>
				</tbody>
			</table>				
			<table id="listTable" class="sortable table table-hover table-striped table-bordered">
				<thead>
					<tr style="cursor: pointer;">
						<th data-sort="string" align="center" width="200">Project Name</th>
						<th data-sort="string" align="center" width="100">Owner</th>
						<th data-sort="string" align="center" width="100">Status</th>
						<th data-sort="string" align="center" width="100">Last Analyzed</th>
						<th data-sort="string" align="center" width="100">Last Modified</th>
						<th data-sort="int" align="center" width="100">Total files</th>
						<th data-sort="int" align="center" width="100">Matched files</th>
						<th data-sort="int" align="center" width="100">Pending files</th>
						<th data-sort="string" align="center" width="180">Default License</th>
						<th data-sort="int" align="cente65r" width="100">Conflict License</th>
						<th data-sort="string" align="center" width="40">git</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${idpList}" var="idp" varStatus="status">
						<tr <c:if test="${status.count%2 != 0}"> class="even"</c:if><c:if test="${status.count%2 == 0}">class="odd"</c:if>>
							<td align="left" title="${idp.projectName}"><tag:limitTag limitLength="50" content="${idp.projectName}"/></td>
							<td align="left">${idp.owner}</td>
							<td align="left">${idp.status}</td>
							<td align="right">${idp.lastAnalyzed}</td>
							<td align="right">${idp.lastModified}</td>
							<td align="right">${idp.totalFiles}</td>
							<td align="right">${idp.matchedFiles}</td>
							<td align="right">${idp.pendingFiles}</td>
							<td align="right">${idp.defaultLicense}</td>
							<td align="right">${idp.conflict}</td>
							<td align="right">${idp.git}</td>
						</tr>
					</c:forEach>
	
				</tbody>
			</table>
		</div>
	</div>
	<!-- Detail End -->
</body>
</html>
