<%@ page contentType="text/html; charset=Windows-31J"%>

<%@ page import="modelPack.BbsEntity"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>BBS�S�\��</title>
</head>
<body>

	<h1>BBS�S�\��</h1>

<form action="bbsControlServlet" method="post">
<p>�X���b�h�ɓ��e�B</p>
<input type="int" name="threadId" value="1">

<input type="text" name="speaker" value="�ȂȂ��̌���">
<input type="text" name="comment" value="">

<input type="submit" value="���M">
</form>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Speaker</th>
			<th>Content</th>
			<th>Date and Time</th>
		</tr>
		<%
		ArrayList<BbsEntity> bbsList = (ArrayList<BbsEntity>) request.getAttribute("bbsList");
		for (BbsEntity bbs : bbsList) {
		%>
		<tr>
			<td><%=bbs.getThreadId()%></td>
			<td><%=bbs.getSpeaker()%></td>
			<td><%=bbs.getComment()%></td>
			<td><%=bbs.getYmdhms()%></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>
