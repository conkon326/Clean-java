<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html><head>
<META charset="Windows-31J">
<title>�Z�L���A����</title>
</head><body>

<!-- �����͗��P��            -->
  <h2>SQL����P���ɘA�����Đ���</h2>
  <form action="control1" method="post">
    <p>���[�U�[���ƃp�X���[�h�̓���</p>
    <p>
      <input type="text" name="name1" value="">
      <input type="text" name="pass1" value="">
      <input type="submit" value="�Ɖ�">
    </p>
  </form>

  <h2>SQL�����v���y�A�[�h�X�e�[�g�����g�Ő���</h2>
  <form action="control1" method="post">
    <p>���[�U�[���ƃp�X���[�h�̓���</p>
    <p>
      <input type="text" name="name2" value="">
      <input type="text" name="pass2" value="">
      <input type="submit" value="�Ɖ�">
    </p>
  </form>


  <p>---------------------------------------</p>

  <%response.addCookie(new Cookie("naisyo","himitu")); %>

<!-- �����͗��Q��            -->
  <h2>���̂܂܊m�F��ʂɕ\���������</h2>
  <form action="control1" method="post">
    <p>���͂̓���</p>
    <p>
      <input type="text" name="text1" value="">
      <input type="submit" value="���M">
    </p>
  </form>

  <h2>�G�X�P�[�v���Ċm�F��ʂɕ\���������</h2>
  <form action="control1" method="post">
    <p>���͂̓���</p>
    <p>
      <input type="text" name="text2" value="">
      <input type="submit" value="���M">
    </p>
  </form>


</body></html>


