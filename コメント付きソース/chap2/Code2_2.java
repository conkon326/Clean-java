public class Code2_2{
  public static void main(String[] args){

    //System.out.println("私の好きな記号は二重引用符（"）です");
    //                   ------------------------------
    //              この範囲をひと続きの文字列として認識してしまう→ｴﾗｰ

    System.out.println("私の好きな記号は二重引用符（\"）です");
    //                                              --
    //                    ｴｽｹｰﾌﾟする事で､文字列の1部とみなしてくれる

    System.out.println("私の好きな\n記号は二重引用符（\"）です");

  }
}
