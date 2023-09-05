import java.util.Scanner;

class KasukabeNezumyLand {

  Object[][][] aveData = {
    // 0
    {
      new Object[] {
        "\u5E73\u5747\u6765\u5834\u8005\u6570\u3000\u3000\u3000\u3000>",
        900,
      },
      new Object[] {
        "\u5E73\u5747\u58F2\u4E0A\u91D1\u984D\u3000\u3000\u3000\u3000>",
        2700000,
      },
    },
    // 1Attraction
    {
      new Object[] {
        "\u4E57\u308A\u7269\u5229\u7528\u8005\u6570\u3000\u3000\u3000\u3000>",
        1500,
      },
      new Object[] {
        "\u30B3\u30FC\u30B9\u30BF\u30FC\u5E73\u5747\u5229\u7528\u8005>",
        500,
      },
      new Object[] {
        "\u89B3\u89A7\u8ECA\u5E73\u5747\u5229\u7528\u8005\u3000\u3000>",
        700,
      },
      new Object[] {
        "\u56DE\u8EE2\u6728\u99AC\u5E73\u5747\u5229\u7528\u8005\u3000>",
        300,
      },
    },
    // 2Vehicle
    {
      new Object[] {
        "\u4E57\u308A\u7269\u5E73\u5747\u5229\u7528\u8005\u3000>",
        1300,
      },
      new Object[] {
        "\u30D0\u30B9\u5E73\u5747\u5229\u7528\u8005\u3000\u3000>",
        200,
      },
      new Object[] {
        "\u6C7D\u8ECA\u5E73\u5747\u5229\u7528\u8005\u3000\u3000>",
        500,
      },
      new Object[] {
        "\u30B4\u30F3\u30C9\u30E9\u5E73\u5747\u5229\u7528\u8005>",
        600,
      },
    },
    // 3Shop
    {
      new Object[] {
        "\u30C1\u30B1\u30C3\u30C8\u5E73\u5747\u58F2\u4E0A\u3000>",
        1700000,
      },
      new Object[] {
        "\u30EC\u30B9\u30C8\u30E9\u30F3\u5E73\u5747\u58F2\u4E0A>",
        500000,
      },
      new Object[] {
        "\u58F2\u5E97\u5E73\u5747\u58F2\u4E0A\u3000\u3000\u3000>",
        200000,
      },
      new Object[] {
        "\u30B0\u30C3\u30BA\u5E73\u5747\u58F2\u4E0A\u3000\u3000>",
        300000,
      },
    },
  };

  String[][] yosouWord = {
    {
      "\u6765\u5834\u8005\u9054\u6210\u7387>",
      "\u58F2\u4E0A\u9054\u6210\u7387\u3000>",
    },
    // 1Attraction

    {
      "\u30B8\u30A7\u30C3\u30C8\u30B3\u30FC\u30B9\u30BF\u30FC\u306E\u4E88\u60F3\u5229\u7528\u8005\u6570>",
      "\u89B3\u89A7\u8ECA\u306E\u4E88\u60F3\u5229\u7528\u8005\u6570\u3000\u3000\u3000\u3000\u3000\u3000> ",
      "\u56DE\u8EE2\u6728\u99AC\u4E88\u60F3\u5229\u7528\u8005\u3000\u3000\u3000\u3000\u3000\u3000\u3000>",
    },
    // 2Vehicle

    {
      "\u30D0\u30B9\u306E\u4E88\u60F3\u5229\u7528\u8005\u6570\u3000\u3000>",
      "\u6C7D\u8ECA\u306E\u4E88\u60F3\u5229\u7528\u8005\u6570\u3000\u3000> ",
      "\u30B4\u30F3\u30C9\u30E9\u306E\u4E88\u60F3\u5229\u7528\u8005\u6570> ",
    },
    // 3Shop

    {
      "\u30C1\u30B1\u30C3\u30C8\u5E73\u5747\u58F2\u4E0A\u3000>",
      "\u30EC\u30B9\u30C8\u30E9\u30F3\u5E73\u5747\u58F2\u4E0A>",
      "\u58F2\u5E97\u5E73\u5747\u58F2\u4E0A\u3000\u3000\u3000>",
      "\u30B0\u30C3\u30BA\u5E73\u5747\u58F2\u4E0A\u3000\u3000>",
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
              (double) (
                (double) aveData[choice][i][1] / (double) (aveData[0][0][1])
              )
            )
          )
        );
      }
    } else {
      for (int i = 0; i < yosouWord[choice].length; i++) {
        System.out.println(
          yosouWord[choice][i] +
          String.valueOf(
            (long) (
              yosou_sales *
              (double) (
                (double) (aveData[choice][i][1]) / (double) (aveData[0][1][1])
              )
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

    System.out.print(
      "\u4E88\u60F3\u6765\u5834\u8005\u6570\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044:"
    );
    yosou_guest = scanner.nextInt();

    System.out.print(
      "\u4E88\u60F3\u58F2\u4E0A\u91D1\u984D\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044: "
    );
    yosou_sales = yosou_guest * scanner.nextLong();

    KasukabeNezumyLand land = null;

    System.out.println("1. \u30A2\u30C8\u30E9\u30AF\u30B7\u30E7\u30F3");
    System.out.println("2. \u4E57\u308A\u7269");
    System.out.println("3. \u30B7\u30E7\u30C3\u30D7");
    System.out.print(
      "\u51E6\u7406\u5BFE\u8C61\u3092\u9078\u3093\u3067\u304F\u3060\u3055\u3044\uFF081, 2, 3\uFF09: "
    );
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
        System.out.println("\u7121\u52B9\u306A\u9078\u629E\u3067\u3059\u3002");
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
