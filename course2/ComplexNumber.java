public class ComplexNumber {
    double real;
    double imaginary;

    void print() {
        System.out.println(real + " + " + imaginary + "i");
    }

    double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }
}
