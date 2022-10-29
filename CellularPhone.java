public class CellularPhone {
  String telephoneNumber;
  int batteryRemaining = 100;

  public CellularPhone(String telNum) {
    telephoneNumber = telNum;
  }

  public void revceiveCall(String caller) {
    System.out.println("ring ring ring");
    System.out.println("Calling from " + caller);
  }

  public void talkSomething(String msg) {
    System.out.println("[" + msg + "]");
  }

  public void hungUp() {
    System.out.println("bye");
    batteryRemaining = batteryRemaining - 10;
    System.out.println("batteryRemaining = " + batteryRemaining);
  }
}
