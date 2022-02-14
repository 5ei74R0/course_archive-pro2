package exercise;

class Point3D extends Point {
    private int z;

    Point3D(int x0, int y0) {
        super(x0, y0);
    }

    int getZ() {
        return z;
    }

    void moveY(int dy) {
        y += dy;
    }
}
