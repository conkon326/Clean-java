<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="modelPack.ProductEntity"%>
<!DOCTYPE html>
<html>
<head>
<META charset="Windows-31J">
<title>�X�E�B�[�c�����y�[�W</title>
</head>
<body>
	<h2>�X�E�B�[�c�����y�[�W</h2>
	<form action="control" method="post">
		<p>�����������X�E�B�[�cID ����͂��ĉ�����</p>
		<p>
			<input type="text" name="paramId" value=""> <input
				type="submit" value="����">
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
	%><h2>��������</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>���O</th>
			<th>���z</th>
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