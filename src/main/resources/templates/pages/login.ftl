<!DOCTYPE html>
<html>
<head>
	<#include "/modules/common/headLinks.ftl">
	<#include "/modules/common/seo.ftl">
</head>
<body>
	<#if error??>
		une erreur est survenue
	</#if>
	<#include "/modules/forms/loginForm.ftl">
</body>
</html>