package connectfour;

/**
 * This method implements the ComputerStrategy interface
 * using the following strategy: The first move is always column 0.
 * All subsequent moves are the next available column using wrap around.
 * If the last move was column 7, the next move must be column 1,
 * if there is an available space. Note: The game would be done before
 * an attempt is made to make a drop when all columns are filled.
 * @author Shawn Francis
 *
 */
public class BeginnerStrategy implements ComputerStrategy {

	int  turns, tryColumn;

	public BeginnerStrategy(){
		turns = 0;
	}
	public int decideMove(GameBoard board, int playerID) {

		tryColumn = (turns % 7);
		while(!board.isLegalPlay(tryColumn)){
			tryColumn++;
			tryColumn = tryColumn % 7;
		}
		turns++;
		return tryColumn;
	}
}
