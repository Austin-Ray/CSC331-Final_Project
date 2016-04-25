package chess.presenter;

import chess.model.Move;
import chess.model.abs.IGameManager;
import chess.presenter.abs.IGameWindowPresenter;
import chess.view.abs.IGameWindow;

/**
 * Presenter class that mediates communication between a GameManager and GameWindow
 */
public class GameWindowPresenter implements IGameWindowPresenter {
  private IGameManager manager;
  private IGameWindow window;

  public GameWindowPresenter() {}

  /**
   * {@inheritDoc}
   */
  @Override
  public void register(IGameManager manager, IGameWindow window) {
    this.manager = manager;
    this.window = window;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void pieceMoved(int[] pointA, int[] pointB, int chessPieceId) {
    // Convert to the format the GameManager uses
    Move move = new Move(chessPieceId, pointA, pointB);
    manager.validateMove(move);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void updateBoard(int[][] newBoard) {
    window.updateBoard(newBoard);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void requestValidMoves(int[] point, int chessPieceId) {
    // Convert to the format the GameManager uses
    Move move = new Move(chessPieceId, point, new int[]{0});

    // Get the valid moves
    int[][] validMoves = manager.getValidMoves(move);

    // Tell the window to display the valid moves
    window.displayValidMoves(validMoves);
  }

  /**
   * {@inheritDoc}
   */
  public void endGame(int[][] newBoard, int winner) {
    window.updateBoard(newBoard);
    window.endGame(winner);
  }
}
