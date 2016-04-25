package chess.util.generator;

import chess.model.Move;
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
    for(int i = x - 1; i > -2; i--) {
      for(int j = y - 1; j > -2; j--) {
        if(shouldGeneratorStop(analyzePath(i, j), i, j)) {
          i = -1;
          break;
        }
        i--;
      }
    }

    // Top Right Diagonal
    for(int i = x + 1; i < 9; i++) {
      for(int j = y - 1; j > -2 ; j--) {
        if(shouldGeneratorStop(analyzePath(i, j), i, j)) {
          i = 9;
          break;
        }
        i++;
      }
    }

    // Bottom Left Diagonal
    for(int i = x - 1; i > -2; i--) {
      for(int j = y + 1; j < 9 ; j++) {
        if(shouldGeneratorStop(analyzePath(i, j), i, j)) {
          i = -1;
          break;
        }
        i--;
      }
    }

    // Bottom Right Diagonal
    outerloop:
    for(int i = x + 1; i < 9; i++) {
      for(int j = y + 1; j < 9 ; j++) {
        if(shouldGeneratorStop(analyzePath(i, j), i, j)) {
          break outerloop;
        }
        i++;
      }
    }

    validMoves[y][x] = 0;

    return validMoves;
  }
}
