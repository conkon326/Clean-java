public class Code4_11 {
  public static void main(String[] args){

    int[] scores = {20, 30, 40, 50, 80};

    int count = 0;

    for(int i = 0; i<scores.length; i++){

      if(scores[i] >= 50){
        count++;               //1‚¸‚Â‘‚â‚µ‚½‚¢
        //count += 1;          //“Á’è‚Ì”‚¾‚¯‘‚â‚µ‚½‚¢
        //count = count + 1    //ŒvZ‚µ‚½‚¢
      }

    }

    System.out.println("50“_ˆÈã‚Ì‰È–Ú‚Ì”‚Í:" + count);

  }
}

