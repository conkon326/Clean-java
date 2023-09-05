class KasukabeNezumyLand {

  int guest_ave = 900;
  long sales_ave = 2700000;

  void outData() {
    System.out.println("平均来場者数　　　　>" + guest_ave);
    System.out.println("平均売上金額　　　　>" + sales_ave);
  }

  void outYosouSalesAndGuest(int a, long b) {
    System.out.println("来場者達成率>" + (double) a / guest_ave * 100 +"%");
    System.out.println("売上達成率　>" + (double) b / sales_ave * 100 +"%");
  }
}

class Attraction extends KasukabeNezumyLand {

  int guest_ave = 1500;
  int coaster_ave = 500;
  int wheel_ave = 700;
  int carousel_ave = 300;

  void outLine() {
    System.out.println("------------------------------");
  }

  void outLine(String startend) {
    if (startend.equals("start") || startend.equals("end")) {
      System.out.println("------------------------------" + startend);
    } else {
      System.out.println("------------------------------");
    }
  }

  void outData() {
    super.outData();
    System.out.println("平均利用者数　　　　>" + guest_ave);
    System.out.println("コースター平均利用者>" + coaster_ave);
    System.out.println("観覧車平均利用者　　>" + wheel_ave);
    System.out.println("回転木馬平均利用者　>" + carousel_ave);
  }

  void outYosouSalesAndGuest(int yosou_guest) {
    KasukabeNezumyLand kasukabe = new KasukabeNezumyLand();

    double coasterPercentage = ((double) coaster_ave / kasukabe.guest_ave);
    double wheelPercentage = ((double) wheel_ave / kasukabe.guest_ave);
    double carouselPercentage = ((double) carousel_ave / kasukabe.guest_ave);

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

  void outLine() {
    System.out.println("------------------------------");
  }

  void outLine(String startend) {
    if (startend.equals("start") || startend.equals("end")) {
      System.out.println("------------------------------" + startend);
    } else {
      System.out.println("------------------------------");
    }
  }

  void outData() {
    super.outData();
    System.out.println("バス平均利用者>" + bus_ave);
    System.out.println("汽車平均利用者　　>" + train_ave);
    System.out.println("ゴンドラ平均利用者　>" + gondola_ave);
  }

  void outYosouSalesAndGuest(int yosou_guest) {
    KasukabeNezumyLand kasukabe = new KasukabeNezumyLand();

    double busrPercentage = ((double) bus_ave / super.guest_ave);
    double trainPercentage = ((double) train_ave / super.guest_ave);
    double carouselPercentage = ((double) gondola_ave / super.guest_ave);

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

class Shop extends KasukabeNezumyLand {

  long restaurant_ave = 500000;
  long foods_ave = 200000;
  long goods_ave = 300000;
  long ticket_ave =
    super.sales_ave - restaurant_ave - foods_ave - goods_ave;

  void outData() {
    KasukabeNezumyLand kasukabe = new KasukabeNezumyLand();
    long ticket_ave =
      kasukabe.sales_ave - restaurant_ave - foods_ave - goods_ave;
    super.outData();
    System.out.println("チケット平均売上　>" + ticket_ave);
    System.out.println("レストラン平均売上>" + restaurant_ave);
    System.out.println("売店平均売上　　　>" + foods_ave);
    System.out.println("グッズ平均売上　　>" + goods_ave);
  }
}

public class Osarai7_5 {

  public static void main(String[] args) {
    int yosou_guest;
    long yosou_sales;
    System.out.print(
      "\u4E88\u60F3\u5165\u5834\u8005\u6570\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044 >"
    );
    yosou_guest = new java.util.Scanner(System.in).nextInt();

    System.out.print(
      "\u4E88\u60F3\u5BA2\u5358\u4FA1\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044 > "
    );
    yosou_sales = yosou_guest * new java.util.Scanner(System.in).nextLong();
    Attraction att = new Attraction();
    Vehicle veh = new Vehicle();
    Shop s = new Shop();

    att.outLine("start");
    att.outData();
    att.outLine();
    att.outYosouSalesAndGuest(yosou_guest);
    att.outYosouSalesAndGuest(yosou_guest, yosou_sales);
    att.outLine("end");

    veh.outLine("start");
    veh.outData();
    veh.outLine();
    veh.outYosouSalesAndGuest(yosou_guest);
    veh.outYosouSalesAndGuest(yosou_guest, yosou_sales);
    att.outLine("end");
    veh.outLine("start");

    s.outData();
  }
}
