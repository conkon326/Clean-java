public class Code3_4 {
  public static void main(String[] args) {

    System.out.println("あなたの運勢を占います");

    int fortune = new java.util.Random().nextInt(4) + 1;
  //              ----------------------
  //              java.utilﾊﾟｯｹｰｼﾞに所属する､
  //              Randomｸﾗｽのｺﾋﾟｰ(ｲﾝｽﾀﾝｽ)を新しく作る｡
  //                                ↓
  //                             ｲﾝｽﾀﾝｽ.nextInt(4)
  //                             -----------------
  //                         ｲﾝｽﾀﾝｽ内にある､nextIntﾒｿｯﾄﾞに4を渡して実行
  //                         nextIntはｾﾞﾛ〜渡した値未満の乱数を返す｡
  //                                     ↓
  //                                 0〜3のいずれか + 1
  //                                 ------------------
  //                    0〜3のいずれかに｢+1｣の補正をして､1〜4の値にする｡

/*
    //▼if文のみで記述する場合…
    if(fortune == 1){
      System.out.println("大吉★");
    }
    if(fortune == 2){
      System.out.println("中吉");
    }
    if(fortune == 3){
      System.out.println("吉");
    }
    if(fortune == 4){
      System.out.println("凶");
    }
    //どの値でも必ず4回比較するので､時間的にﾛｽがある｡
*/
/*
    //▼else時のみ､次のif文で比較を行う
    if(fortune == 1){
        System.out.println("大吉★");
    }else{
        if(fortune == 2){
            System.out.println("中吉");
        }else{
           if(fortune == 3){
               System.out.println("吉");
           }else{
               System.out.println("凶");
           }
       }
    }
    //時間的なﾛｽな無いが､行の開始位置がどんどん深くなってしまう｡
*/
    //▼elseに､すぐif文で判断する時は繋げて記述する事ができる｡
    if(fortune == 1){
      System.out.println("大吉");

    }else if(fortune == 2){
      System.out.println("中吉");

    }else if(fortune == 3){
      System.out.println("吉");

    }else{
      System.out.println("凶");
    }
    //この記述を行う事で､開始位置が深くならない｡

  }
}