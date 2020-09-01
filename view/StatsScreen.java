package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Clicker;

public class StatsScreen {
	
	private JFrame window;
	Clicker clicker;

	public StatsScreen(JFrame window, Clicker clicker) {
		this.window = window;	
		this.clicker = clicker;
	}

	public void init() {
		Container cp = window.getContentPane();

		JPanel centerPanel = new JPanel();
		JLabel timesClicked = new JLabel("Total Clicks: " + clicker.getTotalClicks());
		JLabel totalWalletEarned = new JLabel("Total Money Earned: " + clicker.getWalletTotal());
		JLabel catMoneyEarned = new JLabel("ClickCat Money Earned: ");
		JLabel clickMinerEarned = new JLabel("ClickCoinMiner Money Earned: ");
		JLabel clickIncEarned = new JLabel("ClickInc Money Earned: ");
		JLabel clickMutantsEarned = new JLabel("Click Mutants Earned: ");
		centerPanel.setLayout(new GridLayout(2, 4));
		centerPanel.add(timesClicked);
		centerPanel.add(totalWalletEarned);
		centerPanel.add(catMoneyEarned);
		centerPanel.add(clickMinerEarned);
		centerPanel.add(clickIncEarned);
		centerPanel.add(clickMutantsEarned);

		cp.add(BorderLayout.CENTER, centerPanel);

		JPanel southPanel = new JPanel();
		JButton returnButton = new JButton("Return");
		southPanel.add(returnButton);
		
		cp.add(BorderLayout.SOUTH, southPanel);

		returnButton.addActionListener(e -> {
			window.getContentPane().removeAll();
			var clickSim = new ClickerSimulator(window, clicker);
			clickSim.init();
			window.pack();
			window.revalidate();
		});
		
	}
	

}
