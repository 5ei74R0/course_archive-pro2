public class Prob210 {
    public static void main(String[] args) {
        // a)
        MyCircle circle = new MyCircle();
        // b)
        circle.setCircle(20, 21, 9);
        // c)
        double area = circle.computeArea();
        double circumference = circle.computeCircumference();
        // d)
        System.out.println("The area of the circle is " + area + ", and the circumference is " + circumference);
    }
}
