import java.util.List;

public class PlayMaze {
  public static void main(String[] args) {
    Maze maze = new Maze("*******" +
                         "*..*..*" +
                         "*S**.**" +
                         "*.....*" +
                         "*****.*" +
                         "*G....*" +
                         "*******", 7);
    Piece piece = new Piece(maze);
    while (!piece.isAtGoal()) {
      piece.turnLeft();
      while (!piece.tryStepForward()) {
        piece.turnRight();
      }
    }
    List<Direction> history = piece.getHistory();
    System.out.println(history);
  }
}
