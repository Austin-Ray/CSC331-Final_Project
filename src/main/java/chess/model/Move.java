package chess.model;

import java.awt.*;

/**
 * Helper class for holding move info.
 */
public class Move {
    private ChessPiece piece;
    private int[] pointA;
    private int[] pointB;

    /**
     * Parameterized constructor for packing all necessary pieces of info into class
     * @param chesspieceID      ID of the chess piece
     * @param pointA            XY-coordinates of first point
     * @param pointB            XY-coordinates of second point
     */
    public Move(int chesspieceID, int[] pointA, int[] pointB) {
        piece = new ChessPiece(chesspieceID);
        this.pointA = pointA;
        this.pointB = pointB;
    }

    /**
     * Gets and returns the ID of the ChessPiece object
     * @return      ID of the ChessPiece object
     */
    public int getPieceId() {
        return piece.getId();
    }

    /**
     * Gets and returns the Color object of the ChessPiece object
     * @return      Color object of the ChessPiece
     */
    public Color getPieceColor() {
        return piece.getPieceColor();
    }

    /**
     * Gets and returns the Type of the ChessPiece object
     * @return      Type of the ChessPiece object
     */
    public ChessPiece.Type getPieceType() {
        return piece.getType();
    }

    /**
     * Returns the first point
     * @return      Array containing XY-coordinates of the first point
     */
    public int[] getPointA() {
        return pointA;
    }

    /**
     * Returns the second point
     * @return      Array containing XY-coordinates of the second point
     */
    public int[] getPointB() {
        return pointB;
    }
}
