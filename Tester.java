public class Tester {
  public static void main(String[] args) throws InterruptedException {
    createUserMobileDevice("Taro", "phone");
    createUserMobileDevice("Taro", "tablet");
    Notifier notifier = Notifier.getInstance();
    notifier.send("Taro", "You have a message.");
    Thread.sleep(500L);
    notifier.shutdown();
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
