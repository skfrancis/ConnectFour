package connectfour;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This class uses the ViewDisplay interface to
 * display the game in a graphical view.
 * @author Shawn Francis
 *
 */
public class GraphicsDisplay implements ViewDisplay {

	private static final int ROWS = 6;
	private static final int COLUMNS = 7;
	private static final int SHIFT = 5;
    private static final Color BACKGROUND = new Color(204,204,0);
    private final ArrayList<Color> gameColors;

	public GraphicsDisplay(){
        gameColors = new ArrayList<Color>();
		gameColors.add(Color.GRAY);
		gameColors.add(Color.RED);
		gameColors.add(Color.BLUE);
	}

	@Override
	public void paintDisplay(JPanel panel, Graphics graphics, GameBoard board) {
		Graphics2D pen = (Graphics2D) graphics;
		int width = panel.getSize().width / COLUMNS;
		int height = panel.getSize().height / ROWS;
		int color;
        panel.setBackground(BACKGROUND);

		for(int row = 0; row < ROWS; row++){
			for(int column = 0; column < COLUMNS; column++){
				pen.setPaint(Color.YELLOW);
				pen.fill(new Rectangle((column * width) + SHIFT, (row * height) + SHIFT, width - SHIFT, height - SHIFT));
				color = board.get(row, column);
				pen.setPaint(gameColors.get(color));
				pen.fill(new Ellipse2D.Double((column * width) + SHIFT, (row * height)+ SHIFT,
						 width - SHIFT, height - SHIFT));
			}
		}
	}
}
