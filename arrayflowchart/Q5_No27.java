public class Q5_No27 {

  public static void main(String[] args) {
    int[] a = { 100, -50, 200, 150, -300 };
    int ps = 0;
    int ms = 0;

    for (int i = 0; i < a.length; i++) {
      if (a[i] >= 0) {
        ps += a[i];
      } else {
        ms += a[i];
      }
    }
    System.out.print("³‚Ì‡Œv" + ":" + ps);
    System.out.println();
    System.out.print("•‰‚Ì‡Œv" + ":" + ms);
  }
}
