import java.util.Random;
public class Hima2_2 {
    public static void main(String[] args) {
        int i = new Random().nextInt(7) + 1;
        System.out.println("======= 判定 ======");
        if (i == 7) {
            System.out.println("大当たり！");
        } else if (i == 3) {
            System.out.println("当たり！");
        } else {
            System.out.println("ハズレ");
        }
        System.out.println("=======  END  ======");
    }}



// クラス名の修正：クラス名をHima2_2.javaからHima2_2に変更が必要。
// 乱数の取得：java.util.Random()のインスタンスを作成して乱数を取得するためには、newキーワードを使用が必要
// 比較演算子の修正：条件式で比較演算子==を使って値を比較する必要がある。現在のコードでは代入演算子=が使用されている
// 文法エラーの修正：不要なコロン(:)やセミコロン(;)が含まれているため、それらを削除する必要がある。



// public class Hima2_2.java {
// 	public static void main(String[] args) {
// 		int i = java.util.Random().nextInt();
// 		System.out.println(""):
// 		System.out.println("======= 判 定 ======");
// 		if (i=7) {
// 	　　	System.out.println("大当たり！");
// 		} else if (i=3) {
// 			System.out.println("当たり！");
// 		} else {
// 			System.out.println("ハズレ")；
// 		}
// 		System.out.println("=======  END  ======");
// 	}
// }
