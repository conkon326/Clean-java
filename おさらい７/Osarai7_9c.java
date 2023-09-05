import java.util.Scanner;

class KasukabeNezumyLand {

  String[] aveWord = { "���ϗ���Ґ��@�@�@�@>", "���ϔ�����z�@�@�@�@>" };
  int[] aveData = { 900, 2700000 };
  String[] yosouWord = { "����ҒB����>", "����B�����@>" };
  String[] groupWord;
  int[] groupData;
  String[] word;

  KasukabeNezumyLand(String[] groupWord, int[] groupData, String[] word) {
    this.groupWord = groupWord;
    this.groupData = groupData;
    this.word = word;
  }

  void outData(int choice) {
    for (int i = 0; i < aveData.length; i++) {
      System.out.println(aveWord[i] + aveData[i]);
      for (int x = 0; x < groupWord.length; x++) {
        System.out.println(groupWord[x] + groupData[x]);
      }
    }
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales) {
    System.out.println(
      yosouWord[0] + ((double) yosou_guest / aveData[0] * 100) + "%"
    );
    System.out.println(
      yosouWord[1] + ((double) yosou_sales / aveData[1] * 100) + "%"
    );
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales, int choice) {
    for (int i = 0; i < word.length; i++) {
      System.out.println(
        word[i] + (int) (yosou_guest * ((double) groupData[i+1] / aveData[0]))
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
        "��蕨���p�Ґ��@�@�@�@>",
        "�R�[�X�^�[���ϗ��p��>",
        "�ϗ��ԕ��ϗ��p�ҁ@�@>",
        "��]�ؔn���ϗ��p�ҁ@>",
      },
      new int[] { 1500, 500, 700, 300 },
      new String[] {
        "�W�F�b�g�R�[�X�^�[�̗\�z���p�Ґ�>",
        "�ϗ��Ԃ̗\�z���p�Ґ��@�@�@�@�@�@> ",
        "��]�ؔn�\�z���p�ҁ@�@�@�@�@�@�@>",
      }
    );
  }
}

class Vehicle extends KasukabeNezumyLand {

  Vehicle() {
    super(
      new String[] {
        "��蕨���ϗ��p�ҁ@>",
        "�o�X���ϗ��p�ҁ@�@>",
        "�D�ԕ��ϗ��p�ҁ@�@>",
        "�S���h�����ϗ��p��>",
      },
      new int[] { 1300, 200, 500, 600 },
      new String[] {
        "�o�X�̗\�z���p�Ґ��@�@>",
        "�D�Ԃ̗\�z���p�Ґ��@�@> ",
        "�S���h���̗\�z���p�Ґ�> ",
      }
    );
  }
}

class Shop extends KasukabeNezumyLand {

  Shop() {
    super(
      new String[] {
        "�`�P�b�g���ϔ���@>",
        "���X�g�������ϔ���>",
        "���X���ϔ���@�@�@>",
        "�O�b�Y���ϔ���@�@>",
      },
      new int[] { 1700000, 500000, 200000, 300000 },
      new String[] {
        "�`�P�b�g�̗\�z���v�@>",
        "���X�g�����̗\�z���v> ",
        "���X�̗\�z���v�@�@�@> ",
        "�O�b�Y�̗\�z���v�@�@> ",
      }
    );
  }

  void outYosouSalesAndGuest(int yosou_guest, long yosou_sales, int choice) {
    for (int i = 0; i < word.length; i++) {
      System.out.println(
        word[i] + (int) (yosou_sales * ((double) groupData[i] / aveData[1]))
      );
    }
  }
}


public class Osarai7_9c {

  public static void main(String[] args) {
    int yosou_guest;
    long yosou_sales;
    int choice;

    Scanner scanner = new Scanner(System.in);

    System.out.print("�\�z����Ґ�����͂��Ă�������:");
    yosou_guest = scanner.nextInt();

    System.out.print("�\�z������z����͂��Ă�������: ");
    yosou_sales = yosou_guest * scanner.nextLong();

    KasukabeNezumyLand land = null;

    System.out.println("1. �A�g���N�V����");
    System.out.println("2. ��蕨");
    System.out.println("3. �V���b�v");
    System.out.print("�����Ώۂ�I��ł��������i1, 2, 3�j: ");
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
        System.out.println("�����ȑI���ł��B");
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
