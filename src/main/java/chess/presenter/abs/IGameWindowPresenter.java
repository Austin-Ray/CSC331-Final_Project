package chess.presenter.abs;

import chess.model.abs.IGameManager;
import chess.view.abs.IGameWindow;

/**
 * Interface for the GameWindow presenter.
 */
public interface IGameWindowPresenter {

  /**
     * Registers the manager and window with the presenter in order to do callbacks.
     * @param manager   Instance of IGameManager. Used to call to the back end.
     * @param window    Instance of IGameWindow. Used to call to the front end.
     */
  void register(IGameManager manager, IGameWindow window);

  /**
     * Notifies the IGameManager that piece was moved.
     * @param pointA        Origin point
     * @param pointB        New point
     * @param chessPieceId  ID of chess piece
     */
  void pieceMoved(int[] pointA, int[] pointB, int chessPieceId);

  /**
     * Passes an updated game board to the GameWindow to draw.
     * @param newBoard      New game board to be drawn
     */
  void updateBoard(int[][] newBoard);

  /**
     * Requires all
     * @param point             Point where chess piece is located
     * @param chessPieceId      Id of chess piece
     */
  void requestValidMoves(int[] point, int chessPieceId);

  /**
   * Ends the game.
   * @param newBoard    Last board update
   */
  void endGame(int[][] newBoard, int turn);

  /**
   * Tells the GameWindow to change turn
   */
  void turnComplete(int turn);
}
