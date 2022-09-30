import java.util.ArrayList;
import java.util.List;

public class Piece {
  private final Maze maze;
  private Location location;
  private Direction direction = Direction.NORTH;
  private final List<Direction> history = new ArrayList<>();

  public Piece(Maze maze) {
    this.maze = maze;
    this.location = maze.getLocation();
  }

  public void turnLeft() { direction = direction.left(); }
  public void turnRight() { direction = direction.right(); }

  public boolean tryStepForward() {
    Location nextLocation = new Location(location.x + direction.dx, location.y + direction.dy);
    if (maze.isBlank(nextLocation)) {
      location = nextLocation;
      history.add(direction);
      return true;
    }
    return false;
  }

  public boolean isAtGoal(){ return maze.isGoal(location); }

  public List<Direction> getHistory() { return new ArrayList<>(history); }
}
