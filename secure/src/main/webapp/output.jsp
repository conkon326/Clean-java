<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html><head>
<META charset="Windows-31J">
<title></title>
</head><body>


<!-- ■メッセージ表示欄■                                       -->
<!--  ﾘｸｴｽﾄ変数としてmessageという名前のｵﾌﾞｼﾞｪｸﾄが登録されて
      いたら(→getできたら)､messageという名前がついたｵﾌﾞｼﾞｪｸﾄを
      この位置に編集する｡                                       -->

  <%if(request.getAttribute("message") != null){%>
    <p><%=(String)request.getAttribute("message")%></p>
  <%}%>

  <%if(request.getAttribute("message2") != null){%>
    <pre><%=(String)request.getAttribute("message2")%></pre>
  <%}%>

</body></html>


