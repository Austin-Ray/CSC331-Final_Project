package chess.util;

public class ArrayUtil {
  public static int[][] overlayArray(int[] point, int[][] base, int[][] overlay) {
    int overlayCenterX = (int)Math.ceil(overlay[0].length / 2.0);
    System.out.format("Overlay Center X: %d\n", overlayCenterX);
    int overlayCenterY = (int)Math.ceil(overlay.length / 2.0);
    System.out.format("Overlay Center Y: %d\n", overlayCenterY);

    int pointX = point[0];
    int pointY = point[1];

    for(int i = pointY - overlayCenterY + 1; i < pointY + overlayCenterY; i++) {
      if(i >= 0 && i < Constants.BOARD_HEIGHT) {
        for(int j = pointX - overlayCenterX + 1; j < pointX + overlayCenterX; j++) {
          if(j >= 0 && j < Constants.BOARD_WIDTH) {
            int x;
            int y;
            System.out.format("J: %d, I: %d\n", j, i);

            if(j >= overlay[0].length) {
              x = j - pointX + 1;
            } else {
              x = j + 1;
            }

            if(i >= overlay.length) {
              y = i - pointY + 1;
            } else {
              y = i + 1;
            }

            if(y == overlay.length) {
              y--;
            }
            if(x == overlay.length) {
              x--;
            }

            if(pointX == 1) {
              if(x == 1 && j == 0 || x == 2 && j == 1) {
                x--;
              }
            }

            if(pointY == 1) {
              if(y == 1 && i == 0 || y == 2 && i == 1) {
                y--;
              }
            }

            if(pointX == 2 && pointY == 2) {
              if(x == 2 && j == 2 && y == 2 && i == 2) {
                x--;
                y--;
              }
            }

            System.out.format("J: %d, I: %d\n", j, i);
            System.out.format("X: %d, Y: %d\n", x, y);
            base[i][j] = overlay[y][x];
            System.out.format("Placed %d at X=%d && Y=%d\n", base[i][j], j, i);
          }
        }
      }
    }

    return base;
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
