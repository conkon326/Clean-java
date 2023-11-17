<%@ page contentType="text/html; charset=Windows-31J"%>

<%if (request.getParameter("threadId") == null) {%>

<form action="insertControlServlet" method="post">
	<p>新規スレッドを作成</p>
	<input type="hidden" name="threadId" value="0">
	<label>投稿者</label>
	<input type="text" name="speaker" value="ななしの権平">
	<label>スレッド名</label>
	<input type="text" name="comment" value="">
	<input type="submit" value="送信">
</form>
<h4>既存スレッドを選択</h4>

<%-- ■更新ボタン--%>
<button class="renewal" type="button" onclick="window.location.reload()">更新</button>

<%} else {%>

<form action="insertControlServlet" method="post">
	<p>このスレッドにレスを追加</p>
	<input type="hidden" name="threadId" value="<%=request.getParameter("threadId")%>">
	<label>投稿者</label>
	<input type="text" name="speaker" value="ななしの権平">
	<label>レス内容</label>
	<input type="text" name="comment" value="">
	<input type="submit" value="送信">
</form>
<h4>投稿一覧</h4>

<%-- ■更新ボタン--%>
<button class="renewal" type="button" onclick="window.location.reload()">更新</button>


<%}%>