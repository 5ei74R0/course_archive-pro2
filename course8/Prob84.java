public class Prob84 {
    public static void main(String[] args) {
        try {
            int a[] = new int[]{0, 1, 2};
            for(int i = 0; i < 4; i++){
               System.out.println("a[" + i +"]=" + a[i]);
            }
        } catch(IndexOutOfBoundsException e) {
            // String errMsg = e.getMessage();
            System.out.println("Index is out of bounds!");
        }
    }
}
