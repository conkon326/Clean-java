import java.util.Scanner;

public class Osarai5 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tensu[][] = new int[4][3];
    int goukei = 0;

    for (int i = 0; i < tensu.length; i++) {
      for (int a = 0; a < tensu[i].length; a++) {
        System.out.print(
          (i + 1) + "人目の" + (a + 1) + "教科目の点数を入力してください>"
        );

        tensu[i][a] = scanner.nextInt();
        goukei += tensu[i][a];
      }
    }

    double avg = goukei / 3;

    System.out.println("合計点は" + goukei + "点");
    System.out.println("平均点は" + avg + "点");
  }
}
