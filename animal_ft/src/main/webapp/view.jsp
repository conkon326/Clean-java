<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="rg.*"%>
<%
SixtyAnimalsEntity animal = (SixtyAnimalsEntity) request.getAttribute("aixtyAnimal");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>�肢</title>
</head>
<body>



	<h1>�肢</h1>

	<form action="controlServlet" method="get">
		<p>�肤</p>
		<label>�a���N</label> <input type="number" name="year" value="2000">
		<label>�a����</label> <input type="number" name="month" value="1">
		<label>�a����</label> <input type="number" name="day" value="1">
		<p>����</p>
		<label><input type="radio" name="gender" value="m"> �j</label>
		<label><input type="radio" name="gender" value="f"> ��</label>
		<input type="submit" value="���M">
	</form>

	<p>�肢����</p>
	<%
	if (request.getAttribute("aixtyAnimal") != null) {
	%>

	<div>
		<h2>60�����肢</h2>
		<h3><%=animal.getName()%>

		</h3>
		<h3><%=animal.getId()%></h3>
		<img alt="����" src="pic/<%=(String) request.getAttribute("picString")%>">

	</div>
	<%
	}
	%>
	<%-- ���G���[�����b�Z�[�W�ҏW --%>
	<%
	if (request.getAttribute("message") != null) {
	%>
	<p><%=(String) request.getAttribute("message")%></p>
	<%
	}
	%>
</body>
</html>
