import java.util.Scanner;

public class Osarai3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print(
      "\u56FD\u8A9E\u306E\u70B9\u6570\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044 >"
    );
    int kokugo = scanner.nextInt();

    System.out.print(
      "\u6570\u5B66\u306E\u70B9\u6570\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044 >"
    );
    int suugaku = scanner.nextInt();

    System.out.print(
      "\u82F1\u8A9E\u306E\u70B9\u6570\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044 >"
    );
    int eigo = scanner.nextInt();
    int goukei = kokugo + suugaku + eigo;

    double avg = goukei / 3;

    System.out.println("合計点は" + goukei + "点");
    System.out.println("平均点は" + avg + "点");
  }
}
