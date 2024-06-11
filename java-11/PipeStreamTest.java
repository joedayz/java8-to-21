import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PipeStreamTest {
          public static void main(String[] args) throws IOException {
                    var writer = new StringWriter();
                    var inputPipe = new PipedInputStream();
                    var inputBuffed = new BufferedInputStream(inputPipe);

                    var outputPipe = new PipedOutputStream(inputPipe);
                    var outputBuffered = new BufferedOutputStream(outputPipe);

                    var w = new PrintWriter(outputBuffered);
                    w.write("Hello JoeDayz");
                    w.flush();
                    w.close();

                    System.out.println(new String(inputBuffed.readAllBytes()));
          }
}
