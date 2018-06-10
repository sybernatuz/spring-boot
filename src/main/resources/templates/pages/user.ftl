<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/headLinks.ftl">
	<#include "/modules/common/seo.ftl">
</head>
<body>
	<#if user??>
		${user.id!}
		${user.username!}
	</#if>
</body>
</html>