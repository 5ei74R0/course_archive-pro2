public class Pentagon {
    void draw(Turtle t, Vertex v) {
        for (int i = 0; i < 5; i++) {
            v.draw(t);
            t.penUp();
            t.go(93);
            t.rotate(72);
        }
    }
       
    public static void main(String[] args) {
        Pentagon pentagon = new Pentagon();
        Turtle turtle = new Turtle();
        turtle.move(50, 160);
        pentagon.draw(turtle, new RectVertex());
        turtle.move(120, 250);
        pentagon.draw(turtle, new CrossVertex());
        turtle.move(190, 300);
        pentagon.draw(turtle, new PentagonVertex());
    } 
}
