public class Q6_No21 {

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; i >= j; j++) {
        if (i == j) {
          System.out.print("\u2606");
        } else {
          System.out.print("\u2605");
        }
      }
      System.out.print("\n");
    }
  }
}
