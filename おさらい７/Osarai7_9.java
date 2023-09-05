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
        facilityNames[i] + "���ϗ��p�Ґ� > " + facilityData[i]
      );
    }
  }

  
   Object[][] data = {
            // [0] Attraction
            {
                new Object[] {"���ϗ��p�Ґ�", 1500},
                new Object[] {"�R�[�X�^�[���ϗ��p��", 500},
                new Object[] {"�ϗ��ԕ��ϗ��p��", 700},
                new Object[] {"��]�ؔn���ϗ��p��", 300}
            },
            // [1] Vehicle
            {
                new Object[] {"��蕨���ϗ��p��", 1300},
                new Object[] {"�o�X���ϗ��p��", 200},
                new Object[] {"�D�ԗ��p��", 500},
                new Object[] {"�S���h�����ϗ��p��", 600}
            },
            // [2] Shop
            {
                new Object[] {"�`�P�b�g���ϔ���", 1700000},
                new Object[] {"���X�g�������ϔ���", 500000},
                new Object[] {"���X���ϔ���", 200000},
                new Object[] {"�O�b�Y���ϔ���", 300000}
            }
        };

  // ���ʂ̗\�z���v�Ɨ���Ґ���\�����郁�\�b�h
  void outYosouSalesAndGuest(
    int yosou_guest,
    long yosou_sales,
    double[] facilityPercentage
  ) {
    System.out.println("�\�z����Ґ� > " + yosou_guest + "��");
    for (int i = 0; i < facilityPercentage.length; i++) {
      System.out.println(
        facilityNames[i] +
        "�̗\�z���p�Ґ� > " +
        Math.round(yosou_guest * facilityPercentage[i]) +
        "��"
      );
    }
  }

  void outData() {
    System.out.println("���ϗ���Ґ��@�@�@�@>" + guest_ave);
    System.out.println("���ϔ�����z�@�@�@�@>" + sales_ave);
  }

  void outYosouSalesAndGuest(int a, long b) {
    System.out.println("����ҒB����>" + (double) a / guest_ave * 100 + "%");
    System.out.println("����B�����@>" + (double) b / sales_ave * 100 + "%");
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
      "�`�P�b�g���ϔ��� > " +
      shop[0] +
      "��l������" +
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

    System.out.print("�\�z����Ґ�����͂��Ă�������: ");
    yosou_guest = scanner.nextInt();

    System.out.print("�\�z������z����͂��Ă�������: ");
    yosou_sales = yosou_guest * scanner.nextLong();

    // �{�ݖ��̔z����쐬
    String[] facilityNames = { "�A�g���N�V����", "��蕨", "�V���b�v" };

    KasukabeNezumyLand land = null;

    System.out.println("1. �A�g���N�V����");
    System.out.println("2. ��蕨");
    System.out.println("3. �V���b�v");
    System.out.print("�����Ώۂ�I��ł��������i1, 2, 3�j: ");
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
        System.out.println("�����ȑI���ł��B");
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
