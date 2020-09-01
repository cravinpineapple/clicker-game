package control;

import java.awt.event.ActionListener;

import view.MarketScreen;

import java.awt.event.ActionEvent;

import model.Clicker;

public class MarketClickListener implements ActionListener{

	private MarketScreen panel;

	public MarketClickListener(MarketScreen panel) {
		this.panel = panel;
		panel.getClicker().setTimer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();
		double currentWallet = panel.getClicker().getWallet();

		if (button == panel.getClickCertButton() && currentWallet >= 100) {
			panel.getClicker().setHasCert(true);
			panel.getClicker().setClickPower(5); // *** need to change later
			panel.getClicker().subtWallet(100);
			panel.getWalletText().setText("Wallet: " + (double) (Math.round(panel.getClicker().getWallet() * 10) / 10.0));
			panel.getClickCertButton().setEnabled(false);
		}
		if (button == panel.getClickBSButton() && currentWallet >= 1000) {
			panel.getClicker().setHasBS(true);
			panel.getClicker().setClickPower(15); // *** need to change later
			panel.getClicker().subtWallet(1000);
			panel.getWalletText().setText("Wallet: " + (double) (Math.round(panel.getClicker().getWallet() * 10) / 10.0));
			panel.getClickCertButton().setEnabled(false);
			panel.getClickBSButton().setEnabled(false);
		}
		if (button == panel.getClickMSButton() && currentWallet >= 10000) {
			panel.getClicker().setHasMS(true);
			panel.getClicker().setClickPower(50); // *** need to change later
			panel.getClicker().subtWallet(10000);
			panel.getWalletText().setText("Wallet: " + (double) (Math.round(panel.getClicker().getWallet() * 10) / 10.0));
			panel.getClickCertButton().setEnabled(false);
			panel.getClickBSButton().setEnabled(false);
			panel.getClickMSButton().setEnabled(false);
		}
		if (button == panel.getClickPHDButton() && currentWallet >= 50000) {
			panel.getClicker().setHasPHD(true);
			panel.getClicker().setClickPower(100); // *** need to change later
			panel.getClicker().subtWallet(50000);
			panel.getWalletText().setText("Wallet: " + (double) (Math.round(panel.getClicker().getWallet() * 10) / 10.0));
			panel.getClickCertButton().setEnabled(false);
			panel.getClickBSButton().setEnabled(false);
			panel.getClickMSButton().setEnabled(false);
			panel.getClickPHDButton().setEnabled(false);
		}
		if (button == panel.getClickCatButton() && currentWallet >= Clicker.passiveClickInfo[0].getPrice()) {
			panel.getClicker().subtWallet(Clicker.passiveClickInfo[0].getPrice());
			Clicker.passiveClickInfo[0].purchased();
			panel.getClicker().updateTimer(0.1);
			panel.getWalletText().setText("Wallet: " + (double) (Math.round(panel.getClicker().getWallet() * 10) / 10.0));
			panel.getClickCatButton().setText("<html>Click Cat | Count: " + Clicker.getPassiveClickInfo()[0].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[0].getPrice() + "</html>");
		}
		if (button == panel.getClickCoinMinerButton() && currentWallet >= Clicker.passiveClickInfo[1].getPrice()) {
			panel.getClicker().subtWallet(Clicker.passiveClickInfo[1].getPrice());
			Clicker.passiveClickInfo[1].purchased();
			panel.getClicker().updateTimer(1);
			panel.getWalletText().setText("Wallet: " + (double) (Math.round(panel.getClicker().getWallet() * 10) / 10.0));
			panel.getClickCoinMinerButton().setText("<html>Click-Coin Miner | Count: " + Clicker.getPassiveClickInfo()[1].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[1].getPrice() + "</html>");
		}
		if (button == panel.getClickIncButton() && currentWallet >= Clicker.passiveClickInfo[2].getPrice()) {
			panel.getClicker().subtWallet(Clicker.passiveClickInfo[2].getPrice());
			Clicker.passiveClickInfo[2].purchased();
			panel.getClicker().updateTimer(5);
			panel.getWalletText().setText("Wallet: " + (double) (Math.round(panel.getClicker().getWallet() * 10) / 10.0));
			panel.getClickIncButton().setText("<html>Click Incorporated® | Count: " + Clicker.getPassiveClickInfo()[2].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[2].getPrice() + "</html>");
		}
		if (button == panel.getClickMutantsButton() && currentWallet >= Clicker.passiveClickInfo[3].getPrice()) {
			panel.getClicker().subtWallet(Clicker.passiveClickInfo[3].getPrice());
			Clicker.passiveClickInfo[3].purchased();
			panel.getClicker().updateTimer(20);
			panel.getWalletText().setText("Wallet: " + (double) (Math.round(panel.getClicker().getWallet() * 10) / 10.0));
			panel.getClickMutantsButton().setText("<html>Click Mutants | Count: " + Clicker.getPassiveClickInfo()[3].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[3].getPrice() + "</html>");
		}
	}
	
}