package chess.util.generator;

import chess.model.Move;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a King piece
 */
public class KingMoveGenerator implements IMoveGenerator {

    private Move move;
    private int[][] board;

    /**
     * Parameterized constructor taking in a Move object and the current state of the board
     * @param move      Move object
     * @param board     Current state of the board
     */
    public KingMoveGenerator(Move move, int[][] board) {
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
