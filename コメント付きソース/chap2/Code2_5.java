public class Code2_5{
  public static void main(String[] args){

    float  f = 3;

    //前提として…javaの代入は､代入先(左辺)と代入元(右辺)が
    //同じ型でなければ代入できない。

    double d = f;

    //代入先の型が大きければ､まずその型に合わせて代入元を変換
    //した上で代入してくれる。

    System.out.println(f);
    System.out.println(d);

//----

/*
    double d2 = 3;

    float  f2 = d2;
    //double型(大きい)からfloat型(小さい)に代入する事はできない

    System.out.println(d2);
    System.out.println(f2);
*/

  }
}
