public class Prob28 {
    public static void main(String[] args) {
        Turtle t;
        t = new Turtle();
        t.move(200, 200);
        t.penDown();
        t.go(40);
        for (int i = 0; i < 3; ++i) {
            t.rotate(90);
            t.go(40);
        }
        t.rotate(30);
        t.go(40);
        t.rotate(120);
        t.go(40);
        for (int i = 0; i < 3; ++i) {
            t.rotate(-30);
            t.go(40);
            t.rotate(120);
            t.go(40);
        }
    }
}
