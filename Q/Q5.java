public class Q5 {

  public static void main(String[] args) {
    int count = 0;

    for (int num = 1; num <= 1000000; num++) {
      int operations = 0;
      int currentNum = num;

      while (currentNum >= 10) {
        int product = 1;

        while (currentNum > 0) {
          int digit = currentNum % 10;
          product *= digit;
          currentNum /= 10;
        }

        currentNum = product;
        operations++;
      }

      if (operations == 4) {
        count++;
      }
    }

    System.out.println(count);
  }
}


// 掛け算耐性
// 整数に対して、「一桁ことにばらして各桁の数字の積を求める」という操作を考えます。

// 123 → 1 × 2 × 3 = 6
// 666 → 6 × 6 × 6 = 216
// 1024 → 1 × 0 × 2 × 4 = 0
// 任意の整数について、「操作」を繰り返し適用すると、最終的には一桁の数に到達します。

// 77 → 49 → 36 → 18 → 8
// 123456 → 720 → 0
// 一桁の数に到達するのに必要な「操作」の回数は、77では4回、123456では2回となります。

// それでは、1000000以下の整数のうち、一桁の数に到達するのに必要な「操作」の回数が4回となるものはいくつあるかを、求めてください。
