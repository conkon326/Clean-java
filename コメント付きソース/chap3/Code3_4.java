public class Code3_4 {
  public static void main(String[] args) {

    System.out.println("���Ȃ��̉^����肢�܂�");

    int fortune = new java.util.Random().nextInt(4) + 1;
  //              ----------------------
  //              java.util�߯���ނɏ�������
  //              Random�׽�̺�߰(�ݽ�ݽ)��V�������
  //                                ��
  //                             �ݽ�ݽ.nextInt(4)
  //                             -----------------
  //                         �ݽ�ݽ���ɂ���nextIntҿ��ނ�4��n���Ď��s
  //                         nextInt�;�ہ`�n�����l�����̗�����Ԃ��
  //                                     ��
  //                                 0�`3�̂����ꂩ + 1
  //                                 ------------------
  //                    0�`3�̂����ꂩ�ɢ+1��̕␳�����Ĥ1�`4�̒l�ɂ���

/*
    //��if���݂̂ŋL�q����ꍇ�c
    if(fortune == 1){
      System.out.println("��g��");
    }
    if(fortune == 2){
      System.out.println("���g");
    }
    if(fortune == 3){
      System.out.println("�g");
    }
    if(fortune == 4){
      System.out.println("��");
    }
    //�ǂ̒l�ł��K��4���r����̂Ť���ԓI��۽������
*/
/*
    //��else���̂ݤ����if���Ŕ�r���s��
    if(fortune == 1){
        System.out.println("��g��");
    }else{
        if(fortune == 2){
            System.out.println("���g");
        }else{
           if(fortune == 3){
               System.out.println("�g");
           }else{
               System.out.println("��");
           }
       }
    }
    //���ԓI��۽�Ȗ�������s�̊J�n�ʒu���ǂ�ǂ�[���Ȃ��Ă��܂��
*/
    //��else�ɤ����if���Ŕ��f���鎞�͌q���ċL�q���鎖���ł���
    if(fortune == 1){
      System.out.println("��g");

    }else if(fortune == 2){
      System.out.println("���g");

    }else if(fortune == 3){
      System.out.println("�g");

    }else{
      System.out.println("��");
    }
    //���̋L�q���s�����Ť�J�n�ʒu���[���Ȃ�Ȃ��

  }
}