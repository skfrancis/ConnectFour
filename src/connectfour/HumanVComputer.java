package connectfour;

import java.util.Scanner;

/**
 * This class tests playability of a human
 * versus a computer player(intermediate strategy
 * only).
 *
 * @author Shawn Francis
 *
 */
public class HumanVComputer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameBoard board = new GameBoard();
		Player one = new Player("Human", 1);
		ComputerPlayer two = new ComputerPlayer("Computer", 2, new IntermediateStrategy());

		Scanner keyBoard = new Scanner(System.in);

		int turnCount = 1;
		int columnMove;

		while(board.isFull() != true
				 && board.isWinner(one.getID()) == false
				 && board.isWinner(two.getID()) == false){
			if(turnCount % 2 != 0){
				System.out.println(board.toString());
				System.out.print("Enter Column to drop Checker (0-6): ");
				columnMove = keyBoard.nextInt();
				if (one.makeMove(board, columnMove) == true){
					turnCount++;
				}
				else{
					System.out.println("Invalid Column Selected Please Try Again.");
					System.out.println();
				}

			}
			else{
				two.makeMove(board, 0);
				turnCount++;
			}

		}
		System.out.println(board.toString());
		if (board.isFull() == true){
			System.out.println("Game was a tie!");
		}
		else if(board.isWinner(one.getID())){
			System.out.println(one.getName() + " wins!");
		}
		else if(board.isWinner(two.getID())){
			System.out.println(two.getName() + " wins!");
		}
		board.clearBoard();
	}
}
