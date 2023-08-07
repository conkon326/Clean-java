public class Q5 {

  public static void main(String[] args) {
    int count = 0;

    for (int num = 1; num <= 1000000; num++) {
      int operations = 0;
      int currentNum = num;

      while (currentNum >= 10) {
        int product = 1;

        while (currentNum > 0) {
          int digit = currentNum % 10;
          product *= digit;
          currentNum /= 10;
        }

        currentNum = product;
        operations++;
      }

      if (operations == 4) {
        count++;
      }
    }

    System.out.println(count);
  }
}
