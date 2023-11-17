<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="modelPack.*"%>
<%@ page import="java.util.ArrayList"%>

<%ArrayList<BbsDto> bbsList = (ArrayList<BbsDto>) request.getAttribute("bbsList");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">

<title>BBS�X���b�h�ꗗ</title>
</head>

<body>
	<div class="container">

		<h1>BBS�X���b�h�ꗗ</h1>
	
		<%-- ���C���T�[�g�p�t�H�[�� --%>
		<jsp:include page="includeInsertParts.jsp" />
		
		<%-- ���ŐV�\���{�^��--%>
		<button class="renewal" type="button" onclick="location.href='threadControlServlet'">�ŐV��20���̕\��</button>

		<%-- ���y�[�W�l�[�V����--%>
		<%=(String) request.getAttribute("pages")%>
		
		<%-- ���X���b�h�ꗗ --%>
		<%if (request.getAttribute("bbsList") != null) {%>
	
			<table border="1">
				<tr>
					<th>No</th>
					<th>�X���b�h��</th>
					<th>���X��</th>
				</tr>
		
				<%for (BbsDto bbs : bbsList) {%>
					<tr>
						<td><%=bbs.getThreadId()%></td>
						<td><a href="resControlServlet?threadId=<%=bbs.getThreadId()%>">
								<%=bbs.getContent()%></a></td>
						<td><%=bbs.getCount() - 1%></td>
					</tr>
				<%}%>
		
			</table>
			
		<%}%>
	
		<%-- ���G���[�����b�Z�[�W�ҏW --%>
		<%if (request.getAttribute("message") != null) {%>
			<p><%=(String) request.getAttribute("message")%></p>
		<%}%>
	</div>
</body>
</html>
