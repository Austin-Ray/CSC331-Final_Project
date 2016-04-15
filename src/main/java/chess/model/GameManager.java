package chess.model;

import chess.model.abs.IGameManager;
import chess.presenter.abs.IGameWindowPresenter;
import chess.util.Constants;

/**
 * Handles all the logic of the chess game.
 */
public class GameManager implements IGameManager {
  private IGameWindowPresenter presenter;

  private int[][] board;

  /**
   * Parameterized constructor that allows specification of IGameWindowPresenter instance.
   * @param presenter     IGameWindowPresenter for passing information to the GameWindow.
   */
  public GameManager(IGameWindowPresenter presenter) {
    this.presenter = presenter;
    initializeBoard();
  }

  /**
   * Initializes the board
   */
  private void initializeBoard() {
    // Initialize the board to all 0's
    board = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    // Add the pieces
    for(int i = 0; i < Constants.BOARD_WIDTH; i++) {
      // Add the black special pieces
      board[0][i] = 20 + Constants.SPECIAL_ROW[i];

      // Add the black pawns
      board[1][i] = 20 + Constants.PAWN_ROW[i];

      // Add the white pawns
      board[Constants.BOARD_HEIGHT - 2][i] = 10 + Constants.PAWN_ROW[i];

      // Add the white special pieces
      board[Constants.BOARD_HEIGHT - 1][i] = 10 + Constants.SPECIAL_ROW[i];
    }

    printBoard();
  }

  /**
   * {@inheritDoc}
   */
  @Override public void start() {

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void validateMove(int[] pointA, int[] pointB, int chessPieceId) {
    // Add move validation here.
    if(true) {
      movePiece(pointA, pointB, chessPieceId);
    }

    presenter.updateBoard(board);
  }

  private void movePiece(int[] pointA, int[] pointB, int chessPieceId) {
    int originX = pointA[0];
    int originY = pointA[1];

    int newX = pointB[0];
    int newY = pointB[1];

    // Place a zero where the piece was, and put the piece ID at the new location.
    board[originY][originX] = 0;
    board[newY][newX] = chessPieceId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] getValidMoves(int[] point, int chessPieceId) {
      return new int[0][0];
  }

  /**
   * Prints the board to console.
   */
  public void printBoard() {
    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
        System.out.format("%02d,", board[i][j]);
      }
      System.out.print("\n");
    }
  }
}
