<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html><head>
<META charset="Windows-31J">
<title></title>
</head><body>


<!-- �����b�Z�[�W�\������                                       -->
<!--  ظ��ĕϐ��Ƃ���message�Ƃ������O�̵�޼ު�Ă��o�^�����
      ������(��get�ł�����)�message�Ƃ������O��������޼ު�Ă�
      ���̈ʒu�ɕҏW����                                       -->

  <%if(request.getAttribute("message") != null){%>
    <p><%=(String)request.getAttribute("message")%></p>
  <%}%>

  <%if(request.getAttribute("message2") != null){%>
    <pre><%=(String)request.getAttribute("message2")%></pre>
  <%}%>

</body></html>


