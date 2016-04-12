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
     * Handles when a piece is selected.
     */
    void pieceSelected(int[][] point);

    /**
     * Handles when a piece is moved.
     */
    void piecePlaced(int[][] point);
}
