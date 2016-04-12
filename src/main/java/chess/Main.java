package chess;

import chess.model.Game;

public class Main {
  /**
   * Entry point into the program
   * Creates and runs a Game instance
   * @param args      Command line arguments
   */
  public static void main(String[] args) {
    Game game = new Game();

    if(game.isReady()) {
      game.run();
    } else {
      System.out.println("Game was not ready, unable to start");
    }
  }
}
