package connectfour;

/**
 * This method implements the ComputerStrategy interface
 * using the following strategy: It should first try to win,
 * but if not possible, this strategy should block one of the
 * opponent's possible win(s). In other cases, the drop may
 * involve some extra thinking or the drop may simply be random.
 * @author Shawn Francis
 *
 */
public class IntermediateStrategy implements ComputerStrategy {

	public int decideMove(GameBoard board, int compID) {
		int result = 8;

		//comp tries to win
		////////////////////////////////////////////////////////////////////
		//down-right
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				if(board.get(i,j) == 0 && board.get(i+1,j+1) == board.get(i+2,j+2) &&
						board.get(i+1,j+1) == board.get(i+3,j+3) && board.get(i+1,j+1) == compID
						&& (board.get(i+1,j) != 0 || i == 5)){
					result = j;
				}
			}
		}

		if(result == 8){
			for(int i = 1; i < 4; i++){
				for(int j = 1; j < 5; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j-1) == board.get(i+1,j+1) &&
							board.get(i-1,j-1) == board.get(i+2,j+2) && board.get(i-1,j-1) == compID
							&& (board.get(i+1,j) != 0) ){
						result = j;
					}

				}
			}
		}
		if(result == 8){
			for(int i = 2; i < 5; i++){
				for(int j = 2; j < 6; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j-1) == board.get(i+1,j+1) &&
							board.get(i-1,j-1) == board.get(i-2,j-2) && board.get(i-1,j-1) == compID
							&& (board.get(i+1,j) != 0)){
						result = j;
					}

				}
			}
		}

		//up-right
		if(result == 8){
			for(int i = 3; i < 6; i++){
				for(int j = 0; j < 4; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j+1) == board.get(i-2,j+2) &&
							board.get(i-1,j+1) == board.get(i-3,j+3) && board.get(i-1,j+1) == compID){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		if(result == 8){
			for(int i = 2; i < 5; i++){
				for(int j = 1; j < 5; j++){
						if(board.get(i,j) == 0 && board.get(i-1,j+1) == board.get(i-2,j+2) &&
							board.get(i-1,j+1) == board.get(i+1,j-1) && board.get(i-1,j+1) == compID
							&& board.get(i-1,j+1) != 0  && board.get(i+1,j) != 0){
						result = j;
						}
				}
			}
		}

		if(result == 8){
			for(int i = 1; i < 4; i++){
				for(int j = 2; j < 6; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j+1) == board.get(i+1,j-1) &&
							board.get(i-1,j+1) == board.get(i+2,j-2) && board.get(i-1,j+1) == compID
							&& board.get(i-1,j+1) != 0  && board.get(i+1,j) != 0){
						result = j;
						}
				}
			}
		}

		//down-left
		if(result == 8){
			for(int i = 0; i < 3; i++){
				for(int j = 3; j < 7; j++){
					if(board.get(i,j) == 0 && board.get(i+1,j-1) == board.get(i+2,j-2) &&
							board.get(i+1,j-1) == board.get(i+3,j-3) && board.get(i+1,j-1) == compID
							&& (board.get(i+1,j) != 0 || i == 5)){
						result = j;
					}
				}
			}

		}

		//up-left
		if(result == 8){
			for(int i = 3; i < 6; i++){
				for(int j = 3; j < 7; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j-1) == board.get(i-2,j-2) &&
							board.get(i-1,j-1) == board.get(i-3,j-3) && board.get(i-1,j-1) == compID){
							if(i == 5){
								result = j;
							}
							else if( board.get(i+1,j) != 0){
								result = j;
							}
					}
				}
			}
		}

		//down
		if(result == 8){
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 7; j++){
					if(board.get(i,j) == 0 && board.get(i+1,j) ==compID &&
							board.get(i+1,j) == board.get(i+2,j) && board.get(i+1,j) == board.get(i+3,j)){
						result = j;
					}
				}
			}
		}

		//left
		if(result == 8){
			for(int i = 0; i < 6; i++){
				for(int j = 3; j < 7; j++){
					if(board.get(i,j) == 0 && board.get(i,j-1) ==compID &&
							board.get(i,j-1) == board.get(i,j-2) && board.get(i,j-1) == board.get(i,j-3)){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}
		if(result == 8){
			for(int i = 0; i < 6; i++){
				for(int j = 1; j < 5; j++){
					if(board.get(i,j) == 0 && board.get(i,j-1) ==compID &&
							board.get(i,j-1) == board.get(i,j+1) && board.get(i,j-1) == board.get(i,j+2)){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		if(result == 8){
			for(int i = 0; i < 6; i++){
				for(int j = 2; j < 6; j++){
					if(board.get(i,j) == 0 && board.get(i,j-1) ==compID &&
							board.get(i,j-1) == board.get(i,j+1) && board.get(i,j-1) == board.get(i,j-2)){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		//right
		if(result == 8){
			for(int i = 0; i < 6; i++){
				for(int j = 0; j < 4; j++){
					if(board.get(i,j) == 0 && board.get(i,j+1) ==compID &&
							board.get(i,j+1) == board.get(i,j+2) && board.get(i,j+1) == board.get(i,j+3)){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		//comp blocks other player's win
		//////////////////////////////////////////////////////
		//down-right
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				if(board.get(i,j) == 0 && board.get(i+1,j+1) == board.get(i+2,j+2) &&
						board.get(i+1,j+1) == board.get(i+3,j+3) && board.get(i+1,j+1) != compID
						&& board.get(i+1,j+1) != 0 &&(board.get(i+1,j) != 0 || i == 5)){
					result = j;
				}
			}
		}
		if(result == 8){
			for(int i = 1; i < 4; i++){
				for(int j = 1; j < 5; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j-1) == board.get(i+1,j+1) &&
							board.get(i-1,j-1) == board.get(i+2,j+2) && board.get(i-1,j-1) != compID
							&& (board.get(i+1,j) != 0) && board.get(i-1,j-1) != 0){
						result = j;

					}

				}
			}
		}
		if(result == 8){
			for(int i = 2; i < 5; i++){
				for(int j = 2; j < 6; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j-1) == board.get(i+1,j+1) &&
							board.get(i-1,j-1) == board.get(i-2,j-2) && board.get(i-1,j-1) != compID
							&& (board.get(i+1,j) != 0) && board.get(i-1,j-1) != 0){
						result = j;
						//System.out.println(j);
					}

				}
			}
		}

		//up-right
		if(result == 8){
			for(int i = 3; i < 6; i++){
				for(int j = 0; j < 4; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j+1) == board.get(i-2,j+2) &&
							board.get(i-1,j+1) == board.get(i-3,j+3) && board.get(i-1,j+1) != compID
							&& board.get(i-1,j+1) != 0){
							if(i == 5){
								result = j;
							}
							else if( board.get(i+1,j) != 0){
								result = j;
							}
					}
				}
			}
		}
		if(result == 8){
			for(int i = 2; i < 5; i++){
				for(int j = 1; j < 5; j++){
						if(board.get(i,j) == 0 && board.get(i-1,j+1) == board.get(i-2,j+2) &&
							board.get(i-1,j+1) == board.get(i+1,j-1) && board.get(i-1,j+1) != compID
							&& board.get(i-1,j+1) != 0  && board.get(i+1,j) != 0){
						result = j;
						}
				}
			}
		}

		if(result == 8){
			for(int i = 1; i < 4; i++){
				for(int j = 2; j < 6; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j+1) == board.get(i+1,j-1) &&
							board.get(i-1,j+1) == board.get(i+2,j-2) && board.get(i-1,j+1) != compID
							&& board.get(i-1,j+1) != 0  && board.get(i+1,j) != 0){
						result = j;
						}
				}
			}
		}

		//down-left
		if(result == 8){
			for(int i = 0; i < 3; i++){
				for(int j = 3; j < 7; j++){
					if(board.get(i,j) == 0 && board.get(i+1,j-1) == board.get(i+2,j-2) &&
							board.get(i+1,j-1) == board.get(i+3,j-3) && board.get(i+1,j-1) != compID
							&& board.get(i+1,j-1) != 0 &&(board.get(i+1,j) != 0 || i == 5)){
						result = j;
					}
				}
			}
		}

		//up-left
		if(result == 8){
			for(int i = 3; i < 6; i++){
				for(int j = 3; j < 7; j++){
					if(board.get(i,j) == 0 && board.get(i-1,j-1) == board.get(i-2,j-2) &&
							board.get(i-1,j-1) == board.get(i-3,j-3) && board.get(i-1,j-1) != compID
							&& board.get(i-1,j-1) != 0){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		//down
		if(result == 8){
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 7; j++){
					if(board.get(i,j) == 0 && board.get(i+1,j) !=compID && board.get(i+1,j) != 0 &&
							board.get(i+1,j) == board.get(i+2,j) && board.get(i+1,j) == board.get(i+3,j)){
						result = j;
					}
				}
			}
		}

		//left
		if(result == 8){
			for(int i = 0; i < 6; i++){
				for(int j = 3; j < 7; j++){
					if(board.get(i,j) == 0 && board.get(i,j-1) !=compID && board.get(i,j-1) != 0 &&
							board.get(i,j-1) == board.get(i,j-2) && board.get(i,j-1) == board.get(i,j-3)){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		if(result == 8){
			for(int i = 0; i < 6; i++){
				for(int j = 1; j < 5; j++){
					if(board.get(i,j) == 0 && board.get(i,j-1) !=compID &&
							board.get(i,j-1) == board.get(i,j+1) && board.get(i,j-1) == board.get(i,j+2)
							&& board.get(i,j-1) != 0){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		if(result == 8){
			for(int i = 0; i < 6; i++){
				for(int j = 2; j < 6; j++){
					if(board.get(i,j) == 0 && board.get(i,j-1) !=compID &&
							board.get(i,j-1) == board.get(i,j+1) && board.get(i,j-1) == board.get(i,j-2)
							&& board.get(i,j-1) != 0){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		//right
		if(result == 8){
			for(int i = 0; i < 6; i++){
				for(int j = 0; j < 4; j++){
					if(board.get(i,j) == 0 && board.get(i,j+1) != compID && board.get(i,j+1) != 0 &&
							board.get(i,j+1) == board.get(i,j+2) && board.get(i,j+1) == board.get(i,j+3)){
						if(i == 5){
							result = j;
						}
						else if( board.get(i+1,j) != 0){
							result = j;
						}
					}
				}
			}
		}

		//generates random column
		////////////////////////////////////////////////////

		if(result == 8 || board.isLegalPlay(result) == false){
			while(board.isLegalPlay(result) == false){
				double val = Math.random() * 100;
				if(val >= 0 && val < 14){
					result = 0;
				}
				else if(val >= 14 && val < 28){
					result = 1;
				}
				else if(val >= 28 && val < 42){
					result = 2;
				}
				else if(val >= 42 && val < 56){
					result = 3;
				}
				else if(val >= 56 && val <70){
					result = 4;
				}
				else if(val >= 70 && val < 84){
					result = 5;
				}
				else if(val >= 84 && val < 100){
					result = 6;
				}
			}
		}
		return result;
	}
}
