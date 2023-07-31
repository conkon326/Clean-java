public class Code4_13 {
  public static void main(String[] args){

    int[] scores = {20, 30, 40, 50, 80};
  //------------
  //int型の配列(のｱﾄﾞﾚｽ)を管理する変数scoresを宣言する｡
  //               --------------------
  //               5部屋の配列を生成し､それぞれの部屋に値を代入する｡
  //            ---
  //        配列がPCのﾒﾓﾘｰ上のﾄﾞｺにあるのか…を示すｱﾄﾞﾚｽを
  //        変数scoresに代入する｡


    //▼普通のfor文は( )の中に 初期値; 条件; 操作 を記述する｡

    for(int i = 0; i<scores.length; i++){
      System.out.print(scores[i] + " ");
    }

    System.out.println("\n------------------------------");

    //▼拡張for文は､配列から一つずつ個室に移して､中の処理を行う｡

    for(int value : scores){
    //              ------
    //              配列(状のﾓﾉ)を記述
    //  ---------
    //  個室を宣言
      System.out.print(value + " ");
    }

  }
}

