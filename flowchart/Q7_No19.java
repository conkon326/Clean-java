public class Q7_No19 {

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if ((i + j) % 2 == 0) {
          System.out.print("\u2605");
        } else {
          System.out.print("\u2606");
        }
      }
      System.out.print("\n");
    }
  }
}
