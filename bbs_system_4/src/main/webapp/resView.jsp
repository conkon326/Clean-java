<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="modelPack.*"%>
<%@ page import="java.util.ArrayList"%>

<%ArrayList<BbsEntity> bbsList = (ArrayList<BbsEntity>) request.getAttribute("bbsList");%>
<%BbsEntity threadsTitle = (BbsEntity) request.getAttribute("threadsTitle");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<meta name=�hviewport�h content=�hwidth=device-width,initial-scale=1��>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">

<%-- ���X���b�h���I�� --%>
<%if (request.getParameter("threadId").equals("0")) {%>
	<title>�V�����X���b�h��\��</title>
<%} else {%>
	<title><%=request.getParameter("threadId")%>�̃X���b�h�\��</title>
<%}%>

</head>
<body>
	<div class="container">
	
		<div class="title">
			<h1><%=threadsTitle.getComment()%></h1>
			<div class="d-flex flex-column">
				<div class="d-flex justify-content-between">
					<span class="ml-auto p-2 ">���e�Җ��F<%=threadsTitle.getSpeaker()%></span>
					<span class="mr-auto  p-2">���e�����F<%=threadsTitle.getYmdhms()%></span>
				</div>
			</div>
		</div>
	
	
		<%-- ���C���T�[�g�p�t�H�[�� --%>
		<jsp:include page="includeInsertParts.jsp" />
		
		<%-- ���ŐV�\���{�^��--%>
		<button class="renewal" type="button" onclick="location.href='resControlServlet?threadId=<%=request.getParameter("threadId")%>'">�ŐV��20���̕\��</button>
		
		
		<%-- ���y�[�W�l�[�V����--%>
		<%=(String) request.getAttribute("pages")%>
		
		<%-- �����X�ꗗ --%>
		<%if (request.getAttribute("bbsList") != null) {%>
			<table border="1" >
			
				<%for (BbsEntity bbs : bbsList) {%>
					<tr >
						<td>
						<span class="h4"><%=bbs.getComment()%></span><br>
						<span class="spanL">���e�Җ��F<%=bbs.getSpeaker()%></span>
						<span class="spanR">���e�����F<%=bbs.getYmdhms()%></span>
						</td>
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
