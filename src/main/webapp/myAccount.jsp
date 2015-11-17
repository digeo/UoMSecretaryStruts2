<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
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
	<p>

		<a class="btn btn-default"
			href="${pageContext.request.contextPath}/myAccount/edit"
			role="button">Edit my details</a> <a class="btn btn-default"
			href="${pageContext.request.contextPath}/myAccount/changePassword"
			role="button">Change my Password</a>

<%-- 		<sec:authorize access="hasRole('ROLE_SECRETARY')"> --%>
<!-- 			<a class="btn btn-default" -->
<%-- 				href="${pageContext.request.contextPath}/secretary" role="button">My --%>
<!-- 				admin panel</a> -->
<%-- 		</sec:authorize> --%>
<%-- 		<sec:authorize access="hasRole('ROLE_PROFESSOR')"> --%>
<!-- 			<a class="btn btn-default" -->
<%-- 				href="${pageContext.request.contextPath}/professor" role="button">My --%>
<!-- 				admin panel</a> -->
<%-- 		</sec:authorize> --%>
<%-- 		<sec:authorize access="hasRole('ROLE_STUDENT')"> --%>
<!-- 			<a class="btn btn-default" -->
<%-- 				href="${pageContext.request.contextPath}/student" role="button">My --%>
<!-- 				admin panel</a> -->
<%-- 		</sec:authorize> --%>
	</p>
</div>
<%@ include file="/footer.jsp"%>