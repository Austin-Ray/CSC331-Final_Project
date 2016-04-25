package chess.util;

import java.awt.Color;

/**
 * Validates the Move
 */
public class MoveValidator {
  /**
   * Checks is a move is valid.
   * @param point         Point piece is being moved to.
   * @param validMoves    Game board that lists only the valid moves.
   * @return              If move is possible or not.
   */
  public static boolean isMoveValid(int turn, Color color, int[] point, int[][] validMoves) {
    if(turn == 0 && color == Color.WHITE || turn == 1 && color == Color.BLACK) {
      // Break the point array into its X and Y components.
      int x = point[0];
      int y = point[1];

      // Checks if the validMoves array has 1 at the point.
      // If so, move is valid. Otherwise, return false.
      return validMoves[y][x] == 1 || validMoves[y][x] == 2;
    } else {
      return false;
    }
  }
}
