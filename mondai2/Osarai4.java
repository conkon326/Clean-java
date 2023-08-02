import java.util.Scanner;

public class Osarai4 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tensu[] = new int[3];
    int goukei = 0;
    for (int i = 0; i < 3; i++) {
      System.out.print((i + 1) + "教科目の点数を入力してください>");
      tensu[i] = scanner.nextInt();
    }

    for (int i = 0; i < tensu.length; i++) {
      goukei += tensu[i];
    }

    double avg = goukei / 3;

    System.out.println("合計点は" + goukei + "点");
    System.out.println("平均点は" + avg + "点");
  }
}
