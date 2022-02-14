import java.util.ArrayList;
import java.util.Random;

public class Prob75 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No numbers!");
            return;
        }
        int n = Integer.parseInt(args[0]);
        if (n == 0) {
            System.out.println("Not valid!");
            return;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) list.add(rnd.nextInt(9));
        for (int val : list) System.out.print(val);
        System.out.println("");
        
        ArrayList<Integer> filteredList = new ArrayList<Integer>();
        for (int i = 0; i * 2 < n; i += 2) {
            if (list.get(i) < list.get(i+1)) {
                filteredList.add(list.get(i));
                filteredList.add(list.get(i+1));
            }
        }
        for (int val : filteredList) System.out.print(val);
        System.out.println("");
    }
}
