package question;

import exercise.Point;

public class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x0, int y0, String c) {
        super(x0, y0);
        color = c;
    }

    public String getColor() {
        return color;
    }

    public int xpos() {
        return getX();
    }

    public int ypos() {
        return getY();
    }
}