package connectfour;

/**
 * This class stores the game board needed
 * to play a game of Connect four successfully.
 *
 * @author Shawn Francis
 *
 */
public class GameBoard {

	public static final int EMPTY = 0;
	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	public static final int WIN = 4;

	private int [][] boardLocations;

	/**
	 * The constructor creates a game board initialized
	 * to be empty.
	 */
	public GameBoard() {
		boardLocations = new int[ROWS][COLUMNS];
		clearBoard();
	}

	/**
	 * This method drops the checker into the selected
	 * column. It is assumed that a legal play has been
	 * checked prior to dropping the checker.  It is
	 * also assumed the column selected is a valid
	 * column.
	 * @param column
	 * @param playerID
	 */
	public void dropChecker(int column, int playerID){
		for(int row = (ROWS - 1); row >= 0; row--){
			if(boardLocations[row][column] == EMPTY){
				boardLocations[row][column] = playerID;
				return;
			}
		}
	}

	/**
	 * This method checks the selected column is valid and checks
	 * to see if there is an open move available within that column
	 *
	 * @param column
	 * @return true if there is an open move false otherwise
	 */
	public boolean isLegalPlay(int column){
        return column >= 0 && column < COLUMNS && boardLocations[0][column] == EMPTY;
	}

	/**
	 * This method checks to see if the last person
	 * to make a play is a winner or not.
	 * @param id
	 * @return
	 */
	public boolean isWinner(int id){
		return checkWinVertical(id)
		|| checkWinHorizontal(id)
		|| checkWinDiagonal(id)
		|| checkWinDiagonalReverse(id);

	}

	/**
	 * This method checks the board to see if
	 * all spaces have been filled or not.
	 * @return
	 */
	public boolean isFull(){
		boolean fullBoard = true;
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column ++) {
				if(boardLocations[row][column] == EMPTY){
					fullBoard = false;
				}
			}
		}
		return fullBoard;
	}

	/**
	 * This method clears the board for starting
	 * a new game.
	 */
	public void clearBoard(){
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column ++) {
				boardLocations[row][column] = EMPTY;
			}
		}
	}

	/**
	 * This method gets the value of the specified row
	 * and column passed into the method.
	 * @param row
	 * @param column
	 * @return
	 */
	public int get(int row, int column){
		return boardLocations[row][column];
	}

	/**
	 * This method overrides the toString method
	 * to create a string version of the current
	 * board for display purposes.
	 */
	@Override
	  public String toString() {
	    String boardDisplay = "";
	    for (int row = 0; row < ROWS; row++) {
	      for (int column = 0; column < COLUMNS; column++) {
	        boardDisplay += boardLocations[row][column] + " ";
	      }
	      boardDisplay += "\n";
	    }
	    return boardDisplay;
	}

	/**
	 * This method checks the game board to
	 * see if there is a winner vertically.
	 * @param id
	 * @return
	 */
	private boolean checkWinVertical(int id){
		int winCount;
		for(int i = 0; i < COLUMNS; i++){
			winCount = 0;
			for(int j = 0; j < ROWS; j++){
				if(boardLocations[j][i] == id){
					winCount++;
					if(winCount == WIN){
						return true;
					}
				}
				else{
					winCount = 0;
				}
			}
		}
		return false;
	}

	/**
	 * This method checks the game board to
	 * see if there is a winner horizontally.
	 * @param id
	 * @return
	 */
	private boolean checkWinHorizontal(int id){
		int winCount;
		for(int i = 0; i < ROWS; i++){
			winCount = 0;
			for(int j = 0; j < COLUMNS; j++){
				if(boardLocations[i][j] == id){
					winCount++;
					if(winCount == WIN){
						return true;
					}
				}
				else{
					winCount = 0;
				}
			}
		}
		return false;
	}

	/**
	 * This method checks the game board to
	 * see if there is a winner diagonally.
	 * @param id
	 * @return
	 */
	private boolean checkWinDiagonal(int id){
		int winCount;
		int row, rowShift, column, columnShift;
		row = 2;
		while(row >= 0){
			rowShift = row;
			column = 0;
			winCount = 0;
			while(rowShift < ROWS){
				if(boardLocations[rowShift][column] == id){
					winCount++;
					if(winCount == WIN){
						return true;
					}
				}
				else{
					winCount = 0;
				}
				rowShift++;
				column++;
			}
			row--;
		}
		column = 1;
		while(column < 4){
			columnShift = column;
			row = 0;
			winCount = 0;
			while(columnShift < COLUMNS){
				if(boardLocations[row][columnShift] == id){
					winCount++;
					if(winCount == WIN){
						return true;
					}
				}
				else{
					winCount = 0;
				}
				columnShift++;
				row++;
			}
			column++;
		}
		return false;
	}

	/**
	 * This method checks the game board to
	 * see if there is a winner diagonally
	 * in reverse.
	 * @param id
	 * @return
	 */
	private boolean checkWinDiagonalReverse(int id){
		int winCount;
		int row, rowShift, column, columnShift;
		row = 2;
		while(row >= 0){
			rowShift = row;
			column = 6;
			winCount = 0;
			while(rowShift < ROWS){
				if(boardLocations[rowShift][column] == id){
					winCount++;
					if(winCount == WIN){
						return true;
					}
				}
				else{
					winCount = 0;
				}
				rowShift++;
				column--;
			}
			row--;
		}
		column = 5;
		while(column > 2){
			columnShift = column;
			row = 0;
			winCount = 0;
			while(columnShift >= 0){
				if(boardLocations[row][columnShift] == id){
					winCount++;
					if(winCount == WIN){
						return true;
					}
				}
				else{
					winCount = 0;
				}
				columnShift--;
				row++;
			}
			column--;
		}
		return false;
	}
}
