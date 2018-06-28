<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/head/headLinks.ftl">
	<#include "/modules/common/head/seo.ftl">
</head>
<body>
	<#include "/modules/common/header.ftl">
	<#if user??>
		${user.username!}
	</#if>
</body>
</html>