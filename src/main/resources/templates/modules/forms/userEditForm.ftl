<#assign username=SPRING_SECURITY_CONTEXT.authentication.principal.username />
<form method="post" action="/user/${username}/edit">
  <input type="hidden" name ="username" value="${username}">
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="password">Email</label>
    <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${(formUser.email)!}">
  </div>
  <div class="form-group">
    <label for="password">Phone Number</label>
    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" value="${(formUser.phoneNumber)!}">
  </div>
  <input type="submit" class="btn btn-primary" value ="Edit">
</form>