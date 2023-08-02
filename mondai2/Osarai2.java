import java.util.Scanner;

public class Osarai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("元の値を入力してください >");
        int a = scanner.nextInt();

        System.out.print("計算回数を入力してください >");
        int b = scanner.nextInt();

        System.out.print("++ or -- >");
        String operator = scanner.next();

        for (int i = 0; i < b; i++) {
            if (operator.equals("++")) {
                System.out.println("値は" + ++a);
            } else if (operator.equals("--")) {
                System.out.println("値は" + --a);
            } else {
                System.out.println("無効なオペレーターです。++ または -- を入力してください。");
                break;
            }
        }
    }
}
