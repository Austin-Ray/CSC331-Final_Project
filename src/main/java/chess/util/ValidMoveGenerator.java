package chess.util;

import chess.model.Move;
import chess.util.generator.*;
import chess.util.generator.abs.IMoveGenerator;
import java.awt.Color;

/**
 * Helper class that generates the valid moves based on the current board state and piece position.
 */
public class ValidMoveGenerator {

  public static int[][] generateMoves(Move move, int[][] board, int turn) {
    IMoveGenerator generator = null;

    // Create a blank board
    int[][] validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    if(turn == 0 && move.getPieceColor() == Color.WHITE ||
        turn == 1 && move.getPieceColor() == Color.BLACK) {
      switch (move.getPieceType()) {
        case PAWN:
          generator = new PawnMoveGenerator(move, board);
          break;
        case ROOK:
          generator = new RookMoveGenerator(move, board);
          break;
        case BISHOP:
          generator = new BishopMoveGenerator(move, board);
          break;
        case KNIGHT:
          generator = new KnightMoveGenerator(move, board);
          break;
        case QUEEN:
          generator = new QueenMoveGenerator(move, board);
          break;
        case KING:
          generator = new KingMoveGenerator(move, board);
          break;
      }
    }

    if(generator != null) {
      validMoves = generator.generateValidMoves();
    }

    return validMoves;
  }
}
