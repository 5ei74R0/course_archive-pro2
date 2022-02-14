public class Prob74 {
    private static void solve(String input) {
        System.out.print(input + " ");

        int s1 = 0, s2 = 0;
        for (int i = input.length() - 1; i >= 0; --i) {
            int idx = input.length() - i;
            if (idx % 2 == 1) {
                s1 += input.charAt(i) - '0';
            } else {
                int num = (input.charAt(i) - '0') * 2;
                if (num < 10) {
                    s2 += num;
                } else {
                    s2 += num % 10 + 1;
                }
            }
        }
        System.out.print(s1 + s2 + " ");
        if ((s1 + s2) % 10 == 0) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No numbers!");
            return;
        }
        for (String s : args) {
            solve(s);
        }
    }
}
