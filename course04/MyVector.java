public class MyVector {
    private double[] elements;
    static int count; // インスタンス生成されたベクトルの総数
    public MyVector() {
        // ゼロ・ベクトル(0, 0)に初期化する．
        // elements, count ともに初期化すること．
        elements = new double[2];
        elements[0] = 0;
        elements[1] = 0;
        ++count;
    }
   
    public MyVector(double x, double y) {
        // ベクトル (x, y) に初期化する．elements, count ともに初期化すること．
        elements = new double[2];
        elements[0] = x;
        elements[1] = y;
        ++count;
    }
    MyVector constMult(double k) {
        // ベクトルを定数 (k) 倍にして返す
        MyVector res = new MyVector(elements[0], elements[1]);
        res.elements[0] *= k;
        res.elements[1] *= k;
        return res;
    }
    double getLength() {
        // ベクトルの大きさを返す
        double x = elements[0];
        double y = elements[1];
        return Math.sqrt(x*x + y*y);
    }
    boolean isEqual(MyVector v) {
        // ベクトル v と各成分が等しければ true, そうでなければ false を返す
        return elements[0] == v.elements[0] && elements[1] == v.elements[1];
    }
   
    static int getNumVec() {
        // インスタンス生成されたベクトルの総数を返す
        return count;
    }
    void print() {
        // ベクトルの座標を (x, y) という形で表示する
        System.out.println("(" + elements[0] + ", " + elements[1] + ")");
    }
}
