public class CrossVertex extends Vertex {
    public void draw(Turtle t) {
        for (int i = 0; i < 4; ++i) {
            t.penDown();
            t.go(8);
            t.penUp();
            t.rotate(180);
            t.go(8);
            t.rotate(90);
        }
    }
}
