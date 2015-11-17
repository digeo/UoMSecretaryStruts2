<%@ include file="/header.jsp"%>
<%@ include file="/container.jsp"%>
<s:form action="revokeLessons.action">
	<s:iterator value="lessons">
		<s:checkbox name="checkedLessons" fieldValue="%{id}" label="%{name}" />
	</s:iterator>

	<s:hidden name="username" value="%{username}" />
	<s:submit value="Revoke" />
</s:form>
<%@ include file="/footer.jsp"%>