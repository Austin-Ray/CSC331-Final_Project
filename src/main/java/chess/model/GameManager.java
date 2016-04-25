package chess.model;

import chess.model.abs.IGameManager;
import chess.presenter.abs.IGameWindowPresenter;
import chess.util.Constants;
import chess.util.MoveValidator;
import chess.util.ValidMoveGenerator;
import java.awt.Color;

import static chess.model.ChessPiece.Type.PAWN;

/**
 * Handles all the logic of the chess game.
 */
public class GameManager implements IGameManager {
  private final IGameWindowPresenter presenter;

  private int[][] board;
  private int turn;

  private boolean ready;

  /**
   * Parameterized constructor that allows specification of IGameWindowPresenter instance.
   * @param presenter     IGameWindowPresenter for passing information to the GameWindow.
   */
  public GameManager(IGameWindowPresenter presenter) {
    this.presenter = presenter;
    initializeBoard();
    turn = 0;
    ready = false;
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

    //printBoard(board);
  }

  /**
   * {@inheritDoc}
   */
  @Override public void start() {
    ready = true;
    presenter.updateBoard(board);
  }

  /**
   * {@inheritDoc}
   */
  @Override public void validateMove(Move move) {
    // Checks if the move is valid.
    // If it is, update the board. Otherwise, do not modify board.
    if(MoveValidator.isMoveValid(turn, move.getPieceColor(), move.getPointB(), getValidMoves(move))) {
      movePiece(move);
      //printBoard(board);
      presenter.turnComplete(turn);


      // Change the turn to the other player
      if(ready) {
        switch (turn) {
          case 0:
            turn = 1;
            break;
          case 1:
            turn = 0;
            break;
        }
      }
    }

    if(ready) {
      // Tell the presenter to update the GameWindow.
      presenter.updateBoard(board);
    } else {
      this.endGame();
    }
  }

  /**
   * Updates the game board when a valid move is played.
   * @param move    Move object containing all information about a move
   */
  private void movePiece(Move move) {
    // Break the points into their X and Y coordinates.
    int[] pointA = move.getPointA();
    int originX = pointA[0];
    int originY = pointA[1];

    int[] pointB = move.getPointB();
    int newX = pointB[0];
    int newY = pointB[1];

    // Place a zero where the piece was, and put the piece ID at the new location.
    board[originY][originX] = 0;
    int pieceId = move.getPieceId();

    // Checks for victory condition.
    if(board[newY][newX] == 15 || board[newY][newX] == 25) {
      ready = false;
    }
    // Checks if a Pawn can become a Queen
    else if(move.getPieceType() == PAWN) {
      if(move.getPieceColor() == Color.WHITE && newY == 0) {
        pieceId = 14;
      } else if(move.getPieceColor() == Color.BLACK && newY == 7) {
        pieceId = 24;
      }
    }

    board[newY][newX] = pieceId;
  }

  /**
   * {@inheritDoc}
   */
  @Override public int[][] getValidMoves(Move move) {
    return ValidMoveGenerator.generateMoves(move, board);
  }

  /**
   * Ends the game
   */
  private void endGame() {
    presenter.endGame(board, turn);
  }

  /**
   * Prints the board to the console.
   */
  private void printBoard(int[][] array) {
    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
        System.out.format("%02d,", array[i][j]);
      }
      System.out.print("\n");
    }
  }
}
