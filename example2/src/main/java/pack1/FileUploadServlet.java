package pack1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // リクエスト処理
    String message = "テキストファイルをアップロードできませんでした。";
    String s = null;//ｱｯﾌﾟﾛｰﾄﾞ先のﾊﾟｽを表示させる為


    if (ServletFileUpload.isMultipartContent(req)) {
    //●ﾏﾙﾁﾊﾟｰﾄﾃﾞｰﾀかどうか確認する●
    //通常のform渡しの場合は､postでもgetでもURLｴﾝｺｰﾄﾞしたものを
    //渡している｡
    //ﾌｧｲﾙﾃﾞｰﾀなどの場合は大きいので､ﾏﾙﾁﾊﾟｰﾄﾃﾞｰﾀとしてﾘｸｴｽﾄに
    //埋め込んで渡している｡
    //その際､渡し元(今回はhtml)に｢enctype="multipart/form-data"｣
    //という記述が必要｡

      String dataDir = getServletContext().getRealPath("/") + "data";
      s = dataDir;
      //●ｻｰﾌﾞﾚｯﾄｺﾝﾃｷｽﾄの取得●
      //　ｺﾝﾃｷｽﾄの意味→文脈
      //　　ﾌﾟﾛｸﾞﾗﾐﾝｸﾞ的には､置かれた状況･与えられた条件
      //
      //ｻｰﾌﾞﾚｯﾄｺﾝﾃｷｽﾄとは､簡単に言うとｻｰﾌﾞﾚｯﾄがどの環境で動いて
      //いるのかという情報
      //そのｵﾌﾞｼﾞｪｸﾄを取得して､その中のgetRealPathメソッドを実行
      //すれば､動いている場所のﾊﾟｽを取得できる

      DiskFileItemFactory factory = new DiskFileItemFactory();
      //ﾌｧｲﾙを扱う為のｵﾌﾞｼﾞｪｸﾄを生成
      ServletFileUpload uploader = new ServletFileUpload(factory);
      //ﾌｧｲﾙをｱｯﾌﾟﾛｰﾄﾞする為のｵﾌﾞｼﾞｪｸﾄを生成
      uploader.setFileSizeMax(1024 * 1024); // 1MB
      //しきい値の設定(→境目となる値≒上限値)

      try {
        List<FileItem> fList = uploader.parseRequest(req);
      //--------------
      //Listはｵﾌﾞｼﾞｪｸﾄを配列状に管理できるｸﾗｽ
      //何型のｵﾌﾞｼﾞｪｸﾄを管理するのかは< >の中に記述する
                             //--------------------------
      //reqとして送られてきたﾃﾞｰﾀをFileItemｵﾌﾞｼﾞｪｸﾄに分割し､
      //Listとして返す｡
      //複数対応なのでList形式だが､今回のｼｽﾃﾑでは対象ﾌｧｲﾙは
      //1つなので､必ず1つ｡

        for (FileItem fItem : fList) {
        //拡張for文を用いて､fListからｵﾌﾞｼﾞｪｸﾄを1つずつ取り出して､
        //変数fItemに格納してから､中の処理を行う

          if (!fItem.isFormField()) {
             //isFormField()で､fItemで管理しているｵﾌﾞｼﾞｪｸﾄが
             //ﾌｧｲﾙﾃﾞｰﾀか､その他のformﾃﾞｰﾀかを判別している
             //formﾃﾞｰﾀの場合はtrueを返し､それ以外(ﾌｧｲﾙﾃﾞｰﾀ)なら
             //falseを返す
             //それに｢!｣を付ける事でtrueとfalseを反転させている

            File tmpFile = new File(fItem.getName());
            //ﾌｧｲﾙ名を取得し､Fileｵﾌﾞｼﾞｪｸﾄを生成
            String fileName = tmpFile.getName();
            //ﾌｧｲﾙ名を取得

            if (fileNameCheck(fileName)) {
              //自作のﾁｪｯｸﾒｿｯﾄﾞを利用して､ﾌｧｲﾙ名の形式をﾁｪｯｸする
              File file = new File(dataDir + File.separator + fileName);
                                           //--------------
                                           //ｼｽﾃﾑで用いられている区切り文字
              fItem.write(file);
              message = "テキストファイル「" + fileName + "」をアップロードしました。";
            } else {
              message = "テキストファイルを正しく指定してください。";
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      message = "form タグの enctype 属性に multipart/form-data を指定してください。";
    }


    // レスポンス処理
    resp.setContentType("text/html; charset=Windows-31J");
    PrintWriter out = resp.getWriter();
    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
    out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
    out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
    out.println("<head>");
    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=Windows-31J\" />");
    out.println("<title>ファイルアップロード</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>" + message + s + "</p>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  private boolean fileNameCheck(String fileName) {

    String regex = "^\\S+\\.txt$";
    //ﾌｧｲﾙ名の形式を｢正規表現｣で定義する
    Pattern pattern = Pattern.compile(regex);
    //作成した｢正規表現｣をｾｯﾄしたPatternｵﾌﾞｼﾞｪｸﾄを生成
    Matcher matcher = pattern.matcher(fileName);
    //対象の文字列(ﾌｧｲﾙ名)を渡して､正規表現に適合するか検証
    return matcher.matches();
    //適合していればtrue､していなければfalseを返す

  }
}