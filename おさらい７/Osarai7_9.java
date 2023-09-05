import java.util.Scanner;

class KasukabeNezumyLand {

  int guest_ave = 900;
  long sales_ave = 2700000;

  String[] facilityNames;

  public KasukabeNezumyLand(String[] facilityNames) {
    this.facilityNames = facilityNames;
  }

  void outFacilityData(int[] facilityData) {
    for (int i = 0; i < facilityData.length; i++) {
      System.out.println(
        facilityNames[i] + "平均利用者数 > " + facilityData[i]
      );
    }
  }

  
   Object[][] data = {
            // [0] Attraction
            {
                new Object[] {"平均利用者数", 1500},
                new Object[] {"コースター平均利用者", 500},
                new Object[] {"観覧車平均利用者", 700},
                new Object[] {"回転木馬平均利用者", 300}
            },
            // [1] Vehicle
            {
                new Object[] {"乗り物平均利用者", 1300},
                new Object[] {"バス平均利用者", 200},
                new Object[] {"汽車利用者", 500},
                new Object[] {"ゴンドラ平均利用者", 600}
            },
            // [2] Shop
            {
                new Object[] {"チケット平均売上", 1700000},
                new Object[] {"レストラン平均売上", 500000},
                new Object[] {"売店平均売上", 200000},
                new Object[] {"グッズ平均売上", 300000}
            }
        };

  // 共通の予想収益と来場者数を表示するメソッド
  void outYosouSalesAndGuest(
    int yosou_guest,
    long yosou_sales,
    double[] facilityPercentage
  ) {
    System.out.println("予想来場者数 > " + yosou_guest + "名");
    for (int i = 0; i < facilityPercentage.length; i++) {
      System.out.println(
        facilityNames[i] +
        "の予想利用者数 > " +
        Math.round(yosou_guest * facilityPercentage[i]) +
        "名"
      );
    }
  }

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

  int[] attraction = { 1500, 500, 700, 300 };

  public Attraction(String[] facilityNames) {
    super(facilityNames);
  }

  void outData() {
    super.outData();
    outFacilityData(attraction);
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    double[] attractionPercentage = new double[attraction.length];

    for (int i = 0; i < attraction.length; i++) {
      attractionPercentage[i] = attraction[i] / (double) super.guest_ave;
    }

    super.outYosouSalesAndGuest(yosou_guest, yosou_sales, attractionPercentage);
  }
}

class Vehicle extends KasukabeNezumyLand {

  int[] vehicle = {1300,200, 500, 600 };

  public Vehicle(String[] facilityNames) {
    super(facilityNames);
  }

  void outData() {
    super.outData();
    outFacilityData(vehicle);
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    double[] vehiclePercentage = new double[vehicle.length];

    for (int i = 0; i < vehicle.length; i++) {
      vehiclePercentage[i] = vehicle[i] / (double) super.guest_ave;
    }

    super.outYosouSalesAndGuest(yosou_guest, yosou_sales, vehiclePercentage);
  }
}

class Shop extends KasukabeNezumyLand {

  long[] shop = {1700000, 500000, 200000, 300000 };

  public Shop(String[] facilityNames) {
    super(facilityNames);
  }

  void outData() {
    super.outData();
    System.out.println(
      "チケット平均売上 > " +
      shop[0] +
      "一人当たり" +
      (int) (shop[0] / guest_ave)
    );
    int[] shopInt = new int[shop.length];
    for (int i = 0; i < shop.length; i++) {
      shopInt[i] = (int) shop[i];
    }
    outFacilityData(shopInt);
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    double[] shopPercentage = new double[shop.length];

    for (int i = 0; i < shop.length; i++) {
      shopPercentage[i] = shop[i] / (double) super.sales_ave;
    }

    super.outYosouSalesAndGuest(yosou_guest, yosou_sales, shopPercentage);
  }
}

class Osarai7_9 {

  public static void main(String[] args) {
    int yosou_guest;
    long yosou_sales;

    Scanner scanner = new Scanner(System.in);

    System.out.print("予想来場者数を入力してください: ");
    yosou_guest = scanner.nextInt();

    System.out.print("予想売上金額を入力してください: ");
    yosou_sales = yosou_guest * scanner.nextLong();

    // 施設名の配列を作成
    String[] facilityNames = { "アトラクション", "乗り物", "ショップ" };

    KasukabeNezumyLand land = null;

    System.out.println("1. アトラクション");
    System.out.println("2. 乗り物");
    System.out.println("3. ショップ");
    System.out.print("処理対象を選んでください（1, 2, 3）: ");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        land = new Attraction(facilityNames);
        break;
      case 2:
        land = new Vehicle(facilityNames);
        break;
      case 3:
        land = new Shop(facilityNames);
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
