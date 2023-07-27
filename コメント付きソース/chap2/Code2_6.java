public class Code2_6{
  public static void main(String[] args){

    //int  i = 3.0;
    //         ---
    //         ﾌﾟﾛｸﾞﾗﾑ中に小数を記述するとdouble型として扱うので…
    //---------
    //…ｻｲｽﾞの小さいint型に代入する事はできない→ｴﾗｰ


    //▼強制的に型変換(ｷｬｽﾄ)する事でｴﾗｰを回避できる｡

    int  i = (int)3.2;
  //         -----
  //         3.2を強制的にint型に変換している｡
  //         int型は『整数型』なので､小数点以下が失われてしまう｡

    System.out.println(i);

  }
}
