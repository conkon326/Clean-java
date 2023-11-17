
import java.util.Calendar;

public class Uranai {

    public int calculateValue() {
        int year = 1900;
        int month = 2;
        int day = 1;

        Calendar cal1 = Calendar.getInstance();
        cal1.set(1910, 0, 1);
        long date1 = cal1.getTimeInMillis();

        Calendar cal2 = Calendar.getInstance();
        cal2.set(year, month - 1, 1);
        long date2 = cal2.getTimeInMillis();

        long distance = (date2 - date1) / (1000 * 60 * 60 * 24);
        int kansan = (int) (distance + 2) % 60;

        // 60•ª—Þ‚Ì’l‚ðŒvŽZ
        int value = (kansan + day);
        if (value > 60) {
            value = value - 60;
        }

        return value;
    }

    public static void main(String[] args) {
        Uranai uranai = new Uranai();
        int result = uranai.calculateValue();
        System.out.println("60•ª—Þ‚Ì’l: " + result);
    }
}
