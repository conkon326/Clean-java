public class Chap5_2 {

 public static void main(String[] args) {
    System.out.println("メソッドを呼び出す");
    Chap5_2.hello();
    hello();
    System.out.println("呼び出し終了");
    }

 public static void hello(){
    System.out.println("こんにちは");
 }

}
