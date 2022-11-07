import java.io.File;

public class Sdlist {
  public static void main(String[] args) {
    File dir = new File(args[0]);
    if (!(dir.isDirectory())) {
      System.err.println(args[0] + " is not dir.");
      System.exit(1);
    }
    Sdlist sdlist = new Sdlist();
    sdlist.doSubDirList(dir, 0);
  }

  void doSubDirList(File dir, int tabCnt) {

  } 

  
}
