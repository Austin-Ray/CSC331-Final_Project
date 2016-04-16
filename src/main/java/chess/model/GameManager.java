package chess.model;

import chess.model.abs.IGameManager;
import chess.presenter.abs.IGameWindowPresenter;
import chess.util.Constants;
import chess.util.MoveValidator;
import chess.util.ValidMoveGenerator;

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
    // Checks if the move is valid.
    // If it is, update the board. Otherwise, do not modify board.
    if(MoveValidator.isMoveValid(pointB, getValidMoves(pointA, chessPieceId))) {
      movePiece(pointA, pointB, chessPieceId);
    }

    // Tell the presenter to update the GameWindow.
    presenter.updateBoard(board);
  }

  /**
   * Updates the gameboard when a valid move is played.
   * @param pointA          Origin point
   * @param pointB          Destination point
   * @param chessPieceId    ID of the chess piece
   */
  private void movePiece(int[] pointA, int[] pointB, int chessPieceId) {
    // Break the points into their X and Y coordinates.
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
    int[][] validMoves;

    ChessPiece piece = new ChessPiece(chessPieceId);

    switch(piece.getType()) {
      case PAWN:
        validMoves = ValidMoveGenerator.generatePawnMoves(piece.getPieceColor(), board);
        break;
      case ROOK:
        validMoves = ValidMoveGenerator.generateRookMoves(piece.getPieceColor(), board);
        break;
      case BISHOP:
        validMoves  = ValidMoveGenerator.generateBishopMoves(piece.getPieceColor(), board);
        break;
      case KNIGHT:
        validMoves = ValidMoveGenerator.generateKnightMoves(piece.getPieceColor(), board);
        break;
      case QUEEN:
        validMoves = ValidMoveGenerator.generateQueenMoves(piece.getPieceColor(), board);
        break;
      case KING:
        validMoves = ValidMoveGenerator.generateKingMoves(piece.getPieceColor(), board);
        break;
      default:
        validMoves = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
    }

    return validMoves;
  }

  /**
   * Prints the board to the console.
   */
  private void printBoard() {
    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
        System.out.format("%02d,", board[i][j]);
      }
      System.out.print("\n");
    }
  }
}
