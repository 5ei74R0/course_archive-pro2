public class RectVertex extends Vertex {
    public void draw(Turtle t) {
        t.penDown();
        for (int i = 0; i < 4; ++i) {
            t.go(7);
            t.rotate(90);
        }
        t.penUp();
    }
}
