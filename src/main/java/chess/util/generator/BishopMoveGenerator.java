package chess.util.generator;

import chess.model.Move;
import chess.util.Constants;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Bishop piece
 */
public class BishopMoveGenerator extends Generator implements IMoveGenerator {

  /**
   * Parameterized constructor taking in a Move object and the current state of the game board
   * @param move      Move object
   * @param board     Current state of the game board
   */
  public BishopMoveGenerator(Move move, int[][] board) {
    super(move, board);
  }

  /**
   * {@inheritDoc}
   */
  @Override public int[][] generateValidMoves() {
    int[] point = move.getPointA();
    int x = point[0];
    int y = point[1];

    // Top Left Diagonal
    for(int i = x - 1; i >= 0; i--) {
      for(int j = y - 1; j >= 0 && isInBounds(i); j--) {
        if(shouldGeneratorStop(analyzePath(i, j), i, j)) {
          i = -1;
          j = -1;
        }
        i--;
      }
    }
    // Top Right Diagonal
    for(int i = x + 1; i < Constants.BOARD_WIDTH; i++) {
      for(int j = y - 1; j >= 0 && isInBounds(i); j--) {
        if(shouldGeneratorStop(analyzePath(i, j), i, j)) {
          i = 9;
          j = -1;
        }
        i++;
      }
    }

    // Bottom Left Diagonal
    for(int i = x - 1; i > 0; i--) {
      for(int j = y + 1; j < Constants.BOARD_HEIGHT && isInBounds(i); j++) {
        if(shouldGeneratorStop(analyzePath(i, j), i, j)) {
          i = -1;
          j = 9;
        }
        i--;
      }
    }

    // Bottom Right Diagonal
    for(int i = x + 1; i < Constants.BOARD_WIDTH; i++) {
      for(int j = y + 1; j < Constants.BOARD_HEIGHT && isInBounds(i); j++) {
        if(shouldGeneratorStop(analyzePath(i, j), i, j)) {
          i = 9;
          j = 9;
        }
        i++;
      }
    }

    validMoves[y][x] = 0;

    return validMoves;
  }
}
