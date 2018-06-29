<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/head/headLinks.ftl">
	<#include "/modules/common/head/seo.ftl">
</head>
<body>
	<#include "/modules/common/header.ftl">
	<#if users??>
		<#include "/modules/common/macros/listUserMacro.ftl">
		<@list users/>
	</#if>
</body>
</html>