public class Prob24 {
    public static void main(String[] args) {
        Turtle t;
        t = new Turtle();
        t.move(170, 300);
        t.rotate(-30);  // cancel 1st rotation
        t.penDown();
        for (int i = 0; i < 4; ++i) {
            t.setColor(java.awt.Color.blue);
            t.rotate(30);
            t.go(60);
            t.rotate(30);
            t.setColor(java.awt.Color.red);
            t.go(60);
            t.rotate(30);
            t.setColor(java.awt.Color.yellow);
            t.go(60);
        }
    }
}
