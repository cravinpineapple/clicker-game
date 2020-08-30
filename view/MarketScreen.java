package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MarketScreen {

	private JFrame window;

	/* text headers */
	private JLabel clickPowerHeader = new JLabel("Active Click Income");
	private JLabel clickPassiveIncomeHeader = new JLabel("Passive Click Income");

	/** click power items **/
	private JButton clickCert = new JButton("Clicking Certification");
	private JButton clickBS = new JButton("B.S. of Clicking");
	private JButton clickMS = new JButton("M.S. of Clicking");
	private JButton clickPHD = new JButton("Ph.D. of Clicking");

	/*** auto click items  ***/
	private JButton clickCat = new JButton("Click Cat"); // well trained nekos dedicated to getting you those clicks!
	private JButton clickCoinMiner = new JButton("Click-Coin Miner"); // bitcoin? no, clickcoin is the best new cryptocurrency!
	private JButton clickInc = new JButton("Click Incorporated®"); // you're leading the corporate clicking industry!
	private JButton clickMutants = new JButton("Click Mutants"); // clicking has become more important than life itself. people offer themselves
																 // 	to gain click collecting super powers.


	
	public MarketScreen(JFrame window) {
		this.window = window;
	}

	public void init() {
		Container cp = window.getContentPane();

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 2));

	}



}