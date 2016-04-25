package chess.util.generator;

import chess.model.ChessPiece;
import chess.model.Move;
import chess.util.Constants;

/**
 * Generator parent class that holds useful methods shared between 2 or more generators.
 */
class Generator {

  final Move move;
  final int[][] board;
  int[][] validMoves;

  /**
   * Constructor taking Move data and current board state
   * @param move      Move data
   * @param board     Current board state
   */
  Generator(Move move, int[][] board) {
    this.move = move;
    this.board = board;
    validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
  }

  /**
   * Analyze the spot
   * @param x               X coordinate
   * @param y               Y coordinate
   * @return                -1 to break, 1 if valid move, 2 if valid move and can attack
   */
  int analyzePath(int x, int y) {
    if(!(x >= 0 && x <= 7) || !(y >= 0 && y <= 7)) {
      return -1;
    }

    ChessPiece chessPiece = null;

    if(board[y][x] != 0) {
      chessPiece = new ChessPiece(board[y][x]);
    }

    // Check if there is a piece on the board.
    // If the piece is of the opposite color, put a 2 (indicating attack)
    // Else if, the piece color does match, return -1 (stop looping)
    // Otherwise, place a 1 (indicating valid move)
    if(chessPiece != null && board[y][x] != 0 &&
        chessPiece.getPieceColor() != move.getPieceColor()) {
      return 2;
    } else if(board[y][x] != 0) {
      return -1;
    } else {
      return 1;
    }
  }

  /**
   * Checks if the generator should stop making the path
   * @param n   Integer returned from analyze path
   * @param x   X coordinate
   * @param y   Y coordinate
   * @return    If the generator should stop
   */
  boolean shouldGeneratorStop(int n, int x, int y) {
    if(n == 1) {
      validMoves[y][x] = 1;
    } else if (n == 2) {
      validMoves[y][x] = 2;
      return true;
    } else {
      return true;
    }

    return false;
  }

  /**
   * Checks if the overlay is on top of positions and corrects validMoves if so.
   * @param x   X coordinate
   * @param y   Y coordinate
   */
  void checkOverlayWithBoard(int x, int y) {
    int possible = analyzePath(x, y);
    if(possible == -1) {
      validMoves[y][x] = 0;
    } else if(possible == 2) {
      validMoves[y][x] = 2;
    }
  }
}
