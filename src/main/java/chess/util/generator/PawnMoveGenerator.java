package chess.util.generator;

import chess.model.Move;
import chess.util.generator.abs.IMoveGenerator;

/**
 * Move generator for a Pawn piece
 */
public class PawnMoveGenerator implements IMoveGenerator {
    private int[][] gameboard;
    private Move move;

    /**
     * Parameterized constructor taking a Move object and the current state of the gameboard
     * @param move          Move object
     * @param gameboard     Current state of the gameboard
     */
    public PawnMoveGenerator(Move move, int[][] gameboard) {
        this.move = move;
        this.gameboard = gameboard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[][] generateValidMoves() {
        return new int[0][];
    }
}
