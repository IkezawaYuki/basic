import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;


public class TemplateTester {
  public static void main(String[] args) throws IOException {
    try (
      Reader tReader = new FileReader("template.txt");
      Reader rReader = new FileReader("replacementTable.txt")
    ) {
      Template template = TemplateParser.parse(tReader);
      Map<String, List<String>> table = ReplacementTableParser.parse(rReader);
      System.out.println(template.apply(table));
    } 
  }
}
