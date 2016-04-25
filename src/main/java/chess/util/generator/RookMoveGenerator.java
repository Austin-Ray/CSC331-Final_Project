package chess.util.generator;

import chess.model.Move;
import chess.util.Constants;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Rook piece
 */
public class RookMoveGenerator extends Generator implements IMoveGenerator {

  /**
   * Parameterized constructor taking a Move object and the current state of the board
   * @param move    Move object
   * @param board   Current state of the game board
   */
  public RookMoveGenerator(Move move, int[][] board) {
    super(move, board);
  }

  /**
   * {@inheritDoc}
   */
  @Override public int[][] generateValidMoves() {
    int[] point = move.getPointA();
    int x = point[0];
    int y = point[1];

    // Left
    for(int i = x - 1; i >= 0; i--) {
      if(shouldGeneratorStop(analyzePath(i, y), i, y)) {
        break;
      }
    }

    // Right
    for(int i = x + 1; i < Constants.BOARD_WIDTH; i++) {
      if(shouldGeneratorStop(analyzePath(i, y), i, y)) {
        break;
      }
    }

    // Top
    for(int i = y - 1; i >= 0; i--) {
      if(shouldGeneratorStop(analyzePath(x, i), x, i)) {
        break;
      }
    }

    // Bottom
    for(int i = y + 1; i < Constants.BOARD_HEIGHT; i++) {
      if(shouldGeneratorStop(analyzePath(x, i), x, i)) {
        break;
      }
    }

    validMoves[y][x] = 0; // Set the center to 0.

    return validMoves;
  }
}
