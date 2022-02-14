import java.util.Iterator;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Prob93 {
    private static double calc(String operator, double a, double b) {
        if (operator.compareTo("+") == 0)
            return a + b;
        else if (operator.compareTo("-") == 0)
            return a - b;
        else if (operator.compareTo("*") == 0)
            return a * b;
        else if (operator.compareTo("/") == 0)
            return a / b;
        else
            throw new IllegalArgumentException("No such operator: \"" + operator + "\"");
    }

    private static double processCalc(String[] numsAndOps) {
        try {
            try { // error detection
                Double.parseDouble(numsAndOps[numsAndOps.length - 1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("input line should be end with a number.");
            }

            double res = Double.parseDouble(numsAndOps[0]);
            for (int i = 1; i + 1 < numsAndOps.length; i += 2) {
                res = calc(numsAndOps[i], res, Double.parseDouble(numsAndOps[i + 1]));
            }
            return res;

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            List<String> list = Files.readAllLines(Paths.get("numbers.txt"), Charset.defaultCharset());
            BufferedWriter output = Files.newBufferedWriter(Paths.get("result93.txt"), Charset.defaultCharset());
            for (Iterator<String> line = list.iterator(); line.hasNext();) {
                String s = line.next();
                output.write(s);
                output.write(" = ");
                output.write(Double.toString(processCalc(s.split("\\s+"))));
                if (line.hasNext())
                    output.newLine();
            }
            output.close();
        } catch (IllegalArgumentException e) {
            e.toString();
            System.err.println(e);
        } catch (IOException e) {
            System.err.println("IOException " + e.toString());
        }
    }
}
