public class Chap5_10 {

  public static int add(int x, int y) {
    return x + y;
  }

  public static double add(double x, double y) {
    return x + y;
  }

  public static String add(String x, String y) {
    return x + y;
  }

  public static void main(String[] args) {
    System.out.println(add(10, 10));
    System.out.println(add(10.2, 10.3) 
    );
    System.out.println(add("10", "ss"));
  }
}
