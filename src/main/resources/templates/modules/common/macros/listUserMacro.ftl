<#macro list users>
	<table class="table">
		<thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Username</th>
		      <th scope="col">Email</th>
		      <th scope="col">Phone Number</th>
		    </tr>
	  	</thead>
	  	<tbody>
	  		<#assign count = 1>
			<#list users as user>
				<tr>
			      	<th scope="row">${count}</th>
			      	<td>${user.username!}</td>
			      	<td>${user.email!}</td>
			      	<td>${user.phoneNumber!}</td>
			    </tr>
			    <#assign count = count + 1>
			</#list> 
		</tbody>
	</table>
</#macro>