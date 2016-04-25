package chess.model;

import java.awt.Color;

/**
 * Representation of a player.
 */
public class Player {
  /**
   * States the player can be in
   */
  public enum STATE {
    NONE, HAS_PIECE
  }

  private STATE state;
  private int[] selectedPiece;
  private final Color color;

  /**
   * Parameterized taking in the player's color
   * @param color   Color of the player
   */
  public Player(Color color) {
    this.color = color;
    state = STATE.NONE;
    selectedPiece = new int[]{0};
  }

  /**
   * Change the state of the player
   * @param newState    New player state
   */
  public void setState(STATE newState) {
    this.state = newState;
  }

  /**
   * Set the coordinates of the selected piece
   * @param coords    XY coordinates of the piece.
   */
  public void setSelectedPiece(int[] coords) {
    selectedPiece = coords;
  }

  /**
   * Returns the player's state
   * @return    Player's state
   */
  public STATE getState() {
    return state;
  }

  /**
   * Return the coordinates of the selected piece
   * @return    Integer array containing X and Y coordinates
   */
  public int[] getSelectedPiece() {
    return selectedPiece;
  }

  /**
   * Gets and returns the player's color
   * @return    Player's color
   */
  public Color getColor() {
    return color;
  }
}
