public class Code4_11 {
  public static void main(String[] args){

    int[] scores = {20, 30, 40, 50, 80};

    int count = 0;

    for(int i = 0; i<scores.length; i++){

      if(scores[i] >= 50){
        count++;               //1ずつ増やしたい
        //count += 1;          //特定の数だけ増やしたい
        //count = count + 1    //計算したい
      }

    }

    System.out.println("50点以上の科目の数は:" + count);

  }
}

