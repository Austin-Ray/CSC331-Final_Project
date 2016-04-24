package chess.util.generator;

import chess.model.Move;
import chess.util.generator.abs.IMoveGenerator;
import java.awt.Color;

/**
 * Move generator for a Pawn piece
 */
public class PawnMoveGenerator extends Generator implements IMoveGenerator {

    /**
     * Parameterized constructor taking a Move object and the current state of the gameboard
     * @param move          Move object
     * @param gameboard     Current state of the gameboard
     */
    public PawnMoveGenerator(Move move, int[][] gameboard) {
        super(move, gameboard);
    }

  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] generateValidMoves() {
    Color pieceColor = move.getPieceColor();
    int[] point = move.getPointA();
    int x = point[0];
    int y = point[1];

    if(pieceColor == Color.WHITE) {
      if(analyzePath(x, y + 1) == 1) {
        validMoves[y + 1][x] = 1;
      }
      if(analyzePath(x + 1, y + 1) == 2) {
        validMoves[y + 1][x + 1] = 2;
      }
      if(analyzePath(x - 1, y + 1) == 2) {
        validMoves[y + 1][x - 1] = 2;
      }

      if(y == 1) {
        if(validMoves[y + 1][x] == 1 && analyzePath(x, y+ 2) == 1) {
          validMoves[y + 1][x] = 1;
        }
      }
    } else {
      if(analyzePath(x, y - 1) == 1) {
        validMoves[y - 1][x] = 1;
      }

      if(analyzePath(x + 1, y - 1) == 2) {
        validMoves[y - 1][x + 1] = 2;
      }
      if(analyzePath(x - 1, y - 1) == 2) {
        validMoves[y - 1][x - 1] = 2;
      }

      if(y == 7) {
        if(validMoves[y - 1][x] == 1 && analyzePath(x, y - 2) == 1) {
          validMoves[y - 2][x] = 1;
        }
      }
    }

    return validMoves;
  }
}
