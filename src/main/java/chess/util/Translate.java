package chess.util;

/**
 * Translator class that changes between XY-coordinates and block name.
 */
public class Translate {
  /**
   * Translates from XY-coordinates to block name.
   * @param coords    XY coordinates
   * @return          Block name
   */
  public static String fromCoordToName(int[] coords) {
    String name = "";

    name += Constants.BOARD_LETTER_DECODER[coords[0]];
    name += coords[1] + 1;

    return name;
  }

  /**
   * Translates from block name to XY-coordinates.
   * @param name    Block name
   * @return        XY-coordinates.
   */
  public static int[] fromNameToCoord(String name) {
    int[] coords = new int[2];

    char[] chars = name.toCharArray();

    coords[0] = String.valueOf(Constants.BOARD_LETTER_DECODER).indexOf(chars[0]);
    coords[1] = Integer.parseInt(String.valueOf(chars[1])) - 1;

    return coords;
  }
}
