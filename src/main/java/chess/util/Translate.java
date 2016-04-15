package chess.util;

public class Translate {
  public static String fromCoordToName(int[] coords) {
    String name = "";

    name += Constants.BOARD_LETTER_DECODER[coords[0]];
    name += coords[1] + 1;

    return name;
  }

  public static int[] fromNameToCoord(String name) {
    int[] coords = new int[2];

    char[] chars = name.toCharArray();

    coords[0] = String.valueOf(Constants.BOARD_LETTER_DECODER).indexOf(chars[0]);
    coords[1] = Integer.parseInt(String.valueOf(chars[1])) - 1;

    return coords;
  }
}
