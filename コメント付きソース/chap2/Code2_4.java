public class Code2_4{
  public static void main(String[] args){

    int a;      //int型(整数を管理する型)の変数aを宣言
    a = 100;    //変数aに100を代入

    a++;
    System.out.println(a);          //101


    System.out.println(++a);        //102
    //まず最初に1増やして､出力する

    System.out.println(a++);        //102
    //出力してから､最後に1増やす

    System.out.println(a);          //103

  }
}
