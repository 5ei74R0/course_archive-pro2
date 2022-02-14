public class Tmp {
    public static void main(String[] args) {
        try {
            double numerator = Double.parseDouble(args[0]);
            double denominator = Double.parseDouble(args[1]);
            System.out.println(numerator / denominator);
        } catch(ArithmeticException e) {
            System.out.println("Denominator must not be zero!");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Please enter two numbers!");
        }
    }
}
