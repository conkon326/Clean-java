public class Q2 {
  public static void main(String[] args) {
        int startingNum = 387420489;
        int iterations = 50;
        int result = startingNum;
        
        for (int i = 0; i < iterations; i++) {
            result = (int) (result * 0.8);
        }
        
        System.out.println(result);
    }
}


// 八割にしつづける
// ある整数に対して、「その整数を 0.8 倍して小数部を切り捨てた値に変換する」という操作を「八割にする」と 呼ぶことにする。

// 42 × 0.8 = 33.6 なので、42 を「八割にする」と 33 になる。
// 33 × 0.8 = 26.4 なので、33 を「八割にする」と 26 になる。
// 26 × 0.8 = 20.8 なので、26 を「八割にする」と 20 になる。
// 以上のように、42 を 3 回「八割にする」と 20 になる。それでは、387420489 を 50 回「八割にする」と最後に 得られる値は何になりますか。