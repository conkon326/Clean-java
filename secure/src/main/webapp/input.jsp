<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html><head>
<META charset="Windows-31J">
<title>セキュア入力</title>
</head><body>

<!-- ■入力欄１■            -->
  <h2>SQL文を単純に連結して生成</h2>
  <form action="control1" method="post">
    <p>ユーザー名とパスワードの入力</p>
    <p>
      <input type="text" name="name1" value="">
      <input type="text" name="pass1" value="">
      <input type="submit" value="照会">
    </p>
  </form>

  <h2>SQL文をプリペアードステートメントで生成</h2>
  <form action="control1" method="post">
    <p>ユーザー名とパスワードの入力</p>
    <p>
      <input type="text" name="name2" value="">
      <input type="text" name="pass2" value="">
      <input type="submit" value="照会">
    </p>
  </form>


  <p>---------------------------------------</p>

  <%response.addCookie(new Cookie("naisyo","himitu")); %>

<!-- ■入力欄２■            -->
  <h2>そのまま確認画面に表示する入力</h2>
  <form action="control1" method="post">
    <p>文章の入力</p>
    <p>
      <input type="text" name="text1" value="">
      <input type="submit" value="送信">
    </p>
  </form>

  <h2>エスケープして確認画面に表示する入力</h2>
  <form action="control1" method="post">
    <p>文章の入力</p>
    <p>
      <input type="text" name="text2" value="">
      <input type="submit" value="送信">
    </p>
  </form>


</body></html>


