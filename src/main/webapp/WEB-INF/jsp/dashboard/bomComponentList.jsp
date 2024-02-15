<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglib.jsp"%>
<%@ include file="/jsp/head.jsp"%>
<%@ include file="/jsp/meta.jsp"%>
<title>TIZEN Web</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnIdp").bind('click', function () {
			location.assign("idpProjectList?platformVersion="+$("select option:selected").val());
		});		

		$("#btnBomLicense").bind('click', function () {
			location.assign("bomLicenseList?platformVersion="+$("select option:selected").val());
		});
		
		$("#btnExcel").bind('click', function () {
			location.assign("../excel/excelDown?target=bomComponentList&platformVersion="+$("select option:selected").val());
		});
		
		$("#platformVersion").bind('change', function () {
			location.assign("bomComponentList?platformVersion="+$("select option:selected").val());
		});

		$(':radio[name="rdoStatus"]').bind('click', function () {
			var status = $(':radio[name="rdoStatus"]:checked').val();
			location.assign("bomComponentList?platformVersion="+$("select option:selected").val()+"&status="+status);
		});
		
		$(':radio[name="rdoStatus"]:radio[value="${status}"]').attr("checked",true);
		
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
	
	function openFossPop()
	{
		var platformVersoion = $("select option:selected").val();
		var fossWin = window.open("../popup/fossPop?platformVersion="+platformVersoion, 'popName', 'scrollbars=yes, width=640, height=600, resizable=no');
	    if (window.focus) {fossWin.focus();}
	    if (!fossWin.closed) {fossWin.focus();}
	}
	
	function openLicensePop()
	{
		var platformVersoion = $("select option:selected").val();
		var licenseWin = window.open("../popup/licensePop?platformVersion="+platformVersoion, 'popName', 'scrollbars=yes, width=640, height=600, resizable=no');
	    if (window.focus) {licenseWin.focus();}
	    if (!licenseWin.closed) {licenseWin.focus();}
	}
	
	function openFossProjectPop(fossComponent, version)
	{
		var platformVersoion = $("select option:selected").val();
		var url = "../popup/fossProjectPop?platformVersion="+platformVersoion+"&fossComponent="+encodeURIComponent(fossComponent)+"&version="+version;

		var projectWin = window.open(url, 'popName', 'scrollbars=yes, width=640, height=600, resizable=no');
	    if (window.focus) {projectWin.focus();}
	    if (!projectWin.closed) {projectWin.focus();}
	    
	    return false;
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
			<h2 id="title">Bill Of Materials</h2>
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
							<button id="btnIdp" type="button" class="btn btn-default">Identifying Progress</button>&nbsp;&nbsp;
							<button id="btnBom" type="button" class="btn btn-primary">Bill Of Materials</button>
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
						<th align="center" width="8%">Project</th>
						<th align="center" width="8%">Owners</th>
						<th align="center" width="10%">Status</th>
						<th align="center" width="30%">Detected FOSS</th>
						<th align="center">Identified License</th>
						<th align="center" width="10%">Conflict</th>
					</tr>
				</thead>
				<tbody>
					<tr class="even">
						<td align="center">${bomSummary.cnt}</td>
						<td align="center">${bomSummary.owner}</td>
						<td align="left">
							<c:forEach items="${comStatus}" var="vo" varStatus="status">
								${vo.status}: ${vo.cnt}<br />
							</c:forEach>
							<c:if test="${fn:length(comStatus) == 0}">-</c:if>
						</td>
						<td align="left">
							<c:forEach items="${comFoss}" var="vo" varStatus="status" begin="0" end="4">
								${vo.name}: <fmt:formatNumber value="${vo.foss}" /> (${vo.percent}%) <br />
							</c:forEach>
							<c:if test="${fn:length(comFoss) > 5}"><a href="#" onclick="openFossPop()" style="color: blue;">+ more</a></c:if> 
							<c:if test="${fn:length(comFoss) == 0}">-</c:if>
						</td>
						<td align="left">
							<c:forEach items="${comLicense}" var="vo" varStatus="status" begin="0" end="4">
								${vo.name}: <fmt:formatNumber value="${vo.license}" /> (${vo.percent}%) <br />
							</c:forEach>
							<c:if test="${fn:length(comLicense) > 5}"><a href="#" onclick="openLicensePop()" style="color: blue;">+ more</a></c:if> 
							<c:if test="${fn:length(comLicense) == 0}">-</c:if>
						</td>
						<td align="center"><fmt:formatNumber value="${bomSummary.conflict}" /></td>
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
			<h3>Detail (Total ${fn:length(bomList)} FOSS Components) </h3>				
			<table class="search">
				<tbody>
					<tr>
						<th align="left" width="70%">
							<button id="btnBomComponent" type="button" class="btn btn-sm btn-primary">Component 기준</button>&nbsp;&nbsp;
							<button id="btnBomLicense" type="button" class="btn btn-sm btn-default">License 기준</button>
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
						<th data-sort="string" align="center">FOSS Component</th>
						<th data-sort="string" align="center" width="15%">Version</th>
						<th data-sort="string" align="center" width="30%">License</th>
						<th data-sort="int" align="center" width="15%">Total Files</th>
						<th data-sort="int" align="center" width="15%">Related Projects</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bomList}" var="bom" varStatus="status">
						<tr <c:if test="${status.count%2 != 0}"> class="even"</c:if><c:if test="${status.count%2 == 0}">class="odd"</c:if>>
							<td align="left">${bom.fossComponent}</td>
							<td align="left">${bom.version}</td>
							<td align="left">${bom.license}</td>
							<td align="right">${bom.totalFiles}</td>
							<td align="right" style="cursor: pointer;" onclick="openFossProjectPop('${bom.fossComponent}','${bom.version}')"><span style="color: blue;">${bom.relatedProject}</span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- Detail End -->
</body>
</html>
