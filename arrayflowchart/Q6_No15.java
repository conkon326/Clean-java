public class Q6_No15 {

  public static void main(String[] args) {
    int[] a = { 100, -50, 200, 150, -300 };
    java.util.Arrays.sort(a);
    int last_array_index = a.length - 1;
    double sum = 0;
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || i == last_array_index) {
      } else {

        sum += a[i];
      }
    }
    System.out.print(sum / (a.length - 2));
  }
}
