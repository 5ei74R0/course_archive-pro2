/**
 * Prob14
 * print some sentences.
 */
public class Prob14 {
    public static void main(String[] args) {
        System.out.println("My name is ???, and my ID number is 000");
        for (int i = 1; i < 4; i++) {
            System.out.println(String.format("%d: Hello World!", i));
        }
        System.out.println("Goodbye World!");
    }
}
