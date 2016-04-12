package chess.model;

import chess.model.abs.IGameManager;
import chess.presenter.abs.IGameWindowPresenter;

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
    public GameManager(IGameWindowPresenter presenter) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void validateMove(int[][] pointA, int[][] pointB, int chessPieceId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[][] getValidMoves(int[][] point, int chessPieceId) {
        return new int[0][];
    }
}
