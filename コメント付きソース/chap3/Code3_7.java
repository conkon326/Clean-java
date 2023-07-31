public class Code3_7{
  public static void main(String[] args){

    for( int i=0 ; i<10 ; i++){
  //     -------
  //    『初期値』の設定
  //               ----
  //               継続『条件』
  //                      ---
  //                      値の『操作』

      System.out.println("こんにちは"+i);
    }

    System.out.println("---------------------------------------");

    for( int j=0 ; j<2 ; j++){          //2回繰り返す

      for( int i=0 ; i<3 ; i++){           //3回繰り返す

        System.out.println("こんばんは " + j + " " +i);

      }

    }

  }
}
