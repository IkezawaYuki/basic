public class ScoreManagerTester {
  public static void main(String[] args) {
    ScoreManager sm = new ScoreManager("100m走");
    try {
      sm.put("N01", 10.11);
      sm.put("N02", 10.22);
      sm.put("N03", 10.33);
      sm.put("N04", 10.44);
      sm.put("N05", 10.55);
    } catch (NullPointerException e) {

    }
    sm.print();
    System.out.println(sm.get("N04"));
  }
}
