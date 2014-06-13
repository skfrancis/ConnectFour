package connectfour;

import java.awt.Graphics;
import javax.swing.JPanel;

public interface ViewDisplay {

	/**
	 * This method is used to implement how the display
	 * will be rendered based on its implementation.
	 * @param panel
	 * @param graphics
	 * @param board
	 */
	public void paintDisplay(JPanel panel, Graphics graphics, GameBoard board);
}
