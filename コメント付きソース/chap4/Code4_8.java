public class Code4_8 {
  public static void main(String[] args){
/*
    int[] scores;
    scores = new int[5];
    scores[0] = 20;
    scores[1] = 30;
    scores[2] = 40;
    scores[3] = 50;
    scores[4] = 80;
*/
    //配列を管理する変数の宣言､配列の生成､各部屋への代入を
    //次のように1行で記述する事ができる｡
    //            ↓
    int[] scores = {20, 30, 40, 50, 80};
    //              --, --, --, --, --
    //          ｶﾝﾏ区切りで5つの値がある事で､5部屋の配列だと判断してる｡


//  int sum = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];

    int sum = 0; //←変数sumを前もって宣言し､値をｾﾞﾛにしておく｡

    for(int i=0; i<scores.length; i++){
  //    -------; ---------------; ---
  //    初期値   条件             操作

      //ﾙｰﾌﾟの制御に使っている変数iを流用して､配列の部屋番号の指定をする｡
      //            ↓
      sum += scores[i];
      //  --
      //  加算代入の記号で､計算式にすると→『sum = sum + scores[i]』
    }

    int avg = sum / scores.length;
    //              -------------
    //      配列の中には変数lengthがあって､そこでは部屋数を管理している｡
    //        -----
    //        合計を､配列の部屋数で割る事で､平均の計算をしている｡

    System.out.println("★☆合計点：" + sum);
    System.out.println("平均点：" + avg);

  }
}

