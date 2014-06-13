package connectfour;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class creates a graphical version of the game board
 * extending JPanel so it can be added into a window.
 * @author Shawn Francis
 *
 */
@SuppressWarnings("serial")
public class GameBoardDisplay extends JPanel implements MouseListener, ActionListener {

	private static final int TIMER = 500;
	private static final int COLUMNS = 7;

	private GameBoard board;
	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;
	private ViewDisplay currentView;
	private int lastClickedColumn;
	private Timer gameClock;
	private boolean columnClicked;

	/**
	 * This constructor creates a new board and
	 * sets up a timer used to check for user and
	 * computer input during the game.
	 *
	 */
	public GameBoardDisplay(){
		board = new GameBoard();
		currentView = new GraphicsDisplay();
		gameClock = new Timer(TIMER, this);
		columnClicked = false;
	}

	/**
	 * This method starts the game and adds the
	 * mouse listener.
	 */
	public void startGame(){
		gameClock.start();
		addMouseListener(this);

	}

	/**
	 * This method stops the game and removes the
	 * mouse listener.
	 */
	public void stopGame(){
		gameClock.stop();
		removeMouseListener(this);
	}

	/**
	 * This private method listens for the timer "clicks" during
	 * game play and sends off game moves based on whose turn it
	 * currently is.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentPlayer instanceof ComputerPlayer){
			currentPlayer.makeMove(board, 0);
		}
		else{
			if(columnClicked == false){
				return;
			}
			else{
				if (currentPlayer.makeMove(board, lastClickedColumn) == true){
					columnClicked = false;
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid Column Selected Please Try Again.");
					return;
				}
			}
		}

		if(board.isWinner(currentPlayer.getID())){
			repaint();
			JOptionPane.showMessageDialog(null, currentPlayer.getName() + " wins!");
			stopGame();
		}
		else if(board.isFull()){
			repaint();
			JOptionPane.showMessageDialog(null, "Game was a tie!");
			stopGame();
		}
		else{
			nextPlayer();
		}
		repaint();
	}

	/**
	 * This method creates a new game based on the
	 * passed players to the method.
	 * @param one
	 * @param two
	 */
	public void newGame(Player one, Player two){
		playerOne = one;
		playerTwo = two;
		currentPlayer = playerOne;
		board.clearBoard();
		repaint();
	}

	/**
	 * This method is used to switch between
	 * displays.
	 * @param newDisplay
	 */
	public void setDisplay(ViewDisplay newDisplay){
		currentView = newDisplay;
		repaint();
	}

	/**
	 * This method controls how the Panel is painted.
	 */
	@Override
	 public void paintComponent(Graphics g) {
		super.paintComponent(g);
		currentView.paintDisplay(this, g, board);
	}

	/**
	 * These set of mouse listener methods are used to
	 * get the user input via the mouse clicked on the game
	 * board.
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		lastClickedColumn = event.getPoint().x / (getSize().width / COLUMNS);
		columnClicked = true;
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub not used
	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub not used
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub not used
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub not used
	}

	/**
	 * This private method switches between players
	 * after a player has taken their move.
	 */
	private void nextPlayer(){
		if(currentPlayer == playerOne){
			currentPlayer = playerTwo;
		}
		else{
			currentPlayer = playerOne;
		}
	}


}
