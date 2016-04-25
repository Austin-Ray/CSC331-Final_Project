package chess.util.generator;

import chess.model.Move;
import chess.util.ArrayUtil;
import chess.util.Constants;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a King piece
 */
public class KingMoveGenerator extends Generator implements IMoveGenerator {

  /**
   * Parameterized constructor taking in a Move object and the current state of the board
   * @param move      Move object
   * @param board     Current state of the board
   */
  public KingMoveGenerator(Move move, int[][] board) {
      super(move, board);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] generateValidMoves() {
    int[][] overlay = {{1, 1, 1},
        {1, 0, 1},
        {1, 1, 1}};

    validMoves = ArrayUtil.overlayArray(move.getPointA(), validMoves, overlay);

    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; i++) {
        if(validMoves[i][j] == 1) {
          shouldGeneratorStop(analyzePath(j, i), j, i);
        }
      }
    }
      return validMoves;
  }
}
