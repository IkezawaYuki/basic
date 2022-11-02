import java.io.IOException;
import java.io.RandomAccessFile;

public class Randomfile {
  public static void main(String[] args) throws IOException{
    Randomfile randomfile = new Randomfile();
    randomfile.test();
  }

  void test() throws IOException {
    String filename = "randf.dat";
    int[] intArray = {10,20,30,40,50,60,70,80,90};
    RandomAccessFile raf1 = new RandomAccessFile(filename, "rw");
    for (int i = 0; i < intArray.length; i++) {
      raf1.writeInt(intArray[i]);
    }
    raf1.close();
    displayRandomFile(filename);
  }

  void displayRandomFile(String filename) throws IOException {
    
  }
}
