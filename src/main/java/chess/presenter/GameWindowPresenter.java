package chess.presenter;

import chess.model.abs.IGameManager;
import chess.presenter.abs.IGameWindowPresenter;
import chess.view.abs.IGameWindow;

/**
 * Presenter class that mediates communication between a GameManager and GameWindow
 */
public class GameWindowPresenter implements IGameWindowPresenter {
    private IGameManager manager;
    private IGameWindow window;

    /**
     * {@inheritDoc}
     */
    @Override
    public void register(IGameManager manager, IGameWindow window) { }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pieceMoved(int[][] pointA, int[][] pointB, int chessPieceId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateBoard(int[][] newBoard) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void requestValidMoves(int[][] point, int chessPieceId) {

    }
}
