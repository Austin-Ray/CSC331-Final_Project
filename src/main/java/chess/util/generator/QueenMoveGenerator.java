package chess.util.generator;

import chess.model.Move;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Queen piece
 */
public class QueenMoveGenerator implements IMoveGenerator {

    private int[][] board;
    private Move move;

    /**
     * Parameterized constructor taking a Move object and the current state of the game board.
     * @param move      Move object
     * @param board     Current state of the board
     */
    public QueenMoveGenerator(Move move, int[][] board) {
        this.board = board;
        this.move = move;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[][] generateValidMoves() {
        return new int[0][];
    }
}
