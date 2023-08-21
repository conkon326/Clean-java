public class Chap5_11 {

  public static int add(int x, int y) {
    return x + y;
  }

  public static int add(int x, int y, int z) {
    return x + y + z;
  }

  public static void main(String[] args) {
    System.out.println(add(10, 10));
    System.out.println(add(10, 10, 10));
    System.out.println(args[0]);
    System.out.println(args[1]);
  }
}