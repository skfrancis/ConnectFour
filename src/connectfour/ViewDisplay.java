package connectfour;

import java.awt.Graphics;
import javax.swing.JPanel;

interface ViewDisplay {

	/**
	 * This method is used to implement how the display
	 * will be rendered based on its implementation.
	 * @param panel board panel
	 * @param graphics graphic module
	 * @param board game board
	 */
	public void paintDisplay(JPanel panel, Graphics graphics, GameBoard board);
}
