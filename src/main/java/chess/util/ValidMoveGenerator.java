package chess.util;

import java.awt.Color;

/**
 * Helper class that generates the valid moves based on the current board state and piece position.
 */
public class ValidMoveGenerator {
  /**
   * Generates the valid move board for a pawn
   * @param pieceColor    Color of the piece
   * @param board         Current board state
   * @return              Valid move array
   */
  public static int[][] generatePawnMoves(Color pieceColor, int[][] board) {
    int[][] validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    // TODO: Add implementation

    return validMoves;
  }

  /**
   * Generates the valid move board for a rook
   * @param pieceColor    Color of the piece
   * @param board         Current board state
   * @return              Valid move array
   */
  public static int[][] generateRookMoves(Color pieceColor, int[][] board) {
    int[][] validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    // TODO: Add implementation.

    return validMoves;
  }

  /**
   * Generates the valid move board for a bishop
   * @param pieceColor    Color of the piece
   * @param board         Current board state
   * @return              Valid move array
   */
  public static int[][] generateBishopMoves(Color pieceColor, int[][] board) {
    int[][] validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    // TODO: Add implementation.

    return validMoves;
  }

  /**
   * Generates the valid move board for a knight
   * @param pieceColor    Color of the piece
   * @param board         Current board state
   * @return              Valid move array
   */
  public static int[][] generateKnightMoves(Color pieceColor, int[][] board) {
    int[][] validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    // TODO: Add implementation.

    return validMoves;
  }

  /**
   * Generates the valid move board for a queen
   * @param pieceColor    Color of the piece
   * @param board         Current board state
   * @return              Valid move array
   */
  public static int[][] generateQueenMoves(Color pieceColor, int[][] board) {
    int[][] validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    // TODO: Add implementation.

    return validMoves;
  }

  /**
   * Generates the valid move board for a king
   * @param pieceColor    Color of the piece
   * @param board         Current board state
   * @return              Valid move array
   */
  public static int[][] generateKingMoves(Color pieceColor, int[][] board) {
    int[][] validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    // TODO: Add implementation.

    return validMoves;
  }
}
