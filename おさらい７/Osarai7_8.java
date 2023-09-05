import java.util.Scanner;

class KasukabeNezumyLand {

  int guest_ave = 900;
  long sales_ave = 2700000;

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

  int coaster_ave = 500;
  int wheel_ave = 700;
  int carousel_ave = 300;

  void outData() {
    super.outData();
    System.out.println("���ϗ��p�Ґ��@�@�@�@>" + guest_ave);
    System.out.println("�R�[�X�^�[���ϗ��p��>" + coaster_ave);
    System.out.println("�ϗ��ԕ��ϗ��p�ҁ@�@>" + wheel_ave);
    System.out.println("��]�ؔn���ϗ��p�ҁ@>" + carousel_ave);
  }

  void outYosouSalesAndGuest(int yosou_guest) {
    double coasterPercentage = ((double) coaster_ave / guest_ave);
    double wheelPercentage = ((double) wheel_ave / guest_ave);
    double carouselPercentage = ((double) carousel_ave / guest_ave);

    System.out.println(
      "�\�z���p�Ґ�> " +
      (
        Math.round(yosou_guest * carouselPercentage) +
        Math.round(yosou_guest * wheelPercentage) +
        Math.round(yosou_guest * coasterPercentage)
      ) +
      "��"
    );
    System.out.println(
      "�W�F�b�g�R�[�X�^�[�̗\�z���p�Ґ�>" +
      Math.round(yosou_guest * coasterPercentage) +
      "��"
    );
    System.out.println(
      "�ϗ��Ԃ̗\�z���p�Ґ�> " +
      Math.round(yosou_guest * wheelPercentage) +
      "��"
    );
    System.out.println(
      "�����[�S�[�����h�̗\�z���p�Ґ�> " +
      Math.round(yosou_guest * carouselPercentage) +
      "��"
    );
  }
}

class Vehicle extends KasukabeNezumyLand {

  int bus_ave = 200;
  int train_ave = 500;
  int gondola_ave = 600;

  void outData() {
    super.outData();
    System.out.println("�o�X���ϗ��p��>" + bus_ave);
    System.out.println("�D�ԕ��ϗ��p�ҁ@�@>" + train_ave);
    System.out.println("�S���h�����ϗ��p�ҁ@>" + gondola_ave);
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    double busrPercentage = ((double) bus_ave / guest_ave);
    double trainPercentage = ((double) train_ave / guest_ave);
    double carouselPercentage = ((double) gondola_ave / guest_ave);

    System.out.println(
      "�o�X�̗\�z���p�Ґ�>" + Math.round(yosou_guest * busrPercentage) + "��"
    );
    System.out.println(
      "�D�Ԃ̗\�z���p�Ґ�> " + Math.round(yosou_guest * trainPercentage) + "��"
    );
    System.out.println(
      "�S���h���̗\�z���p�Ґ�> " +
      Math.round(yosou_guest * carouselPercentage) +
      "��"
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
      "�`�P�b�g���ϔ���@>" +
      ticket_ave +
      "��l������" +
      (int) (ticket_ave / guest_ave)
    );
    System.out.println(
      "���X�g�������ϔ���>" +
      restaurant_ave +
      "��l������" +
      (int) (restaurant_ave / guest_ave)
    );
    System.out.println(
      "���X���ϔ���@�@�@>" +
      foods_ave +
      "��l������" +
      (int) (foods_ave / guest_ave)
    );
    System.out.println(
      "�O�b�Y���ϔ���@�@>" +
      goods_ave +
      "��l������" +
      (int) (goods_ave / guest_ave)
    );
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    double restaurantPercentage = ((double) restaurant_ave / sales_ave);
    double foodsPercentage = ((double) foods_ave / sales_ave);
    double goodsPercentage = ((double) goods_ave / sales_ave);

    System.out.println(
      "���X�g��������" + Math.round(restaurantPercentage * 100) + "%"
    );
    System.out.println("���X����" + Math.round(foodsPercentage * 100) + "%");
    System.out.println("�O�b�Y����" + Math.round(goodsPercentage * 100) + "%");

    System.out.println(
      "���X�g�����̗\�z���v>" +
      Math.round(yosou_sales * restaurantPercentage) +
      "�~"
    );
    System.out.println(
      "���X�̗\�z���v> " + Math.round(yosou_sales * foodsPercentage) + "�~"
    );
    System.out.println(
      "�O�b�Y�̗\�z���v> " + Math.round(yosou_sales * goodsPercentage) + "�~"
    );
  }
}

class Osarai7_8 {

  public static void main(String[] args) {
    int yosou_guest;
    long yosou_sales;

    Scanner scanner = new Scanner(System.in);

    System.out.print("�\�z����Ґ�����͂��Ă�������: ");
    yosou_guest = scanner.nextInt();

    System.out.print("�\�z������z����͂��Ă�������: ");
    yosou_sales = scanner.nextLong();

    KasukabeNezumyLand land = null;

    System.out.println("1. �A�g���N�V����");
    System.out.println("2. ��蕨");
    System.out.println("3. �V���b�v");
    System.out.print("�����Ώۂ�I��ł��������i1, 2, 3�j: ");
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
