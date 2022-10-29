import java.util.ArrayList;
import java.util.List;

class Cache {

}

public abstract class ListBasedCache extends Cache {
  final List<Entry> entries = new ArrayList<>();
}
