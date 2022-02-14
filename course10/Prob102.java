public class Prob102 {
    public static void main(String[] args) {
        (new Object() {
            public void turnOn() {
                System.out.println("Let's watch!");
            }
        }).turnOn();
    }
}
