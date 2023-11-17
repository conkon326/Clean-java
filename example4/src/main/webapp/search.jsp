<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="modelPack.ProductEntity"%>
<!DOCTYPE html>
<html>
<head>
<META charset="Windows-31J">
<title>スウィーツ検索ページ</title>
</head>
<body>
	<h2>スウィーツ検索ページ</h2>
	<form action="control" method="post">
		<p>検索したいスウィーツID を入力して下さい</p>
		<p>
			<input type="text" name="paramId" value=""> <input
				type="submit" value="検索">
		</p>
	</form>
	<%
	if (request.getAttribute("message") != null) {
	%>
	<p><%=(String) request.getAttribute("message")%></p>
	<%}%>
	<%
	if (request.getAttribute("sweets") != null) {
	%>
	<%
	ProductEntity ent = (ProductEntity) request.getAttribute("sweets");
	%><h2>検索結果</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>金額</th>
		</tr>
		<tr>
			<td><%=ent.getId()%></td>
			<td><%=ent.getName()%></td>
			<td><%=ent.getPrice()%></td>
		</tr>
	</table>
	<%}%>
</body>
</html>