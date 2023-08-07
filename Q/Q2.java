public class Q2 {
  public static void main(String[] args) {
        int startingNum = 387420489;
        int iterations = 50;
        int result = startingNum;
        
        for (int i = 0; i < iterations; i++) {
            result = (int) (result * 0.8);
        }
        
        System.out.println(result);
    }
}
