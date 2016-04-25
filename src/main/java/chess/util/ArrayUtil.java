package chess.util;

/**
 * Helper class for array manipulation
 */
public class ArrayUtil {
  /**
   * Overlay one array on top of another
   * @param point       Point that needs the overlay on
   * @param base        Base array
   * @param overlay     Overlay array
   * @return            Base array with overlay
   */
  public static int[][] overlayArray(int[] point, int[][] base, int[][] overlay) {
    int xCoord = point[0];
    int yCoord = point[1];

    int distanceFromCenter = overlay.length / 2;

    int distanceLeft = translateValue(findDistanceLeft(xCoord, distanceFromCenter), overlay.length);
    int distanceRight = translateValue(findDistanceRight(xCoord, distanceFromCenter), overlay.length);
    int distanceTop = translateValue(findDistanceTop(yCoord, distanceFromCenter), overlay.length);
    int distanceBottom = translateValue(findDistanceFromBottom(yCoord, distanceFromCenter), overlay.length);

    for(int i = (distanceFromCenter) - distanceTop; i < overlay.length && i + distanceBottom < Constants.BOARD_HEIGHT; i++) {
      for(int j = (distanceFromCenter) - distanceLeft; j < overlay.length && j + distanceRight <= Constants.BOARD_WIDTH; j++) {

        if(!(xCoord + j - distanceFromCenter >= Constants.BOARD_WIDTH || yCoord + i - distanceFromCenter >= Constants.BOARD_HEIGHT)) {
          base[yCoord + i - distanceFromCenter][xCoord + j - distanceFromCenter] = overlay[i][j];
        }
      }
    }

    return base;
  }

  /**
   * Find the distance from the left
   * @param x                     X coordinate
   * @param distanceFromCenter    Distance from the center of the overlay
   * @return                      Distance between X coordinate and array bounds
   */
  private static int findDistanceLeft(int x, int distanceFromCenter) {
    return x - distanceFromCenter;
  }

  /**
   * Finds the distance from the top of the array
   * @param y                     Y coordinate
   * @param distanceFromCenter    Distance from center of overlay
   * @return                      Distance from the top of the array bounds
   */
  private static int findDistanceTop(int y, int distanceFromCenter) {
    return y - distanceFromCenter;
  }

  /**
   * Finds the distance from the right bound of the array
   * @param x                     X coordinate
   * @param distanceFromCenter    Distance from the center of the overlay.
   * @return                      Distance from the right bound of the array.
   */
  private static int findDistanceRight(int x, int distanceFromCenter) {
    return -1 * (x + distanceFromCenter) + Constants.BOARD_WIDTH;
  }

  /**
   * Finds the distance from the bottom of the array.
   * @param y                     Y coordinate
   * @param distanceFromCenter    Distance from the center of the overlay array
   * @return                      Distance from the bottom of the base array.
   */
  private static int findDistanceFromBottom(int y, int distanceFromCenter) {
    return -1 * (y + distanceFromCenter) + Constants.BOARD_HEIGHT;
  }

  /**
   * Translate a value from the base array to the proper overlay value
   * @param n           Base Array value
   * @param length      Length of the overlay array
   * @return            Translated coordinate that works in the overlay
   */
  private static int translateValue(int n, int length) {
    if(n == 0) {
      return length / 2;
    } else if(n < 0 && length == 3) {
      return 0;
    } else if(n < 0 && length == 5) {
      return n + length / 2;
    } else if(n >= length - (length / 2)) {
      return length - (length / 2 + 1);
    }

    return length / 2;
  }

  /**
   * Combine two arrays. Overlays one values into another.
   * @param array1    First array
   * @param array2    Second array
   * @return          Combined array
   */
  public static int[][] combineArray(int[][] array1, int[][] array2) {
    int[][] newArray = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];

    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
        if(array1[i][j] != 0) {
          newArray[i][j] = array1[i][j];
        }

        if(array2[i][j] != 0) {
          newArray[i][j] = array2[i][j];
        }
      }
    }

    return newArray;
  }
}
