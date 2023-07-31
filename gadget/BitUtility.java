import java.util.Random;
import java.util.Scanner;

// 8ビット2進数を10進数に変換するゲーム
public class BitUtility {

    public static void main(String[] args) {
        int[] binary_bits = new int[8];
        for (int i = 0; i < binary_bits.length; i++) {
            binary_bits[i] = new Random().nextInt(2);
            System.out.print(binary_bits[i]);
        }
        System.out.print("\n");

        int num = 0;
        int[] Decimal = { 128, 64, 32, 16, 8, 4, 2, 1 };
        for (int i = 0; i < binary_bits.length; i++) {
            num += (binary_bits[i] * Decimal[i]);
        }

        Scanner scanner = new Scanner(System.in);
        int userGuess = scanner.nextInt();

        if (userGuess == num) {
            System.out.print("正解！");
        } else {
            System.out.print("不正解。正解は " + num);
        }

        scanner.close();
    }
}
