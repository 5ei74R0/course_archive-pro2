/**
 * Prob18
 * judge whether or not given number is a prime number.
 */
public class Prob18 {
    public static void main(String[] args) {
        int target = 210409;
        int max_div = 1;
        for (int div = 2; div * div <= target; ++div) {
            if (target % div == 0) {
                max_div = Math.max(max_div, target / div);
            }
        }

        if (max_div == 1) {
            System.out.println("Given number is a prime number.");
        } else {
            System.out.println("Given number is divisible by " + max_div + ".");
        }
    }
}
