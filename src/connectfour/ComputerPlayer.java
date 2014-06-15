package connectfour;

/**
 * This class extends the Player class to be able
 * to have a computer player with extra methods and
 * to store its current strategy.
 * @author Shawn Francis
 *
 */
public class ComputerPlayer extends Player {
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
        super(name, id);
        currentStrategy = strategy;
    }

	/**
	 * This method changes the current stored
	 * computer strategy to the passed strategy.
	 * @param newStrategy computer strategy
	 */
	public void setStrategy(ComputerStrategy newStrategy){
		currentStrategy = newStrategy;
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

}
