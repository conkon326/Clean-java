class KasukabeNezumyLand {

  int guest_ave = 900;
  long sales_ave = 2700000;




  void outData() {
    System.out.println("���ϗ���Ґ��@�@�@�@>" + guest_ave);
    System.out.println("���ϔ�����z�@�@�@�@>" + sales_ave);
  }

  void outYosouSalesAndGuest(int a, long b) {
    System.out.println("����ҒB����>" + (double) a / guest_ave * 100);
    System.out.println("����B�����@>" + (double) b / sales_ave * 100);
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
    System.out.println("���ϗ��p�Ґ��@�@�@�@>" + guest_ave);
    System.out.println("�R�[�X�^�[���ϗ��p��>" + coaster_ave);
    System.out.println("�ϗ��ԕ��ϗ��p�ҁ@�@>" + wheel_ave);
    System.out.println("��]�ؔn���ϗ��p�ҁ@>" + carousel_ave);
  }

  void outYosouSalesAndGuest(int yosou_guest) {

		KasukabeNezumyLand kasukabe = new KasukabeNezumyLand();

    double coasterPercentage =
      ((double) coaster_ave / kasukabe.guest_ave);
    double wheelPercentage =
      ((double) wheel_ave / kasukabe.guest_ave);
    double carouselPercentage =
      ((double) carousel_ave / kasukabe.guest_ave);

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
    System.out.println("�o�X���ϗ��p��>" + bus_ave);
    System.out.println("�D�ԕ��ϗ��p�ҁ@�@>" + train_ave);
    System.out.println("�S���h�����ϗ��p�ҁ@>" + gondola_ave);
  }

  void outYosouSalesAndGuest(int yosou_guest) {
				KasukabeNezumyLand kasukabe = new KasukabeNezumyLand();

    double busrPercentage = ((double) bus_ave / kasukabe.guest_ave);
    double trainPercentage =
      ((double) train_ave / kasukabe.guest_ave);
    double carouselPercentage =
      ((double) gondola_ave / kasukabe.guest_ave);

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

public class Osarai7_2 {

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
  }
}
