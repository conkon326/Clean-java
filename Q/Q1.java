public class Q1 {
    public static void main(String[] args) {
        long num = 1470268800;
        int lowLimit = 10000;
        int upLimit = 99999;

        long sum = 0;

        for (long i = lowLimit; i <= upLimit; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}