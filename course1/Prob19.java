/**
 * Prob19
 * judge whether or not given number is a Harshad Number
 */
public class Prob19 {
    public static void main(String[] args) {
        int target = 210409;
        int h = 0, tmp = target;
        while (tmp > 0) {
            h += tmp % 10;
            tmp /= 10;
        }
        if (target % h == 0) {
            System.out.println("Given number is a Harshad Number.");
        } else {
            System.out.println("Given number is not a Harshad Number.");
        }
    }
}
