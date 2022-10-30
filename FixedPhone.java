public class FixedPhone {
  String telephoneNumber;
  String installationSite;

  public FixedPhone(String telNum, String site) {
    telephoneNumber = telNum;
    installationSite = site;
  }

  public void revceiveCall(String caller) {
    System.out.println("ring! ring! ring!");
    System.out.println("Caller " + caller + " -> "
                        + telephoneNumber
                        + "(site: " + installationSite + ")");
  }
  public void talkSomething(String msg) {
    System.out.println("[" + msg + "]");
  }
  public void hangUp() {
    System.out.println("bye!");
  }
}
