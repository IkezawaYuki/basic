import java.util.List;
import java.util.Map;

public class Replacer implements Fragment {
  final String key;

  Replacer(CharSequence cs) { key = cs.toString(); }

  public String replace(Map<String, List<String>> table) {
    return String.join("\n", table.get(key));
  }
}
