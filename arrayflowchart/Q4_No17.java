public class Q4_No17 {

  public static void main(String[] args) {
    int[] a = { 100, 50, 200, 150, 300 };
    int sum = 0;
    int max = 0;
    for (int i = 0; i < a.length; i++) {
      max = Math.max(max, a[i]);
      sum += a[i];
    }
    for (int j = 0; j < a.length; j++) {
      float ave = (float) a[j] / sum;
      if (a[j] == max) {
        System.out.println("最大値>" + a[j] + ":" + (ave * 100) + "%");
      } else {
        System.out.println("　　　 " + a[j] + ":" + (ave * 100) + "%");
      }
    }
  }
}
