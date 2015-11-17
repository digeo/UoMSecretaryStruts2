<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Semester</th>
				<th>ECTS</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="lesson" step="1" value="studentEnrolledToLessonsList">
				<tr>
					<td><s:property value="lesson.name" /></td>
					<td><s:property value="lesson.semester" /></td>
					<td><s:property value="lesson.ects" /></td>
					<td><s:property value="grade" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
<%@ include file="/footer.jsp"%>