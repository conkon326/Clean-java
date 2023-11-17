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

<title>BBSスレッド一覧</title>
</head>

<body>
	<div class="container">

		<h1>BBSスレッド一覧</h1>
	
		<%-- ■インサート用フォーム --%>
		<jsp:include page="includeInsertParts.jsp" />
		
		<%-- ■最新表示ボタン--%>
		<button class="renewal" type="button" onclick="location.href='threadControlServlet'">最新の20件の表示</button>

		<%-- ■ページネーション--%>
		<%=(String) request.getAttribute("pages")%>
		
		<%-- ■スレッド一覧 --%>
		<%if (request.getAttribute("bbsList") != null) {%>
	
			<table border="1">
				<tr>
					<th>No</th>
					<th>スレッド名</th>
					<th>レス数</th>
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
	
		<%-- ■エラー等メッセージ編集 --%>
		<%if (request.getAttribute("message") != null) {%>
			<p><%=(String) request.getAttribute("message")%></p>
		<%}%>
	</div>
</body>
</html>
