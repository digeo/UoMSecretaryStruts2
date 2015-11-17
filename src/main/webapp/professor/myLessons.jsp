<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>description</th>
				<th>ECTS</th>
				<th>Semester</th>
				<th>SET GRADES</th>
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
				<td><a class="btn btn-default"
					href="<s:url action="setGrades.action" > <s:param name="lessonId"><s:property value="id" /></s:param> </s:url>"
					role="button">Set grades &raquo;</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
<%@ include file="/footer.jsp"%>