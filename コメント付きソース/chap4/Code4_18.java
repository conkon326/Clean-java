public class Code4_18 {
  public static void main(String[] args) {

    int[][] scores = new int[2][3];
  //                        ---
  //                   �ꎟ���Ƃ���2�����̔z������c
  //                           ---
  //                        ���̤���ꂼ��̕�����3�����̔z����Ǘ�����
  //--------------
  //�񎟌�(�ꎟ���z��̒��Ť�ʂ̈ꎟ���z����Ǘ�����)�̔z���
  //�Ǘ�����z��ͤ[]��2�t����

    scores[0][0] = 40;
    scores[0][1] = 50;
    scores[0][2] = 60;
    scores[1][0] = 80;
    scores[1][1] = 65; //�l��ύX
    scores[1][2] = 70;

    System.out.println(scores[1][1]);

    System.out.println("---------------------------------");

    //�S�Ă̕����̒l���o�͂���ɂ́c

/*
    System.out.println(scores[0][0]);
    System.out.println(scores[0][1]);
    System.out.println(scores[0][2]);
    //              :
    // �S�Ă̕�����1�s���o�͂��Ă��ǂ�����������������Ƒ�ϡ
*/
    for(int i=0; i<2; i++){       //1������ٰ�� 0       1
                                  //
      for(int j=0; j<3; j++){     //2������ٰ��    0       0
                                  //               1       1 
                                  //               2       2
         System.out.println(scores[i][j]);

      }

    }


  }
}


