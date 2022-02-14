import java.util.Scanner;

public class Prob91 {
    private int result = 0;
    private void processInput(String inString) {  
		String[] inputs = inString.split("\\s+");
		for (int i=0; i<inputs.length; i++) {
            if (inputs[i].compareTo("quit") == 0) {
                System.exit(0);
            }
            else if (inputs[i].compareTo("finish") == 0) {
                System.out.println(result);
                result = 0;
            }
			else result += Integer.valueOf(inputs[i]);
		}
	}

	public static void main(String[] args) {
		Prob91 app = new Prob91();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Please input numbers: ");
			String str = scan.nextLine();
			app.processInput(str);
		}
	}
}
