<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html><head>
<META charset="Windows-31J">
<title>�Z�L���A����</title>
</head><body>

<!-- �����͗��R��            -->
  <h2>SQL����P���ɘA�����Đ������Ainsert</h2>
  <form action="control2" method="post">
    <p>DB�ɓo�^������e�����</p>
    <p>
      <input type="text" name="text3" value="">
      <input type="submit" value="���M">
    </p>
  </form>

  <h2>SQL�����v���y�A�[�h�X�e�[�g�����g�Ő������Ainsert</h2>
  <form action="control2" method="post">
    <p>DB�ɓo�^������e�����</p>
    <p>
      <input type="text" name="text4" value="">
      <input type="submit" value="���M">
    </p>
  </form>


  <h2>text_tbl�̒��g��S���o��</h2>

    <%if(request.getAttribute("list") != null){
        java.util.ArrayList<String> list = (java.util.ArrayList<String>)request.getAttribute("list");

        for(String s : list){%>
          <%-- <p><%=s %></p > --%>
          <p><%=s.replaceAll("<","&lt;").replaceAll(">","&gt;") %></p >
      <%} %>

	<%} %>



</body></html>


