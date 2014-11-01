package strategies;

import connectfour.GameBoard;

/**
 * This method implements the ComputerStrategy interface
 * using the following strategy: The computer randomly picks a valid
 * column to play.
 * @author Shawn Francis
 *
 */
public class BeginnerStrategy implements ComputerStrategy {

	public int decideMove(GameBoard board, int playerID) {

        int tryColumn = (int) (Math.random() * 7);
		while(!board.isLegalPlay(tryColumn)){
			tryColumn = (int) (Math.random() * 7);
		}
		return tryColumn;
	}
}
