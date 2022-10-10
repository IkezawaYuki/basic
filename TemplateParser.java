import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class TemplateParser {
  static public Template parse(Reader reader) throws IOException {
    StringBuilder buf = new StringBuilder();
    List<Fragment> fragmentList = new ArrayList<>();
    int c;
    while ((c = reader.read()) > 0) {
      switch(c) {
        case '<':
          fragmentList.add(new PassThrough(buf));
          buf = new StringBuilder();
          break;
        case '>':
          fragmentList.add(new Replacer(buf));
          buf = new StringBuilder();
          break;
        default:
          buf.append((char) c);
      }
    }
    fragmentList.add(new PassThrough(buf));
    
  }
}
