public class Q3 {
   public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            for (int i = 1; i <= (c - 'A' + 1); i++) {
                sb.append(c);
            }
        }
        
        String result = sb.toString();
        System.out.print(sb);

        System.out.print("A");
        int interval = 20;
        int length = result.length();
        for (int i = interval - 1; i < length; i += interval) {
            System.out.print(result.charAt(i));
        }
    }
}

// Easy as ABC
// 英語のアルファベット(A~Z)について、A から Z の順に
// 「n 番目の文字を n 個」(つまり、A を 1 個、B を 2個、C を 3 個、......、Z を 26 個)書きます。
// すると最終的に、次のような文字列(351 文字)が得られます。
// ABBCCCDDDDEE......ZZZZZZZZZZZZ
// この文字列を 1 行 20 文字の行に分けて書き直したとします。
// ABBCCCDDDDEEEEEFFFFF
// FGGGGGGGHHHHHHHHIIII
// I...
// このときに、各行の左端の文字を(上から下の順に)読んでできる文字列を答えてください。