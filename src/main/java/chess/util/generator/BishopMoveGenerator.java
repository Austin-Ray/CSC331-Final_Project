package chess.util.generator;

import chess.model.Move;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Bishop piece
 */
public class BishopMoveGenerator implements IMoveGenerator {

    private Move move;
    private int[][] board;

    /**
     * Parameterized constructor taking in a Move object and the current state of the game board
     * @param move      Move object
     * @param board     Current state of the game board
     */
    public BishopMoveGenerator(Move move, int[][] board) {
        this.move = move;
        this.board = board;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[][] generateValidMoves() {
        return new int[0][];
    }
}
