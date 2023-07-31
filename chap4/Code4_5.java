public class Code4_5 {
  public static void main(String[] args){


    int     i;      //int型(整数を管理する型)の変数iを宣言する｡

    String  s;      //Stringｸﾗｽ型の変数sを宣言する｡
                    //(ｸﾗｽ型の変数は､そのｸﾗｽのｺﾋﾟｰ(のｱﾄﾞﾚｽ)を管理する)

/*
    int[] scores;   //(int型の)配列を管理する為の特殊なｸﾗｽ型｡

    scores = new int[5];
  //         ----------
  //         int型の5部屋を持つ配列を生成し…
  //---------
  //配列がどこにあるか…を示すｱﾄﾞﾚｽを変数scoreに代入する｡

*/
  //配列を管理する変数の宣言と､配列の生成および､そのｱﾄﾞﾚｽの代入は1行でok｡
  //          ↓
   int[] scores = new int[5];

    scores[1] = 30;
  //変数scoreにあるｱﾄﾞﾚｽを辿った先にある配列の1番の部屋に30を代入する｡

    System.out.println(scores[1]+"★");
  //変数scoreにあるｱﾄﾞﾚｽを辿った先にある配列の1番の部屋の値を出力｡


    //System.out.println(i);
    //変数iには何も代入していない(→初期化していない)ので､出力できない｡

    System.out.println(scores[0]);
    //配列には､型に合わせた初期値(intなら0､doubleなら0.0)が
    //自動的に入るので､何も代入せずに出力してもｴﾗｰにはならない｡

  }
}

