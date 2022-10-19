import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ValueSortedMap<K, V> implements Iterable<K> {
  Map<K, V> map = new HashMap<K, V>();
  Map<V, List<K>> reverseMap;

  public ValueSortedMap() {
    reverseMap = new TreeMap<V, List<K>>();
  }

  
}