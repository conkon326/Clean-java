public class Code4_15 {
  public static void main(String[] args){

    int[] arrayA = {1, 2, 3};

    int[] arrayB;

    arrayB = arrayA;
  //arrayAで管理している｢ｱﾄﾞﾚｽ｣をarrayBに代入する｡
  //→arrayAもarrayBも同じ｢ｱﾄﾞﾚｽ｣が入っているので､そのｱﾄﾞﾚｽを辿った
  //  先にある配列は同じﾓﾉになる｡

    arrayB[0] = 100;

  //System.out.println(arrayA[0]);

    for( int i=0; i<arrayA.length; i++ ){ //普通のfor文でarrayAを全て表示
      System.out.print(arrayA[i] + " ");
    }

    System.out.println("\n---------------");

    for( int j : arrayB ){                //拡張for文でarrayBを全て表示
      System.out.print(j + " ");
    }

  }
}

