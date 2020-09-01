package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ClickerSimulator;
import view.MenuScreen;
import view.StatsScreen;
import view.MarketScreen;

public class ButtonClickListener implements ActionListener {

	private ClickerSimulator panel;

	public ButtonClickListener(ClickerSimulator panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();

		if (button == panel.getExitButton()) {
			panel.getWindow().getContentPane().removeAll();
			var menuSim = new MenuScreen(panel.getWindow());
			menuSim.init();
			panel.getWindow().pack();
			panel.getWindow().revalidate();
		}
		else if (button == panel.getClickButton()) {
			panel.getClicker().clicked(); // adds +1 to click count & adds to wallet and walletTotal.
			panel.getWalletText().setText("Wallet: " + panel.getClicker().getWallet()); // updates wallet with new money amount
		}
		else if (button == panel.getMarketButton()) {
			panel.getWindow().getContentPane().removeAll();
			var marketScreen = new MarketScreen(panel.getWindow(), panel.getClicker()); // passes clicker too to keep data
			marketScreen.init();
			panel.getWindow().pack();
			panel.getWindow().revalidate();
		}
		else if (button == panel.getStatsButton()) {
			panel.getWindow().getContentPane().removeAll();
			var statsScreen = new StatsScreen(panel.getWindow(), panel.getClicker());
			statsScreen.init();
			panel.getWindow().pack();
			panel.getWindow().revalidate();
		}
	}
	
}