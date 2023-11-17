<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="rg.*"%>
<%
SixtyAnimalsEntity animal = (SixtyAnimalsEntity) request.getAttribute("aixtyAnimal");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>占い</title>
</head>
<body>



	<h1>占い</h1>

	<form action="controlServlet" method="get">
		<p>占う</p>
		<label>誕生年</label> <input type="number" name="year" value="2000">
		<label>誕生月</label> <input type="number" name="month" value="1">
		<label>誕生月</label> <input type="number" name="day" value="1">
		<p>性別</p>
		<label><input type="radio" name="gender" value="m"> 男</label>
		<label><input type="radio" name="gender" value="f"> 女</label>
		<input type="submit" value="送信">
	</form>

	<p>占い結果</p>
	<%
	if (request.getAttribute("aixtyAnimal") != null) {
	%>

	<div>
		<h2>60動物占い</h2>
		<h3><%=animal.getName()%>

		</h3>
		<h3><%=animal.getId()%></h3>
		<img alt="動物" src="pic/<%=(String) request.getAttribute("picString")%>">

	</div>
	<%
	}
	%>
	<%-- ■エラー等メッセージ編集 --%>
	<%
	if (request.getAttribute("message") != null) {
	%>
	<p><%=(String) request.getAttribute("message")%></p>
	<%
	}
	%>
</body>
</html>
