<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>test</title>
</head>
<body>
	<input type="text" name="name" id="name">
	<br>
	<input type="button" value="button" onclick="responseName()">
</body>

<script>
function responseName(){
	var name = document.getElementById('name').value;
	alert("Hi, " + name + "!!!");
}
</script>

</html>