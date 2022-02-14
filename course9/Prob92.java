import java.util.Iterator;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Prob92 {
    public static void main(String[] args) {
        try {
            List<String> list = Files.readAllLines(Paths.get("message.txt"), Charset.defaultCharset());
            BufferedWriter output = Files.newBufferedWriter(Paths.get("output.txt"), Charset.defaultCharset());
            for (Iterator<String> line = list.iterator(); line.hasNext();) {
                String s = line.next();
                int cntChars = s.length();
                String[] words = s.split("\\s+");
                int cntWords = (words.length == 1 && words[0].compareTo("") == 0 ? 0 : words.length);
                output.write(Integer.toString(cntWords));
                output.write(" ");
                output.write(Integer.toString(cntChars));
                output.write(": ");
                output.write(s);
                if (line.hasNext()) output.newLine();
            }
            output.close();
        } catch(IOException e) {
            System.err.println("IOException " + e.toString());
        }
	}
}
