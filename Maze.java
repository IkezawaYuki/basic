
public class Maze {
  private final String mazeData;
  private final int width;
  private final Location startLocation;

  public Maze(String mazeData, int width) {
    this.mazeData = mazeData;
    this.width = width;
    this.startLocation = locationOf('S');
  }

  public Location getLocation() { return startLocation; }

  public boolean isGoal(Location loc) {
    return mazeData.charAt(loc.y * width + loc.x) == 'G';
  }

  public boolean isBlank(Location loc) {
    return mazeData.charAt(loc.y * width + loc.x) == '*';
  }

  private Location locationOf(char c) {
    int index = mazeData.indexOf(c);
    return new Location(index % width, index / width);
  }
}

