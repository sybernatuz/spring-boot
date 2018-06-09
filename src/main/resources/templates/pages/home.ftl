<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"/>
<title>Insert title here</title>
</head>
<body>
	<#if users??>
		<#list users as user>
			${user.username}
		</#list> 
	</#if>
</body>
</html>