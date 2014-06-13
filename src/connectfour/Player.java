package connectfour;

/**
 * This class contains all information needed
 * to store a player for the connect four game.
 * @author Shawn Francis
 *
 */
public class Player {

	private String playerName;
	private int playerID;


	/**
	 * This constructor creates a new player
	 * with its passed name and passed player
	 * id.
	 * @param name
	 * @param id
	 */
	public Player(String name, int id){
		playerName = name;
		playerID = id;

	}

	/**
	 * This method returns the stored
	 * player name.
	 * @return
	 */
	public String getName(){
		return playerName;
	}

	/**
	 * This method returns the stored
	 * player id.
	 * @return
	 */
	public int getID(){
		return playerID;
	}

	public void setStrategy(ComputerStrategy newStrategy){
		return;
	}

	/**
	 * This method returns whether or not
	 * the passed column selected by the player
	 * is a valid move or not. If it is a valid
	 * move it plays the checker if not it returns
	 * false that the move was invalid.
	 * @param board
	 * @param column
	 * @return
	 */
	public boolean makeMove(GameBoard board, int column){
		if(board.isLegalPlay(column)){
			board.dropChecker(column, playerID);
			return true;
		}
		else return false;
	}

}
