public class Code4_15 {
  public static void main(String[] args){

    int[] arrayA = {1, 2, 3};

    int[] arrayB;

    arrayB = arrayA;
  //arrayA�ŊǗ����Ă��颱��ڽ���arrayB�ɑ������
  //��arrayA��arrayB����������ڽ��������Ă���̂Ť���̱��ڽ��H����
  //  ��ɂ���z��͓����ɂɂȂ�

    arrayB[0] = 100;

  //System.out.println(arrayA[0]);

    for( int i=0; i<arrayA.length; i++ ){ //���ʂ�for����arrayA��S�ĕ\��
      System.out.print(arrayA[i] + " ");
    }

    System.out.println("\n---------------");

    for( int j : arrayB ){                //�g��for����arrayB��S�ĕ\��
      System.out.print(j + " ");
    }

  }
}

