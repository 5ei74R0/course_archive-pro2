public class PentagonVertex extends Vertex {
    public void draw(Turtle t) {
        t.penDown();
        for (int i = 0; i < 5; ++i) {
            t.go(7);
            t.rotate(72);
        }
        t.penUp();
    }
}
