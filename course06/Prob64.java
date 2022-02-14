import java.lang.Integer;

public class Prob64 {
    public static void main(String[] args) {
        int res = 1;
        for (int i = 0; i < args.length; ++i) {
            res *= Integer.valueOf(args[i]);
        }
        System.out.println(res);
    }
}
