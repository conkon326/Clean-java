public class Code4_8 {
  public static void main(String[] args){
/*
    int[] scores;
    scores = new int[5];
    scores[0] = 20;
    scores[1] = 30;
    scores[2] = 40;
    scores[3] = 50;
    scores[4] = 80;
*/
    //�z����Ǘ�����ϐ��̐錾��z��̐�����e�����ւ̑����
    //���̂悤��1�s�ŋL�q���鎖���ł���
    //            ��
    int[] scores = {20, 30, 40, 50, 80};
    //              --, --, --, --, --
    //          ��ϋ�؂��5�̒l�����鎖�Ť5�����̔z�񂾂Ɣ��f���Ă�


//  int sum = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];

    int sum = 0; //���ϐ�sum��O�����Đ錾����l���ۂɂ��Ă����

    for(int i=0; i<scores.length; i++){
  //    -------; ---------------; ---
  //    �����l   ����             ����

      //ٰ�߂̐���Ɏg���Ă���ϐ�i�𗬗p���Ĥ�z��̕����ԍ��̎w�������
      //            ��
      sum += scores[i];
      //  --
      //  ���Z����̋L���Ť�v�Z���ɂ���Ɓ��wsum = sum + scores[i]�x
    }

    int avg = sum / scores.length;
    //              -------------
    //      �z��̒��ɂ͕ϐ�length�������Ĥ�����ł͕��������Ǘ����Ă���
    //        -----
    //        ���v��z��̕������Ŋ��鎖�Ť���ς̌v�Z�����Ă���

    System.out.println("�������v�_�F" + sum);
    System.out.println("���ϓ_�F" + avg);

  }
}

