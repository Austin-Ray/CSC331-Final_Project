package chess.util.generator;

import chess.model.Move;
import chess.util.generator.abs.IMoveGenerator;
import java.awt.Color;

/**
 * Move generator for a Pawn piece
 */
public class PawnMoveGenerator extends Generator implements IMoveGenerator {

  /**
     * Parameterized constructor taking a Move object and the current state of the game board
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

    if(pieceColor == Color.BLACK) {
      // Checks the position in front of the pawn.
      if(analyzePath(x, y + 1) == 1) {
        validMoves[y + 1][x] = 1;
      }
      // Checks the right diagonal
      if(analyzePath(x + 1, y + 1) == 2) {
        validMoves[y + 1][x + 1] = 2;
      }
      // Checks the left diagonal
      if(analyzePath(x - 1, y + 1) == 2) {
        validMoves[y + 1][x - 1] = 2;
      }

      if(y == 1) {
        // If in the starting position see if it can move the bonus move.
        if(validMoves[y + 1][x] == 1 && analyzePath(x, y + 2) == 1) {
          validMoves[y + 2][x] = 1;
        }
      }
    } else {
      // Exact mirror of the above code.
      if(analyzePath(x, y - 1) == 1) {
        validMoves[y - 1][x] = 1;
      }

      if(analyzePath(x + 1, y - 1) == 2) {
        validMoves[y - 1][x + 1] = 2;
      }
      if(analyzePath(x - 1, y - 1) == 2) {
        validMoves[y - 1][x - 1] = 2;
      }

      if(y == 6) {
        if(validMoves[y - 1][x] == 1 && analyzePath(x, y - 2) == 1) {
          validMoves[y - 2][x] = 1;
        }
      }
    }

    return validMoves;
  }
}
