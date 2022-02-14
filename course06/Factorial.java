
public class Factorial {
    public static void main(String[] args) {
        int res = 1;
        for (int i = 1; i <= Integer.valueOf(args[0]); ++i) res *= i;
        System.out.println(res);
    }
}
