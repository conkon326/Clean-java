public class Q3_No13 {

  public static void main(String[] args) {
    int[] a = { 100, 50, 200, 150, 300 };
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    float rat = 0;
    for (int j = 0; j < a.length; j++) {
      rat = (float) a[j] / sum * 100;
      System.out.println(rat + "%");
    }
  }
}
