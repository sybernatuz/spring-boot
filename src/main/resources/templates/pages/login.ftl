<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/head/headLinks.ftl">
	<#include "/modules/common/head/seo.ftl">
</head>
<body>
	<#include "/modules/common/header.ftl">
	<#if error??>
		une erreur est survenue
	</#if>
	<#include "/modules/forms/loginForm.ftl">
</body>
</html>