<%@ page contentType="text/html; charset=Windows-31J"%>

<%if (request.getParameter("threadId") == null) {%>

<form action="insertControlServlet" method="post">
	<p>�V�K�X���b�h���쐬</p>
	<input type="hidden" name="threadId" value="0">
	<label>���e��</label>
	<input type="text" name="speaker" value="�ȂȂ��̌���">
	<label>�X���b�h��</label>
	<input type="text" name="comment" value="">
	<input type="submit" value="���M">
</form>
<h4>�����X���b�h��I��</h4>

<%-- ���X�V�{�^��--%>
<button class="renewal" type="button" onclick="window.location.reload()">�X�V</button>

<%} else {%>

<form action="insertControlServlet" method="post">
	<p>���̃X���b�h�Ƀ��X��ǉ�</p>
	<input type="hidden" name="threadId" value="<%=request.getParameter("threadId")%>">
	<label>���e��</label>
	<input type="text" name="speaker" value="�ȂȂ��̌���">
	<label>���X���e</label>
	<input type="text" name="comment" value="">
	<input type="submit" value="���M">
</form>
<h4>���e�ꗗ</h4>

<%-- ���X�V�{�^��--%>
<button class="renewal" type="button" onclick="window.location.reload()">�X�V</button>


<%}%>