public class Code2_8{
  public static void main(String[] args){

    //前提として…javaの『代入』は(基本的に)同じ型同士でないとできない｡
    //『計算』も代入と一緒で､同じ型同士じゃないと計算できない｡

    //型が違う場合は､小さい方を大きい方と同じ型に変換してから計算する｡

    double d = 8.5 / 2;
  //           ---
  //        double型として扱う
  //                 -
  //               int型として扱う
  //              ---
  //        double型とint型は型違いで計算できないので､大きい方のdouble型
  //        に合わせてから計算する｡

  //                 int
  //                  ↓       まず変換してから…
  //       double / double     計算を行う｡


    long l = 5 + 2L;
  //        int
  //         ↓
  //       long + long


    System.out.println(d);

    System.out.println(l);

  }
}
