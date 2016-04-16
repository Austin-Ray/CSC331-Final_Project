package chess.util.generator.abs;

/**
 * Interface that must be implemented by all MoveGenerators
 */
public interface IMoveGenerator {
    /**
     * Generates a game board of valid moves
     * @return      Game board of valid moves
     */
    int[][] generateValidMoves();
}
