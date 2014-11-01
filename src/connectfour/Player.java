package connectfour;

import strategies.ComputerStrategy;

/**
 * Interface for creating connect four players
 * Created by Shawn on 10/31/2014.
 */
public interface Player {

    public int getID();
    public String getName();
    public boolean makeMove(GameBoard board, int column);
    public void setStrategy(ComputerStrategy newStrategy);
}

