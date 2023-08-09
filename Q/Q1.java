public class Q1 {
    public static void main(String[] args) {
        long num = 1470268800;
        int lowLimit = 10000;// スタート
        int upLimit = 99999;// ラスト

        long sum = 0;

        for (long i = lowLimit; i <= upLimit; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}

// 約数をひたすら足していく
// 1470268800の正の約数のうち、
// 10000 以上 99999 以下の範囲にあるものを全て足し合わせたときの和を求めてください。
