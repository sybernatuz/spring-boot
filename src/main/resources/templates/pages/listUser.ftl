<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/headLinks.ftl">
	<#include "/modules/common/seo.ftl">
</head>
<body>
	<#if users??>
		<ul class="list-group">
			<#list users as user>
				<li class="list-group-item">${user.username!}</li>
			</#list> 
		</ul>
	</#if>
</body>
</html>