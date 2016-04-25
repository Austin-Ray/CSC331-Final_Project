package chess.view;

import chess.presenter.abs.IGameWindowPresenter;
import chess.model.*;
import chess.util.Constants;
import chess.view.abs.IGameWindow;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

/**
 * GameWindow instance. Front end of the game.
 */
public class GameWindow extends JFrame implements IGameWindow {

    private IGameWindowPresenter presenter;
    
    private JLabel[][] chessBoardSquares = new JLabel[8][8];
    private JPanel chessBoard;
    enum Player_State{
    	selectPiece, movePiece
    	
    } 

    /**
     * Constructor that sets up the GameWindow and all its components.
     * @param presenter     Presenter for callbacks
     */
    public GameWindow(IGameWindowPresenter presenter) {
    	//Build the JFrame Viewer
    	this.setTitle("Chess");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new FlowLayout());
    	this.setSize(1000, 1000);
    	
    	//Build the Board
    	chessBoard = new JPanel(new GridLayout(0, 8));
    	chessBoard.setBorder(new LineBorder(Color.BLACK));
    	this.add(chessBoard);
    	
    	//Create the Tiles/
    	for (int i = 0; i < Constants.BOARD_HEIGHT; i++){
    		for (int j = 0; j < Constants.BOARD_WIDTH; j++){  			
    			JLabel square = new JLabel();
    		    			
    			Border border = BorderFactory.createLineBorder(Color.BLACK);
    			square.setPreferredSize(new Dimension(100, 100));
    			square.setBorder(border);
    			square.setOpaque(true);
    			
    			square.addMouseListener(new MouseListener());
    			
    			//Color the chessboard
    			if((j % 2 == 1 && i % 2 == 1)|| (j% 2 == 0 && i % 2 == 0)) {
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
     * {@inheritDoc}
     */
    @Override
    public void displayValidMoves(int[][] validMoveBoard) {
    	
    	//Local variable for valid move options
    	int[][] canMove = validMoveBoard;
    	
    	//
    	for(int i = 0; i < Constants.BOARD_HEIGHT; i++){
    		for(int j = 0; j < Constants.BOARD_WIDTH; j++){
    			int[][] boardSquare = new int[i][j];
    			
    			if(boardSquare == canMove){
    				chessBoardSquares[i][j].setBackground(Color.RED);
    			}
    		}
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pieceSelected(int[] point) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void piecePlaced(int[] point) {

    }

  /**
   * {@inheritDoc}
   */
  @Override public void updateBoard(int[][] newBoard) {
	  for(int i = 0; i < Constants.BOARD_HEIGHT; i++) {
	      for(int j = 0; j < Constants.BOARD_WIDTH; j++) {
	        if(newBoard[i][j] != 0) {
	          ChessPiece piece = new ChessPiece(newBoard[i][j]);
	          if((j % 2 == 1 && i % 2 == 1)|| (j% 2 == 0 && i % 2 == 0)) {
  				chessBoardSquares[i][j].setBackground(new Color(255, 222, 198));
  			} else {
  				chessBoardSquares[i][j].setBackground(new Color(239, 173, 107));
  			}
	          chessBoardSquares[i][j].setIcon(getImage(piece.getType(), piece.getPieceColor()));
	          chessBoardSquares[i][j].setHorizontalAlignment(JLabel.CENTER);
	        }
	      }
	  }
	  
	  repaint();
  }
  
  private ImageIcon getImage(ChessPiece.Type type, Color color) {
	    switch(type) {
	      case PAWN:
	        if(color == Color.WHITE) {
	          return new ImageIcon("res/pawn_white.png");
	        } else {
	          return new ImageIcon("res/pawn_black.png");
	        }
	      case ROOK:
	        if(color == Color.WHITE) {
	          return new ImageIcon("res/rook_white.png");
	        } else {
	          return new ImageIcon("res/rook_black.png");
	        }
	      case BISHOP:
	        if(color == Color.WHITE) {
	          return new ImageIcon("res/bishop_white.png");
	        } else {
	          return new ImageIcon("res/bishop_black.png");
	        }
	      case KNIGHT:
	        if(color == Color.WHITE) {
	          return new ImageIcon("res/knight_white.png");
	        } else {
	          return new ImageIcon("res/knight_black.png");
	        }
	      case QUEEN:
	        if(color == Color.WHITE) {
	          return new ImageIcon("res/queen_white.png");
	        } else {
	          return new ImageIcon("res/queen_black.png");
	        }
	      case KING:
	        if(color == Color.WHITE) {
	          return new ImageIcon("res/king_white.png");
	        } else {
	          return new ImageIcon("res/king_black.png");
	        }
	      default:
	        return null;
	    }
	    }

  /**
   * {@inheritDoc}
   * @param winner    0 if white, 1 if black
   */
  @Override public void endGame(int winner) {

  }
}
