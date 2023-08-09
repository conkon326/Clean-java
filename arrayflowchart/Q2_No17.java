public class Q2_No17 {

  public static void main(String[] args) {
    int[] a = { 100, 50, 200, 150, 300 };
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    int ave = sum / a.length;
    System.out.print(ave);
  }
}
