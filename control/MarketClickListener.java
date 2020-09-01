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

		if (button == panel.getClickCertButton() && currentWallet >= 30) {
			panel.getClicker().setHasCert(true);
			panel.getClicker().increaseClickPower(100); // *** need to change later
			panel.getClicker().subtWallet(30);
			panel.getClickCertButton().setEnabled(false);
		}
		if (button == panel.getClickBSButton() && currentWallet >= 500) {
			panel.getClicker().setHasBS(true);
			panel.getClicker().increaseClickPower(1000); // *** need to change later
			panel.getClicker().subtWallet(500);
			panel.getClickBSButton().setEnabled(false);
		}
		if (button == panel.getClickMSButton() && currentWallet >= 5000) {
			panel.getClicker().setHasMS(true);
			panel.getClicker().increaseClickPower(5000); // *** need to change later
			panel.getClicker().subtWallet(5000);
			panel.getClickMSButton().setEnabled(false);
		}
		if (button == panel.getClickPHDButton() && currentWallet >= 10000) {
			panel.getClicker().setHasPHD(true);
			panel.getClicker().increaseClickPower(10000); // *** need to change later
			panel.getClicker().subtWallet(10000);
			panel.getClickPHDButton().setEnabled(false);
		}
		if (button == panel.getClickCatButton() && currentWallet >= Clicker.passiveClickInfo[0].getPrice()) {
			panel.getClicker().subtWallet(Clicker.passiveClickInfo[0].getPrice());
			Clicker.passiveClickInfo[0].purchased();
			panel.getClicker().updateTimer(Clicker.passiveClickInfo[0].getCount() * 0.1);
			panel.getClickCatButton().setText("<html>Click Cat | Count: " + Clicker.getPassiveClickInfo()[0].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[0].getPrice() + "</html>");
		}
		if (button == panel.getClickCoinMinerButton() && currentWallet >= Clicker.passiveClickInfo[1].getPrice()) {
			panel.getClicker().subtWallet(Clicker.passiveClickInfo[1].getPrice());
			Clicker.passiveClickInfo[1].purchased();
			panel.getClicker().updateTimer(Clicker.passiveClickInfo[1].getCount() * 1);
			panel.getClickCoinMinerButton().setText("<html>Click-Coin Miner | Count: " + Clicker.getPassiveClickInfo()[1].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[1].getPrice() + "</html>");
		}
		if (button == panel.getClickIncButton() && currentWallet >= Clicker.passiveClickInfo[2].getPrice()) {
			panel.getClicker().subtWallet(Clicker.passiveClickInfo[2].getPrice());
			Clicker.passiveClickInfo[2].purchased();
			panel.getClicker().updateTimer(Clicker.passiveClickInfo[2].getCount() * 10);
			panel.getClickIncButton().setText("<html>Click Incorporated® | Count: " + Clicker.getPassiveClickInfo()[2].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[2].getPrice() + "</html>");
		}
		if (button == panel.getClickMutantsButton() && currentWallet >= Clicker.passiveClickInfo[3].getPrice()) {
			panel.getClicker().subtWallet(Clicker.passiveClickInfo[3].getPrice());
			Clicker.passiveClickInfo[3].purchased();
			panel.getClicker().updateTimer(Clicker.passiveClickInfo[3].getCount() * 100);
			panel.getClickMutantsButton().setText("<html>Click Mutants | Count: " + Clicker.getPassiveClickInfo()[3].getCount() + "<br/> Price: " + Clicker.getPassiveClickInfo()[3].getPrice() + "</html>");
		}
	}
	
}