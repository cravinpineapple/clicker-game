package view;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.MarketClickListener;
import model.Clicker;

import javax.swing.JLabel;

public class MarketScreen {

	private JFrame window;
	private Clicker clicker;

	/* text headers */
	private JLabel clickPowerHeader = new JLabel("                     Active Click Income");
	private JLabel clickPassiveIncomeHeader = new JLabel("                   Passive Click Income");
	private JLabel walletText = new JLabel();

	/** click power items **/
	private JButton clickCertButton = new JButton("<html>Clicking Certification<br/>Price: 100</html>");
	private JButton clickBSButton = new JButton("<html>B.S. of Clicking<br/>Price: 1000</html>");
	private JButton clickMSButton = new JButton("<html>M.S. of Clicking<br/>Price: 10000</html>");
	private JButton clickPHDButton = new JButton("<html>Ph.D. of Clicking<br/>Price: 50000</html>");

	/*** auto click items  ***/
	private JButton clickCatButton = new JButton("<html>Click Cat | Count: " + Clicker.getPassiveClickInfo()[0].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[0].getPrice() + "</html>"); // well trained nekos dedicated to getting you those clicks!
	private JButton clickCoinMinerButton = new JButton("<html>Click-Coin Miner | Count: " + Clicker.getPassiveClickInfo()[1].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[1].getPrice() + "</html>"); // bitcoin? no, clickcoin is the best new cryptocurrency!
	private JButton clickIncButton = new JButton("<html>Click Incorporated® | Count: " + Clicker.getPassiveClickInfo()[2].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[2].getPrice() + "</html>"); // you're leading the corporate clicking industry!
	private JButton clickMutantsButton = new JButton("<html>Click Mutants | Count: " + Clicker.getPassiveClickInfo()[3].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[3].getPrice() + "</html>"); // clicking has become more important than life itself. people offer themselves
																 // 	to gain click collecting super powers.

	// exit button
	private JButton returnButton = new JButton("Return");


	
	public MarketScreen(JFrame window, Clicker clicker) {
		this.window = window;
		this.clicker = clicker;

		if (clicker.getHasCert() || clicker.getHasBS() || clicker.getHasMS() || clicker.getHasPHD()) {
			clickCertButton.setEnabled(false);
		}
		if (clicker.getHasBS() || clicker.getHasMS() || clicker.getHasPHD()) {
			clickBSButton.setEnabled(false);
		}
		if (clicker.getHasMS() || clicker.getHasPHD()) {
			clickMSButton.setEnabled(false);
		}
		if (clicker.getHasPHD()) {
			clickPHDButton.setEnabled(false);
		}
	}

	public void init() {
		Container cp = window.getContentPane();

		clicker.updateMarketScreen(this);

		JPanel northPanel = new JPanel();
		walletText.setText("Wallet: " + (double) (Math.round(clicker.getWallet() * 10) / 10.0));
		northPanel.add(walletText);
		cp.add(BorderLayout.NORTH, northPanel);


		JPanel centerPanel = new JPanel(); // panel for all shop bottons
		centerPanel.setLayout(new GridLayout(5, 2));
		centerPanel.add(clickPowerHeader);
		centerPanel.add(clickPassiveIncomeHeader);
		centerPanel.add(clickCertButton);
		centerPanel.add(clickCatButton);
		centerPanel.add(clickBSButton);
		centerPanel.add(clickCoinMinerButton);
		centerPanel.add(clickMSButton);
		centerPanel.add(clickIncButton);
		centerPanel.add(clickPHDButton);
		centerPanel.add(clickMutantsButton);
		cp.add(BorderLayout.CENTER, centerPanel);

		JPanel southPanel = new JPanel(); // panel for return to game button
		southPanel.add(returnButton);
		cp.add(BorderLayout.SOUTH, southPanel);

		/**** Action Listeners Below****/
		MarketClickListener marketClickListener = new MarketClickListener(this);

		clickCertButton.addActionListener(marketClickListener);
		clickBSButton.addActionListener(marketClickListener);
		clickMSButton.addActionListener(marketClickListener);
		clickPHDButton.addActionListener(marketClickListener);
		clickCatButton.addActionListener(marketClickListener);
		clickCoinMinerButton.addActionListener(marketClickListener);
		clickIncButton.addActionListener(marketClickListener);
		clickMutantsButton.addActionListener(marketClickListener);

		returnButton.addActionListener(e -> {
			window.getContentPane().removeAll();
			var clickSim = new ClickerSimulator(window, clicker);
			clickSim.init();
			window.pack();
			window.revalidate();
		});

	}

	public JButton getClickCertButton() {
		return clickCertButton;
	}

	public JButton getClickBSButton() {
		return clickBSButton;
	}

	public JButton getClickMSButton() {
		return clickMSButton;
	}

	public JButton getClickPHDButton() {
		return clickPHDButton;
	}

	public JButton getClickCatButton() {
		return clickCatButton;
	}

	public JButton getClickCoinMinerButton() {
		return clickCoinMinerButton;
	}

	public JButton getClickIncButton() {
		return clickIncButton;
	}

	public JButton getClickMutantsButton() {
		return clickMutantsButton;
	}

	public JLabel getWalletText() {
		return walletText;
	}

	public Clicker getClicker() {
		return clicker;
	}



}