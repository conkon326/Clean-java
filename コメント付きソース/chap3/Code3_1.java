public class Code3_1{
  public static void main(String[] args){

  //boolean tenki = true;
  //-------------
  //boolean型(trueかfalseを管理する型)の変数tenkiを宣言する。

    boolean tenki = false;

    if(tenki == true){
  //   -------------
  //   条件が成立していれば､それに続く{ }の中の処理を実行する｡

      System.out.println("洗濯をします");
      System.out.println("散歩にいきます");

    }else{
  // ----
  // 条件が成立していなければ､elseに続く{ }の中の処理を実行する｡

      System.out.println("DVDを見ます");

    }

    System.out.println("---------------------------------------");

    if(tenki == true){
      System.out.println("晴れですよ");
    }

  }
}
