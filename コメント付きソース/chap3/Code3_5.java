public class Code3_5 {
  public static void main(String[] args) {

    System.out.println("���Ȃ��̉^����肢�܂�");

    int fortune = 3;

//  java��switch�`case���́w������x�ł͂Ȃ��B

//  java��switch�`case���ͤ�ǂ����ݸނŏ����̗���ɏ悹�邩
//                                                 �c�Ƃ��������B
//  switch�`case�𔲂���wbreak�x�����p���鎖�Ť
//  ������̂悤�ɏ������鎖���ł���


    switch(fortune){
      case 1:
        System.out.println("��g");
        //break;
      case 2:
        System.out.println("���g");
        break;
      case 3:
        System.out.println("�g");
        break;
      default:
        System.out.println("��");
    }


  }
}