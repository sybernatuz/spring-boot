<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/seo.ftl">
</head>
<body>
	<#if users??>
		<ul>
			<#list users as user>
				<li>${user.username!}</li>
			</#list> 
		</ul>
	</#if>
</body>
</html>