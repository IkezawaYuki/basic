import java.util.List;
import java.util.Map;


public class Template {
  List<Fragment> fragmentList;

  Template(List<Fragment> fragmentList) {
    this.fragmentList = fragmentList;
  }

  public String apply(Map<String, List<String>> table) {
    StringBuilder sb = new StringBuilder();
    for (Fragment fragment : fragmentList) {
      sb.append(fragment.replace(table));
    }
    return sb.toString();
  }
}
