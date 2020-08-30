package control;

import java.awt.event.ActionListener;

import view.MarketScreen;

import java.awt.event.ActionEvent;

public class MarketClickListener implements ActionListener{

	private MarketScreen panel;

	public MarketClickListener(MarketScreen panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();

		if (button == panel.getClickCertButton() && panel.getClicker().getWallet() >= 30) {
			panel.getClicker().setHasPower(0, true);
			panel.getClicker().increaseClickPower(100); // *** need to change later
			panel.getClicker().subtWallet(30);
			panel.getClickCertButton().setEnabled(false);
		}
		else if (button == panel.getClickBSButton() && panel.getClicker().getWallet() >= 500) {
			panel.getClicker().setHasPower(1, true);
			panel.getClicker().increaseClickPower(1000); // *** need to change later
			panel.getClicker().subtWallet(500);
			panel.getClickBSButton().setEnabled(false);
		}
		else if (button == panel.getClickMSButton() && panel.getClicker().getWallet() >= 5000) {
			panel.getClicker().setHasPower(2, true);
			panel.getClicker().increaseClickPower(5000); // *** need to change later
			panel.getClicker().subtWallet(5000);
			panel.getClickMSButton().setEnabled(false);
		}
		else if (button == panel.getClickPHDButton() && panel.getClicker().getWallet() >= 10000) {
			panel.getClicker().setHasPower(3, true);
			panel.getClicker().increaseClickPower(10000); // *** need to change later
			panel.getClicker().subtWallet(10000);
			panel.getClickPHDButton().setEnabled(false);
		}

	}
	
}