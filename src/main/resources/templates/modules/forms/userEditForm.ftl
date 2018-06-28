<#assign username=SPRING_SECURITY_CONTEXT.authentication.principal.username />
<form method="post" action="/profile/${username}/edit">
  <div class="form-group">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" name ="username" placeholder="${username}">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
  <input type="submit" class="btn btn-primary" value ="Login">
</form>