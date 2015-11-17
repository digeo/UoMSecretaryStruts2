<%@ include file="/header.jsp"%>
<div class="table-responsive">

		<table class="table table-striped">
			<tbody>
				<tr>
					<td>username</td>
					<td><s:property value="userDetails.username" /></td>
				</tr>
				<tr>
					<td>name</td>
					<td><s:property value="userDetails.name" /></td>
				</tr>
				<tr>
					<td>surname</td>
					<td><s:property value="userDetails.surname" /></td>
				</tr>
				<tr>
					<td>sex</td>
					<td><s:property value="userDetails.sex" /></td>
				</tr>
				<tr>
					<td>telephone</td>
					<td><s:property value="userDetails.telephone" /></td>
				</tr>
				<tr>
					<td>address</td>
					<td><s:property value="userDetails.address" /></td>
				</tr>
				<tr>
					<td>birthday</td>
					<td><s:property value="userDetails.birthday" /></td>
				</tr>
			</tbody>
		</table>
		<a class="btn btn-default" href="<s:url action='edit'/>">Edit my Information</a>
		<a class="btn btn-default" href="<s:url action='myLessons'/>">my Lessons</a>
</div>
<%@ include file="/footer.jsp"%>