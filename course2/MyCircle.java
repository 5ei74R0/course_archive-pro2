public class MyCircle {
    MyPoint center;
    int radius;
    void setCircle(int centerX, int centerY, int r) {
        center = new MyPoint();
        center.x = centerX;
        center.y = centerY;
        radius = r;
    }
    int computeDiameter() {
        return 2 * radius;
    }
    double computeArea() {
        return radius * radius * Math.PI;
    }
    double computeCircumference() {
        return 2 * radius * Math.PI;
    }
}
