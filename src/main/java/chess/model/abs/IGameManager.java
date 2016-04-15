package chess.model.abs;

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
   * @param pointA        Origin point
   * @param pointB        New point
   * @param chessPieceId  ID of chess piece
   */
  void validateMove(int[] pointA, int[] pointB, int chessPieceId);

  /**
   * Returns an array of the game board that only lists valid moves.
   * @param point             Point where piece is located.
   * @param chessPieceId      Chess piece's id
   * @return                  Array of valid moves for the piece
   */
  int[][] getValidMoves(int[] point, int chessPieceId);
}
