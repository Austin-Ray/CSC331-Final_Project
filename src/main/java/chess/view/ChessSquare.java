package chess.view;

import chess.model.ChessPiece;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * Chess square that appears on the board.
 */
class ChessSquare extends JLabel {
  private final int[] point;
  private int chessPieceId;
  private Color pieceColor;

  /**
   * Parameterized constructor that takes the X and Y coordinates of the piece on the board.
   * @param x     X coordinate
   * @param y     Y coordinates
   */
  ChessSquare(int x, int y) {
    point = new int[2];
    point[0] = x;
    point[1] = y;
    chessPieceId = 0;
    updateColor();
  }

  /**
   * Updates the square's piece's color.
   */
  private void updateColor() {
    if(chessPieceId != 0) {
      ChessPiece piece = new ChessPiece(chessPieceId);
      pieceColor = piece.getPieceColor();
    } else {
      pieceColor = null;
    }
  }

  /**
   * Sets the ChessPieceId
   * @param n   new ChessPieceId
   */
  void setChessPieceId(int n) {
    chessPieceId = n;
    updateColor();
  }

  /**
   * Gets the X and Y coordinates of the piece.
   * @return      Array with X and Y coordinates
   */
  public int[] getPoint() {
    return point;
  }

  /**
   * Gets and returns the ChessPieceId of the piece on the square.
   * @return    ChessPieceId if there is a piece, otherwise 0.
   */
  int getChessPieceId() {
    return chessPieceId;
  }

  /**
   * Returns the square's piece's color.
   * @return    Square's piece's color if any, null otherwise.
   */
  Color getPieceColor() {
    return pieceColor;
  }
}
