class KasukabeNezumyLand {

	int  guest_ave = 900;
	long sales_ave = 2700000;

	void outData(){
		System.out.println("平均来場者数　　　　>" + guest_ave);
		System.out.println("平均売上金額　　　　>" + sales_ave);
	}
	void outYosouSalesAndGuest(int a, long b){
		System.out.println("来場者達成率>" + (double)a/guest_ave*100);
		System.out.println("売上達成率　>" + (double)b/sales_ave*100);
	}
}
class Attraction extends KasukabeNezumyLand {

	int  guest_ave = 1500;
	int  coaster_ave = 500;
	int  wheel_ave = 700;
	int  carousel_ave = 300;


	void outLine(){
		System.out.println("------------------------------");
	}

void outLine(String startend) {
    if (startend.equals("start") || startend.equals("end")) {
        System.out.println("------------------------------" + startend);
    } else {
        System.out.println("------------------------------");
    }
}

	void outData(){
				super.outData();

		System.out.println("平均利用者数　　　　>" + guest_ave);
		System.out.println("コースター平均利用者>" + coaster_ave);
		System.out.println("観覧車平均利用者　　>" + wheel_ave);
		System.out.println("回転木馬平均利用者　>" + carousel_ave);
	}
}

public class Osarai7_1 {
	public static void main (String[] args) {

		int  yosou_guest;
		long yosou_sales;
// 予想入場者数を入力してください >
System.out.print("\u4E88\u60F3\u5165\u5834\u8005\u6570\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044 >");
		yosou_guest = new java.util.Scanner(System.in).nextInt();
// 予想客単価を入力してください >
System.out.print("\u4E88\u60F3\u5BA2\u5358\u4FA1\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044 > ");
		yosou_sales = yosou_guest * new java.util.Scanner(System.in).nextLong();

		Attraction att = new Attraction();

		att.outLine("start");
		att.outData();
		att.outLine();
		att.outYosouSalesAndGuest(yosou_guest, yosou_sales);
		att.outLine();

		
	}
}
