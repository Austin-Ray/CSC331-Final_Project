package chess.model.abs;

import chess.model.Move;

/**
 * Interface that every GameManager must implement.
 */
public interface IGameManager {
  /**
   * Tells the GameManager to start the game.
   */
  void start();

  /**
   * Validates a move. If not valid, just send back the same board as before.
   * @param move    Move object containing all relevant information.
   */
  void validateMove(Move move);

  /**
   * Returns an array of the game board that only lists valid moves.
   * @param move    Move object
   * @return        Array of valid moves for the piece
   */
  int[][] getValidMoves(Move move);
}
