package connectfour;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This class implements the view display interface to
 * display the game in a textual view.
 * @author Shawn Francis
 *
 */
public class TextDisplay implements ViewDisplay {

	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	public static final int SHIFT = 5;
	private ArrayList<Color> gameColors;

	public TextDisplay(){
        gameColors = new ArrayList<Color>();
		gameColors.add(Color.BLACK);
		gameColors.add(Color.RED);
		gameColors.add(Color.BLUE);

	}

	@Override
	public void paintDisplay(JPanel panel, Graphics g, GameBoard board) {
		Font displayFont = new Font("SansSerif", Font.BOLD, 16);
		Graphics2D pen = (Graphics2D)g;
		int width = panel.getSize().width / COLUMNS;
		int height = panel.getSize().height / ROWS;
		int color;
		Integer checker;
		pen.setFont(displayFont);
		for(int row = 0; row < ROWS; row++){
			for(int column = 0; column < COLUMNS; column++){
				color = board.get(row, column);
				checker = new Integer(board.get(row, column));
				pen.setPaint((Color)gameColors.get(color));
				pen.drawString(checker.toString(), (column * width) + 40, (row * height) + 40);
			}
		}

	}

}
