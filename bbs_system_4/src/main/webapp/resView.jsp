<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="modelPack.*"%>
<%@ page import="java.util.ArrayList"%>

<%ArrayList<BbsEntity> bbsList = (ArrayList<BbsEntity>) request.getAttribute("bbsList");%>
<%BbsEntity threadsTitle = (BbsEntity) request.getAttribute("threadsTitle");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<meta name=”viewport” content=”width=device-width,initial-scale=1″>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">

<%-- ■スレッド名選択 --%>
<%if (request.getParameter("threadId").equals("0")) {%>
	<title>新しいスレッドを表示</title>
<%} else {%>
	<title><%=request.getParameter("threadId")%>のスレッド表示</title>
<%}%>

</head>
<body>
	<div class="container">
	
		<div class="title">
			<h1><%=threadsTitle.getComment()%></h1>
			<div class="d-flex flex-column">
				<div class="d-flex justify-content-between">
					<span class="ml-auto p-2 ">投稿者名：<%=threadsTitle.getSpeaker()%></span>
					<span class="mr-auto  p-2">投稿日時：<%=threadsTitle.getYmdhms()%></span>
				</div>
			</div>
		</div>
	
	
		<%-- ■インサート用フォーム --%>
		<jsp:include page="includeInsertParts.jsp" />
		
		<%-- ■最新表示ボタン--%>
		<button class="renewal" type="button" onclick="location.href='resControlServlet?threadId=<%=request.getParameter("threadId")%>'">最新の20件の表示</button>
		
		
		<%-- ■ページネーション--%>
		<%=(String) request.getAttribute("pages")%>
		
		<%-- ■レス一覧 --%>
		<%if (request.getAttribute("bbsList") != null) {%>
			<table border="1" >
			
				<%for (BbsEntity bbs : bbsList) {%>
					<tr >
						<td>
						<span class="h4"><%=bbs.getComment()%></span><br>
						<span class="spanL">投稿者名：<%=bbs.getSpeaker()%></span>
						<span class="spanR">投稿日時：<%=bbs.getYmdhms()%></span>
						</td>
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
