package chess.util;

import chess.model.Move;
import chess.util.generator.BishopMoveGenerator;
import chess.util.generator.RookMoveGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {
  @Test
  public void overlayArrayTest() throws Exception {
    int[][] base = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
    int[][] kingOverlay = {{1, 1, 1},
                           {1, 0, 1},
                           {1, 1, 1}};

    int[][] knightOverlay =
       {{0, 1, 0, 1, 0},
        {1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1},
        {0, 1, 0, 1, 0}};

    int[] point = {0, 0};

    //int[][] newArray = ArrayUtil.overlayArray(point, base, kingOverlay);
    int[][] newArray = ArrayUtil.overlayArray(point, base, knightOverlay);

    printArray(newArray);

  }

  @Test
  public void combineArrayTest() throws Exception {
    int[][] base = new int[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
    int[] point = {3, 3};


    int[][] rookArray = new RookMoveGenerator(new Move(11, point, point), base).generateValidMoves();
    int[][] bishopArray = new BishopMoveGenerator(new Move(12, point, point), base).generateValidMoves();

    int[][] newArray = ArrayUtil.combineArray(rookArray, bishopArray);

    printArray(newArray);
  }

  /**
   * Prints an array out
   * @param array   Array
   */
  private void printArray(int[][] array) {
    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
        System.out.format("%01d,", array[i][j]);
      }
      System.out.print("\n");
    }
  }
}