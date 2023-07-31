import java.util.Scanner;

public class Osarai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("元の値を入力してください >");
        int a = scanner.nextInt();

        System.out.print("計算回数を入力してください >");
        int b = scanner.nextInt();

        for (int i = 0; i < b; i++) {
            System.out.println("値は" + ++a);
        }
    }
}
