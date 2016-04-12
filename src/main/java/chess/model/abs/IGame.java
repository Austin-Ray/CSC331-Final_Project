package chess.model.abs;

public interface IGame {
  /**
   * Runs the game instance.
   */
  void run();

  /**
   * Return if the game is ready to run.
   * @return    True if ready, otherwise false.
   */
  boolean isReady();
}
