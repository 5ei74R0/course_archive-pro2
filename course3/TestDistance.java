public class TestDistance {
    public static void main(String[] args) {
        MyPoint p = new MyPoint();
        p.setPoint(20, 21);
        MyPoint q = new MyPoint();
        q.setPoint(4, 23);
        // output
        System.out.println(p.getDistanceFrom(q));
    }
}
