<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="navbar-brand">
	    <img src="/images/spring-boot-project-logo.png" width="30" height="30" class="d-inline-block align-top">
	    Spring Boot
    </div>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
  	<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home</a>
      </li>
    </ul>
    <div class="form-inline my-2 my-lg-0">
	    <#if isAuthenticate()>
	    	<#assign username=SPRING_SECURITY_CONTEXT.authentication.principal.username />
			<a href="/logout" class="btn btn-primary btn-md active" role="button" aria-pressed="true">Logout</a>
			<a href="/user/${username}" class="btn btn-primary btn-md active" role="button" aria-pressed="true">Profile</a>
		<#else>
			<a href="/user/login" class="btn btn-primary btn-md active" role="button" aria-pressed="true">Login</a>
			<a href="/user/register" class="btn btn-primary btn-md active" role="button" aria-pressed="true">Register</a>
		</#if>
    </div>
  </div>
</nav>