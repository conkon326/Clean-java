public class Code3_4 {
  public static void main(String[] args) {

    System.out.println("‚ ‚È‚½‚Ì‰^¨‚ğè‚¢‚Ü‚·");

    int fortune = new java.util.Random().nextInt(4) + 1;
  //              ----------------------
  //              java.utilÊß¯¹°¼Ş‚ÉŠ‘®‚·‚é¤
  //              Random¸×½‚ÌºËß°(²İ½Àİ½)‚ğV‚µ‚­ì‚é¡
  //                                «
  //                             ²İ½Àİ½.nextInt(4)
  //                             -----------------
  //                         ²İ½Àİ½“à‚É‚ ‚é¤nextIntÒ¿¯ÄŞ‚É4‚ğ“n‚µ‚ÄÀs
  //                         nextInt‚Í¾ŞÛ`“n‚µ‚½’l–¢–‚Ì—”‚ğ•Ô‚·¡
  //                                     «
  //                                 0`3‚Ì‚¢‚¸‚ê‚© + 1
  //                                 ------------------
  //                    0`3‚Ì‚¢‚¸‚ê‚©‚É¢+1£‚Ì•â³‚ğ‚µ‚Ä¤1`4‚Ì’l‚É‚·‚é¡

/*
    //¥if•¶‚Ì‚İ‚Å‹Lq‚·‚éê‡c
    if(fortune == 1){
      System.out.println("‘å‹gš");
    }
    if(fortune == 2){
      System.out.println("’†‹g");
    }
    if(fortune == 3){
      System.out.println("‹g");
    }
    if(fortune == 4){
      System.out.println("‹¥");
    }
    //‚Ç‚Ì’l‚Å‚à•K‚¸4‰ñ”äŠr‚·‚é‚Ì‚Å¤ŠÔ“I‚ÉÛ½‚ª‚ ‚é¡
*/
/*
    //¥else‚Ì‚İ¤Ÿ‚Ìif•¶‚Å”äŠr‚ğs‚¤
    if(fortune == 1){
        System.out.println("‘å‹gš");
    }else{
        if(fortune == 2){
            System.out.println("’†‹g");
        }else{
           if(fortune == 3){
               System.out.println("‹g");
           }else{
               System.out.println("‹¥");
           }
       }
    }
    //ŠÔ“I‚ÈÛ½‚È–³‚¢‚ª¤s‚ÌŠJnˆÊ’u‚ª‚Ç‚ñ‚Ç‚ñ[‚­‚È‚Á‚Ä‚µ‚Ü‚¤¡
*/
    //¥else‚É¤‚·‚®if•¶‚Å”»’f‚·‚é‚ÍŒq‚°‚Ä‹Lq‚·‚é–‚ª‚Å‚«‚é¡
    if(fortune == 1){
      System.out.println("‘å‹g");

    }else if(fortune == 2){
      System.out.println("’†‹g");

    }else if(fortune == 3){
      System.out.println("‹g");

    }else{
      System.out.println("‹¥");
    }
    //‚±‚Ì‹Lq‚ğs‚¤–‚Å¤ŠJnˆÊ’u‚ª[‚­‚È‚ç‚È‚¢¡

  }
}