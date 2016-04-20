package chess.util;

public class MoveValidator {
  /**
   * Checks is a move is valid.
   * @param point         Point piece is being moved to.
   * @param validMoves    Gameboard that lists only the valid moves.
   * @return              If move is possible or not.
   */
  public static boolean isMoveValid(int[] point, int[][] validMoves) {
    // Break the point array into its X and Y components.
    int x = point[0];
    int y = point[1];

    // Checks if the validMoves array has 1 at the point.
    // If so, move is valid. Otherwise, return false.
    return validMoves[y][x] == 1;
  }
}
