package chess.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Translate class' to convert between (x,y) coordinates and chess position names.
 */
public class TranslateTest {

  /**
   * Tests the ability of the translator to convert from XY-coordinates to block name
   * @throws Exception    Throw an exception if test fails
   */
  @Test
  public void fromCoordToName() throws Exception {
    assertTrue(Translate.fromCoordToName(new int[]{0, 0}).equalsIgnoreCase("A1"));
  }

  /**
   * Tests the ability of the translator to convert from block name to XY-coordinates
   * @throws Exception    Throw an exception if the test fails.
   */
  @Test
  public void fromNameToCoord() throws Exception {
    int[] testCoords = new int[]{0, 0};
    int[] actualCoords = Translate.fromNameToCoord("A1");

    compareTestToActualCoords(testCoords, actualCoords);

    testCoords = new int[]{0, 1};
    actualCoords = Translate.fromNameToCoord("A2");

    compareTestToActualCoords(testCoords, actualCoords);
  }

  /**
   * Helper method to save writing the assertEquals for comparing coordinate arrays.
   * @param testCoords      Array of test coordinates.
   * @param actualCoords    Actual coordinates from the method
   */
  private void compareTestToActualCoords(int[] testCoords, int[] actualCoords) {
    assertEquals(testCoords[0], actualCoords[0]);
    assertEquals(testCoords[1], actualCoords[1]);
  }
}