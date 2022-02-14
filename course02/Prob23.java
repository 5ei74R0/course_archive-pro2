public class Prob23 {
    public static void main(String[] args) {
        Turtle t1 = new Turtle();
        Turtle t2 = new Turtle();
        t1.move(10, 70);
        t2.move(30, 270);
        t1.penDown();
        t2.penDown();
        // write t1
        t1.go(60);
        for (int i = 0; i < 3; ++i) {
            t1.rotate(90);
            t1.go(60);
        }
        // write t2
        t2.go(60);
        for (int i = 0; i < 4; ++i) {
            t2.rotate(72);
            t2.go(60);
        }
    }    
}