import java.util.Scanner;

class KasukabeNezumyLand {

  int guest_ave = 900;
  long sales_ave = 2700000;

  void outData() {
    System.out.println("平均来場者数　　　　>" + guest_ave);
    System.out.println("平均売上金額　　　　>" + sales_ave);
  }

  void outYosouSalesAndGuest(int a, long b) {
    System.out.println("来場者達成率>" + (double) a / guest_ave * 100 + "%");
    System.out.println("売上達成率　>" + (double) b / sales_ave * 100 + "%");
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
      System.out.println("------------------------------");
    }
  }
}

class Attraction extends KasukabeNezumyLand {

  int coaster_ave = 500;
  int wheel_ave = 700;
  int carousel_ave = 300;

  void outData() {
    super.outData();
    System.out.println("平均利用者数　　　　>" + guest_ave);
    System.out.println("コースター平均利用者>" + coaster_ave);
    System.out.println("観覧車平均利用者　　>" + wheel_ave);
    System.out.println("回転木馬平均利用者　>" + carousel_ave);
  }

  void outYosouSalesAndGuest(int yosou_guest) {
    double coasterPercentage = ((double) coaster_ave / guest_ave);
    double wheelPercentage = ((double) wheel_ave / guest_ave);
    double carouselPercentage = ((double) carousel_ave / guest_ave);

    System.out.println(
      "予想利用者数> " +
      (
        Math.round(yosou_guest * carouselPercentage) +
        Math.round(yosou_guest * wheelPercentage) +
        Math.round(yosou_guest * coasterPercentage)
      ) +
      "名"
    );
    System.out.println(
      "ジェットコースターの予想利用者数>" +
      Math.round(yosou_guest * coasterPercentage) +
      "名"
    );
    System.out.println(
      "観覧車の予想利用者数> " +
      Math.round(yosou_guest * wheelPercentage) +
      "名"
    );
    System.out.println(
      "メリーゴーランドの予想利用者数> " +
      Math.round(yosou_guest * carouselPercentage) +
      "名"
    );
  }
}

class Vehicle extends KasukabeNezumyLand {

  int bus_ave = 200;
  int train_ave = 500;
  int gondola_ave = 600;

  void outData() {
    super.outData();
    System.out.println("バス平均利用者>" + bus_ave);
    System.out.println("汽車平均利用者　　>" + train_ave);
    System.out.println("ゴンドラ平均利用者　>" + gondola_ave);
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    double busrPercentage = ((double) bus_ave / guest_ave);
    double trainPercentage = ((double) train_ave / guest_ave);
    double carouselPercentage = ((double) gondola_ave / guest_ave);

    System.out.println(
      "バスの予想利用者数>" + Math.round(yosou_guest * busrPercentage) + "名"
    );
    System.out.println(
      "汽車の予想利用者数> " + Math.round(yosou_guest * trainPercentage) + "名"
    );
    System.out.println(
      "ゴンドラの予想利用者数> " +
      Math.round(yosou_guest * carouselPercentage) +
      "名"
    );
  }
}

class Shop extends Vehicle {

  long restaurant_ave = 500000;
  long foods_ave = 200000;
  long goods_ave = 300000;

  void outData() {
    long ticket_ave = sales_ave - restaurant_ave - foods_ave - goods_ave;
    super.outData();
    System.out.println(
      "チケット平均売上　>" +
      ticket_ave +
      "一人当たり" +
      (int) (ticket_ave / guest_ave)
    );
    System.out.println(
      "レストラン平均売上>" +
      restaurant_ave +
      "一人当たり" +
      (int) (restaurant_ave / guest_ave)
    );
    System.out.println(
      "売店平均売上　　　>" +
      foods_ave +
      "一人当たり" +
      (int) (foods_ave / guest_ave)
    );
    System.out.println(
      "グッズ平均売上　　>" +
      goods_ave +
      "一人当たり" +
      (int) (goods_ave / guest_ave)
    );
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    double restaurantPercentage = ((double) restaurant_ave / sales_ave);
    double foodsPercentage = ((double) foods_ave / sales_ave);
    double goodsPercentage = ((double) goods_ave / sales_ave);

    System.out.println(
      "レストラン割合" + Math.round(restaurantPercentage * 100) + "%"
    );
    System.out.println("売店割合" + Math.round(foodsPercentage * 100) + "%");
    System.out.println("グッズ割合" + Math.round(goodsPercentage * 100) + "%");

    System.out.println(
      "レストランの予想収益>" +
      Math.round(yosou_sales * restaurantPercentage) +
      "円"
    );
    System.out.println(
      "売店の予想収益> " + Math.round(yosou_sales * foodsPercentage) + "円"
    );
    System.out.println(
      "グッズの予想収益> " + Math.round(yosou_sales * goodsPercentage) + "円"
    );
  }
}

class Osarai7_8 {

  public static void main(String[] args) {
    int yosou_guest;
    long yosou_sales;

    Scanner scanner = new Scanner(System.in);

    System.out.print("予想来場者数を入力してください: ");
    yosou_guest = scanner.nextInt();

    System.out.print("予想売上金額を入力してください: ");
    yosou_sales = scanner.nextLong();

    KasukabeNezumyLand land = null;

    System.out.println("1. アトラクション");
    System.out.println("2. 乗り物");
    System.out.println("3. ショップ");
    System.out.print("処理対象を選んでください（1, 2, 3）: ");
    int choice = scanner.nextInt();

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
    land.outData();
    land.outLine();

    land.outYosouSalesAndGuest(yosou_guest, yosou_sales);

    land.outLine("end");

    scanner.close();
  }
}
