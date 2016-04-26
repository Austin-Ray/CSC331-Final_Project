package chess.view;

import chess.presenter.abs.IGameWindowPresenter;
import chess.model.*;
import chess.util.Constants;
import chess.view.abs.IGameWindow;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * GameWindow instance. Front end of the game.
 */
public class GameWindow extends JFrame implements IGameWindow {

  private final IGameWindowPresenter presenter;
  private boolean isGameActive;
    
  private final ChessSquare[][] chessBoardSquares = new ChessSquare[8][8];

  private final Player player1;
  private final Player player2;
  private Player currentPlayer;

  /**
   * Constructor that sets up the GameWindow and all its components.
   * @param presenter     Presenter for callbacks
   */
  public GameWindow(IGameWindowPresenter presenter) {
    this.presenter = presenter;
    isGameActive = true;

    //Build the JFrame Viewer
    this.setTitle("Chess");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.setSize(1000, 1000);

    //Build the Board
    JPanel chessBoard = new JPanel(new GridLayout(0, 8));
    chessBoard.setBorder(new LineBorder(Color.BLACK));
    this.add(chessBoard);

    // Create the player objects
    player1 = new Player(Color.WHITE);
    player2 = new Player(Color.BLACK);
    currentPlayer = player1;

    //Create the Tiles/
    for (int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for (int j = 0; j < Constants.BOARD_WIDTH; j++) {
        ChessSquare square = new ChessSquare(j, i);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        square.setPreferredSize(new Dimension(100, 100));
        square.setBorder(border);
        square.setOpaque(true);

        square.addMouseListener(new MouseListener() {
          @Override public void mouseClicked(MouseEvent e) {
            if(isGameActive) {
              if (currentPlayer.getState() == Player.STATE.NONE
                  && currentPlayer.getColor() == square.getPieceColor()) {
                pieceSelected(square.getPoint());
              } else if (currentPlayer.getState() == Player.STATE.HAS_PIECE
                  && square.getPoint() == currentPlayer.getSelectedPiece()) {
                currentPlayer.setState(Player.STATE.NONE);
                cleanBoard();
              } else if (currentPlayer.getState() == Player.STATE.HAS_PIECE
                  && (square.getBackground() == Color.RED
                  || square.getBackground() == Color.GREEN)) {
                piecePlaced(square.getPoint());
              } else if (currentPlayer.getColor() == square.getPieceColor()) {
                pieceSelected(square.getPoint());
              }
            }
          }

          // We don't care about these methods.
          @Override public void mousePressed(MouseEvent e) { }
          @Override public void mouseReleased(MouseEvent e) { }
          @Override public void mouseEntered(MouseEvent e) { }
          @Override public void mouseExited(MouseEvent e) { }
        });

        //Color the chessboard
        if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
          square.setBackground(new Color(255, 222, 198));
        } else {
          square.setBackground(new Color(239, 173, 107));
        }

        //Add the square to the board
        chessBoardSquares[i][j] = square;
        chessBoard.add(chessBoardSquares[i][j]);
      }
    }
    this.setVisible(true);
  }

  /**
   * Clean the board of any red or green tiles by reverting to default state.
   */
  private void cleanBoard() {
    for (int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for (int j = 0; j < Constants.BOARD_WIDTH; j++) {
        //Color the chessboard
        if((j % 2 == 1 && i % 2 == 1)|| (j% 2 == 0 && i % 2 == 0)) {
          chessBoardSquares[i][j].setBackground(new Color(255, 222, 198));
        } else {
          chessBoardSquares[i][j].setBackground(new Color(239, 173, 107));
        }
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override public void displayValidMoves(int[][] validMoveBoard) {
    int count = 0;
    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
        int validMove = validMoveBoard[i][j];
        if(validMove == 1) {
          chessBoardSquares[i][j].setBackground(Color.GREEN);
          count++;
        } else if(validMove == 2) {
          chessBoardSquares[i][j].setBackground(Color.RED);
          count++;
        }
        chessBoardSquares[i][j].repaint();
      }
    }

    // No valid moves, change state back to NONE.
    if(count == 0) {
      currentPlayer.setState(Player.STATE.NONE);
    }

    repaint();
  }

  /**
   * Invoked when a piece is selected.
   * @param point   Point where piece has been selected
   */
  private void pieceSelected(int[] point) {
    // Clean the board
    cleanBoard();

    // Break the point into X and Y coordinates
    int x = point[0];
    int y = point[1];

    // Change the players state and store what point it has
    currentPlayer.setState(Player.STATE.HAS_PIECE);
    currentPlayer.setSelectedPiece(point);

    // Request valid moves
    presenter.requestValidMoves(point, chessBoardSquares[y][x].getChessPieceId());
  }

  /**
   * Invoked when a piece has been placed.
   * @param point   Point where new piece has been placed.
   */
  private void piecePlaced(int[] point) {
    // Break point into its X and Y coordinates
    int x = currentPlayer.getSelectedPiece()[0];
    int y = currentPlayer.getSelectedPiece()[1];

    // Perform callback
    presenter.pieceMoved(currentPlayer.getSelectedPiece(), point,
        chessBoardSquares[y][x].getChessPieceId());
  }

  /**
   * {@inheritDoc}
   */
  @Override public void updateBoard(int[][] newBoard) {
    cleanBoard();

    for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
        // If there is a piece, configure the square
        // Otherwise, make sure no residual information is possible by setting explicit values.
        if(newBoard[i][j] != 0) {
          ChessPiece piece = new ChessPiece(newBoard[i][j]);
          chessBoardSquares[i][j].setIcon(getImage(piece.getType(), piece.getPieceColor()));
          chessBoardSquares[i][j].setHorizontalAlignment(JLabel.CENTER);
          chessBoardSquares[i][j].setChessPieceId(piece.getId());
          chessBoardSquares[i][j].repaint();
        } else {
          chessBoardSquares[i][j].setChessPieceId(0);
          chessBoardSquares[i][j].setIcon(null);
          chessBoardSquares[i][j].setHorizontalAlignment(JLabel.CENTER);
          chessBoardSquares[i][j].repaint();
        }
      }
    }

    this.repaint();
  }

  /**
   * Gets the current image based on the Type of chesspiece and its color.
   * @param type      Type of piece
   * @param color     Color of the piece
   * @return          ImageIcon based on the type and color
   */
  private ImageIcon getImage(ChessPiece.Type type, Color color) {
      switch(type) {
        case PAWN:
          return color == Color.WHITE ?
              new ImageIcon(getClass().getResource("/res/pawn_white.png")) :
              new ImageIcon(getClass().getResource("/res/pawn_black.png"));
        case ROOK:
          return color == Color.WHITE ?
              new ImageIcon(getClass().getResource("/res/rook_white.png")) :
              new ImageIcon(getClass().getResource("/res/rook_black.png"));
        case BISHOP:
          return color == Color.WHITE ?
              new ImageIcon(getClass().getResource("/res/bishop_white.png")) :
              new ImageIcon(getClass().getResource("/res/bishop_black.png"));
        case KNIGHT:
          return color == Color.WHITE ?
              new ImageIcon(getClass().getResource("/res/knight_white.png")) :
              new ImageIcon(getClass().getResource("/res/knight_black.png"));
        case QUEEN:
          return color == Color.WHITE ?
              new ImageIcon(getClass().getResource("/res/queen_white.png")) :
              new ImageIcon(getClass().getResource("/res/queen_black.png"));
        case KING:
          return color == Color.WHITE ?
              new ImageIcon(getClass().getResource("/res/king_white.png")) :
              new ImageIcon(getClass().getResource("/res/king_black.png"));
        default:
          return null;
      }
      }

  /**
   * {@inheritDoc}
   */
  @Override public void endGame(String winner, String loser) {
    // Stop the game
    isGameActive = false;

    // Create a congratulations message
    JFrame winnerFrame = new JFrame("Winner!");
    winnerFrame.setSize(400, 100);
    winnerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JLabel winnerText = new JLabel(String.format("%s player has defeated the %s player",
        winner, loser));

    // Horizontally align the text.
    winnerText.setHorizontalAlignment(JLabel.CENTER);

    // Set the location to the center of the screen.
    winnerFrame.setLocation(this.getX() + (this.getWidth() / 2) - (winnerFrame.getWidth() / 2),
        this.getY() + (this.getHeight() / 2) - (winnerFrame.getHeight() / 2));

    winnerFrame.add(winnerText);
    winnerFrame.setVisible(true);
  }

  /**
   * {@inheritDoc}
   */
  @Override public void turnComplete(int turn) {
    if(turn == 0) {
      player1.setState(Player.STATE.NONE);
      currentPlayer = player2;
    } else {
      player2.setState(Player.STATE.NONE);
      currentPlayer = player1;
    }
  }
}
