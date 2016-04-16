package chess.util.generator;

import chess.model.Move;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Rook piece
 */
public class RookMoveGenerator implements IMoveGenerator {

    private Move move;
    private int[][] board;

    /**
     * Parameterized constructor taking a Move object and the current state of the board
     * @param move
     * @param board
     */
    public RookMoveGenerator(Move move, int[][] board) {
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
