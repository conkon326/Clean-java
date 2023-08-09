public class Q3_No08 {

  public static void main(String[] args) {
    for (int j = 0; j < 5; j++) {
      for (int i = 0; i < 5; i++) {
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
