/**
 * Tmp
 */
public class Tmp {
    static void change(String s) {
        s = new String();
        s = "c";
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        change(a);
        System.out.println(a);
    }

}