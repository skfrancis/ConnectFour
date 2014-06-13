package connectfour;

/**
 * This class tests the playability of two
 * computers against each other with different
 * types of strategies employed for at most 1000
 * games each.
 * @author Shawn Francis
 *
 */
public class Run2Bots {

	public static void main(String[] args) {
		int botOneWin, botTwoWin, ties, turnCount;
		GameBoard board = new GameBoard();
		ComputerPlayer one = new ComputerPlayer("Computer One", 1, new IntermediateStrategy());
		ComputerPlayer two = new ComputerPlayer("Computer Two", 2, new IntermediateStrategy());

		ties = 0;
		botOneWin = 0;
		botTwoWin = 0;
		turnCount = 1;

		for(int i = 1; i <= 1000; i++){
			while(board.isFull() != true
				 && board.isWinner(one.getID()) == false
				 && board.isWinner(two.getID()) == false){
				if(turnCount % 2 != 0){
					one.makeMove(board, 0);
					turnCount++;
				}
				else{
					two.makeMove(board, 0);
					turnCount++;
				}
			}
			if (board.isFull() == true){
				ties++;
			}
			else if(board.isWinner(one.getID())){
				botOneWin++;
			}
			else if(board.isWinner(two.getID())){
				botTwoWin++;
			}
			board.clearBoard();
		}
		System.out.println(one.getName() + " won " + botOneWin + " games.");
		System.out.println(two.getName() + " won " + botTwoWin + " games.");
		System.out.println("There was "+ ties + " tie games.");
		System.out.println();

		one.setStrategy(new BeginnerStrategy());
		two.setStrategy(new IntermediateStrategy());
		botOneWin = 0;
		botTwoWin = 0;
		ties = 0;

		for(int i = 1; i <= 1000; i++){
			if(i == 501){
				one.setStrategy(new IntermediateStrategy());
				two.setStrategy(new BeginnerStrategy());
			}
			while(board.isFull() != true
				 && board.isWinner(one.getID()) == false
				 && board.isWinner(two.getID()) == false){
				if(turnCount % 2 != 0){
					one.makeMove(board, 0);
					turnCount++;
				}
				else{
					two.makeMove(board, 0);
					turnCount++;
				}
			}
			if (board.isFull() == true){
				ties++;
			}
			else if(board.isWinner(one.getID())){
				botOneWin++;
			}
			else if(board.isWinner(two.getID())){
				botTwoWin++;
			}
			board.clearBoard();
		}
		System.out.println(one.getName() + " won " + botOneWin + " games.");
		System.out.println(two.getName() + " won " + botTwoWin + " games.");
		System.out.println("There was "+ ties + " tie games.");
		System.out.println();

		one.setStrategy(new BeginnerStrategy());
		two.setStrategy(new IntermediateStrategy());
		botOneWin = 0;
		botTwoWin = 0;
		ties = 0;

		for(int i = 1; i <= 1000; i++){

			while(board.isFull() != true
				 && board.isWinner(one.getID()) == false
				 && board.isWinner(two.getID()) == false){
				if(turnCount % 2 != 0){
					one.makeMove(board, 0);
					turnCount++;
				}
				else{
					two.makeMove(board, 0);
					turnCount++;
				}
			}
			if (board.isFull() == true){
				ties++;
			}
			else if(board.isWinner(one.getID())){
				botOneWin++;
			}
			else if(board.isWinner(two.getID())){
				botTwoWin++;
			}
			board.clearBoard();
		}
		System.out.println(one.getName() + " won " + botOneWin + " games.");
		System.out.println(two.getName() + " won " + botTwoWin + " games.");
		System.out.println("There was "+ ties + " tie games.");
		System.out.println();

		one.setStrategy(new BeginnerStrategy());
		two.setStrategy(new AdvancedStrategy());
		botOneWin = 0;
		botTwoWin = 0;
		ties = 0;

		for(int i = 1; i <= 1000; i++){

			while(board.isFull() != true
				 && board.isWinner(one.getID()) == false
				 && board.isWinner(two.getID()) == false){
				if(turnCount % 2 != 0){
					one.makeMove(board, 0);
					turnCount++;
				}
				else{
					two.makeMove(board, 0);
					turnCount++;
				}
			}
			if (board.isFull() == true){
				ties++;
			}
			else if(board.isWinner(one.getID())){
				botOneWin++;
			}
			else if(board.isWinner(two.getID())){
				botTwoWin++;
			}
			board.clearBoard();
		}

		System.out.println(one.getName() + " won " + botOneWin + " games.");
		System.out.println(two.getName() + " won " + botTwoWin + " games.");
		System.out.println("There was "+ ties + " tie games.");

		one.setStrategy(new IntermediateStrategy());
		two.setStrategy(new AdvancedStrategy());
		botOneWin = 0;
		botTwoWin = 0;
		ties = 0;

		for(int i = 1; i <= 1000; i++){

			while(board.isFull() != true
				 && board.isWinner(one.getID()) == false
				 && board.isWinner(two.getID()) == false){
				if(turnCount % 2 != 0){
					one.makeMove(board, 0);
					turnCount++;
				}
				else{
					two.makeMove(board, 0);
					turnCount++;
				}
			}
			if (board.isFull() == true){
				ties++;
			}
			else if(board.isWinner(one.getID())){
				botOneWin++;
			}
			else if(board.isWinner(two.getID())){
				botTwoWin++;
			}
			board.clearBoard();
		}
		System.out.println();
		System.out.println(one.getName() + " won " + botOneWin + " games.");
		System.out.println(two.getName() + " won " + botTwoWin + " games.");
		System.out.println("There was "+ ties + " tie games.");
	}
}
