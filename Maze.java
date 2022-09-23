import javax.tools.DocumentationTool.Location;

public class Maze {
  private final String mazeData;
  private final int width;
  private final Location startLocation;

  public Maze(String mazeData, int width) {
    this.mazeData = mazeData;
    this.width = width;
    this.startLocation = locationOf('S');
  }

  private Location locationOf(char c) {
    
  }
}
