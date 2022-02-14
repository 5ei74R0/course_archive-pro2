import java.text.DecimalFormat;

/**
 * Prob17
 * generate a convert table (from inch to centimeter)
 */
public class Prob17 {
    public static void main(String[] args) {
        System.out.println(" Inch |    cm");
        for (int inch = 1; inch < 26; ++inch) {
            // padding
            int pad = 5, tmp = inch;
            while (tmp > 0) {
                --pad;
                tmp /= 10;
            }
            while (pad > 0) {
                --pad;
                System.out.print(" ");
            }
            System.out.print(String.format("%d | ", inch));

            DecimalFormat cm = new DecimalFormat("##.00");
            String cm_str = cm.format(2.54 * inch);
            // padding
            pad = 5 - cm_str.length();
            while (pad > 0) {
                --pad;
                System.out.print(" ");
            }
            System.out.println(cm_str);
        }
    }
}
