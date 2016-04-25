package chess;

import chess.model.GameManager;
import chess.model.abs.IGame;
import chess.model.abs.IGameManager;
import chess.presenter.GameWindowPresenter;
import chess.presenter.abs.IGameWindowPresenter;
import chess.view.GameWindow;
import chess.view.abs.IGameWindow;

/**
 * Game class. Represents a came instance
 */
class Game implements IGame {

  private final IGameManager manager;
  private final IGameWindow window;

  /**
   * Default constructor
   * Initializes all required components of a Game instance
   */
  Game() {
    // Creates the presenter
    IGameWindowPresenter presenter = new GameWindowPresenter();

    // Creates the GameManager and GameWindow
    manager = new GameManager(presenter);
    window = new GameWindow(presenter);

    // Registers GameManager and GameWindow with GamePresenter.
    presenter.register(manager, window);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void run() {
    manager.start();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isReady() {
    return manager != null && window != null;
  }
}
