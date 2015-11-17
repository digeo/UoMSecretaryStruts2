<%@ include file="header.jsp"%>
<%@ include file="container.jsp"%>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>description</th>
				<th>ECTS</th>
				<th>Semester</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="lesson" step="1" value="lessons">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="ects" /></td>
					<td><s:property value="semester" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
<%@ include file="footer.jsp"%>