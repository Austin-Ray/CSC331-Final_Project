package chess.util;

public class ArrayUtil {


  public static int[][] overlayArray(int[] point, int[][] base, int[][] overlay) {
    int xCoord = point[0];
    int yCoord = point[1];

    int distanceFromCenter = overlay.length / 2;

    int distanceLeft = translateValue(findDistanceLeft(xCoord, distanceFromCenter), overlay.length);
    int distanceRight = translateValue(findDistanceRight(xCoord, distanceFromCenter), overlay.length);
    int distanceTop = translateValue(findDistanceTop(yCoord, distanceFromCenter), overlay.length);
    int distanceBottom = translateValue(findDistanceFromBottom(yCoord, distanceFromCenter), overlay.length);


    //System.out.format("distanceLeft: %d, distanceRight %d, distanceTop: %d, distanceBottom: %d\n", distanceLeft, distanceRight, distanceTop, distanceBottom);
    for(int i = (distanceFromCenter) - distanceTop; i < overlay.length && i + distanceBottom < Constants.BOARD_HEIGHT; i++) {
      //System.out.format("Y=%d\n", i);
      for(int j = (distanceFromCenter) - distanceLeft; j < overlay.length && j + distanceRight <= Constants.BOARD_WIDTH; j++) {
        //System.out.format("Value %d at X=%d, Y=%d\n", base[i][j], j, i);
        //System.out.format("YCoord + i - distanceFromCenter: %d\n", yCoord + i - distanceFromCenter) ;
        //System.out.format("XCoord + i - distanceFromCenter: %d\n", xCoord + j - distanceFromCenter) ;

        if(!(xCoord + j - distanceFromCenter >= Constants.BOARD_WIDTH || yCoord + i - distanceFromCenter >= Constants.BOARD_HEIGHT)) {
          base[yCoord + i - distanceFromCenter][xCoord + j - distanceFromCenter] = overlay[i][j];
        }
      }
    }

    return base;
  }

  static int findDistanceLeft(int x, int distanceFromCenter) {
    return x - distanceFromCenter;
  }

  static int findDistanceTop(int y, int distanceFromCenter) {
    return y - distanceFromCenter;
  }

  static int findDistanceRight(int x, int distanceFromCenter) {
    return -1 * (x + distanceFromCenter) + Constants.BOARD_WIDTH;
  }

  static int findDistanceFromBottom(int y, int distanceFromCenter) {
    return -1 * (y + distanceFromCenter) + Constants.BOARD_HEIGHT;
  }

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
