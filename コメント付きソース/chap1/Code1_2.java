public class Code1_2{
  public static void main(String[] args){

    int age;      //age�Ƃ������O�̓��ꕨ(�ϐ�)�����    ��  ��
                  //                                    x������

    //System.out.println(age);
    //�ϐ��ɉ�������Ȃ���Ԃŏo�͂͂ł��Ȃ����װ

    age = 30;     //�ϐ�age��6������(�������)         ��30��
                  //                                    x������

    System.out.println(age);

    //age = 30.5;
    //      ----
    //      ��۸��ђ��ɏ����𒼐ڏ����Ƥdouble�^�Ƃ��Ĉ���
    //------
    //����(int)�^�̕ϐ��ɤ����(double)�^�̒l�͑���ł��Ȃ����װ

    age = (int)30.5;
    //    -----
    //    �����I��int�^�ɕϊ����鎖���ł���c��������_�ȉ���������

    System.out.println(age);

  }
}
