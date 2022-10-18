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

  public void print(){
    System.out.println(subject + "の記録");
    for(String name : this) {
      System.out.printf(" %s : %.2f秒%n", name, get(name));
    }
  }
}