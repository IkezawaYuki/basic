import java.io.*;
public class Ecopy {
  public static void main(String[] args) {
    BufferedReader br = null;
    BufferedWriter bw = null;
    String ie = "JISAutoDerect";
    String oe = System.getProperty("file.encoding");
    String in = "", out = "";
    String line;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-ie")) {
        ie = args[++i];
      } else if (args[i].equals("-oe")) {
        oe = args[++i];
      } else {
        if (in.equals("")) {
          in = args[i];
        } else {
          out = args[i];
        }
      }
    }

    if (in.equals("") || out.equals("")) {
      System.out.println("Usage : ");
      System.out.println("Ecopy [-ie]");
      System.out.println(1);
    }

    try {
      br = new BufferedReader(
        new InputStreamReader(
          new FileInputStream(in), ie));
      
    } catch (FileNotFoundException fnfe) {
      System.err.println("FileNotFoundException caught");
    } catch (IOException ioe) {

    } finally {
      try {
        if (br != null) { br.close(); }
        if (bw != null) { bw.close(); }
      } catch (Exception e) {
        
      }
    }
  }
}