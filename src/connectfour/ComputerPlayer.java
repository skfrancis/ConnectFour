package connectfour;

import strategies.ComputerStrategy;

/**
 * This class extends the Player class to be able
 * to have a computer player with extra methods and
 * to store its current strategy.
 * @author Shawn Francis
 *
 */
public class ComputerPlayer implements Player {
    private final String playerName;
    private final int playerID;
	private ComputerStrategy currentStrategy;

	/**
	 * This constructor creates a new computer
	 * player with the passed name, its passed player
	 * id and its chosen strategy.
	 * @param name player name
	 * @param id player identification
	 * @param strategy computer strategy
	 */
	public ComputerPlayer(String name, int id, ComputerStrategy strategy) {
        playerName = name;
        playerID = id;
        currentStrategy = strategy;
    }

    /**
     * This method returns the stored player name.
     */
    @Override
    public String getName(){
        return playerName;
    }

    /**
     * This method returns the stored player id.
     */
    @Override
    public int getID(){
        return playerID;
    }

    @Override
	public boolean makeMove(GameBoard board, int column){
		column = currentStrategy.decideMove(board, getID());
		if(board.isLegalPlay(column)){
			board.dropChecker(column, getID());
			return true;
		}
		else return false;
	}

    /**
     * This method changes the current stored
     * computer strategy to the passed strategy.
     * @param newStrategy computer strategy
     */
    @Override
    public void setStrategy(ComputerStrategy newStrategy) {
        currentStrategy = newStrategy;
    }
}
