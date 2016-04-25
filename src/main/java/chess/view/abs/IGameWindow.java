package chess.view.abs;

/**
 * Interface that every GameWindow must implement.
 */
public interface IGameWindow {
    /**
     * Displays the valid moves of a chess piece
     * @param validMoveBoard    Valid move board that will be used to paint the tiles of possible moves.
     */
    void displayValidMoves(int[][] validMoveBoard);

  /**
   * Updates the game board to a new state
   * @param newBoard        New game board
   */
  void updateBoard(int[][] newBoard);

  /**
   * Ends the game
   * @param winner    0 if white, 1 if black
   */
  void endGame(String winner, String loser);

  /**
   * Tells the GameWindow the turn is complete.
   */
  void turnComplete(int turn);
}
