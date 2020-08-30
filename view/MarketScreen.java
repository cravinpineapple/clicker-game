package view;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Clicker;

import javax.swing.JLabel;

public class MarketScreen {

	private JFrame window;
	private Clicker clicker;

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

	// exit button
	private JButton returnButton = new JButton("Return");


	
	public MarketScreen(JFrame window, Clicker clicker) {
		this.window = window;
		this.clicker = clicker;
	}

	public void init() {
		Container cp = window.getContentPane();

		JPanel centerPanel = new JPanel(); // panel for all shop bottons
		centerPanel.setLayout(new GridLayout(5, 2));
		centerPanel.add(clickPowerHeader);
		centerPanel.add(clickPassiveIncomeHeader);
		centerPanel.add(clickCert);
		centerPanel.add(clickCat);
		centerPanel.add(clickBS);
		centerPanel.add(clickCoinMiner);
		centerPanel.add(clickMS);
		centerPanel.add(clickInc);
		centerPanel.add(clickPHD);
		centerPanel.add(clickMutants);
		cp.add(BorderLayout.CENTER, centerPanel);

		JPanel southPanel = new JPanel(); // panel for return to game button
		southPanel.add(returnButton);
		cp.add(southPanel);

		returnButton.addActionListener(e -> {
			window.getContentPane().removeAll();
			var clickSim = new ClickerSimulator(window, clicker);
			clickSim.init();
			window.pack();
			window.revalidate();
		});

	}



}