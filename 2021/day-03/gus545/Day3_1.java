import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class Day3_1 {

  /**
   * Read x lines one at a time from r.  After reading x lines, output
   * the lines to w.
   * @param x the number of lines to read in
   * @param r the reader to read from
   * @param w the writer to write to
   * @throws IOException
   */
  public static void doIt(BufferedReader r, PrintWriter w)
      throws IOException {
      String line = r.readLine();
      int x =line.length();
      int[] columns = new int[x];
      System.out.println(Arrays.toString(columns));
      for(String l = line; l != null; l = r.readLine()){
        for(int i =0; i < x; i++){
          // System.out.println("i = "+ i + " " +Integer.parseInt(String.valueOf(line.charAt(i))));
          if(Integer.parseInt(String.valueOf(l.charAt(i))) == 1){
            columns[i]++;
          }else{
            columns[i]--;
          }
        }
        System.out.println(Arrays.toString(columns));
      }
      System.out.println(Arrays.toString(columns));
      int gamma = 0;
      for(int i =0; i < x; i++){
        if(columns[i]>0) columns[i] = 1;
        else columns[i] = 0;
      }
      System.out.println(Arrays.toString(columns));
      for(int j =x-1; j >= 0; j--){
        gamma += columns[j]*Math.pow(2,x-1-j);
      }
      int epsilon = 0;
      for(int i =0; i < x; i++){
        if(columns[i]>0) columns[i] = 0;
        else columns[i] = 1;
      }
      for(int j =x-1; j >= 0; j--){
        epsilon += columns[j]*Math.pow(2,x-1-j);
      }
      w.println(gamma*(epsilon));

  }

  /**
   * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
   * and System.out or from filenames specified on the command line, then cl doIt on the first argument.
   * @param args
   */
  public static void main(String[] args) {
    try {
      BufferedReader r;
      PrintWriter w;
      if( args.length == 0) {
        r = new BufferedReader(new InputStreamReader(System.in));
        w = new PrintWriter(System.out);
      } else if (args.length == 1) {
        r = new BufferedReader(new FileReader(args[0]));
        w = new PrintWriter(System.out);
      } else {
        r = new BufferedReader(new FileReader(args[0]));
        w = new PrintWriter(new FileWriter(args[1]));
      }
      long start = System.nanoTime();
      doIt(r, w);
      w.flush();
      long stop = System.nanoTime();
      System.out.println("Execution time: " + 1e-9 * (stop-start));
    } catch (IOException e) {
      System.err.println(e);
      System.exit(-1);
    }
  }
}
