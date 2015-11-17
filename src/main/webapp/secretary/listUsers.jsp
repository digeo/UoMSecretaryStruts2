<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>username</th>
				<th>name</th>
				<th>surname</th>
				<th>sex</th>
				<th>telephone</th>
				<th>address</th>
				<th>birthday</th>
				<th>enabled</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="userDetails" step="1" value="usersDetails">
				<tr>
					<td><s:property value="username" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="surname" /></td>
					<td><s:property value="sex" /></td>
					<td><s:property value="telephone" /></td>
					<td><s:property value="address" /></td>
					<td><s:property value="birthday" /></td>
					<td><s:property value="user.enabled" /></td>
					<td><a class="btn btn-warning"
						href="<s:url action="editUser.action" > <s:param name="username"><s:property value="username" /></s:param> </s:url>">edit</a>
					</td>
					<td><a class="btn btn-danger"
						href="<s:url action="deleteUser.action" > <s:param name="username"><s:property value="username" /></s:param> </s:url>"
						onclick="return confirm('Are you sure?')">delete</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

	<a class="btn btn-primary" href="<s:url value="createUserForm" />">create</a>
</div>
<%@ include file="/footer.jsp"%>