package connectfour;

/**
 * This class extends the Player class to be able
 * to have a computer player with extra methods and
 * to store its current strategy.
 * @author Shawn Francis
 *
 */
public class ComputerPlayer extends Player {
	ComputerStrategy currentStrategy;

	/**
	 * This constructor creates a new computer
	 * player with the passed name, its passed player
	 * id and its chosen strategy.
	 * @param name
	 * @param id
	 * @param strategy
	 */
	public ComputerPlayer(String name, int id, ComputerStrategy strategy) {
		super(name, id);
		currentStrategy = strategy;

	/**
	 * This method returns the current stored
	 * computer strategy.
	 */
	}
	public ComputerStrategy getStrategy(){
		return currentStrategy;
	}

	/**
	 * This method changes the current stored
	 * computer strategy to the passed strategy.
	 * @param newStrategy
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
