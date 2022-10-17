import java.util.Comparator;


public class ScoreManager extends ValueSortedMap<String, Double>{
  private final String subject;

  public ScoreManager(String subject) {
    super(new Comparator<Double>() {
      public int compare(Double a, Double b) {
        return a.compareTo(b);
      }
    });
    this.subject = subject;
  }
  
}