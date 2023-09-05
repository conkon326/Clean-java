import java.util.Scanner;

class KasukabeNezumyLand {

  Object[][][] aveData = {
    // 0平均
    {
      new Object[] { "平均来場者数　　　　>", 900 },
      new Object[] { "平均売上金額　　　　>", 2700000 },
    },
    // 1Attraction
    {
      new Object[] { "乗り物利用者数　　　　>", 1500 },
      new Object[] { "コースター平均利用者>", 500 },
      new Object[] { "観覧車平均利用者　　>", 700 },
      new Object[] { "回転木馬平均利用者　>", 300 },
    },
    // 2Vehicle
    {
      new Object[] { "乗り物平均利用者　>", 1300 },
      new Object[] { "バス平均利用者　　>", 200 },
      new Object[] { "汽車平均利用者　　>", 500 },
      new Object[] { "ゴンドラ平均利用者>", 600 },
    },
    // 3Shop
    {
      new Object[] { "チケット平均売上　>", 1700000 },
      new Object[] { "レストラン平均売上>", 500000 },
      new Object[] { "売店平均売上　　　>", 200000 },
      new Object[] { "グッズ平均売上　　>", 300000 },
    },
  };

  String[][] yosouWord = {
    // 0平均
    { "来場者達成率>", "売上達成率　>" },
    // 1Attraction

    {
      "ジェットコースターの予想利用者数>",
      "観覧車の予想利用者数　　　　　　> ",
      "回転木馬予想利用者　　　　　　　>",
    },
    // 2Vehicle

    {
      "バスの予想利用者数　　>",
      "汽車の予想利用者数　　> ",
      "ゴンドラの予想利用者数> ",
    },
    // 3Shop

    {
      "チケット平均売上　>",
      "レストラン平均売上>",
      "売店平均売上　　　>",
      "グッズ平均売上　　>",
    },
  };

  void outData(int choice) {
    for (int i = 0; i < aveData[0].length; i++) {
      System.out.println((String) aveData[0][i][0] + (int) aveData[0][i][1]);
    }
    for (int i = 0; i < aveData[choice].length; i++) {
      System.out.println(
        (String) aveData[choice][i][0] + (int) aveData[choice][i][1]
      );
    }
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    System.out.println(
      yosouWord[0][0] +
      String.valueOf((double) yosou_guest / (int) aveData[0][0][1] * 100) +
      "%"
    );
    System.out.println(
      yosouWord[0][1] +
      String.valueOf((double) yosou_sales / (int) aveData[0][1][1] * 100) +
      "%"
    );
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales, int choice) {
    if (choice == 1 || choice == 2) {
      for (int i = 0; i < yosouWord[choice].length; i++) {
        System.out.println(
          yosouWord[choice][i] +
          String.valueOf(
            (int) (
              (double) yosou_guest *
              (double) ((double) aveData[choice][i][1] / (double) (aveData[0][0][1]))
            )
          )
        );
      }
    } else {
      for (int i = 0; i < yosouWord[choice].length; i++) {
        System.out.println(
          yosouWord[choice][i] +
          String.valueOf(
            (long) (yosou_sales *
              (double) ((int) (aveData[choice][i][1]) / (double) (aveData[0][1][1]))
            )
          )
        );
      }
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

class Attraction extends KasukabeNezumyLand {}

class Vehicle extends KasukabeNezumyLand {}

class Shop extends KasukabeNezumyLand {}

class Osarai7_9a {

  public static void main(String[] args) {
    int yosou_guest;
    long yosou_sales;
    int choice;

    Scanner scanner = new Scanner(System.in);

    System.out.print("予想来場者数を入力してください:");
    yosou_guest = scanner.nextInt();

    System.out.print("予想売上金額を入力してください: ");
    yosou_sales = yosou_guest * scanner.nextLong();

    // 施設名の配列を作成
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
    land.outYosouSalesAndGuest(yosou_guest, yosou_sales, choice);
    land.outLine("end");

    scanner.close();
  }
}
