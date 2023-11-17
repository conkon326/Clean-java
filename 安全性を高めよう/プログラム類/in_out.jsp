<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html><head>
<META charset="Windows-31J">
<title>セキュア入力</title>
</head><body>

<!-- ■入力欄３■            -->
  <h2>SQL文を単純に連結して生成し、insert</h2>
  <form action="control2" method="post">
    <p>DBに登録する内容を入力</p>
    <p>
      <input type="text" name="text3" value="">
      <input type="submit" value="送信">
    </p>
  </form>

  <h2>SQL文をプリペアードステートメントで生成し、insert</h2>
  <form action="control2" method="post">
    <p>DBに登録する内容を入力</p>
    <p>
      <input type="text" name="text4" value="">
      <input type="submit" value="送信">
    </p>
  </form>


  <h2>text_tblの中身を全件出力</h2>

    <%if(request.getAttribute("list") != null){
        java.util.ArrayList<String> list = (java.util.ArrayList<String>)request.getAttribute("list");

        for(String s : list){%>
          <%-- <p><%=s %></p > --%>
          <p><%=s.replaceAll("<","&lt;").replaceAll(">","&gt;") %></p >
      <%} %>

	<%} %>



</body></html>


