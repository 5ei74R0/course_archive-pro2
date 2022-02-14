import java.util.ArrayList;

public class Prob87 {

    private static void bruteForceSolver(int money) {
        // Solution.1
        // brute force : O(ABCDEF), where A is max number of 500yen-coin
        //                          & B is max number of 100yen-coin
        //                          & C is max number of 50yen-coin
        //                          & D is max number of 10yen-coin
        //                          & E is max number of 5yen-coin
        //                          & F is max number of 1yen-coin
        // => TOO SLOW
        int comb = 0;
        for (int i1 = 0; i1 < 2; ++i1) {  // 500 yen
            for (int i2 = 0; i2 < 10; ++i2) {  // 100 yen
                for (int i3 = 0; i3 < 20; ++i3) {  // 50 yen
                    for (int i4 = 0; i4 < 100; ++i4) {  // 10 yen
                        for (int i5 = 0; i5 < 200; ++i5) {  // 5 yen
                            for (int i6 = 0; i6 <= money; ++i6) {  // 1 yen
                                if (500 * i1 + 100 * i2 + 50 * i3 + 10 * i4 + 5 * i5 + i6 == money) {
                                    comb += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(comb);
    }

    private static void DPSolver(int money) {
            // Solution.2
            // DP : O(CM), where M is required amount of money
            //                   & C is the number of sort of coins (in this case, C = 6)
            // much more efficient than solution.1
            ArrayList<Integer> dp = new ArrayList<Integer>();
            dp.add(1);
            for (int i = 0; i < money; ++i) dp.add(0);
            for (int i = 0; i < money; ++i) {  // use only 1 yen
                if (i+1 <= money) dp.set(i+1, dp.get(i+1) + dp.get(i));
            }
            for (int i = 0; i < money; ++i) {  // use only 5 yen
                if (i+5 <= money) dp.set(i+5, dp.get(i+5) + dp.get(i));
            }
            for (int i = 0; i < money; ++i) {  // use only 10 yen
                if (i+10 <= money) dp.set(i+10, dp.get(i+10) + dp.get(i));
            }
            for (int i = 0; i < money; ++i) {  // use only 50 yen
                if (i+50 <= money) dp.set(i+50, dp.get(i+50) + dp.get(i));
            }
            for (int i = 0; i < money; ++i) {  // use only 100 yen
                if (i+100 <= money) dp.set(i+100, dp.get(i+100) + dp.get(i));
            }
            for (int i = 0; i < money; ++i) {  // use only 500 yen
                if (i+500 <= money) dp.set(i+500, dp.get(i+500) + dp.get(i));
            }
            System.out.println(dp.get(money));
    }

    public static void main(String[] args) {
        try {
            int money = Integer.parseInt(args[0]);

            // bruteForceSolver(money);  // slow solver
            DPSolver(money);  // fast solver
        } catch(IndexOutOfBoundsException e) {
            System.out.println("No amount specified");
        } catch(NumberFormatException e) {
            System.out.println("Please input INTEGERs.");
        }
    }
}
