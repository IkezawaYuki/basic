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
}
