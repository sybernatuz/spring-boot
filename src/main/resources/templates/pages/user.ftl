<#import "/spring.ftl" as spring />
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
	<#include "/modules/forms/userEditForm.ftl">
</body>
</html>