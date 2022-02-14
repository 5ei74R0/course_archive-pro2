public class Prob85 {
    public static void main(String[] args) {
        try {
            int numerator = Integer.parseInt(args[0]);
            int denominator = Integer.parseInt(args[1]);
            System.out.println(numerator / denominator);
        } catch(ArithmeticException e) {
            System.out.println("Denominator must not be zero!");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Please enter two numbers!");
        }
    }
}
