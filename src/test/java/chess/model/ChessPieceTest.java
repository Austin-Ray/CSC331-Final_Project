package chess.model;

import java.awt.Color;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ChessPiece class' ability to process a chess pieces ID to get color and type.
 */
public class ChessPieceTest {
  private ChessPiece whitePawn = new ChessPiece(10);
  private ChessPiece whiteRook = new ChessPiece(11);
  private ChessPiece whiteBishop = new ChessPiece(12);
  private ChessPiece whiteKnight = new ChessPiece(13);
  private ChessPiece whiteQueen = new ChessPiece(14);
  private ChessPiece whiteKing = new ChessPiece(15);

  private ChessPiece blackPawn = new ChessPiece(20);
  private ChessPiece blackRook = new ChessPiece(21);
  private ChessPiece blackBishop = new ChessPiece(22);
  private ChessPiece blackKnight = new ChessPiece(23);
  private ChessPiece blackQueen = new ChessPiece(24);
  private ChessPiece blackKing = new ChessPiece(25);

  /**
   * Tests the getType() method of the ChessPiece class
   * @throws Exception    Throw an exception if test fails.
   */
  @Test
  public void getType() throws Exception {
    // Test the white pieces' type
    assertEquals(ChessPiece.Type.PAWN, whitePawn.getType());
    assertEquals(ChessPiece.Type.ROOK, whiteRook.getType());
    assertEquals(ChessPiece.Type.BISHOP, whiteBishop.getType());
    assertEquals(ChessPiece.Type.KNIGHT,whiteKnight.getType());
    assertEquals(ChessPiece.Type.QUEEN, whiteQueen.getType());
    assertEquals(ChessPiece.Type.KING, whiteKing.getType());

    // Test the black pieces' type
    assertEquals(ChessPiece.Type.PAWN, blackPawn.getType());
    assertEquals(ChessPiece.Type.ROOK, blackRook.getType());
    assertEquals(ChessPiece.Type.BISHOP, blackBishop.getType());
    assertEquals(ChessPiece.Type.KNIGHT, blackKnight.getType());
    assertEquals(ChessPiece.Type.QUEEN, blackQueen.getType());
    assertEquals(ChessPiece.Type.KING, blackKing.getType());
  }

  /**
   * Tests the getPieceColor() method of the ChessPiece class
   * @throws Exception    Throw an exception if test fails.
   */
  @Test
  public void getPieceColor() throws Exception {
    // Test the white pieces' color
    assertEquals(Color.WHITE, whitePawn.getPieceColor());
    assertEquals(Color.WHITE, whiteRook.getPieceColor());
    assertEquals(Color.WHITE, whiteBishop.getPieceColor());
    assertEquals(Color.WHITE, whiteKnight.getPieceColor());
    assertEquals(Color.WHITE, whiteQueen.getPieceColor());
    assertEquals(Color.WHITE, whiteKing.getPieceColor());

    // Test the black pieces' color
    assertEquals(Color.BLACK, blackPawn.getPieceColor());
    assertEquals(Color.BLACK, blackRook.getPieceColor());
    assertEquals(Color.BLACK, blackBishop.getPieceColor());
    assertEquals(Color.BLACK, blackKnight.getPieceColor());
    assertEquals(Color.BLACK, blackQueen.getPieceColor());
    assertEquals(Color.BLACK, blackKing.getPieceColor());
  }
}