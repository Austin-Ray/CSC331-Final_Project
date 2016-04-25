package chess.util;

/**
 * Class containing helpful constants.
 */
public class Constants {
  // Height and width of the board;
  public static final int BOARD_HEIGHT = 8;
  public static final int BOARD_WIDTH = 8;

  // Useful for initializing the pieces
  public static final int[] PAWN_ROW = new int[BOARD_WIDTH];
  public static final int[] SPECIAL_ROW = {1, 2, 3, 4, 5, 3, 2, 1};

  // Helpful in the Translate class
  static final char[] BOARD_LETTER_DECODER = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
}
