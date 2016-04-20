package chess.util.generator;

import chess.model.ChessPiece;
import chess.model.Move;
import chess.util.Constants;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Bishop piece
 */
public class BishopMoveGenerator implements IMoveGenerator {

  private final Move move;
  private final int[][] board;
  private int[][] validMoves;

  /**
   * Parameterized constructor taking in a Move object and the current state of the game board
   * @param move      Move object
   * @param board     Current state of the game board
   */
  public BishopMoveGenerator(Move move, int[][] board) {
    this.move = move;
    this.board = board;
    validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] generateValidMoves() {
    int[] point = move.getPointA();
    int x = point[0];
    int y = point[1];

    // Top Left Diagonal
    for(int i = x; i > 0; i--) {
      for(int j = y; j > 0; j--) {
        if(isNotGood(analyzePath(i, j, move), i, j)) {
          i = -1;
          j = -1;
        }
      }
    }
    // Top Right Diagonal
    for(int i = x; i < Constants.BOARD_WIDTH; i++) {
      for(int j = y; j > 0; j--) {
        if(isNotGood(analyzePath(i, j, move), i, j)) {
          i = 9;
          j = -1;
        }
      }
    }

    // Bottom Left Diagonal
    for(int i = x; i > 0; i--) {
      for(int j = y; j < Constants.BOARD_HEIGHT; j++) {
        if(isNotGood(analyzePath(i, j, move), i, j)) {
          i = -1;
          j = 9;
        }
      }
    }

    // Bottom Right Diagonal
    for(int i = x; i < Constants.BOARD_WIDTH; i++) {
      for(int j = y; j < Constants.BOARD_HEIGHT; j++) {
        if(isNotGood(analyzePath(i, j, move), i, j)) {
          i = 9;
          j = 9;
        }
      }
    }

    return validMoves;
  }

  /**
   * Analyze the spot
   * @param x               X coordinate
   * @param y               Y coordinate
   * @param move            Move object
   * @return                -1 to break, 1 if valid move, 2 if valid move and can attack
   */
  private int analyzePath(int x, int y, Move move) {
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

  private boolean isNotGood(int n, int x, int y) {
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
}
