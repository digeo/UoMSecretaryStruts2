<%@ include file="header.jsp"%>
<%@ include file="container.jsp"%>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th>Telephone</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="secretary" step="1" value="secretaries">
				<tr>
					<td><s:property value="name" /></td>
					<td><s:property value="surname" /></td>
					<td><s:property value="telephone" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
<%@ include file="footer.jsp"%>