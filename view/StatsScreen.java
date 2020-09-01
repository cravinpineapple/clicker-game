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
		JLabel timesClicked = new JLabel("<html>Total Clicks:<br/>" + "[" +  clicker.getTotalClicks() + "]");
		JLabel totalWalletEarned = new JLabel("<html>Total Money Earned:<br/>" + "[" + (double) (Math.round(clicker.getWalletTotal() * 10) / 10.0) + "]");
		JLabel catMoneyEarned = new JLabel("<html>ClickCat Money Earned:<br/>" + "[" + (double) (Math.round(clicker.getTotalCatClicksEarned() * 10) / 10.0) + "]");
		JLabel clickMinerEarned = new JLabel("<html>ClickCoinMiner<br/>Money Earned:<br/>" + "[" + (double) (Math.round(clicker.getTotalClickCoinMinerEarned() * 10) / 10.0) + "]");
		JLabel clickIncEarned = new JLabel("<html>ClickInc Money Earned:<br/>" + "[" + (double) (Math.round(clicker.getTotalClickCoinMinerEarned() * 10) / 10.0) + "]");
		JLabel clickMutantsEarned = new JLabel("<html>Click Mutants Earned:<br/>" + "[" + (double) (Math.round(clicker.getTotalClickMutantEarned() * 10) / 10.0) + "]");
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
