package connectfour;

import strategies.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class runs the full gui for the connect four game
 * creating menus and adding the game board display.
 *
 * @author Shawn Francis
 *
 */
@SuppressWarnings("serial")
public class RunConnectFour extends JFrame {

    private final GameBoardDisplay display;
    private JMenuItem newGame;
    private JRadioButtonMenuItem graphical;
    private JRadioButtonMenuItem textual;
    private JRadioButtonMenuItem playerOneHuman;
    private JRadioButtonMenuItem playerOneComputer;
    private JRadioButtonMenuItem playerTwoHuman;
    private JRadioButtonMenuItem playerTwoComputer;
    private JRadioButtonMenuItem beginnerOne;
    private JRadioButtonMenuItem intermediateOne;
    private JRadioButtonMenuItem advancedOne;
    private JRadioButtonMenuItem beginnerTwo;
    private JRadioButtonMenuItem intermediateTwo;
    private JRadioButtonMenuItem advancedTwo;
    private final JMenuBar menu;
    private Player playerOne;
    private Player playerTwo;
    private ComputerStrategy computerOne;
    private ComputerStrategy computerTwo;

	/**
	 * This constructor creates the gui for the connect four game
	 * initializing it with player one being human and player two
	 * being a computer player.  The computer strategies for computer
	 * players one and two is set at beginner.
	 */
    private RunConnectFour(){
		setTitle("Connect Four");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		display = new GameBoardDisplay();
		setSize(700,600);
		setLocation(150, 100);
		add(display);
		menu = new JMenuBar();
		setJMenuBar(menu);
		gameMenuInit();
		viewMenuInit();
		optionMenuInit();
		difficultyMenuInit();
		computerOne = new BeginnerStrategy();
		computerTwo = new BeginnerStrategy();
		playerOne = new HumanPlayer("Human Red",1);
		playerTwo = new ComputerPlayer("Computer Blue",2, computerTwo);
		display.newGame(playerOne, playerTwo);
		display.startGame();
	}

	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		RunConnectFour window = new RunConnectFour();
		window.setVisible(true);
	}

	/**
	 * This private method initializes the game menu.
	 */
	private void gameMenuInit(){
		JMenu gameMenu = new JMenu("Game");
		menu.add(gameMenu);
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new gameMenuListener());
		gameMenu.add(newGame);
	}

	/**
	 * This private method initializes the view selection menu.
	 */
	private void viewMenuInit(){
		JMenu viewMenu = new JMenu("View");
		menu.add(viewMenu);
		graphical = new JRadioButtonMenuItem("Graphical View");
		textual = new JRadioButtonMenuItem("Textual View");
		graphical.addActionListener(new ViewButtonListener());
		textual.addActionListener(new ViewButtonListener());
		graphical.setSelected(true);
		textual.setSelected(false);
		viewMenu.add(graphical);
		viewMenu.add(textual);
	}

	/**
	 * This private method initializes the player option menu.
	 */
	private void optionMenuInit(){
		JMenu optionMenu = new JMenu("Players");
		JLabel one = new JLabel("Player One");
		JLabel two = new JLabel("Player Two");
		menu.add(optionMenu);
		optionMenu.add(one);
		playerOneHuman = new JRadioButtonMenuItem("Human Player");
		playerOneComputer = new JRadioButtonMenuItem("Computer Player");
		playerOneHuman.setSelected(true);
		playerOneComputer.setSelected(false);
		playerOneHuman.addActionListener(new PlayerButtonListener());
		playerOneComputer.addActionListener(new PlayerButtonListener());
		optionMenu.add(playerOneHuman);
		optionMenu.add(playerOneComputer);
		optionMenu.add(two);
		playerTwoHuman = new JRadioButtonMenuItem("Human Player");
		playerTwoComputer = new JRadioButtonMenuItem("Computer Player");
		playerTwoHuman.setSelected(false);
		playerTwoComputer.setSelected(true);
		playerTwoHuman.addActionListener(new PlayerButtonListener());
		playerTwoComputer.addActionListener(new PlayerButtonListener());
		optionMenu.add(playerTwoHuman);
		optionMenu.add(playerTwoComputer);

	}

	/**
	 * This private method initializes the strategy menu.
	 */
	private void difficultyMenuInit(){
        JMenu difficultyMenu = new JMenu("Strategy");
		JLabel one = new JLabel("Player One");
		JLabel two = new JLabel("Player Two");
		menu.add(difficultyMenu);
		difficultyMenu.add(one);
		beginnerOne = new JRadioButtonMenuItem("Beginner");
		intermediateOne = new JRadioButtonMenuItem("Intermediate");
		advancedOne = new JRadioButtonMenuItem("Advanced");
		beginnerOne.setSelected(true);
		intermediateOne.setSelected(false);
		advancedOne.setSelected(false);
		beginnerOne.addActionListener(new DifficultyButtonListener());
		intermediateOne.addActionListener(new DifficultyButtonListener());
		advancedOne.addActionListener(new DifficultyButtonListener());
		difficultyMenu.add(beginnerOne);
		difficultyMenu.add(intermediateOne);
		difficultyMenu.add(advancedOne);
		difficultyMenu.add(two);
		beginnerTwo = new JRadioButtonMenuItem("Beginner");
		intermediateTwo = new JRadioButtonMenuItem("Intermediate");
		advancedTwo = new JRadioButtonMenuItem("Advanced");
		beginnerTwo.setSelected(true);
		intermediateTwo.setSelected(false);
		advancedTwo.setSelected(false);
		beginnerTwo.addActionListener(new DifficultyButtonListener());
		intermediateTwo.addActionListener(new DifficultyButtonListener());
		advancedTwo.addActionListener(new DifficultyButtonListener());
		difficultyMenu.add(beginnerTwo);
		difficultyMenu.add(intermediateTwo);
		difficultyMenu.add(advancedTwo);
	}

	/**
	 * The private ActionListener classes implemented are used
	 * to get input from the user via menus
	 */
	private class gameMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			Object eventSource = event.getSource();
			if(eventSource == newGame){
				display.newGame(playerOne, playerTwo);
				display.startGame();
			}
		}
	}

	private class ViewButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			Object eventSource = event.getSource();
			if(eventSource == graphical){
				graphical.setSelected(true);
				textual.setSelected(false);
				display.setDisplay(new GraphicsDisplay());
			}
			if(eventSource == textual){
				graphical.setSelected(false);
				textual.setSelected(true);
				display.setDisplay(new TextDisplay());
			}
		}
	}

	private class PlayerButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			Object eventSource = event.getSource();
			if(eventSource == playerOneHuman){
				playerOne = new HumanPlayer("Human Red",1);
				playerOneHuman.setSelected(true);
				playerOneComputer.setSelected(false);
				display.stopGame();
				display.newGame(playerOne, playerTwo);
				display.startGame();

			}
			if(eventSource == playerOneComputer){
				playerOne = new ComputerPlayer("Computer Red",1,computerOne);
				playerOneHuman.setSelected(false);
				playerOneComputer.setSelected(true);
				display.stopGame();
				display.newGame(playerOne, playerTwo);
				display.startGame();

			}
			if(eventSource == playerTwoHuman){
				playerTwo = new HumanPlayer("Human Blue",2);
				playerTwoHuman.setSelected(true);
				playerTwoComputer.setSelected(false);
				display.stopGame();
				display.newGame(playerOne, playerTwo);
				display.startGame();
			}
			if(eventSource == playerTwoComputer){
				playerTwo = new ComputerPlayer("Computer Blue",2,computerTwo);
				playerTwoHuman.setSelected(false);
				playerTwoComputer.setSelected(true);
				display.stopGame();
				display.newGame(playerOne, playerTwo);
				display.startGame();
			}
		}
	}

	private class DifficultyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			Object eventSource = event.getSource();
			if(eventSource == beginnerOne){
				computerOne = new BeginnerStrategy();
				playerOne.setStrategy(computerOne);
				beginnerOne.setSelected(true);
				intermediateOne.setSelected(false);
				advancedOne.setSelected(false);

			}
			if(eventSource == intermediateOne){
				computerOne = new IntermediateStrategy();
				playerOne.setStrategy(computerOne);
				beginnerOne.setSelected(false);
				intermediateOne.setSelected(true);
				advancedOne.setSelected(false);

			}
			if(eventSource == advancedOne){
				computerOne = new AdvancedStrategy();
				playerOne.setStrategy(computerOne);
				beginnerOne.setSelected(false);
				intermediateOne.setSelected(false);
				advancedOne.setSelected(true);
			}
			if(eventSource == beginnerTwo){
				computerTwo = new BeginnerStrategy();
				playerTwo.setStrategy(computerTwo);
				beginnerTwo.setSelected(true);
				intermediateTwo.setSelected(false);
				advancedTwo.setSelected(false);
			}
			if(eventSource == intermediateTwo){
				computerTwo = new IntermediateStrategy();
				playerTwo.setStrategy(computerTwo);
				beginnerTwo.setSelected(false);
				intermediateTwo.setSelected(true);
				advancedTwo.setSelected(false);
			}
			if(eventSource == advancedTwo){
				computerTwo = new AdvancedStrategy();
				playerTwo.setStrategy(computerTwo);
				beginnerTwo.setSelected(false);
				intermediateTwo.setSelected(false);
				advancedTwo.setSelected(true);
			}
		}
	}
}
