<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="modelPack.*"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<BbsEntity> bbsList = (ArrayList<BbsEntity>) request.getAttribute("bbsList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<link rel="stylesheet" href="css/stylesheet.css">
<title><%=request.getParameter("id")%>のスレッド表示</title>
</head>

<body>

	<h1><%=request.getParameter("id")%>のスレッド表示</h1>

	<%if (request.getAttribute("message") != null) {%>
		<p><%=(String) request.getAttribute("message")%></p>
	<%}%>

	<%if (request.getAttribute("bbsList") != null) {%>

		<table border="1">

			<tr>
				<th>ID</th>
				<th>Speaker</th>
				<th>Content</th>
				<th>Date and Time</th>
			</tr>
	
			<%for (BbsEntity bbs : bbsList) {%>
				<tr>
					<td><%=bbs.getThreadId()%></td>
					<td><%=bbs.getSpeaker()%></td>
					<td><%=bbs.getComment()%></td>
					<td><%=bbs.getYmdhms()%></td>
				</tr>
			<%}%>
			
		</table>
	<%}%>

</body>
</html>
