public class Code4_5 {
  public static void main(String[] args){


    int     i;      //int�^(�������Ǘ�����^)�̕ϐ�i��錾����

    String  s;      //String�׽�^�̕ϐ�s��錾����
                    //(�׽�^�̕ϐ��ͤ���̸׽�̺�߰(�̱��ڽ)���Ǘ�����)

/*
    int[] scores;   //(int�^��)�z����Ǘ�����ׂ̓���ȸ׽�^�

    scores = new int[5];
  //         ----------
  //         int�^��5���������z��𐶐����c
  //---------
  //�z�񂪂ǂ��ɂ��邩�c���������ڽ��ϐ�score�ɑ������

*/
  //�z����Ǘ�����ϐ��̐錾�Ƥ�z��̐�������Ѥ���̱��ڽ�̑����1�s��ok�
  //          ��
   int[] scores = new int[5];

    scores[1] = 30;
  //�ϐ�score�ɂ�����ڽ��H������ɂ���z���1�Ԃ̕�����30��������

    System.out.println(scores[1]+"��");
  //�ϐ�score�ɂ�����ڽ��H������ɂ���z���1�Ԃ̕����̒l���o�͡


    //System.out.println(i);
    //�ϐ�i�ɂ͉���������Ă��Ȃ�(�����������Ă��Ȃ�)�̂Ť�o�͂ł��Ȃ��

    System.out.println(scores[0]);
    //�z��ɂͤ�^�ɍ��킹�������l(int�Ȃ�0�double�Ȃ�0.0)��
    //�����I�ɓ���̂Ť������������ɏo�͂��Ă�װ�ɂ͂Ȃ�Ȃ��

  }
}
