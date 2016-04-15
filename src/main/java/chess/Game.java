package chess;

import chess.model.GameManager;
import chess.model.abs.IGame;
import chess.model.abs.IGameManager;
import chess.presenter.GameWindowPresenter;
import chess.presenter.abs.IGameWindowPresenter;
import chess.view.GameWindow;
import chess.view.abs.IGameWindow;

public class Game implements IGame {

  IGameManager manager;
  IGameWindow window;

  /**
   * Default constructor
   * Initializes all required components of a Game instance
   */
  public Game() {
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