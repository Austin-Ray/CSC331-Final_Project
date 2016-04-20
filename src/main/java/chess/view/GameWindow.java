package chess.view;

import chess.presenter.abs.IGameWindowPresenter;
import chess.view.abs.IGameWindow;

/**
 * GameWindow instance. Front end of the game.
 */
public class GameWindow implements IGameWindow {

    private IGameWindowPresenter presenter;

    /**
     * Constructor that sets up the GameWindow and all its components.
     * @param presenter     Presenter for callbacks
     */
    public GameWindow(IGameWindowPresenter presenter) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayValidMoves(int[][] validMoveBoard) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pieceSelected(int[] point) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void piecePlaced(int[] point) {

    }

  /**
   * {@inheritDoc}
   */
  @Override public void updateBoard(int[][] newBoard) {

    }
}
