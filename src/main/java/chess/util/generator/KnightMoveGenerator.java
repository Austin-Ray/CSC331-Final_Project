package chess.util.generator;

import chess.model.Move;
import chess.util.ArrayUtil;
import chess.util.Constants;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Knight piece
 */
public class KnightMoveGenerator extends Generator implements IMoveGenerator {

  /**
   * Parameterized constructor taking a Move object and the current state of the board.
   * @param move      Move object
   * @param board     Current state of the board
   */
  public KnightMoveGenerator(Move move, int[][] board) {
    super(move, board);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] generateValidMoves() {
    int[][] overlay = {{0, 1, 0, 1, 0},
        {1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1},
        {0, 1, 0, 1, 0}};

    validMoves = ArrayUtil.overlayArray(move.getPointA(), validMoves, overlay);

    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
        if(validMoves[i][j] == 1) {
          checkOverlayWithBoard(j, i);
        }
      }
    }

    return validMoves;
  }
}
