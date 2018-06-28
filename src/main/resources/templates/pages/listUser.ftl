<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/head/headLinks.ftl">
	<#include "/modules/common/head/seo.ftl">
</head>
<body>
	<#include "/modules/common/header.ftl">
	<#if users??>
		<ul class="list-group">
			<#list users as user>
				<li class="list-group-item">${user.username!}</li>
			</#list> 
		</ul>
	</#if>
</body>
</html>