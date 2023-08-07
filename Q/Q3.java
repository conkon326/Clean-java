public class Q3 {
   public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            for (int i = 1; i <= (c - 'A' + 1); i++) {
                sb.append(c);
            }
        }
        
        String result = sb.toString();
        
        System.out.print("A");
        int interval = 20;
        int length = result.length();
        for (int i = interval - 1; i < length; i += interval) {
            System.out.print(result.charAt(i));
        }
    }
}