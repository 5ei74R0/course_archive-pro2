public class MyPoint {
	private int x;
	private int y;

	void setPoint(int xpos, int ypos) {
		x = xpos;
		y = ypos;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	double getDistanceFrom(MyPoint q) {
		double d_x = x - q.x;
		double d_y = y - q.y;
		return Math.sqrt(d_x * d_x + d_y * d_y);
	}
}