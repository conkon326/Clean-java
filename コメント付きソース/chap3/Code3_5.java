public class Code3_5 {
  public static void main(String[] args) {

    System.out.println("あなたの運勢を占います");

    int fortune = 3;

//  javaのswitch〜case文は『多分岐』ではない。

//  javaのswitch〜case文は､どのﾀｲﾐﾝｸﾞで処理の流れに乗せるか
//                                                 …という処理。
//  switch〜caseを抜ける『break』を活用する事で､
//  多分岐のように処理する事ができる｡


    switch(fortune){
      case 1:
        System.out.println("大吉");
        //break;
      case 2:
        System.out.println("中吉");
        break;
      case 3:
        System.out.println("吉");
        break;
      default:
        System.out.println("凶");
    }


  }
}