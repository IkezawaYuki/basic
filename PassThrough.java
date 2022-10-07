import java.util.List;
import java.util.Map;

public class PassThrough implements Fragment {
  final String str;

  PassThrough(CharSequence cs) { str = cs.toString(); }

  public String replace(Map<String, List<String>> table) {
    return str;
  }
}
