import java.util.Scanner;

class KasukabeNezumyLand {

  String[] aveWord = { "平均来場者数　　　　>", "平均売上金額　　　　>" };
  int[] aveData = { 900, 2700000 };
  String[] targetWord = { "来場者達成率>", "売上達成率　>" };
  String[] groupAveWord;
  int[] groupAveData;
  String[] word;

  KasukabeNezumyLand(String[] groupAveWord, int[] groupAveData, String[] word) {
    this.groupAveWord = groupAveWord;
    this.groupAveData = groupAveData;
    this.word = word;
  }

  void outData(int choice) {
    for (int i = 0; i < aveData.length; i++) {
      System.out.println(aveWord[i] + aveData[i]);
      for (int x = 0; x < groupAveWord.length; x++) {
        System.out.println(groupAveWord[x] + groupAveData[x]);
      }
    }
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    System.out.println(
      targetWord[0] + ((double) yosou_guest / aveData[0] * 100) + "%"
    );
    System.out.println(
      targetWord[1] + ((double) yosou_sales / aveData[1] * 100) + "%"
    );
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales, int choice) {
    for (int i = 0; i < word.length; i++) {
      System.out.println(
        word[i] + (int) (yosou_guest * ((double) groupAveData[i+1] / aveData[0]))
      );
    }
  }

  void outLine() {
    System.out.println("------------------------------");
  }

  void outLine(String startend) {
    if (startend.equals("start") || startend.equals("end")) {
      System.out.println(
        "------------------------------" + startend.toUpperCase()
      );
    } else {
      outLine();
    }
  }
}

class Attraction extends KasukabeNezumyLand {

  Attraction() {
    super(
      new String[] {
        "乗り物利用者数　　　　>",
        "コースター平均利用者>",
        "観覧車平均利用者　　>",
        "回転木馬平均利用者　>",
      },
      new int[] { 1500, 500, 700, 300 },
      new String[] {
        "ジェットコースターの予想利用者数>",
        "観覧車の予想利用者数　　　　　　> ",
        "回転木馬予想利用者　　　　　　　>",
      }
    );
  }
}

class Vehicle extends KasukabeNezumyLand {

  Vehicle() {
    super(
      new String[] {
        "乗り物平均利用者　>",
        "バス平均利用者　　>",
        "汽車平均利用者　　>",
        "ゴンドラ平均利用者>",
      },
      new int[] { 1300, 200, 500, 600 },
      new String[] {
        "バスの予想利用者数　　>",
        "汽車の予想利用者数　　> ",
        "ゴンドラの予想利用者数> ",
      }
    );
  }
}

class Shop extends KasukabeNezumyLand {

  Shop() {
    super(
      new String[] {
        "チケット平均売上　>",
        "レストラン平均売上>",
        "売店平均売上　　　>",
        "グッズ平均売上　　>",
      },
      new int[] { 1700000, 500000, 200000, 300000 },
      new String[] {
        "チケットの予想収益　>",
        "レストランの予想収益> ",
        "売店の予想収益　　　> ",
        "グッズの予想収益　　> ",
      }
    );
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales, int choice) {
    for (int i = 0; i < word.length; i++) {
      System.out.println(
        word[i] + (int) (yosou_sales * ((double) groupAveData[i] / aveData[1]))
      );
    }
  }
}

public class Osarai7_9b {

  public static void main(String[] args) {
    int yosou_guest;
    long yosou_sales;
    int choice;

    Scanner scanner = new Scanner(System.in);

    System.out.print("予想来場者数を入力してください:");
    yosou_guest = scanner.nextInt();

    System.out.print("予想売上金額を入力してください: ");
    yosou_sales = yosou_guest * scanner.nextLong();

    KasukabeNezumyLand land = null;

    System.out.println("1. アトラクション");
    System.out.println("2. 乗り物");
    System.out.println("3. ショップ");
    System.out.print("処理対象を選んでください（1, 2, 3）: ");
    choice = scanner.nextInt();

    switch (choice) {
      case 1:
        land = new Attraction();
        break;
      case 2:
        land = new Vehicle();
        break;
      case 3:
        land = new Shop();
        break;
      default:
        System.out.println("無効な選択です。");
        scanner.close();
        return;
    }

    land.outLine("start");
    land.outData(choice);
    land.outLine();
    land.outYosouSalesAndGuest(yosou_guest, yosou_sales);
    land.outLine();
    land.outYosouSalesAndGuest(yosou_guest, yosou_sales, choice);
    land.outLine("end");

    scanner.close();
  }
}
