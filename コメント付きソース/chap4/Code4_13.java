public class Code4_13 {
  public static void main(String[] args){

    int[] scores = {20, 30, 40, 50, 80};
  //------------
  //int�^�̔z��(�̱��ڽ)���Ǘ�����ϐ�scores��錾����
  //               --------------------
  //               5�����̔z��𐶐�������ꂼ��̕����ɒl��������
  //            ---
  //        �z��PC����ذ����޺�ɂ���̂��c���������ڽ��
  //        �ϐ�scores�ɑ������


    //�����ʂ�for����( )�̒��� �����l; ����; ���� ���L�q����

    for(int i = 0; i<scores.length; i++){
      System.out.print(scores[i] + " ");
    }

    System.out.println("\n------------------------------");

    //���g��for���ͤ�z�񂩂������Ɉڂ��Ĥ���̏������s���

    for(int value : scores){
    //              ------
    //              �z��(�����)���L�q
    //  ---------
    //  ����錾
      System.out.print(value + " ");
    }

  }
}

