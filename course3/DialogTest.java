public class DialogTest {
    public static void main(String[] args) {
        String text = javax.swing.JOptionPane.showInputDialog(null);
        if (text.equals("beef") || text.equals("chicken")) {
            System.out.println("meat");
        }
        else if (text.equals("lettuce") || text.equals("carrot")) {
            System.out.println("vegetable");
        }
        else if (text.equals("banana") || text.equals("apple")) {
            System.out.println("fruit");
        }
        else {
            System.out.println("Unknown");
        }
    }
}
