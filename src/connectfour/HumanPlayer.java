package connectfour;

import strategies.ComputerStrategy;

/**
 * This class contains all information needed for a human player.
 * @author Shawn Francis
 *
 */
class HumanPlayer implements Player {

	private final String playerName;
	private final int playerID;

	/**
	 * This constructor creates a new player with its passed name and passed player id.
	 * @param name player name
	 * @param id computer strategy
	 */
	public HumanPlayer(String name, int id){
		playerName = name;
		playerID = id;

	}

	/**
	 * This method returns the player's name.
	 */
	public String getName(){
		return playerName;
	}

	/**
	 * This method returns the player's id.
	 */
	public int getID(){
		return playerID;
	}

    /**
     * This method returns true if the passed column selected by the player
     * is a valid move. If it is a valid move it plays the checker. Otherwise it returns false
     * that the move was invalid.
     * @param board game board
     * @param column board column
     * @return returns true if move was valid and completed; otherwise false
     */
    public boolean makeMove(GameBoard board, int column){
        if(board.isLegalPlay(column)){
            board.dropChecker(column, playerID);
            return true;
        }
        else return false;
    }

    /**
     * Method not used
     * @param newStrategy not used
     */
	public void setStrategy(ComputerStrategy newStrategy){}
}
