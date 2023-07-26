public class Code1_2{
  public static void main(String[] args){

    int age;      //ageという名前の入れ物(変数)を作る    │  │
                  //                                    x└─┘

    //System.out.println(age);
    //変数に何も入れない状態で出力はできない→ｴﾗｰ

    age = 30;     //変数ageに6を入れる(代入する)         │30│
                  //                                    x└─┘

    System.out.println(age);

    //age = 30.5;
    //      ----
    //      ﾌﾟﾛｸﾞﾗﾑ中に小数を直接書くと､double型として扱う
    //------
    //整数(int)型の変数に､小数(double)型の値は代入できない→ｴﾗｰ

    age = (int)30.5;
    //    -----
    //    強制的にint型に変換する事ができる…が､小数点以下が失われる

    System.out.println(age);

  }
}
