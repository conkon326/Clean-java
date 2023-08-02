public class Code4_18 {
  public static void main(String[] args) {

    int[][] scores = new int[2][3];
  //                        ---
  //                   一次元として2部屋の配列を作り…
  //                           ---
  //                        その､それぞれの部屋で3部屋の配列を管理する｡
  //--------------
  //二次元(一次元配列の中で､別の一次元配列を管理する)の配列を
  //管理する配列は､[]を2つ付ける｡

    scores[0][0] = 40;
    scores[0][1] = 50;
    scores[0][2] = 60;
    scores[1][0] = 80;
    scores[1][1] = 65; //値を変更
    scores[1][2] = 70;

    System.out.println(scores[1][1]);

    System.out.println("---------------------------------");

    //全ての部屋の値を出力するには…

/*
    System.out.println(scores[0][0]);
    System.out.println(scores[0][1]);
    System.out.println(scores[0][2]);
    //              :
    // 全ての部屋を1行ずつ出力しても良いが､部屋数が多いと大変｡
*/
    for(int i=0; i<2; i++){       //1次元のﾙｰﾌﾟ 0       1
                                  //
      for(int j=0; j<3; j++){     //2次元のﾙｰﾌﾟ    0       0
                                  //               1       1 
                                  //               2       2
         System.out.println(scores[i][j]);

      }

    }


  }
}


