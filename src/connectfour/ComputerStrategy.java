package connectfour;
/**
 * This interface is used to implement a
 * computer strategy for dropping checkers
 * in a connect four game.
 * @author Shawn Francis
 *
 */
public interface ComputerStrategy {

	/**
	 * This method will return a decided move
	 * for the computer based on the strategy
	 * employed.
	 * @param board
	 * @param playerID
	 * @return
	 */
	public int decideMove(GameBoard board, int playerID);
}
