<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/seo.ftl">
</head>
<body>
	<#if users??>
		<#list users as user>
			${user.username}
		</#list> 
	</#if>
</body>
</html>