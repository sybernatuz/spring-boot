<#if isAuthenticate()>
	<a href="/logout" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Logout</a>
<#else>
	<a href="/user/login" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Login</a>
	<a href="/user/register" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Register</a>
</#if>