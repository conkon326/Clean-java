public class Code2_10{
  public static void main(String[] args){


    String name = "すがわら";
  //-----------
  //Stringｸﾗｽ型の変数nameを宣言する
  //(ｸﾗｽ型の変数は､そのｸﾗｽのｺﾋﾟｰを管理する)
  //              ----------
  //              "すがわら"という文字列を持った
  //              Stringｸﾗｽのｺﾋﾟｰが生成される｡
  //           ---
  //           ｸﾗｽのｺﾋﾟｰが直接代入されるわけではなく､
  //           ｸﾗｽのｺﾋﾟｰがある場所を示す『ｱﾄﾞﾚｽ』が代入される。

    String message;

    message = name + "さん、こんにちは";

    System.out.println(message);

    System.out.println(name);

  }
}
