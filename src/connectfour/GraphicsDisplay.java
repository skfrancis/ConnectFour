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

	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	public static final int SHIFT = 5;
	private ArrayList<Color> gameColors;

	public GraphicsDisplay(){
        gameColors = new ArrayList<Color>();
		gameColors.add(Color.BLACK);
		gameColors.add(Color.RED);
		gameColors.add(Color.BLUE);
	}

	@Override
	public void paintDisplay(JPanel panel, Graphics g, GameBoard board) {
		Graphics2D pen = (Graphics2D)g;
		int width = panel.getSize().width / COLUMNS;
		int height = panel.getSize().height / ROWS;
		int color;

		for(int row = 0; row < ROWS; row++){
			for(int column = 0; column < COLUMNS; column++){
				pen.setPaint(Color.YELLOW);
				pen.fill(new Rectangle(column * width, row * height, width, height));
				color = board.get(row, column);
				pen.setPaint((Color)gameColors.get(color));
				pen.fill(new Ellipse2D.Double((column * width) + SHIFT, (row * height)+ SHIFT,
						 width - SHIFT, height - SHIFT));
			}
		}
	}
}
