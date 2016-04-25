package chess.util.generator;

import chess.model.Move;
import chess.util.ArrayUtil;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Queen piece
 */
public class QueenMoveGenerator extends Generator implements IMoveGenerator {

  /**
   * Parameterized constructor taking a Move object and the current state of the game board.
   * @param move      Move object
   * @param board     Current state of the board
   */
  public QueenMoveGenerator(Move move, int[][] board) {
    super(move, board);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] generateValidMoves() {
    int[][] rookArray = new RookMoveGenerator(move, board).generateValidMoves();
    int[][] bishopArray = new BishopMoveGenerator(move, board).generateValidMoves();

    return ArrayUtil.combineArray(rookArray, bishopArray);
  }
}
