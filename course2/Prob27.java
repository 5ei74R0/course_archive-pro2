public class Prob27 {
    public static void main(String[] args) {
        // declare 1 + 2i
        ComplexNumber a = new ComplexNumber();
        a.real = 1;
        a.imaginary = 2;
        // declare 3 + 4i
        ComplexNumber b = new ComplexNumber();
        b.real = 3;
        b.imaginary = 4;

        // invoke ComplexNumber.print()
        a.print();
        b.print();

        // print ComplexNumber.abs()
        System.out.println("a.abs() = " + a.abs());
        System.out.println("b.abs() = " + b.abs());
    }
}
