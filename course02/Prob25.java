public class Prob25 {
    public static void main(String[] args) {
        // declare P(20, 21)
        MyPoint p = new MyPoint();
        p.x = 20;
        p.y = 21;
        // declare Q(4, 16)
        MyPoint q = new MyPoint();
        q.x = 4;
        q.y = 16;
        System.out.println("the distance between (0, 0) and p : " + p.getDistance());
        System.out.println("the distance between (0, 0) and q : " + q.getDistance());
    }
}
