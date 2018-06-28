<#function isAuthenticate Role="USER">
	<#if SPRING_SECURITY_CONTEXT??>
		<#list SPRING_SECURITY_CONTEXT.authentication.authorities as authority>
			<#if authority == Role>
				<#return true>
			</#if>
		</#list>
	</#if>
	<#return false>
</#function>