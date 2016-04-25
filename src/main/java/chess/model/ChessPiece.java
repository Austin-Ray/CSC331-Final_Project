package chess.model;

import java.awt.*;

/**
 * Data object for holding information about a chess piece
 */
public class ChessPiece {
  /**
   * Type of chess piece.
   */
  public enum Type {
    NONE, PAWN, ROOK, BISHOP, KNIGHT, QUEEN, KING
  }

  private final int id;
  private Type type;
  private Color pieceColor;

  /**
   * Parameterized constructor that takes an ID an processes it.
   * @param chessPieceId      ID of a chess piece.
   */
  public ChessPiece(int chessPieceId) {
    this.id = chessPieceId;
    processId(chessPieceId);
  }

  /**
   * Determine the piece based on its ID
   * @param chessPieceId    ID of chess piece.
   */
  private void processId(int chessPieceId) {
    char[] parts = String.valueOf(chessPieceId).toCharArray();

    if(parts[0] == '1') {
      pieceColor = Color.WHITE;
    }
    else if(parts[0] == '2') {
      pieceColor = Color.BLACK;
    }

    switch (parts[1]) {
      case '0':
        type = Type.PAWN;
        break;
      case '1':
        type = Type.ROOK;
        break;
      case '2':
        type = Type.BISHOP;
        break;
      case '3':
        type = Type.KNIGHT;
        break;
      case '4':
        type = Type.QUEEN;
        break;
      case '5':
        type = Type.KING;
        break;
      default:
        type = Type.NONE;  // Should never happen
    }
  }

  /**
   * Gets and returns the chess piece Id
   * @return  ID of chess piece
     */
  public int getId() {
    return id;
  }

  /**
   * Gets and returns the type of the piece
   * @return  the Type of the chess piece.
   */
  public Type getType() {
    return type;
  }

  /**
   * Gets and returns the color of the chess piece.
   * @return  the color of the piece.
   */
  public Color getPieceColor() {
    return pieceColor;
  }
}
