public class Code3_2{
  public static void main(String[] args){

    boolean doorClose = true;
    //                -
    //               『=』は代入、『==』は(同じかどうかの)比較


    //     for文は( )の中に｢初期値｣｢条件｣｢操作｣を記述するが､
    //     while文は｢条件」のみ記述する｡
    //           ↓
    while(doorClose == true){
    //    -----------------
    //    変数doorCloseにはtrueが入っており､それがtrueと同じかどうか比較
    //    している｡
    //        →同じなので､trueと判断している。
      System.out.println("ノックする");
      System.out.println("1分待つ");
    }

/*
    while(true){
      System.out.println("★ノックする");
      System.out.println("1分待つ");
    }
*/

//  if文や､for文や､while文の( )内は､
//  条件式を書かなくてはいけない…わけじゃない｡

//  実は､( )内が『true』か『false』か…を判断していて､
//  条件式が書いてある場合は､その条件式が成立していればtrue､
//  成立していなければfalseとしている｡


  }
}
