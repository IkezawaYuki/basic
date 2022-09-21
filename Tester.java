public class Tester {
  public static void main(String[] args) {
    createUserMobileDevice("Taro", "phone");
    
  }

  private static void createUserMobileDevice(String user, String name) {
    MobileDevice device = new MobileDevice(name, messageList -> 
          System.out.println(name + ": " + messageList));
    Notifier notifier = Notifier.getInstance();
    notifier.register(user, device);
    new Thread(() -> {
      notifier.loopForMessage(device);
      System.out.printf("Terminating %s's %s%n", user, name);
    }).start();
  }
}
