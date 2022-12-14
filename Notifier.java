import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class Notifier {
  private static final Notifier INSTANCE = new Notifier();
  private final Object lock = new Object();
  private final Map<String, List<MobileDevice>> userMobileDevices = new HashMap<>();
  private final Map<MobileDevice, List<String>> messagesToDeliver = new HashMap<>();
  private volatile boolean active = true;
  public static Notifier getInstance() { return INSTANCE; }
  public Notifier() {

  }

  public void register(String user, MobileDevice device) {
    synchronized(lock) {
      List<MobileDevice> devices = userMobileDevices.get(user);
      if (device == null) {
        devices = new ArrayList<>();
        userMobileDevices.put(user, devices);
      }
      devices.add(device);
    }
  }

  public void send(String user, String message) {
    List<MobileDevice> devices = new ArrayList<>();
    synchronized(lock) {
      if (userMobileDevices.containsKey(user)) {
        for (MobileDevice device: userMobileDevices.get(user)) {
          List<String> messageList = messagesToDeliver.get(device);
          if (messageList == null) {
            messageList = new ArrayList<>();
            messagesToDeliver.put(device, messageList);
          }
          messageList.add(message);
          devices.add(device);
        }
      }
    }
    for (MobileDevice device : devices) {
      synchronized(device) {
        device.notifyAll();
      }
    }
  }

  public void loopForMessage(MobileDevice device) {
    while (active) {
      List<String> messageList;
      synchronized(lock) {
        messageList = messagesToDeliver.remove(device);
      }
      if (messageList != null) {
        device.getListener().onNotificationReceived(messageList);
      }
      synchronized(device) {
        try {
          device.wait(3000L);
        } catch(InterruptedException e) {
          break;
        }
      }
    }
  }

  public void shutdown() {
    active = false;
    List<MobileDevice> devices = new ArrayList<>();
    synchronized(lock) {
      messagesToDeliver.clear();
      for (String user : userMobileDevices.keySet()) {
        for (MobileDevice device : userMobileDevices.get(user)) {
          devices.add(device);
        }
      }
      userMobileDevices.clear();
    }
    for (MobileDevice device : devices) {
      synchronized(device) {
        device.notifyAll();
      }
    }
  }
}
